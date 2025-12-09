import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IdpFlix {

    private static final String URL = "jdbc:postgresql://localhost:5432/dvdrental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        Path path = Paths.get("..", "..", "data", "new_films.txt");
        FilmFileReader reader = new FilmFileReader();
        List<Film> films = reader.read(path);

        if (films.isEmpty()) {
            System.out.println("Nenhum filme lido do arquivo.");
            return;
        }

        try {
            inserirFilmes(films);
            atualizarRentalRate();
            listarFilmesDuracao99();
        } catch (SQLException e) {
            System.err.println("Erro de banco: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void inserirFilmes(List<Film> films) throws SQLException {
        String sql = "INSERT INTO film "
                + "(title, language_id, rental_duration, rental_rate, replacement_cost) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (Film f : films) {
                ps.setString(1, f.getTitle());
                ps.setInt(2, f.getLanguageId());
                ps.setInt(3, f.getRentalDuration());
                ps.setDouble(4, f.getRentalRate());
                ps.setDouble(5, f.getReplacementCost());
                ps.addBatch();
            }

            ps.executeBatch();
        }
    }

    private static void atualizarRentalRate() throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int linhas = ps.executeUpdate();
            System.out.println("Rental rate atualizado em " + linhas + " filmes.");
        }
    }

    private static void listarFilmesDuracao99() throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Filmes com rental_duration = 99:");
            while (rs.next()) {
                String title = rs.getString("title");
                double rate = rs.getDouble("rental_rate");
                System.out.println(title + " - " + rate);
            }
        }
    }
}