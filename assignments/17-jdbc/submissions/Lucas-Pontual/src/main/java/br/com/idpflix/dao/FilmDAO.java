package br.com.idpflix.dao;

import br.com.idpflix.model.Film;
import br.com.idpflix.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FilmDAO {

    public void insertFilms(List<Film> films) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Film film : films) {
                stmt.setString(1, film.getTitle());
                stmt.setInt(2, film.getLanguageId());
                stmt.setInt(3, film.getRentalDuration());
                stmt.setDouble(4, film.getRentalRate());
                stmt.setDouble(5, film.getReplacementCost());
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
    }

    public int updateRentalRate() throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            return stmt.executeUpdate();
        }
    }

    public void listFilmsByRentalDuration(int duration) throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, duration);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Filmes com duração de locação igual a " + duration + ":");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("Título: %s, Valor de Locação: %.2f%n", title, rentalRate);
                }
            }
        }
    }
}
