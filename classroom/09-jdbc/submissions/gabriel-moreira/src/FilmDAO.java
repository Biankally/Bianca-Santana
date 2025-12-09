import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FilmDAO {

    public void listarFilmes() {
        String sql = "SELECT film_id, title, release_year FROM film LIMIT 10";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("film_id");
                String title = rs.getString("title");
                int year = rs.getInt("release_year");

                System.out.println(id + " - " + title + " (" + year + ")");
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar filmes: " + e.getMessage());
        }
    }
}
