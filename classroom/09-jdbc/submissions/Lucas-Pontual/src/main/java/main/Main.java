package main;

import service.DvdRentalService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Filmes");
        System.out.println("--------------------------------------------------");

        // 1. Inserir um novo filme
        DvdRentalService.inserirFilme("O Retorno do JDBC", "Um filme sobre bancos de dados.", 2025, 1, 7, 5.99, 120, 25.99, "PG");
        System.out.println("--------------------------------------------------");

        // 2. Buscar filme por ID (usando um ID conhecido)
        DvdRentalService.buscarFilme(1);
        System.out.println("--------------------------------------------------");

        // 3. Listar atores de um filme, buscar filme por ID (usando um ID conhecido)
        DvdRentalService.listarAtoresDoFilme(1);
        System.out.println("--------------------------------------------------");

        // 4. Excluir ator por ID (usando um ID que provavelmente existe)
        // ATENÇÃO: A exclusão de um ator pode falhar devido a chaves estrangeiras.
        // Usaremos um ID alto (999) para simular a exclusão de um ator que não existe,
        // e um ID baixo (1) para simular a exclusão de um ator que existe (e que pode falhar).
        DvdRentalService.excluirAtor(1);
        DvdRentalService.excluirAtor(999);
        System.out.println("--------------------------------------------------");

        // O requisito 5 (Log de auditoria) é tratado dentro dos métodos do DvdRentalService.

        System.out.println("Fim dos dados");
    }
}
