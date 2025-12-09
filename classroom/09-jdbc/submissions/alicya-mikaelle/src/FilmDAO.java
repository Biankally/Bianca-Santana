import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    // CREATE
    public void insert(Film film) throws SQLException {
        String sql = "INSERT INTO film (title, description, language_id) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getLanguageId());
            stmt.executeUpdate();
        }
    }

    // READ by ID
    public Film findById(int id) throws SQLException {
        String sql = "SELECT film_id, title, description, language_id FROM film WHERE film_id = ?";
        Film film = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                film = new Film(
                        rs.getInt("film_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("language_id")
                );
            }
        }
        return film;
    }

    // UPDATE
    public void update(Film film) throws SQLException {
        String sql = "UPDATE film SET title = ?, description = ?, language_id = ? WHERE film_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getLanguageId());
            stmt.setInt(4, film.getFilmId());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM film WHERE film_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Listar atores de um filme
    public List<String> listActors(int filmId) throws SQLException {

        String sql =
            "SELECT a.first_name || ' ' || a.last_name AS actor " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "WHERE fa.film_id = ?";

        List<String> actors = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                actors.add(rs.getString("actor"));
            }
        }
        return actors;
    }

    // Excluir ator por ID
    public void deleteActor(int actorId) throws
