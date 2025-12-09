import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CadastroNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER); // ignora maiúsculas/minúsculas

        // Entrada de nomes
        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            String nome = scanner.nextLine().trim();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }
            if (!nome.isEmpty()) {
                nomes.add(nome);
            }
        }

        // Exibe nomes cadastrados
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        // Pesquisa de nomes
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String busca = scanner.nextLine().trim();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
