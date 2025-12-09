import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public class Main {

    private static Connection connect() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));

        return DriverManager.getConnection(
            props.getProperty("db.url"),
            props.getProperty("db.user"),
            props.getProperty("db.password")
        );
    }

    public static void main(String[] args) {

        try (Connection conn = connect()) {

            List<Film> films = FilmReader.readFilms("../new_films.txt");

            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                for (Film f : films) {
                    stmt.setString(1, f.getTitle());
                    stmt.setInt(2, f.getLanguageId());
                    stmt.setInt(3, f.getRentalDuration());
                    stmt.setDouble(4, f.getRentalRate());
                    stmt.setDouble(5, f.getReplacementCost());
                    stmt.executeUpdate();
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement("UPDATE film SET rental_rate = rental_rate * 1.1")) {
                stmt.executeUpdate();
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

            try (PreparedStatement stmt = conn.prepareStatement(selectSql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String title = rs.getString("title");
                    double rate = rs.getDouble("rental_rate");
                    System.out.println(title + " - " + rate);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
