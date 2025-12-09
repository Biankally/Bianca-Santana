package com.idpflix;

import java.sql.*;
import java.util.List;

public class Main {

    // Configurações do Banco de Dados
    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres"; // Verifique sua senha

    public static void main(String[] args) {
        // 1. Ler filmes do arquivo
        System.out.println("--- Lendo arquivo de filmes ---");
        String filePath = "data/new_films.txt"; // Caminho relativo à raiz da execução
        // Se rodar de dentro da pasta submissions/guilh-montalvão, o caminho seria apenas "data/new_films.txt"
        // Ajuste conforme necessário dependendo de onde o comando java é executado.
        
        List<Film> films = FileLoader.loadFilms(filePath);
        System.out.println(films.size() + " filmes carregados do arquivo.");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
            // 2. Inserir filmes no banco
            System.out.println("\n--- Inserindo filmes no banco ---");
            insertFilms(conn, films);

            // 3. Atualizar preços (+10%)
            System.out.println("\n--- Atualizando preços de locação (+10%) ---");
            updateRentalRates(conn);

            // 4. Listar filmes com duração 99
            System.out.println("\n--- Relatório: Filmes com duração de locação = 99 ---");
            listLongDurationFilms(conn);

        } catch (SQLException e) {
            System.err.println("Erro de conexão com banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertFilms(Connection conn, List<Film> films) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int count = 0;
            for (Film film : films) {
                pstmt.setString(1, film.getTitle());
                pstmt.setInt(2, film.getLanguageId());
                pstmt.setInt(3, film.getRentalDuration());
                pstmt.setDouble(4, film.getRentalRate());
                pstmt.setDouble(5, film.getReplacementCost());
                pstmt.addBatch(); // Otimização para inserir em lote
                count++;
            }
            
            if (count > 0) {
                int[] result = pstmt.executeBatch();
                System.out.println(result.length + " filmes inseridos com sucesso.");
            }
        }
    }

    private static void updateRentalRates(Connection conn) throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Preços atualizados. Total de filmes afetados: " + rowsAffected);
        }
    }

    private static void listLongDurationFilms(Connection conn) throws SQLException {
        // Nota: O enunciado pede "rent_duration" mas a coluna no banco dvdrental padrão é "rental_duration"
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            System.out.printf("%-50s | %s%n", "TÍTULO", "PREÇO");
            System.out.println("-".repeat(60));
            
            while (rs.next()) {
                String title = rs.getString("title");
                double rate = rs.getDouble("rental_rate");
                System.out.printf("%-50s | %.2f%n", title, rate);
            }
        }
    }
}
