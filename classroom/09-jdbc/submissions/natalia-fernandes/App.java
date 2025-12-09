import dao.FilmDAO;
import dao.ActorDAO;
import dvdrental.Film;
import dvdrental.Actor;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();

        int opcao;

        do {
            System.out.println("==== MENU DVDRENTAL ====");
            System.out.println("1 - Inserir novo filme");
            System.out.println("2 - Buscar filme por ID");
            System.out.println("3 - Listar atores de um filme (por film_id)");
            System.out.println("4 - Excluir ator por ID");
            System.out.println("5 - Atualizar filme (título/descrição/tempo)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> inserirFilme(sc, filmDAO);
                case 2 -> buscarFilme(sc, filmDAO);
                case 3 -> listarAtores(sc, actorDAO);
                case 4 -> excluirAtor(sc, actorDAO);
                case 5 -> atualizarFilme(sc, filmDAO);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

            System.out.println();

        } while (opcao != 0);

        sc.close();
    }

    private static void inserirFilme(Scanner sc, FilmDAO filmDAO) {
        System.out.print("Título: ");
        String title = sc.nextLine();

        System.out.print("Descrição: ");
        String description = sc.nextLine();

        System.out.print("Ano de lançamento (ex: 2006): ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Duração em minutos: ");
        int length = Integer.parseInt(sc.nextLine());

        Film film = new Film(title, description, year, length);
        filmDAO.insert(film);
        System.out.println("Filme inserido (confira o audit.log para o registro).");
    }

    private static void buscarFilme(Scanner sc, FilmDAO filmDAO) {
        System.out.print("ID do filme: ");
        int id = Integer.parseInt(sc.nextLine());

        Film film = filmDAO.findById(id);
        if (film != null) {
            System.out.println("Filme encontrado:");
            System.out.println(film);
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    private static void listarAtores(Scanner sc, ActorDAO actorDAO) {
        System.out.print("ID do filme (film_id): ");
        int filmId = Integer.parseInt(sc.nextLine());

        List<Actor> actors = actorDAO.findActorsByFilmId(filmId);
        if (actors.isEmpty()) {
            System.out.println("Nenhum ator encontrado para esse filme.");
        } else {
            System.out.println("Atores do filme " + filmId + ":");
            for (Actor a : actors) {
                System.out.println(a);
            }
        }
    }

    private static void excluirAtor(Scanner sc, ActorDAO actorDAO) {
        System.out.print("ID do ator (actor_id): ");
        int actorId = Integer.parseInt(sc.nextLine());

        actorDAO.deleteById(actorId);
        System.out.println("Se existir, o ator foi excluído (veja o audit.log).");
    }

    private static void atualizarFilme(Scanner sc, FilmDAO filmDAO) {
        System.out.print("ID do filme a atualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        Film film = filmDAO.findById(id);
        if (film == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.println("Filme atual: " + film);

        System.out.print("Novo título (deixe vazio para manter): ");
        String title = sc.nextLine();
        if (!title.isBlank()) {
            film.setTitle(title);
        }

        System.out.print("Nova descrição (deixe vazio para manter): ");
        String desc = sc.nextLine();
        if (!desc.isBlank()) {
            film.setDescription(desc);
        }

        System.out.print("Nova duração em minutos (0 para manter): ");
        String lenStr = sc.nextLine();
        if (!lenStr.isBlank()) {
            int len = Integer.parseInt(lenStr);
            if (len > 0) {
                film.setLengthMinutes(len);
            }
        }

        filmDAO.update(film);
        System.out.println("Filme atualizado (confira o audit.log).");
    }
}
