import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FilmDAO {

    public int insertFilm(String title, String description, int releaseYear, int languageId) {
        String sql = "INSERT INTO film (title, description, release_year, language_id) " +
                     "VALUES (?, ?, ?, ?) RETURNING film_id";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setInt(3, releaseYear);
            ps.setInt(4, languageId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int newId = rs.getInt("film_id");
                    AuditLogger.log("Inserido filme ID " + newId + " - " + title);
                    return newId;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
        }
        return -1;
    }

    public FilmRecord getFilmById(int filmId) {
        String sql = "SELECT film_id, title, description, release_year, language_id " +
                     "FROM film WHERE film_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, filmId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new FilmRecord(
                        rs.getInt("film_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("release_year"),
                        rs.getInt("language_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme por ID: " + e.getMessage());
        }
        return null;
    }

    public List<FilmRecord> listAllFilms() {
        List<FilmRecord> list = new ArrayList<>();
        String sql = "SELECT film_id, title, description, release_year, language_id FROM film ORDER BY film_id";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new FilmRecord(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("release_year"),
                    rs.getInt("language_id")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar filmes: " + e.getMessage());
        }
        return list;
    }

    public boolean updateFilmTitle(int filmId, String newTitle) {
        String sql = "UPDATE film SET title = ? WHERE film_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newTitle);
            ps.setInt(2, filmId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                AuditLogger.log("Atualizado título do filme ID " + filmId + " para '" + newTitle + "'");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar título: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteFilm(int filmId) {
        String sql = "DELETE FROM film WHERE film_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, filmId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                AuditLogger.log("Removido filme ID " + filmId);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir filme: " + e.getMessage());
        }
        return false;
    }

    public static class FilmRecord {
        public final int filmId;
        public final String title;
        public final String description;
        public final int releaseYear;
        public final int languageId;

        public FilmRecord(int filmId, String title, String description, int releaseYear, int languageId) {
            this.filmId = filmId;
            this.title = title;
            this.description = description;
            this.releaseYear = releaseYear;
            this.languageId = languageId;
        }

        @Override
        public String toString() {
            return "FilmRecord{id=" + filmId +
                   ", title='" + title + '\'' +
                   ", year=" + releaseYear +
                   ", lang=" + languageId + '}';
        }
    }
}
