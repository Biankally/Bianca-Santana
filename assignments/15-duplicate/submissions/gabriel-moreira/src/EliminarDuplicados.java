import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Locale;

public class EliminarDuplicados {

    private static final String COMANDO_FIM_CADASTRO = "FIM";
    private static final String COMANDO_FIM_PESQUISA = "SAIR";

    public static void main(String[] args) {
        Set<String> nomesUnicos = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("--- Cadastro de Nomes ---");
        cadastrarNomes(scanner, nomesUnicos);

        System.out.println("\nNomes cadastrados (" + nomesUnicos.size() + "):");
        System.out.println(nomesUnicos);

        System.out.println("\n--- Pesquisa de Nomes ---");
        pesquisarNomes(scanner, nomesUnicos);

        System.out.println("\nPrograma encerrado. Obrigado!");
        scanner.close();
    }

    private static void cadastrarNomes(Scanner scanner, Set<String> nomesUnicos) {
        String entrada;
        System.out.println("Digite os nomes (digite '" + COMANDO_FIM_CADASTRO + "' para encerrar):");

        while (scanner.hasNextLine()) {
            entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase(COMANDO_FIM_CADASTRO)) {
                break;
            }

            if (!entrada.isEmpty()) {
                if (!nomesUnicos.add(entrada)) {
                    System.out.println("Nome '" + entrada + "' já existe (duplicata ignorada).");
                }
            }
        }
    }

    private static void pesquisarNomes(Scanner scanner, Set<String> nomesUnicos) {
        String termoPesquisa;
        System.out.println("Pesquisar nomes (digite '" + COMANDO_FIM_PESQUISA + "' para encerrar):");

        while (true) {
            System.out.print("> ");
            if (scanner.hasNextLine()) {
                termoPesquisa = scanner.nextLine().trim();
            } else {
                break;
            }

            if (termoPesquisa.equalsIgnoreCase(COMANDO_FIM_PESQUISA)) {
                break;
            }

            if (termoPesquisa.isEmpty()) {
                continue;
            }

            if (nomesUnicos.contains(termoPesquisa)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }
    }
}
