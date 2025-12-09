import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        // Lê o arquivo db.properties que está na mesma pasta
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
        }
        return DriverManager.getConnection(props.getProperty("url"), props);
    }
}