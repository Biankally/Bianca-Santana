package com.idpflix.app;

import com.idpflix.dao.FilmDAO;
import com.idpflix.model.Film;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        FilmDAO dao = new FilmDAO();

        try {
            System.out.println("--- 1. Inserindo Novo Filme ---");
            Film novoFilme = new Film(
                "IDPFlix O Retorno", 
                1,                    
                5,                   
                4.99,                 
                19.99,               
                LocalDate.of(2025, 1, 1) 
            );
            
            Film filmeInserido = dao.insert(novoFilme);
            System.out.println("✅ Filme inserido com sucesso: " + filmeInserido);

            int filmeId = filmeInserido.getFilmId();

            System.out.println("\n--- 2. Buscando Filme por ID: " + filmeId + " ---");
            Film filmeBuscado = dao.findById(filmeId);
            if (filmeBuscado != null) {
                System.out.println("✅ Filme encontrado: " + filmeBuscado);
            } else {
                System.out.println("❌ Filme não encontrado.");
            }

            
            int existingFilmId = 1;
            System.out.println("\n--- 3. Listando Atores do Filme ID " + existingFilmId + " ---");
            List<String> atores = dao.listActorsByFilmId(existingFilmId);
            if (!atores.isEmpty()) {
                System.out.println("Atores: " + atores);
            } else {
                System.out.println("Filme ID " + existingFilmId + " não tem atores listados.");
            }
            
            System.out.println("\n--- 4. Atualizando Taxa de Locação do Filme ID: " + filmeId + " ---");
            filmeBuscado.setRentalRate(7.99); 
            filmeBuscado.setRentalDuration(7); 
            
            if (dao.update(filmeBuscado)) {
                System.out.println("✅ Filme ID " + filmeId + " atualizado.");
            } else {
                System.out.println("❌ Falha ao atualizar filme.");
            }

            System.out.println("\n--- 5. Excluindo Filme ID: " + filmeId + " ---");
            
            if (dao.delete(filmeId)) {
                System.out.println("✅ Filme ID " + filmeId + " excluído com sucesso.");
            } else {
                System.out.println("❌ Falha ao excluir filme (pode haver restrições de FK).");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro de Operação no Banco de Dados: " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
             System.err.println(e.getMessage());
        }
        
        System.out.println("\n*** Verifique o arquivo audit.log para o registro das operações de INSERT, UPDATE e DELETE. ***");
    }
}