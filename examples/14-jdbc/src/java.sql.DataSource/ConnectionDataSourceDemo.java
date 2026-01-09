import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDataSourceDemo {
    public static void main(String[] args) {
    
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setServerNames(new String[] {"localhost"});
        dataSource.setPortNumbers(new int[] {5431});
        dataSource.setDatabaseName("dvdrental");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");

        String sql = "SELECT title, release_year FROM film ORDER BY title LIMIT 5";

        try (
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            System.out.println("Filmes encontrados:");
            while (rs.next()) {
                System.out.printf("- %s (%d)%n", rs.getString("title"), rs.getInt("release_year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
