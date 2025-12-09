import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class IdpFlixApp {
    private static final String URL = "jdbc:postgresql://localhost:5440/postgresql";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    public static void main(String[] args) {
        FilmFileReader reader = new FilmFileReader();
        List<Film> newFilms = reader.readFilms("../../data/new_films.txt");

        System.out.println("Filmes carregados do arquivo: " + newFilms.size());

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            createTable(conn);

            insertFilms(conn, newFilms);
            updateRentalRates(conn);
            listSpecificFilms(conn);
        } catch (SQLException e) {
            System.err.println("Erro fatal no banco de dados: " + e.getMessage());
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS film (" +
                "id SERIAL PRIMARY KEY, " +
                "title VARCHAR(255) NOT NULL, " +
                "language_id INT NOT NULL, " +
                "rental_duration INT NOT NULL, " +
                "rental_rate DECIMAL(5,2) NOT NULL, " +
                "replacement_cost DECIMAL(5,2) NOT NULL" +
                ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(">> Tabela 'film' verificada/criada com sucesso.");
        }
    }

    private static void insertFilms(Connection conn, List<Film> films) throws SQLException {
        if (films.isEmpty()) return;

        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Film f : films) {
                pstmt.setString(1, f.getTitle());
                pstmt.setInt(2, f.getLanguageId());
                pstmt.setInt(3, f.getRentalDuration());
                pstmt.setDouble(4, f.getRentalRate());
                pstmt.setDouble(5, f.getReplacementCost());
                pstmt.executeUpdate();
            }

            System.out.println(">> Inserção concluída.");
        }
    }

    private static void updateRentalRates(Connection conn) throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int rows = pstmt.executeUpdate();
            System.out.println(">> Preços atualizados (+10%). Registros afetados: " + rows);
        }
    }

    private static void listSpecificFilms(Connection conn) throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        System.out.println("\n--- Relatório: Filmes com Duração de Locação = 99 ---");
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.printf("Filme: %-30s | Taxa: %.2f%n",
                        rs.getString("title"),
                        rs.getDouble("rental_rate"));
            }
        }
    }
}