import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NameRegistry {

    public static void main(String[] args) {
        
        // Conjunto para armazenar nomes únicos com comparação case-insensitive
        Set<String> nomesCadastrados = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Scanner scanner = new Scanner(System.in);
        String entrada;

        // Fase de cadastro de nomes
        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            if (!entrada.isEmpty()) {
                nomesCadastrados.add(entrada);
            }
        }

        // Exibir nomes cadastrados
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomesCadastrados);

        // Fase de pesquisa
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            if (!entrada.isEmpty()) {
                // A pesquisa é case-insensitive devido ao comparator
                if (nomesCadastrados.contains(entrada)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }
        }

        scanner.close();
    }
}

