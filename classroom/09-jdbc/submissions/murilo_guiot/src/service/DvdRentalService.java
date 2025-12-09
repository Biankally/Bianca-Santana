package service;


import util.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DvdRentalService {

    public static void inserirFilme(String titulo) {
        String sql = "INSERT INTO film (title, language_id) VALUES (?, 1)";

        try (Connection conn = Config.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulo);
            pstmt.executeUpdate();

            Config.logAudit("INSERT", "Filme '" + titulo + "' inserido.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir filme: " + e.getMessage());
        }
    }

    public static void buscarFilme(int filmId) {
        String sql = "SELECT title FROM film WHERE film_id = ?";

        try (Connection conn = Config.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, filmId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Busca (ID " + filmId + "): Encontrado: " + rs.getString("title"));
                } else {
                    System.out.println("Busca (ID " + filmId + "): Filme não encontrado.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar filme: " + e.getMessage());
        }
    }

    public static void listarAtoresDoFilme(int filmId) {
        String sql = "SELECT a.first_name, a.last_name " +
                     "FROM actor a JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ?";

        System.out.println("Atores do Filme (ID " + filmId + "):");
        try (Connection conn = Config.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, filmId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("  - " + rs.getString("first_name") + " " + rs.getString("last_name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar atores: " + e.getMessage());
        }
    }

    public static void excluirAtor(int actorId) {
        String sql = "DELETE FROM actor WHERE actor_id = ?";

        try (Connection conn = Config.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, actorId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                Config.logAudit("DELETE", "Ator ID " + actorId + " excluído.");
            } else {
                System.out.println("Aviso: Ator ID " + actorId + " não encontrado para exclusão.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir ator (ID " + actorId + "): " + e.getMessage());
            Config.logAudit("ERRO DELETE", "Falha ao excluir ator ID " + actorId + ". Causa: " + e.getMessage());
        }
    }
}
