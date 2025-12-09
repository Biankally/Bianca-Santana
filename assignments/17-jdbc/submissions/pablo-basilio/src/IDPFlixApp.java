package com.idpflix.app;

import com.idpflix.model.Film;
import com.idpflix.util.FilmFileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IDPFlixApp {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "seu_usuario";
    private static final String PASS = "sua_senha";
    private static final String FILE_PATH = "new_films.txt"; 
    public static void main(String[] args) {
        List<Film> newFilms = FilmFileReader.readFilmsFromFile(FILE_PATH);
        if (newFilms.isEmpty()) {
            System.out.println("Nenhum filme válido encontrado no arquivo. Encerrando.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            conn.setAutoCommit(false); 
            System.out.println("Conexão com o banco de dados estabelecida.");

            importFilms(conn, newFilms);

            updateRentalRates(conn);

            listFilmsByRentalDuration(conn, 99);

            conn.commit(); 
            System.out.println("\n✅ Todas as operações de banco de dados concluídas e confirmadas.");

        } catch (SQLException e) {
            System.err.println("\n❌ Erro de banco de dados: " + e.getMessage());
            e.printStackTrace();
            
        }
    }

   
    private static void importFilms(Connection conn, List<Film> films) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\n--- A. Importando novos filmes...");
            int count = 0;
            for (Film film : films) {
                pstmt.setString(1, film.getTitle());
                pstmt.setInt(2, film.getLanguageId());
                pstmt.setInt(3, film.getRentalDuration());
                pstmt.setDouble(4, film.getRentalRate());
                pstmt.setDouble(5, film.getReplacementCost());
                
                pstmt.addBatch();
                count++;
            }
            
            int[] results = pstmt.executeBatch();
            System.out.println(results.length + " filmes inseridos com sucesso.");
        }
    }

    private static void updateRentalRates(Connection conn) throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\n--- B. Atualizando valor de locação em 10%...");
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " filmes tiveram o valor de locação atualizado.");
        }
    }

   
    private static void listFilmsByRentalDuration(Connection conn, int duration) throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("\n--- C. Listando filmes com duração de locação igual a " + duration + "...");
            
            pstmt.setInt(1, duration);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.printf("%-50s | %-15s%n", "Título", "Taxa de Locação");
                System.out.println("--------------------------------------------------+-----------------");
                int count = 0;
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("%-50s | $%-15.2f%n", title, rentalRate);
                    count++;
                }
                System.out.println("--------------------------------------------------+-----------------");
                System.out.println("Total de filmes encontrados: " + count);
            }
        }
    }
}