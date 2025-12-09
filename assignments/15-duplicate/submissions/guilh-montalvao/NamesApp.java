import java.util.Scanner;
import java.util.TreeSet;

public class NamesApp {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite os nomes (digite 'fim' para encerrar):");
            while (true) {
                String line = scanner.nextLine();
                if (line == null) {
                    break;
                }
                String value = line.trim();
                if (value.isEmpty()) {
                    continue;
                }
                if (value.equalsIgnoreCase("fim")) {
                    break;
                }
                names.add(value);
            }

            System.out.println();
            System.out.println("Nomes cadastrados:");
            System.out.println(names);

            System.out.println();
            System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");
            while (true) {
                String query = scanner.nextLine();
                if (query == null) {
                    break;
                }
                String q = query.trim();
                if (q.equalsIgnoreCase("sair")) {
                    break;
                }
                if (q.isEmpty()) {
                    continue;
                }
                System.out.println(names.contains(q) ? "Nome encontrado." : "Nome não encontrado.");
            }
        }
    }
}
