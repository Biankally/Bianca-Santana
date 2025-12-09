import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorNomes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String nomeInput = scanner.nextLine();

            if (nomeInput.equalsIgnoreCase("fim")) {
                break;
            }

            if (!nomeInput.trim().isEmpty()) {
                nomes.add(nomeInput);
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String nomeBusca = scanner.nextLine();

            if (nomeBusca.equalsIgnoreCase("sair")) {
                break;
            }

            if (nomes.contains(nomeBusca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        System.out.println("\nPrograma encerrado.");
        scanner.close();
    }
}