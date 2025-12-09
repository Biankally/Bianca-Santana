import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorDeNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instanciamos um TreeSet com um Comparador Case-Insensitive.
        // Isso garante que 'Ana' e 'ana' sejam tratados como iguais,
        // mas preserva a formatação da primeira inserção.
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("=== Cadastro de Nomes ===");
        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        // 1. Loop de Inserção
        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            if (!entrada.isEmpty()) {
                boolean adicionado = nomes.add(entrada);
                // Opcional: Feedback visual se foi duplicado ou não
                // if (!adicionado) System.out.println(" (Duplicado ignorado)");
            }
        }

        // 2. Exibição dos dados ordenados
        System.out.println("\nNomes cadastrados:");
        // O toString() padrão do Set já exibe no formato [Nome1, Nome2, ...]
        System.out.println(nomes);

        // 3. Loop de Pesquisa
        System.out.println("\n=== Pesquisa ===");
        System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String busca = scanner.nextLine().trim();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            // O método contains usa o mesmo comparador do TreeSet (case-insensitive)
            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}