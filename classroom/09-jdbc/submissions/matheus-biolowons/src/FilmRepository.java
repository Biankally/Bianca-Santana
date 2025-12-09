import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.Optional;

public class FilmRepository {

    private static final Logger LOGGER = System.getLogger(FilmRepository.class.getName());

    public void insert(Models.Film film) {
        String sql = """
            INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (var conn = DatabaseConfig.getConnection();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, film.title());
            pstmt.setInt(2, film.languageId());
            pstmt.setInt(3, film.rentalDuration());
            pstmt.setDouble(4, film.rentalRate());
            pstmt.setDouble(5, film.replacementCost());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (var rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        AuditLogger.log("INSERT_FILM", "Filme criado: " + film.title() + " (ID: " + generatedId + ")");
                        LOGGER.log(Level.INFO, "Filme inserido com sucesso. ID: {0}", generatedId);
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Erro de SQL ao inserir filme: " + film.title(), e);
        }
    }

    public Optional<Models.Film> findById(int id) {
        String sql = "SELECT * FROM film WHERE id = ?";

        try (var conn = DatabaseConfig.getConnection();
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (var rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Models.Film(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("language_id"),
                            rs.getInt("rental_duration"),
                            rs.getDouble("rental_rate"),
                            rs.getDouble("replacement_cost")
                    ));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Erro ao buscar filme por ID: " + id, e);
        }
        return Optional.empty();
    }
}