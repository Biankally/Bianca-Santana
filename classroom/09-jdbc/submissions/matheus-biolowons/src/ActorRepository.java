import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorRepository {

    private static final Logger LOGGER = System.getLogger(ActorRepository.class.getName());

    public List<Models.Actor> findActorsByFilmId(int filmId) {
        String sql = """
            SELECT a.id, a.first_name, a.last_name
            FROM actor a
            JOIN film_actor fa ON a.id = fa.actor_id
            WHERE fa.film_id = ?
            """;

        List<Models.Actor> actors = new ArrayList<>();

        try (var conn = DatabaseConfig.getConnection();
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, filmId);

            try (var rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    actors.add(new Models.Actor(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name")
                    ));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Erro ao listar atores para o filme ID: " + filmId, e);
        }
        return actors;
    }

    public void delete(int actorId) {
        String sql = "DELETE FROM actor WHERE id = ?";

        try (var conn = DatabaseConfig.getConnection();
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, actorId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                AuditLogger.log("DELETE_ACTOR", "Ator removido ID: " + actorId);
                LOGGER.log(Level.INFO, "Ator ID {0} excluído com sucesso.", actorId);
            } else {
                LOGGER.log(Level.WARNING, "Tentativa de excluir ator inexistente ID: {0}", actorId);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Erro ao tentar excluir ator ID: " + actorId, e);
        }
    }

    public void addActorToFilm(String firstName, String lastName, int filmId) {
        String insertActor = "INSERT INTO actor (first_name, last_name) VALUES (?, ?) RETURNING id";
        String linkActor = "INSERT INTO film_actor (actor_id, film_id) VALUES (?, ?)";

        try (var conn = DatabaseConfig.getConnection()) {
            conn.setAutoCommit(false);

            int newActorId = 0;
            try (var pstmt = conn.prepareStatement(insertActor)) {
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                var rs = pstmt.executeQuery();
                if (rs.next()) newActorId = rs.getInt(1);
            }

            try (var pstmt = conn.prepareStatement(linkActor)) {
                pstmt.setInt(1, newActorId);
                pstmt.setInt(2, filmId);
                pstmt.executeUpdate();
            }

            conn.commit();
            AuditLogger.log("INSERT_ACTOR_LINK", "Ator " + firstName + " vinculado ao filme " + filmId);

        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Erro transacional ao adicionar ator ao filme.", e);
        }
    }
}