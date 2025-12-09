import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {
    private static final Logger LOGGER = System.getLogger(DatabaseConfig.class.getName());
    private static final Properties props = new Properties();

    static {
        try (var input = new FileInputStream("db.properties")) {
            props.load(input);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Falha fatal ao carregar configurações do banco (db.properties)", e);
            throw new RuntimeException("Falha de configuração", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }

    public static void initializeDatabase() {
        String sql = """
            CREATE TABLE IF NOT EXISTS film (
                id SERIAL PRIMARY KEY,
                title VARCHAR(255) NOT NULL,
                language_id INT NOT NULL,
                rental_duration INT NOT NULL,
                rental_rate DECIMAL(5,2) NOT NULL,
                replacement_cost DECIMAL(5,2) NOT NULL
            );
            CREATE TABLE IF NOT EXISTS actor (
                id SERIAL PRIMARY KEY,
                first_name VARCHAR(45) NOT NULL,
                last_name VARCHAR(45) NOT NULL
            );
            CREATE TABLE IF NOT EXISTS film_actor (
                actor_id INT REFERENCES actor(id) ON DELETE CASCADE,
                film_id INT REFERENCES film(id) ON DELETE CASCADE,
                PRIMARY KEY (actor_id, film_id)
            );
            """;

        try (var conn = getConnection();
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
            LOGGER.log(Level.INFO, "Banco de dados inicializado/verificado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Erro ao inicializar tabelas do banco de dados", e);
        }
    }
}