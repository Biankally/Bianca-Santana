package dao;

import dvdrental.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {

    // Listar atores de um filme (buscando por film_id)
    public List<Actor> findActorsByFilmId(int filmId) {
        String sql = "SELECT a.actor_id, a.first_name, a.last_name " +
                     "FROM actor a " +
                     "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ? " +
                     "ORDER BY a.actor_id";

        List<Actor> actors = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setId(rs.getInt("actor_id"));
                    actor.setFirstName(rs.getString("first_name"));
                    actor.setLastName(rs.getString("last_name"));
                    actors.add(actor);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar atores do filme: " + e.getMessage());
        }

        return actors;
    }

    // DELETE - excluir ator por ID
    public void deleteById(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actorId);

            int rows = stmt.executeUpdate();
            AuditLogger.log("DELETE ACTOR: id=" + actorId +
                    ", rowsAffected=" + rows);

        } catch (SQLException e) {
            System.err.println("Erro ao excluir ator: " + e.getMessage());
        }
    }
}

