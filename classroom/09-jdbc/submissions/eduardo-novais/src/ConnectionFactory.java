import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    
    private static String url;
    private static String user;
    private static String password;
    
    static {
        try {
            Properties props = new Properties();
            props.load(Files.newInputStream(Paths.get("src/db.properties")));
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo db.properties: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

