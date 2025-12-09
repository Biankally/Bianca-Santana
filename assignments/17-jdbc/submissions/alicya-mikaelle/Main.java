import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dvd_rental";
        String user = "postgres";
        String password = "postgres";

        // Lê o arquivo new_films.txt
        FilmFileReader reader = new FilmFileReader();
        List<Film> films = reader.read("new_films.txt");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // -------------------------------
            // 1) Inserir filmes do arquivo
            // -------------------------------
            String insertSQL =
                "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) " +
                "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                for (Film f : films) {
                    ps.setString(1, f.getTitle());
                    ps.setInt(2, f.getLanguageId());
                    ps.setInt(3, f.getRentalDuration());
                    ps.setDouble(4, f.getRentalRate());
                    ps.setDouble(5, f.getReplacementCost());
                    ps.executeUpdate();
                }
            }

            // -------------------------------
            // 2) Atualizar rental_rate em 10%
            // -------------------------------
            String updateSQL =
                "UPDATE film SET rental_rate = rental_rate * 1.1";

            try (PreparedStatement ps = conn.prepareStatement(updateSQL)) {
                ps.executeUpdate();
            }

            // -------------------------------
            // 3) Listar filmes com rental_duration = 99
            // -------------------------------
            String selectSQL =
                "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

            try (PreparedStatement ps = conn.prepareStatement(selectSQL);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String title = rs.getString("title");
                    double rate = rs.getDouble("rental_rate");
                    System.out.println(title + " - R$ " + rate);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
