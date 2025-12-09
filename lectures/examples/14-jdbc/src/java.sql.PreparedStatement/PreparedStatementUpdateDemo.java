import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PreparedStatementUpdateDemo {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get("db.properties")));

        try (Connection conn = DriverManager.getConnection(
                props.getProperty("url"), props.getProperty("user"), props.getProperty("password"))) {

            String sql = "UPDATE category SET name = ?, last_update = CURRENT_TIMESTAMP WHERE category_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "CATEGORIA_ATUALIZADA");
                ps.setInt(2, 1); 
                int rows = ps.executeUpdate();
                System.out.println("Linhas atualizadas: " + rows);
            }
        }
    }
}
