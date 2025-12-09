package com.idpflix.dao;

import com.idpflix.model.Film;
import com.idpflix.service.AuditService;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    private final Properties props = new Properties();

    public FilmDAO() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Não foi possível encontrar db.properties");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar configurações do BD: " + e.getMessage(), e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            props.getProperty("db.url"),
            props.getProperty("db.user"),
            props.getProperty("db.password")
        );
    }

    public Film insert(Film film) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost, release_year) VALUES (?, ?, ?, ?, ?, ?) RETURNING film_id";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            Date releaseYearDate = film.getReleaseYear() != null ? Date.valueOf(film.getReleaseYear()) : null; 

            pstmt.setString(1, film.getTitle());
            pstmt.setInt(2, film.getLanguageId());
            pstmt.setInt(3, film.getRentalDuration());
            pstmt.setDouble(4, film.getRentalRate());
            pstmt.setDouble(5, film.getReplacementCost());
            pstmt.setDate(6, releaseYearDate);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    film.setFilmId(rs.getInt(1));
                    AuditService.log("INSERT", "Novo filme inserido: " + film.toString());
                    return film;
                }
            }
            throw new SQLException("Falha ao obter ID do filme inserido.");
        }
    }

    public Film findById(int id) throws SQLException {
        String sql = "SELECT film_id, title, language_id, rental_duration, rental_rate, replacement_cost, release_year FROM film WHERE film_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractFilmFromResultSet(rs);
                }
                return null;
            }
        }
    }

    public List<String> listActorsByFilmId(int filmId) throws SQLException {
        List<String> actors = new ArrayList<>();
        String sql = "SELECT a.first_name, a.last_name FROM actor a " +
                     "INNER JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, filmId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String actorName = rs.getString("first_name") + " " + rs.getString("last_name");
                    actors.add(actorName);
                }
            }
        }
        return actors;
    }
    
   
    public boolean update(Film film) throws SQLException {
        String sql = "UPDATE film SET title = ?, rental_rate = ?, replacement_cost = ?, rental_duration = ? WHERE film_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, film.getTitle());
            pstmt.setDouble(2, film.getRentalRate());
            pstmt.setDouble(3, film.getReplacementCost());
            pstmt.setInt(4, film.getRentalDuration());
            pstmt.setInt(5, film.getFilmId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                AuditService.log("UPDATE", "Filme ID " + film.getFilmId() + " atualizado para: " + film.toString());
                return true;
            }
            return false;
        }
    }

    public boolean delete(int id) throws SQLException {

        
        String sql = "DELETE FROM film WHERE film_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, id);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                AuditService.log("DELETE", "Filme ID " + id + " excluído.");
                return true;
            }
            return false;
        }
    }

    private Film extractFilmFromResultSet(ResultSet rs) throws SQLException {
        Date releaseYearDate = rs.getDate("release_year");
        LocalDate releaseYear = releaseYearDate != null ? releaseYearDate.toLocalDate() : null;
        
        return new Film(
            rs.getInt("film_id"),
            rs.getString("title"),
            rs.getInt("language_id"),
            rs.getInt("rental_duration"),
            rs.getDouble("rental_rate"),
            rs.getDouble("replacement_cost"),
            releaseYear
        );
    }
}