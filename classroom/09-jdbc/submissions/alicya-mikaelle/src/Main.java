import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        FilmDAO dao = new FilmDAO();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir filme");
            System.out.println("2 - Buscar filme por ID");
            System.out.println("3 - Editar filme");
            System.out.println("4 - Excluir filme");
            System.out.println("5 - Listar atores de um filme");
            System.out.println("6 - Excluir ator por ID");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int op = sc.nextInt();

            if (op == 0) break;

            switch (op) {

                case 1:
                    sc.nextLine();
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Descrição: ");
                    String d = sc.nextLine();
                    System.out.print("Language ID: ");
                    int lang = sc.nextInt();

                    Film f = new Film(t, d, lang);
                    dao.insert(f);
                    AuditService.log("INSERT film: " + t);
                    break;

                case 2:
                    System.out.print("ID: ");
                    Film film = dao.findById(sc.nextInt());
                    System.out.println(film == null ? "Não encontrado" : film.getTitle());
                    break;

                case 3:
                    System.out.print("ID: ");
                    int idUp = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo título: ");
                    String nt = sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String nd = sc.nextLine();
                    System.out.print("Language ID: ");
                    int nl = sc.nextInt();

                    Film fu = new Film(idUp, nt, nd, nl);
                    dao.update(fu);
                    AuditService.log("UPDATE film: " + idUp);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int del = sc.nextInt();
                    dao.delete(del);
                    AuditService.log("DELETE film: " + del);
                    break;

                case 5:
                    System.out.print("ID do filme: ");
                    List<String> actors = dao.listActors(sc.nextInt());
                    actors.forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("ID do ator: ");
                    int actorId = sc.nextInt();
                    dao.deleteActor(actorId);
                    AuditService.log("DELETE actor: " + actorId);
                    break;
            }
        }
        sc.close();
    }
}
