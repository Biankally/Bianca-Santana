package service;

import util.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DvdRentalService {

    private static final Path LOG_FILE = Paths.get("audit.log");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static void log(String operation, String message) {
        String logEntry = String.format("[%s] %s: %s%n",
                LocalDateTime.now().format(FORMATTER),
                operation,
                message);
        try {
            Files.write(LOG_FILE, Arrays.asList(logEntry), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }

    public static void inserirFilme(String title, String description, int releaseYear, int languageId, int rentalDuration, double rentalRate, int length, double replacementCost, String rating) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setInt(3, releaseYear);
            stmt.setInt(4, languageId);
            stmt.setInt(5, rentalDuration);
            stmt.setDouble(6, rentalRate);
            stmt.setInt(7, length);
            stmt.setDouble(8, replacementCost);
            stmt.setString(9, rating);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                log("INSERT", "Filme inserido: " + title);
                System.out.println("Filme inserido: " + title);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
        }
    }

    public static void buscarFilme(int filmId) {
        String sql = "SELECT title, release_year, rental_rate FROM film WHERE film_id = ?";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("Filme encontrado: ID %d, Título: %s, Ano: %d, Taxa: %.2f%n",
                            filmId, rs.getString("title"), rs.getInt("release_year"), rs.getDouble("rental_rate"));
                } else {
                    System.out.println("Filme com ID " + filmId + " não encontrado.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme: " + e.getMessage());
        }
    }

    public static void listarAtoresDoFilme(int filmId) {
        String sql = "SELECT a.first_name, a.last_name FROM actor a JOIN film_actor fa ON a.actor_id = fa.actor_id WHERE fa.film_id = ?";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.printf("Atores do Filme ID %d:%n", filmId);
                while (rs.next()) {
                    System.out.printf("- %s %s%n", rs.getString("first_name"), rs.getString("last_name"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar atores: " + e.getMessage());
        }
    }

    public static void excluirAtor(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actorId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                log("DELETE", "Ator excluído: ID " + actorId);
                System.out.println("Ator com ID " + actorId + " excluído com sucesso.");
            } else {
                System.out.println("Ator com ID " + actorId + " não encontrado para exclusão.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir ator: " + e.getMessage());
        }
    }
}
