package com.jdbc09;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicializa o DBConfig para garantir que o db.properties seja lido
        DBConfig.getUrl(); 
        
        // Se o DBConfig falhar (ex: arquivo não encontrado), a execução para aqui
        
        FilmDAO dao = new FilmDAO();

        // --------------------------------------------------
        // TESTE 1: INSERÇÃO (CREATE)
        // --------------------------------------------------
        System.out.println("\n--- 1. INSERINDO NOVO FILME (CREATE) ---");
        // Cria um novo objeto Film
        Film novoFilme = new Film("JAVA POO PROJECT", "Demonstração de JDBC puro e DAO.", 2025);
        
        // Insere no banco de dados e retorna o ID gerado
        int newId = dao.insert(novoFilme);
        System.out.println("Filme inserido com ID: " + newId);

        if (newId != -1) {
            // --------------------------------------------------
            // TESTE 2: BUSCA POR ID (READ)
            // --------------------------------------------------
            System.out.println("\n--- 2. BUSCANDO FILME POR ID (" + newId + ") ---");
            Film filmeBuscado = dao.findById(newId);
            
            if (filmeBuscado != null) {
                System.out.println("Filme Encontrado: " + filmeBuscado);
            } else {
                System.out.println("Erro: Filme não encontrado após a inserção.");
            }
            
            // --------------------------------------------------
            // TESTE 3: ATUALIZAÇÃO (UPDATE)
            // --------------------------------------------------
            System.out.println("\n--- 3. ATUALIZANDO FILME ---");
            // Altera o título do objeto
            filmeBuscado.setTitle("JAVA POO PROJECT - Versão Final");
            
            // Atualiza no banco de dados
            boolean updated = dao.update(filmeBuscado);
            System.out.println("Filme atualizado? " + (updated ? "Sim" : "Não"));
        } else {
            System.out.println("Não foi possível continuar o teste de CRUD pois a inserção falhou.");
        }

        // --------------------------------------------------
        // TESTE 4: LISTAR ATORES (READ com JOIN)
        // Usamos um ID existente (verifique o banco dvdrental, ID 1 é 'Academy Dinosaur')
        // --------------------------------------------------
        int existingFilmId = 1; 
        System.out.println("\n--- 4. LISTANDO ATORES DO FILME ID " + existingFilmId + " ---");
        List<String> actors = dao.findActorsByFilmId(existingFilmId);
        System.out.println("Total de Atores: " + actors.size());
        if (!actors.isEmpty()) {
            System.out.println("Primeiros Atores: " + actors.subList(0, Math.min(3, actors.size())));
        }

        // --------------------------------------------------
        // TESTE 5: EXCLUIR LIGAÇÃO DO ATOR (DELETE)
        // ATENÇÃO: Use um actor_id existente para teste (ex: 200, 'Thora Temple')
        // --------------------------------------------------
        int actorIdToDelete = 200; 
        System.out.println("\n--- 5. REMOVENDO ATOR ID " + actorIdToDelete + " DE FILMES (film_actor) ---");
        boolean actorRemoved = dao.deleteActorByActorId(actorIdToDelete);
        System.out.println("Ligaç(ões) de ator removida(s)? " + (actorRemoved ? "Sim" : "Não"));

        System.out.println("\n--- FIM DA EXECUÇÃO ---");
        System.out.println("Verifique o arquivo 'audit.log' e o seu banco de dados para validar as operações!");
    }
}