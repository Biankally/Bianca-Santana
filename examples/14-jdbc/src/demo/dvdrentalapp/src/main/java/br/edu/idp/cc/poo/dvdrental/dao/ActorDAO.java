package br.edu.idp.cc.poo.dvdrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.idp.cc.poo.dvdrental.model.Actor;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;

public class ActorDAO {

    public void insert(Actor actor) throws SQLException {
        String sql = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, CURRENT_TIMESTAMP)";
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());
            ps.executeUpdate();
            AuditLogger.log("INSERT", "Ator inserido: " + actor);
        }
    }

    public List<Actor> findAll() throws SQLException {
        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id";
        List<Actor> actors = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Actor actor = new Actor(
                    rs.getInt("actor_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
                );
                actors.add(actor);
            }
        }
        return actors;
    }

    public Actor findById(int id) throws SQLException {
        String sql = "SELECT actor_id, first_name, last_name FROM actor WHERE actor_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Actor(
                        rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                    );
                }
            }
        }
        return null;
    }

    public List<Actor> findByName(String name) throws SQLException {
        String sql = "SELECT actor_id, first_name, last_name FROM actor WHERE first_name ILIKE ? OR last_name ILIKE ?";
        List<Actor> actors = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    actors.add(new Actor(
                        rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                    ));
                }
            }
        }
        return actors;
    }

    public void update(Actor actor) throws SQLException {
        String sql = "UPDATE actor SET first_name = ?, last_name = ?, last_update = CURRENT_TIMESTAMP WHERE actor_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());
            ps.setInt(3, actor.getActorId());
            ps.executeUpdate();
            AuditLogger.log("UPDATE", "Ator atualizado: " + actor);
        }
    }

    public void delete(int id) throws SQLException {
        Actor actor = findById(id);
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            AuditLogger.log("DELETE", "Ator removido: " + actor);
        }
    }
}
