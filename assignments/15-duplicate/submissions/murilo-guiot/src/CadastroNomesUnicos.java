import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CadastroNomesUnicos {

    public static void main(String[] args) {

        Set<String> nomesCadastrados = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String nomeInput = scanner.nextLine();

            if (nomeInput.equalsIgnoreCase("fim")) {
                break;
            }

            if (nomeInput.trim().isEmpty()) {
                continue;
            }

            nomesCadastrados.add(nomeInput);
        }

        //  Exibição dos Nomes 
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomesCadastrados);


        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String nomeBusca = scanner.nextLine();

            if (nomeBusca.equalsIgnoreCase("sair")) {
                break;
            }

            if (nomesCadastrados.contains(nomeBusca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
        System.out.println("\nPrograma encerrado.");
    }
}