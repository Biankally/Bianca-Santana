import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PreparedStatementDeleteDemo {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get("db.properties")));

        try (Connection conn = DriverManager.getConnection(
                props.getProperty("url"), props.getProperty("user"), props.getProperty("password"))) {

            String sql = "DELETE FROM category WHERE name = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "EXEMPLO_CATEGORIA");
                int rows = ps.executeUpdate();
                System.out.println("Linhas removidas: " + rows);
            }
        }
    }
}
