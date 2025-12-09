import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminadorDeNomesDuplicados {

    public static void main(String[] args) {
        // ---- 1. Configuração ----
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

            // ---- 2. Cadastro ----
            System.out.println("Digite os nomes (digite 'fim' para encerrar):");

            while (true) {
                System.out.print("> ");
                String nome = scanner.nextLine();

                if (nome.equalsIgnoreCase("fim")) {
                    break;
                }

                // 'nome != null' removida.
                // Desnecessária, pois scanner.nextLine() não retorna null.
                // A verificação trim().isEmpty() é mantida para evitar nomes vazios.
                if (!nome.trim().isEmpty()) {
                    nomes.add(nome);
                }
            }

            // ---- 3. Exibição dos Nomes ----
            System.out.println("\nNomes cadastrados:");
            System.out.println(nomes);

            System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

            while (true) {
                System.out.print("> ");
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

            System.out.println("\nPrograma encerrado.");
            
        }
    }
}