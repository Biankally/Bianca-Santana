import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorDAO {

    public void listActorsByFilmId(int filmId) {
        String sql = "SELECT a.actor_id, a.first_name, a.last_name " +
                     "FROM film_actor fa " +
                     "JOIN actor a ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, filmId);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("Atores do filme ID " + filmId + ":");
                while (rs.next()) {
                    int actorId = rs.getInt("actor_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    System.out.println("- " + actorId + ": " + firstName + " " + lastName);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar atores do filme: " + e.getMessage());
        }
    }

    public void deleteActorById(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, actorId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                AuditLogger.log("Removido ator ID " + actorId);
            } else {
                System.out.println("Nenhum ator encontrado com ID " + actorId);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir ator: " + e.getMessage());
        }
    }
}
