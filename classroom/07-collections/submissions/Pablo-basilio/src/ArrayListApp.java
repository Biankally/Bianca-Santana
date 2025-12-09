import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {

    public static void main(String[] args) {
        System.out.println("### Iniciando ArrayListApp ###\n");

        System.out.println("[Operação 1]: Create and Print ArrayList");
        List<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 2]: Iterate ArrayList Elements");
        System.out.println("Resultado:");
        for (String cor : cores) {
            System.out.println("- " + cor);
        }

        System.out.println("\n[Operação 3]: Insert at First Position");
        cores.add(0, "Vermelho");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 4]: Retrieve Element by Index (índice 2)");
        int index = 2;
        if (index >= 0 && index < cores.size()) {
            String elemento = cores.get(index);
            System.out.println("Resultado: " + elemento);
        } else {
            System.out.println("Resultado: Índice inválido.");
        }

        System.out.println("\n[Operação 5]: Update ArrayList Element (índice 1 por 'Laranja')");
        cores.set(1, "Laranja");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 6]: Remove Third Element (índice 2)");
        if (cores.size() > 2) {
            cores.remove(2);
            System.out.println("Resultado: " + cores);
        } else {
            System.out.println("Resultado: Lista não possui elemento no índice 2.");
        }

        System.out.println("\n[Operação 7]: Search Element in ArrayList ('Laranja')");
        boolean contem = cores.contains("Laranja");
        System.out.println("Resultado: " + contem);

        System.out.println("\n[Operação 8]: Sort ArrayList");
        Collections.sort(cores);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 9]: Copy ArrayList");
        List<String> copiaCores = new ArrayList<>(cores);
        System.out.println("Resultado: " + copiaCores);

        System.out.println("\n[Operação 10]: Shuffle ArrayList");
        Collections.shuffle(cores);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 11]: Reverse ArrayList");
        Collections.reverse(cores);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 12]: Extract Sublist from ArrayList (índice 1 a 3)");
        if (cores.size() >= 3) {
            List<String> sublista = cores.subList(1, 3);
            System.out.println("Resultado: " + sublista);
        } else {
            System.out.println("Resultado: Tamanho insuficiente para sublista.");
        }

        System.out.println("\n[Operação 13]: Compare Two ArrayLists");
        List<String> coresComparacao = new ArrayList<>(cores);
        boolean saoIguais = cores.equals(coresComparacao);
        System.out.println("Resultado: " + saoIguais);

        System.out.println("\n[Operação 14]: Swap ArrayList Elements (índice 0 e 2)");
        if (cores.size() > 2) {
            Collections.swap(cores, 0, 2);
            System.out.println("Resultado: " + cores);
        } else {
             System.out.println("Resultado: Tamanho insuficiente para troca.");
        }

        System.out.println("\n[Operação 15]: Join Two ArrayLists");
        List<String> novasCores = new ArrayList<>();
        novasCores.add("Preto");
        novasCores.add("Cinza");
        List<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(novasCores);
        System.out.println("Resultado: " + listaUnida);

        System.out.println("\n[Operação 16]: Clone ArrayList");
        ArrayList<String> cloneList = (ArrayList<String>) ((ArrayList<String>) cores).clone();
        System.out.println("Resultado: " + cloneList);

        System.out.println("\n[Operação 17]: Clear ArrayList");
        cores.clear();
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 18]: Check if ArrayList is Empty");
        System.out.println("Resultado: " + cores.isEmpty());

        System.out.println("\n[Operação 19]: Trim ArrayList Capacity");
        ArrayList<String> listaTrim = new ArrayList<>(10);
        listaTrim.add("Item 1");
        listaTrim.add("Item 2");
        listaTrim.trimToSize();
        System.out.println("Resultado: trimToSize() chamado. Lista: " + listaTrim);

        System.out.println("\n[Operação 20]: Increase ArrayList Capacity");
        listaTrim.ensureCapacity(15);
        System.out.println("Resultado: ensureCapacity(15) chamado.");

        System.out.println("\n[Operação 21]: Replace Second Element (índice 1)");
        cores.add("Ciano");
        cores.add("Magenta");
        cores.add("Roxo");
        cores.set(1, "NovoMagenta");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 22]: Print Elements by Position");
        System.out.println("Resultado:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        System.out.println("\n### ArrayListApp Finalizado ###");
    }
}