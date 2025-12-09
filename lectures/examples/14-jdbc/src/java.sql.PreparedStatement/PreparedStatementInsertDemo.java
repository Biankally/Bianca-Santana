import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementInsertDemo {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get("db.properties")));

        try (Connection conn = DriverManager.getConnection(
                props.getProperty("url"), props.getProperty("user"), props.getProperty("password"))) {

            String sql = "INSERT INTO category (name, last_update) VALUES (?, CURRENT_TIMESTAMP)";
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, "EXEMPLO_CATEGORIA");
                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        System.out.println("Categoria criada com ID: " + rs.getInt(1));
                    }
                }
            }
        }
    }
}
