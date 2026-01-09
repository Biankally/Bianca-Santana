import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class StatementSelectOrderByDemo {
    public static void main(String[] args) throws Exception {
        
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get("db.properties")));

        try (Connection conn = DriverManager.getConnection(
                props.getProperty("url"), props.getProperty("user"), props.getProperty("password"))) {

            String sql = """
                            SELECT  actor_id,
                                    first_name,
                                    last_name 
                            FROM    actor
                            ORDER BY last_update DESC
                            LIMIT 10;
                        """;
            
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    System.out.printf("ID: %-3d | Nome: %-20s | Sobrenome: %s%n",
                            rs.getInt("actor_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"));
                }
            }
        }
    }
}
