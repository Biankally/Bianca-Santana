package submissions.nome-sobrenome.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {
        
        System.out.println("1. Create and Print ArrayList");
        List<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Roxo");
        cores.add("Preto");
        System.out.println(cores);

        System.out.println("\n2. Iterate ArrayList Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n3. Insert at First Position");
        cores.add(0, "Vermelho");
        System.out.println(cores);

        System.out.println("\n4. Retrieve Element by Index");
        int indiceBusca = 2;
        if (indiceBusca >= 0 && indiceBusca < cores.size()) {
            System.out.println("Elemento no índice " + indiceBusca + ": " + cores.get(indiceBusca));
        } else {
            System.out.println("Índice inválido.");
        }

        System.out.println("\n5. Update ArrayList Element");
        int indiceSubstituir = 3;
        String elementoAntigo = cores.set(indiceSubstituir, "Laranja");
        System.out.println("Elemento substituído (" + elementoAntigo + ") pelo novo: Laranja");
        System.out.println(cores);

        System.out.println("\n6. Remove Third Element");
        int indiceRemover = 2;
        if (indiceRemover >= 0 && indiceRemover < cores.size()) {
            cores.remove(indiceRemover);
            System.out.println("Lista após remoção do terceiro elemento (índice " + indiceRemover + "): " + cores);
        } else {
            System.out.println("Índice de remoção inválido.");
        }
        
        System.out.println("\n7. Search Element in ArrayList");
        String elementoProcurado = "Amarelo";
        System.out.println("Contém " + elementoProcurado + ": " + cores.contains(elementoProcurado));

        System.out.println("\n8. Sort ArrayList");
        Collections.sort(cores);
        System.out.println(cores);

        System.out.println("\n9. Copy ArrayList");
        List<String> copiaCores = new ArrayList<>(cores);
        System.out.println(copiaCores);

        System.out.println("\n10. Shuffle ArrayList");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\n11. Reverse ArrayList");
        Collections.reverse(cores);
        System.out.println(cores);

        System.out.println("\n12. Extract Sublist from ArrayList");
        List<String> subLista = cores.subList(1, 4);
        System.out.println(subLista);

        System.out.println("\n13. Compare Two ArrayLists");
        List<String> outraLista = new ArrayList<>(copiaCores);
        System.out.println("Cores vs CopiaCores (após sort): " + cores.equals(copiaCores));
        System.out.println("CopiaCores vs OutraLista: " + copiaCores.equals(outraLista));

        System.out.println("\n14. Swap ArrayList Elements");
        Collections.swap(cores, 0, cores.size() - 1);
        System.out.println(cores);

        System.out.println("\n15. Join Two ArrayLists");
        List<String> listaSecundaria = new ArrayList<>();
        listaSecundaria.add("Ciano");
        listaSecundaria.add("Magenta");
        List<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(listaSecundaria);
        System.out.println(listaUnida);

        System.out.println("\n16. Clone ArrayList");
        @SuppressWarnings("unchecked")
        ArrayList<String> coresClonadas = (ArrayList<String>) ((ArrayList<String>) cores).clone();
        System.out.println(coresClonadas);

        System.out.println("\n17. Clear ArrayList");
        listaSecundaria.clear();
        System.out.println(listaSecundaria);

        System.out.println("\n18. Check if ArrayList is Empty");
        System.out.println("Lista secundária vazia: " + listaSecundaria.isEmpty());

        System.out.println("\n19. Trim ArrayList Capacity");
        ((ArrayList<String>) cores).trimToSize();
        System.out.println("TrimToSize chamado para 'cores'.");

        System.out.println("\n20. Increase ArrayList Capacity");
        ((ArrayList<String>) cores).ensureCapacity(20);
        System.out.println("EnsureCapacity chamado para 'cores'.");

        System.out.println("\n21. Replace Second Element");
        cores.set(1, "Cinza");
        System.out.println(cores);

        System.out.println("\n22. Print Elements by Position");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}