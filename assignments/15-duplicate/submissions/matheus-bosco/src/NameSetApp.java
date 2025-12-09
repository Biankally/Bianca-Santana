import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NameSetApp {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TreeSet com comparação que ignora maiusculas/minusculas, por exemplo, ele vai tratar ana e Ana como o mesmo nome
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);


        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            String linha = sc.nextLine();
            if (linha == null) break;

            String nome = linha.trim();
            if (nome.equalsIgnoreCase("fim")) break;
            if (nome.isEmpty()) continue; // ignora linhas vazias


            // Mantem o primeiro casing que aparecer, TreeSet ignora duplicados (case-insensitive)
            //se eu digitar primeiro matheus e depois Matheus, ele vai guardar matheus
            if (!nomes.contains(nome)) {
                nomes.add(nome);
            }
        }

        System.out.println();
        System.out.println("Nomes cadastrados: ");
        System.out.println(nomes);


        System.out.println();
        System.out.println("Pesquisar nomes (digite 'sair' para encerrar): ");
        while (true) {
            System.out.print("> ");
            String linha = sc.nextLine();
            if (linha == null) break;

            String consulta = linha.trim();    //consulta é igual a linha digitada após : ("Pesquisar nomes (digite 'sair' para encerrar): "
            if (consulta.equalsIgnoreCase("sair")) break;  
            if (consulta.isEmpty()) continue;


            boolean encontrado = nomes.contains(consulta);
            System.out.println(encontrado ? "Nome encontrado." : "Nome não encontrado.");
        }



        sc.close();
    }
}
