import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    
    public void insert(Film film) {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, film.getTitle());
            ps.setInt(2, film.getLanguageId());
            ps.setInt(3, film.getRentalDuration());
            ps.setDouble(4, film.getRentalRate());
            ps.setDouble(5, film.getReplacementCost());
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        film.setFilmId(rs.getInt(1));
                    }
                }
                AuditLogger.log("INSERT", "Filme inserido: " + film.getTitle() + " (ID: " + film.getFilmId() + ")");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
        }
    }
    
    public Film findById(int filmId) {
        String sql = "SELECT film_id, title, language_id, rental_duration, rental_rate, replacement_cost FROM film WHERE film_id = ?";
        Film film = null;
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, filmId);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    film = new Film();
                    film.setFilmId(rs.getInt("film_id"));
                    film.setTitle(rs.getString("title"));
                    film.setLanguageId(rs.getInt("language_id"));
                    film.setRentalDuration(rs.getInt("rental_duration"));
                    film.setRentalRate(rs.getDouble("rental_rate"));
                    film.setReplacementCost(rs.getDouble("replacement_cost"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme: " + e.getMessage());
        }
        
        return film;
    }
    
    public void update(Film film) {
        String sql = "UPDATE film SET title = ?, language_id = ?, rental_duration = ?, rental_rate = ?, replacement_cost = ? WHERE film_id = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, film.getTitle());
            ps.setInt(2, film.getLanguageId());
            ps.setInt(3, film.getRentalDuration());
            ps.setDouble(4, film.getRentalRate());
            ps.setDouble(5, film.getReplacementCost());
            ps.setInt(6, film.getFilmId());
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                AuditLogger.log("UPDATE", "Filme atualizado: " + film.getTitle() + " (ID: " + film.getFilmId() + ")");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar filme: " + e.getMessage());
        }
    }
    
    public void delete(int filmId) {
        String sql = "DELETE FROM film WHERE film_id = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            Film film = findById(filmId);
            String filmTitle = film != null ? film.getTitle() : "Desconhecido";
            
            ps.setInt(1, filmId);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                AuditLogger.log("DELETE", "Filme excluído: " + filmTitle + " (ID: " + filmId + ")");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir filme: " + e.getMessage());
        }
    }
    
    public List<String> listActorsByFilmId(int filmId) {
        String sql = "SELECT a.first_name, a.last_name FROM actor a " +
                     "INNER JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ? ORDER BY a.last_name, a.first_name";
        List<String> actors = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, filmId);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    actors.add(firstName + " " + lastName);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar atores: " + e.getMessage());
        }
        
        return actors;
    }
}

