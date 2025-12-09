import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetNomes {

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

            System.out.println("Digite os nomes (digite 'fim' para encerrar):");

            while (true) {
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("fim")) {
                    break;
                }
                
                if (!entrada.trim().isEmpty()) {
                   nomes.add(entrada);
                }
            }

            System.out.println("\nNomes cadastrados:");
            System.out.println(nomes);

            
            System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

            while (true) {
                String pesquisa = scanner.nextLine();

                if (pesquisa.equalsIgnoreCase("sair")) {
                    break;
                }

                if (nomes.contains(pesquisa)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }

        } 

        System.out.println("\nPrograma encerrado.");
    }
}