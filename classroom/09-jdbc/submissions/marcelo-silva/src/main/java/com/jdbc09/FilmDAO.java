package com.jdbc09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    private Connection getConnection() throws SQLException {
        // Conexão baseada nas propriedades lidas pelo DBConfig
        return DriverManager.getConnection(
            DBConfig.getUrl(),
            DBConfig.getUser(),
            DBConfig.getPassword()
        );
    }
    
    // Método auxiliar para mapear o ResultSet para um objeto Film
    private Film mapResultSetToFilm(ResultSet rs) throws SQLException {
        int filmId = rs.getInt("film_id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        int releaseYear = rs.getInt("release_year");
        Timestamp lastUpdateTs = rs.getTimestamp("last_update");

        // Converte java.sql.Timestamp para java.time.LocalDateTime
        LocalDateTime lastUpdate = lastUpdateTs != null ? lastUpdateTs.toLocalDateTime() : null;

        return new Film(filmId, title, description, releaseYear, lastUpdate);
    }

    // --------------------------------------------------
    // 1. INSERIR NOVO FILME (CREATE)
    // --------------------------------------------------
    public int insert(Film film) {
        // CORREÇÃO: Usando public.film para resolver o erro de relação não existe
        String sql = "INSERT INTO public.film (title, description, release_year, language_id, rental_duration, rental_rate, replacement_cost, last_update) " +
                     "VALUES (?, ?, ?, 1, 3, 4.99, 19.99, NOW()) RETURNING film_id;"; 

        int generatedId = -1;
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                    film.setFilmId(generatedId);
                    AuditLogger.log("INSERT", "Filme ID: " + generatedId + ", Título: " + film.getTitle());
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
        }
        return generatedId;
    }

    // --------------------------------------------------
    // 2. BUSCAR FILME POR ID (READ)
    // --------------------------------------------------
    public Film findById(int id) {
        // CORREÇÃO: Usando public.film
        String sql = "SELECT film_id, title, description, release_year, last_update FROM public.film WHERE film_id = ?";
        Film film = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    film = mapResultSetToFilm(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme por ID: " + e.getMessage());
        }
        return film;
    }

    // --------------------------------------------------
    // 3. LISTAR ATORES DE UM FILME (READ - JOIN)
    // --------------------------------------------------
    public List<String> findActorsByFilmId(int filmId) {
        List<String> actors = new ArrayList<>();
        // CORREÇÃO: Usando public.actor e public.film_actor
        String sql = "SELECT a.first_name, a.last_name FROM public.actor a " +
                     "JOIN public.film_actor fa ON a.actor_id = fa.actor_id " +
                     "WHERE fa.film_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    actors.add(rs.getString("first_name") + " " + rs.getString("last_name"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar atores: " + e.getMessage());
        }
        return actors;
    }
    
    // --------------------------------------------------
    // 4. EXCLUIR ATOR POR ID (DELETE de film_actor)
    // --------------------------------------------------
    public boolean deleteActorByActorId(int actorId) {
        // CORREÇÃO: Usando public.film_actor
        String sql = "DELETE FROM public.film_actor WHERE actor_id = ?";
        boolean success = false;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actorId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                AuditLogger.log("DELETE", rowsAffected + " ligações removidas para Actor ID: " + actorId);
                success = true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover ator de film_actor: " + e.getMessage());
        }
        return success;
    }
    
    // --------------------------------------------------
    // 5. UPDATE de Filme (Adicionado para CRUD completo)
    // --------------------------------------------------
     public boolean update(Film film) {
        // CORREÇÃO: Usando public.film
        String sql = "UPDATE public.film SET title = ?, description = ?, release_year = ?, last_update = NOW() WHERE film_id = ?";
        boolean success = false;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear());
            stmt.setInt(4, film.getFilmId());

            if (stmt.executeUpdate() > 0) {
                AuditLogger.log("UPDATE", "Filme ID: " + film.getFilmId() + ", Novo Título: " + film.getTitle());
                success = true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar filme: " + e.getMessage());
        }
        return success;
    }
}