package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("db.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar db.properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("url"),
                props.getProperty("user"),
                props.getProperty("password")
        );
    }
}
