import java.util.List;
import java.util.Scanner;

import dao.DvdRentalDAO;
import model.Actor;
import model.Film;

public class Main {
    public static void main(String[] args) {
        DvdRentalDAO dao = new DvdRentalDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n--- DVD RENTAL MANAGER ---");
            System.out.println("1Readerrir Novo Filme");
            System.out.println("2. Buscar Filme por ID");
            System.out.println("3. Listar Atores de um Filme");
            System.out.println("4. Atualizar Titulo de Filme");
            System.out.println("5. Excluir Ator por ID");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Titulo: ");
                    String title = scanner.nextLine();
                    System.out.print("Descricao: ");
                    String desc = scanner.nextLine();
                    System.out.print("Ano Lancamento: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    dao.insertFilm(new Film(title, desc, year, 1));
                    break;
                case 2:
                    System.out.print("ID do Filme: ");
                    int idBusca = Integer.parseInt(scanner.nextLine());
                    Film f = dao.getFilmById(idBusca);
                    if (f != null) System.out.println(f);
                    else System.out.println("Filme nao encontrado.");
                    break;
                case 3:
                    System.out.print("ID do Filme: ");
                    int idFilmeActor = Integer.parseInt(scanner.nextLine());
                    List<Actor> atores = dao.getActorsByFilmId(idFilmeActor);
                    System.out.println("Atores no filme:");
                    for (Actor a : atores) System.out.println(a);
                    break;
                case 4:
                    System.out.print("ID do Filme para atualizar: ");
                    int idUpd = Integer.parseInt(scanner.nextLine());
                    System.out.print("Novo Titulo: ");
                    String novoTitulo = scanner.nextLine();
                    dao.updateFilmTitle(idUpd, novoTitulo);
                    break;
                case 5:
                    System.out.print("ID do Ator para excluir: ");
                    int idAtor = Integer.parseInt(scanner.nextLine());
                    dao.deleteActor(idAtor);
                    break;
                case 6:
                    System.out.println("Sair.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }
}