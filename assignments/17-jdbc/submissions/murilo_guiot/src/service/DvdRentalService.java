package service;

import model.Film;
import util.DBConfig;
import java.sql.*;
import java.util.List;

public class DvdRentalService {
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            DBConfig.getDbUrl(), 
            DBConfig.getDbUser(), 
            DBConfig.getDbPassword()
        );
    }
    
    public void importFilms(List<Film> films) throws SQLException {
        final String INSERT_SQL = 
            "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) " +
            "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); 
            try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
                
                for (Film film : films) {
                    pstmt.setString(1, film.getTitle());
                    pstmt.setInt(2, film.getLanguageId());
                    pstmt.setInt(3, film.getRentalDuration());
                    pstmt.setDouble(4, film.getRentalRate());
                    pstmt.setDouble(5, film.getReplacementCost());
                    pstmt.addBatch();
                }
                
                pstmt.executeBatch(); 
                conn.commit(); 
                System.out.println("✅ Importação de " + films.size() + " filmes concluída.");
                
            } catch (SQLException e) {
                conn.rollback();
                throw e; 
            }
        }
    }

    public void updateRentalRates() throws SQLException {
        final String UPDATE_SQL = "UPDATE film SET rental_rate = rental_rate * 1.1";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("✅ Rental Rate atualizado em 10%. Linhas afetadas: " + rowsAffected);
        }
    }

    public void listFilmsWithDuration99() throws SQLException {
        final String SELECT_SQL = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
        
        System.out.println("\n➡️ Filmes com Duração de Locação = 99:");

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL);
             ResultSet rs = pstmt.executeQuery()) {
            
            boolean found = false;
            while (rs.next()) {
                found = true;
                String title = rs.getString("title");
                double rentalRate = rs.getDouble("rental_rate");
                System.out.printf("   - Título: %-40s | Valor Locação (Atualizado): R$ %.2f\n", title, rentalRate);
            }
            if (!found) {
                System.out.println("   Nenhum filme encontrado.");
            }
        }
    }
}