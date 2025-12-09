import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IDPFlix {

    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        String filePath = "src/new_films.txt";

        List<Film> films = FilmReader.readFilms(filePath);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            importFilms(conn, films);
            updateRentalRates(conn);
            listFilmsWithRentalDuration99(conn);
        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }

    private static void importFilms(Connection conn, List<Film> films) {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Film film : films) {
                ps.setString(1, film.getTitle());
                ps.setInt(2, film.getLanguageId());
                ps.setInt(3, film.getRentalDuration());
                ps.setDouble(4, film.getRentalRate());
                ps.setDouble(5, film.getReplacementCost());
                ps.executeUpdate();
            }
            System.out.println("Filmes importados com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao importar filmes: " + e.getMessage());
        }
    }

    private static void updateRentalRates(Connection conn) {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int rowsAffected = ps.executeUpdate();
            System.out.println("Valores de locação atualizados: " + rowsAffected + " filmes");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar valores de locação: " + e.getMessage());
        }
    }

    private static void listFilmsWithRentalDuration99(Connection conn) {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nFilmes com duração de locação igual a 99:");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                String title = rs.getString("title");
                double rentalRate = rs.getDouble("rental_rate");
                System.out.printf("%s: %.2f%n", title, rentalRate);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar filmes: " + e.getMessage());
        }
    }
}