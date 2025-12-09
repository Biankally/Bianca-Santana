package com.dvdrental.dao;

import com.dvdrental.model.Actor;
import com.dvdrental.model.Film;
import com.dvdrental.util.AuditLog;
import com.dvdrental.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public void insert(Film film) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?::mpaa_rating)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, film.getTitle());
            pstmt.setString(2, film.getDescription());
            
            if (film.getReleaseYear() != null) pstmt.setInt(3, film.getReleaseYear());
            else pstmt.setNull(3, Types.INTEGER);
            
            pstmt.setInt(4, film.getLanguageId());
            
            if (film.getRentalDuration() != null) pstmt.setInt(5, film.getRentalDuration());
            else pstmt.setInt(5, 3); // Default
            
            pstmt.setDouble(6, film.getRentalRate());
            
            if (film.getLength() != null) pstmt.setInt(7, film.getLength());
            else pstmt.setNull(7, Types.INTEGER);
            
            if (film.getReplacementCost() != null) pstmt.setDouble(8, film.getReplacementCost());
            else pstmt.setDouble(8, 19.99); // Default
            
            if (film.getRating() != null) pstmt.setString(9, film.getRating());
            else pstmt.setString(9, "G"); // Default

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        film.setFilmId(generatedKeys.getInt(1));
                        System.out.println("Filme inserido com ID: " + film.getFilmId());
                        AuditLog.log("INSERT Film ID: " + film.getFilmId() + ", Title: " + film.getTitle());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Film findById(Integer id) {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        Film film = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    film = new Film();
                    film.setFilmId(rs.getInt("film_id"));
                    film.setTitle(rs.getString("title"));
                    film.setDescription(rs.getString("description"));
                    film.setReleaseYear(rs.getInt("release_year"));
                    film.setLanguageId(rs.getInt("language_id"));
                    film.setRentalDuration(rs.getInt("rental_duration"));
                    film.setRentalRate(rs.getDouble("rental_rate"));
                    film.setLength(rs.getInt("length"));
                    film.setReplacementCost(rs.getDouble("replacement_cost"));
                    film.setRating(rs.getString("rating"));
                    film.setLastUpdate(rs.getTimestamp("last_update"));
                    
                    AuditLog.log("READ Film ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme: " + e.getMessage());
        }
        return film;
    }

    public List<Actor> findActorsByFilmId(Integer filmId) {
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT a.actor_id, a.first_name, a.last_name " +
                     "FROM actor a " +
                     "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, filmId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setActorId(rs.getInt("actor_id"));
                    actor.setFirstName(rs.getString("first_name"));
                    actor.setLastName(rs.getString("last_name"));
                    actors.add(actor);
                }
                AuditLog.log("READ Actors for Film ID: " + filmId);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar atores do filme: " + e.getMessage());
        }
        return actors;
    }
}
