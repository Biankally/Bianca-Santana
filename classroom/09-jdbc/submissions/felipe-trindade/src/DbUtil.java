import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.InputStream;

public class DbUtil {

    private static final String PROPS_FILE = "db.properties";

    private static Properties loadProps() {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(PROPS_FILE))) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar " + PROPS_FILE, e);
        }
        return props;
    }

    public static Connection getConnection() throws SQLException {
        Properties p = loadProps();
        String url = p.getProperty("db.url");
        String user = p.getProperty("db.user");
        String pass = p.getProperty("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
