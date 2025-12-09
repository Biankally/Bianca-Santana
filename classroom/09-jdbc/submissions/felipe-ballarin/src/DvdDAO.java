import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DvdDAO {

    public Film insertFilm(Film film) {
        // MUDANÇA AQUI
        String sql = "INSERT INTO public.film (title, description, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, 3, 4.99, 19.99) RETURNING film_id";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getLanguageId());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                AuditLog.log("INSERT", "Novo filme ID: " + id);
                return new Film(id, film.getTitle(), film.getDescription(), film.getLanguageId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Film findFilmById(int id) {
        // MUDANÇA AQUI
        String sql = "SELECT film_id, title, description, language_id FROM public.film WHERE film_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Film(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("language_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Actor> getActorsByFilm(int filmId) {
        List<Actor> list = new ArrayList<>();
        // MUDANÇA AQUI tambem
        String sql = "SELECT a.actor_id, a.first_name, a.last_name FROM public.actor a " +
                     "JOIN public.film_actor fa ON a.actor_id = fa.actor_id WHERE fa.film_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Actor(
                    rs.getInt("actor_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteActor(int actorId) {
        // MUDANÇA AQUI tambem: public.actor
        String sql = "DELETE FROM public.actor WHERE actor_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, actorId);
            int affected = stmt.executeUpdate();
            
            if (affected > 0) {
                AuditLog.log("DELETE", "Ator removido ID: " + actorId);
                System.out.println("Ator removido com sucesso.");
            } else {
                System.out.println("Ator não encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir (possível FK): " + e.getMessage());
        }
    }
}