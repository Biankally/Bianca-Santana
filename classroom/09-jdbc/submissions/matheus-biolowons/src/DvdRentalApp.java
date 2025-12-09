import java.util.Scanner;

public class DvdRentalApp {
    public static void main(String[] args) {
        DatabaseConfig.initializeDatabase();

        var filmRepo = new FilmRepository();
        var actorRepo = new ActorRepository();
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== DVD RENTAL SYSTEM ===");
            System.out.println("1. Inserir Filme");
            System.out.println("2. Buscar Filme por ID");
            System.out.println("3. Listar Atores de um Filme");
            System.out.println("4. Excluir Ator");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            var option = scanner.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.println(">> Inserindo novo filme...");
                    Models.Film novoFilme = new Models.Film(null, "Matrix 4", 1, 3, 4.99, 19.99);
                    filmRepo.insert(novoFilme);
                }
                case "2" -> {
                    System.out.print("ID do Filme: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    filmRepo.findById(id).ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Filme não encontrado.")
                    );
                }
                case "3" -> {
                    System.out.print("ID do Filme para listar atores: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (actorRepo.findActorsByFilmId(id).isEmpty()) {
                        System.out.println("(Gerando atores de teste...)");
                        actorRepo.addActorToFilm("Keanu", "Reeves", id);
                    }

                    var actors = actorRepo.findActorsByFilmId(id);
                    System.out.println("Atores encontrados: " + actors.size());
                    actors.forEach(System.out::println);
                }
                case "4" -> {
                    System.out.print("ID do Ator para excluir: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    actorRepo.delete(id);
                }
                case "5" -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}