import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FilmDAO dao = new FilmDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Inserir Filme");
        System.out.println("2 - Buscar Filme");
        System.out.println("3 - Listar Atores do Filme");
        System.out.println("4 - Atualizar Filme");
        System.out.println("5 - Excluir Filme");
        System.out.println("6 - Excluir Ator");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                System.out.print("Descrição: ");
                String desc = sc.nextLine();
                dao.inserirFilme(titulo, desc);
            }
            case 2 -> {
                System.out.print("ID do filme: ");
                dao.buscarFilmePorId(sc.nextInt());
            }
            case 3 -> {
                System.out.print("ID do filme: ");
                dao.listarAtoresPorFilme(sc.nextInt());
            }
            case 4 -> {
                System.out.print("ID do filme: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Novo título: ");
                dao.atualizarFilme(id, sc.nextLine());
            }
            case 5 -> dao.excluirFilme(sc.nextInt());
            case 6 -> dao.excluirAtor(sc.nextInt());
        }

        sc.close();
    }
}
