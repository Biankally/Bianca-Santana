package com.dvdrental;

import com.dvdrental.dao.ActorDAO;
import com.dvdrental.dao.FilmDAO;
import com.dvdrental.model.Actor;
import com.dvdrental.model.Film;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- DVD Rental System ---");
            System.out.println("1. Inserir novo filme");
            System.out.println("2. Buscar filme por ID");
            System.out.println("3. Listar atores de um filme");
            System.out.println("4. Excluir ator por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (option) {
                case 1:
                    Film newFilm = new Film();
                    System.out.print("Título: ");
                    newFilm.setTitle(scanner.nextLine());
                    System.out.print("Descrição: ");
                    newFilm.setDescription(scanner.nextLine());
                    System.out.print("Ano de Lançamento: ");
                    newFilm.setReleaseYear(scanner.nextInt());
                    System.out.print("ID do Idioma (ex: 1 para Inglês): ");
                    newFilm.setLanguageId(scanner.nextInt());
                    System.out.print("Preço de Locação: ");
                    newFilm.setRentalRate(scanner.nextDouble());
                    System.out.print("Duração (minutos): ");
                    newFilm.setLength(scanner.nextInt());
                    
                    filmDAO.insert(newFilm);
                    break;

                case 2:
                    System.out.print("ID do Filme: ");
                    int filmIdSearch = scanner.nextInt();
                    Film film = filmDAO.findById(filmIdSearch);
                    if (film != null) {
                        System.out.println("Filme encontrado: " + film);
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID do Filme: ");
                    int filmIdActors = scanner.nextInt();
                    List<Actor> actors = filmDAO.findActorsByFilmId(filmIdActors);
                    if (actors.isEmpty()) {
                        System.out.println("Nenhum ator encontrado para este filme.");
                    } else {
                        System.out.println("Atores:");
                        for (Actor actor : actors) {
                            System.out.println("- " + actor.getFirstName() + " " + actor.getLastName());
                        }
                    }
                    break;

                case 4:
                    System.out.print("ID do Ator para excluir: ");
                    int actorIdDelete = scanner.nextInt();
                    System.out.print("Tem certeza? (1-Sim, 0-Não): ");
                    if (scanner.nextInt() == 1) {
                        actorDAO.delete(actorIdDelete);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
