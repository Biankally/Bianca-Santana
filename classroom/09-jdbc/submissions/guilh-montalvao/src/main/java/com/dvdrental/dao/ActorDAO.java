package com.dvdrental.dao;

import com.dvdrental.model.Actor;
import com.dvdrental.util.AuditLog;
import com.dvdrental.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActorDAO {

    public void delete(Integer actorId) {
        String deleteFilmActorSQL = "DELETE FROM film_actor WHERE actor_id = ?";
        String deleteActorSQL = "DELETE FROM actor WHERE actor_id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Iniciar transação
            conn.setAutoCommit(false);

            try {
                // 1. Remover referências na tabela film_actor
                try (PreparedStatement pstmt = conn.prepareStatement(deleteFilmActorSQL)) {
                    pstmt.setInt(1, actorId);
                    pstmt.executeUpdate();
                }

                // 2. Remover o ator
                try (PreparedStatement pstmt = conn.prepareStatement(deleteActorSQL)) {
                    pstmt.setInt(1, actorId);
                    int affectedRows = pstmt.executeUpdate();

                    if (affectedRows > 0) {
                        System.out.println("Ator removido com sucesso: ID " + actorId);
                        AuditLog.log("DELETE Actor ID: " + actorId);
                    } else {
                        System.out.println("Ator não encontrado: ID " + actorId);
                    }
                }

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao excluir ator: " + e.getMessage());
        }
    }
}
