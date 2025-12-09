import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
            try (var fis = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (fis == null) {
            throw new IOException("Arquivo db.properties não encontrado no classpath!");
    }
    props.load(fis);
}


        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, pass);
    }
}
