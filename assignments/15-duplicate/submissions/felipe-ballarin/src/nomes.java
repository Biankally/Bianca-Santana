import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import static java.lang.System.out;

public class nomes {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        Set<String> nomesCadastrados = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            
            String nomeDigitado = leitor.nextLine();

            if (nomeDigitado.equalsIgnoreCase("FIM")) {
                break;
            }

            nomesCadastrados.add(nomeDigitado);
        }

        out.println("\nNomes cadastrados:");
        out.println(nomesCadastrados);

        out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {

            String nomePesquisado = leitor.nextLine();

            if (nomePesquisado.equalsIgnoreCase("sair")) {
                break;
            }

            if (nomesCadastrados.contains(nomePesquisado)) {
                out.println("Nome encontrado.");
            } else {
                out.println("Nome não encontrado.");
            }

        }

        leitor.close();
    }
}