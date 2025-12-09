package dao;

import dvdrental.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmDAO {

    // INSERT - Inserir novo filme
    public void insert(Film film) {
        String sql = "INSERT INTO film (" +
                "title, description, release_year, language_id, " +
                "rental_duration, rental_rate, length, replacement_cost, rating" +
                ") VALUES (?, ?, ?, 1, 3, 4.99, ?, 19.99, 'G')";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear());
            stmt.setInt(4, film.getLengthMinutes());

            int rows = stmt.executeUpdate();
            AuditLogger.log("INSERT FILM: title=" + film.getTitle() +
                    ", rowsAffected=" + rows);

        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
        }
    }

    // READ - Buscar filme por ID
    public Film findById(int id) {
        String sql = "SELECT film_id, title, description, release_year, length " +
                     "FROM film WHERE film_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Film film = new Film();
                    film.setId(rs.getInt("film_id"));
                    film.setTitle(rs.getString("title"));
                    film.setDescription(rs.getString("description"));
                    film.setReleaseYear(rs.getInt("release_year"));
                    film.setLengthMinutes(rs.getInt("length"));

                    return film;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme por ID: " + e.getMessage());
        }

        return null;
    }

    // UPDATE - atualizar título e descrição de um filme
    public void update(Film film) {
        String sql = "UPDATE film SET title = ?, description = ?, length = ? " +
                     "WHERE film_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getLengthMinutes());
            stmt.setInt(4, film.getId());

            int rows = stmt.executeUpdate();
            AuditLogger.log("UPDATE FILM: id=" + film.getId() +
                    ", rowsAffected=" + rows);

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar filme: " + e.getMessage());
        }
    }
}
