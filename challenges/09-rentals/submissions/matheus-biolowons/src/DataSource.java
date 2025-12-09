import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private final Connection connection;

    public DataSource(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conectado ao banco de dados!");
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (!this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Conexão com o banco de dados Destruida!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
