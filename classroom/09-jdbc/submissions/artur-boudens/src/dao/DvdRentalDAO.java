package dao;

import model.Actor;
import model.Film;
import util.DatabaseConnection;
import util.LoggerService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DvdRentalDAO {

    public void insertFilm(Film film) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, 3, 4.99, 19.99)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear());
            stmt.setInt(4, film.getLanguageId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    LoggerService.log("INSERCAO", "Novo filme inserido. ID: " + generatedId + " - Titulo: " + film.getTitle());
                    System.out.println("Filme inserido com sucesso! ID: " + generatedId);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public Film getFilmById(int id) {
        String sql = "SELECT film_id, title, description, release_year, language_id FROM film WHERE film_id = ?";
        Film film = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                film = new Film(
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("release_year"),
                    rs.getInt("language_id")
                );
                film.setFilmId(rs.getInt("film_id"));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return film;
    }

    public List<Actor> getActorsByFilmId(int filmId) {
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT a.actor_id, a.first_name, a.last_name FROM actor a JOIN film_actor fa ON a.actor_id = fa.actor_id WHERE fa.film_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Actor actor = new Actor();
                actor.setActorId(rs.getInt("actor_id"));
                actor.setFirstName(rs.getString("first_name"));
                actor.setLastName(rs.getString("last_name"));
                actors.add(actor);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return actors;
    }
    
    public void updateFilmTitle(int filmId, String newTitle) {
        String sql = "UPDATE film SET title = ? WHERE film_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newTitle);
            stmt.setInt(2, filmId);
            
            int rows = stmt.executeUpdate();
            if(rows > 0) {
                LoggerService.log("ATUALIZACAO", "Titulo do filme ID " + filmId + " alterado para: " + newTitle);
                System.out.println("Filme atualizado com sucesso.");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteActor(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actorId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                LoggerService.log("EXCLUSAO", "Ator removido. ID: " + actorId);
                System.out.println("Ator removido com sucesso.");
            } else {
                System.out.println("Nenhum ator encontrado com esse ID.");
            }

        } catch (SQLException | IOException e) {
            System.err.println("Erro ao excluir ator: " + e.getMessage());
        }
    }
}