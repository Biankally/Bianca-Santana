import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("db/db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar db/db.properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeQuietly(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception e) {
                System.err.println("Erro ao fechar recurso: " + e.getMessage());
            }
        }
    }
}
