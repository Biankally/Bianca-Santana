import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:5432/dvdrental?sslmode=require";
    private static final String USER = "postgres.lsphluefsmusjfnkghln";
    private static final String PASS = "postgres1234*";

    public static void main(String[] args) {
        
        List<Film> novosFilmes = Reader.lerFilmes("new_films.txt");
        
        String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
        String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            
            try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                for (Film f : novosFilmes) {
                    stmtInsert.setString(1, f.getTitle());
                    stmtInsert.setInt(2, f.getLanguageId());
                    stmtInsert.setInt(3, f.getRentalDuration());
                    stmtInsert.setDouble(4, f.getRentalRate());
                    stmtInsert.setDouble(5, f.getReplacementCost());
                    stmtInsert.executeUpdate();
                }
            }

            try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                stmtUpdate.executeUpdate();
            }

            try (PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
                 ResultSet rs = stmtSelect.executeQuery()) {
                
                while (rs.next()) {
                    System.out.println(rs.getString("title") + " - " + rs.getDouble("rental_rate"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}