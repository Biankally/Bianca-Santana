package com.jdbc17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    // CONFIGURAÇÃO DO BANCO
    // Tentei mudar para 'dvdrental' (sem _). Se der erro, volte para 'dvd_rental'
    private static final String URL = "jdbc:postgresql://localhost:5432/dvdrental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres"; // Verifique se sua senha é essa

    public static void main(String[] args) {
        
        FilmeLeitor leitor = new FilmeLeitor();
        
        // CORREÇÃO: Apontando para a pasta data onde está o arquivo
        List<Film> novosFilmes = leitor.lerFilmes("data/new_films.txt");

        if (novosFilmes.isEmpty()) {
            System.out.println("Nenhum filme foi lido. Verifique o arquivo data/new_films.txt");
            return;
        }

        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão estabelecida com sucesso!");

            // 1. INSERT
            String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            
            try (PreparedStatement stmtInsert = conexao.prepareStatement(sqlInsert)) {
                for (Film filme : novosFilmes) {
                    stmtInsert.setString(1, filme.getTitle());
                    stmtInsert.setInt(2, filme.getLanguageId());
                    stmtInsert.setInt(3, filme.getRentalDuration());
                    stmtInsert.setDouble(4, filme.getRentalRate());
                    stmtInsert.setDouble(5, filme.getReplacementCost());
                    stmtInsert.executeUpdate();
                }
                System.out.println(novosFilmes.size() + " filmes inseridos.");
            }

            // 2. UPDATE (Aumento de 10%)
            String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement stmtUpdate = conexao.prepareStatement(sqlUpdate)) {
                int atualizados = stmtUpdate.executeUpdate();
                System.out.println("Preços atualizados. Filmes afetados: " + atualizados);
            }

            // 3. SELECT (Duração = 99)
            System.out.println("\n--- Filmes com duração de 99 dias ---");
            String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = ?";
            
            try (PreparedStatement stmtSelect = conexao.prepareStatement(sqlSelect)) {
                stmtSelect.setInt(1, 99);
                
                try (ResultSet rs = stmtSelect.executeQuery()) {
                    while (rs.next()) {
                        System.out.printf("Filme: %-30s | Preço: %.2f%n", 
                            rs.getString("title"), 
                            rs.getDouble("rental_rate"));
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro de Banco de Dados: " + e.getMessage());
            // Dica para debug
            if (e.getMessage().contains("does not exist")) {
                System.err.println("DICA: Verifique se o nome do banco na URL é 'dvdrental' ou 'dvd_rental'.");
            }
        }
    }
}