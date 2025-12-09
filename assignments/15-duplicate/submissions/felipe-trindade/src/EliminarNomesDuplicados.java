import java.util.*;

public class EliminarNomesDuplicados{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while(true){
            System.out.print("> ");
            String nome = sc.nextLine().trim();
            if (nome.equalsIgnoreCase("fim")) break;
            if (!nome.isEmpty()) nomes.add(nome);
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while(true){
            System.out.print("> ");
            String busca = sc.nextLine().trim();
            if(busca.equalsIgnoreCase("sair")) break;
            if(nomes.stream().anyMatch(n -> n.equalsIgnoreCase(busca))) {
                System.out.println("Nome encontrado.");
            }else{
                System.out.println("Nome não encontrado.");
            }
        }

        sc.close();
    }
}