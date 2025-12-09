import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNamesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // O parâmetro 'String.CASE_INSENSITIVE_ORDER' garante que:
        // 1. A lista seja ordenada alfabeticamente.
        // 2. "ana" e "Ana" sejam tratados como o mesmo elemento (evita duplicatas).
        Set<String> names = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("=== Cadastro de Nomes ===");
        System.out.println("Digite os nomes um por um.");
        System.out.println("Digite 'fim' para encerrar o cadastro.\n");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim(); // .trim() remove espaços extras

            if (input.equalsIgnoreCase("fim")) break;

            if (!input.isEmpty()) {
                boolean added = names.add(input);
                if (!added) System.out.println("   (Aviso: '" + input + "' já foi cadastrado e será ignorado)");
            }
        }

        System.out.println("\n--------------------------------");
        System.out.println("Nomes cadastrados (Ordenados):");
        System.out.println(names);
        System.out.println("--------------------------------\n");

        System.out.println("=== Pesquisa de Nomes ===");
        System.out.println("Digite um nome para buscar ou 'sair' para fechar.\n");

        while (true) {
            System.out.print("Pesquisar > ");
            String searchName = scanner.nextLine().trim();

            if (searchName.equalsIgnoreCase("sair")) break;
            if (searchName.isEmpty()) continue;

            if (names.contains(searchName)) {
                System.out.println("Resultado: Nome encontrado.");
            } else {
                System.out.println("Resultado: Nome NÃO encontrado.");
            }
        }

        scanner.close();
    }
}