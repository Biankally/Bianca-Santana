import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminarNomesDuplicados {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            String entrada = leitor.nextLine().trim();
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            if (!entrada.isEmpty()) {
   
                if (!nomes.contains(entrada)) {
                    nomes.add(entrada);
                }
            }
        }

        System.out.println();
        System.out.println("Nomes cadastrados:");
        System.out.println(nomes);
        System.out.println();

        System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String busca = leitor.nextLine().trim();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            if (busca.isEmpty()) {
                continue;
            }
            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        leitor.close();
    }
}
