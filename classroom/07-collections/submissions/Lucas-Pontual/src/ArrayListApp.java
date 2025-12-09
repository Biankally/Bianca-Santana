import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListApp {

    public static void main(String[] args) {

        System.out.println("1. Create and Print ArrayList");
        List<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate ArrayList Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println("3. Insert at First Position");
        cores.add(0, "Preto");
        System.out.println(cores);
        System.out.println();

        System.out.println("4. Retrieve Element by Index");
        int index = 2;
        if (index >= 0 && index < cores.size()) {
            String elemento = cores.get(index);
            System.out.println("Elemento no índice " + index + ": " + elemento);
        } else {
            System.out.println("Índice inválido: " + index);
        }
        System.out.println();

        System.out.println("5. Update ArrayList Element");
        String antigoElemento = cores.set(cores.size() - 1, "Cinza");
        System.out.println("Elemento substituído: " + antigoElemento);
        System.out.println("Lista atualizada: " + cores);
        System.out.println();

        System.out.println("6. Remove Third Element");
        int indiceRemover = 2;
        if (indiceRemover >= 0 && indiceRemover < cores.size()) {
            String removido = cores.remove(indiceRemover);
            System.out.println("Elemento removido no índice " + indiceRemover + ": " + removido);
        } else {
            System.out.println("Não foi possível remover, índice inválido: " + indiceRemover);
        }
        System.out.println(cores);
        System.out.println();

        System.out.println("7. Search Element in ArrayList");
        String busca = "Amarelo";
        boolean encontrado = cores.contains(busca);
        System.out.println("O elemento '" + busca + "' está presente? " + encontrado);
        System.out.println();

        System.out.println("8. Sort ArrayList");
        Collections.sort(cores);
        System.out.println(cores);
        System.out.println();

        System.out.println("9. Copy ArrayList");
        List<String> copiaCores = new ArrayList<>(cores);
        System.out.println("Cópia da lista: " + copiaCores);
        System.out.println();

        System.out.println("10. Shuffle ArrayList");
        Collections.shuffle(cores);
        System.out.println(cores);
        System.out.println();

        System.out.println("11. Reverse ArrayList");
        Collections.reverse(cores);
        System.out.println(cores);
        System.out.println();

        System.out.println("12. Extract Sublist from ArrayList");
        int fromIndex = 1;
        int toIndex = cores.size() - 1;
        if (fromIndex >= 0 && toIndex <= cores.size() && fromIndex <= toIndex) {
            List<String> subLista = cores.subList(fromIndex, toIndex);
            System.out.println("Sublista de " + fromIndex + " a " + toIndex + ": " + subLista);
        } else {
            System.out.println("Índices de sublista inválidos.");
        }
        System.out.println();

        System.out.println("13. Compare Two ArrayLists");
        List<String> lista1 = new ArrayList<>(List.of("A", "B", "C"));
        List<String> lista2 = new ArrayList<>(List.of("A", "B", "C"));
        List<String> lista3 = new ArrayList<>(List.of("C", "B", "A"));
        boolean comparacao1 = lista1.equals(lista2);
        boolean comparacao2 = lista1.equals(lista3);
        System.out.println(lista1 + " é igual a " + lista2 + "? " + comparacao1);
        System.out.println(lista1 + " é igual a " + lista3 + "? " + comparacao2);
        System.out.println();

        System.out.println("14. Swap ArrayList Elements");
        List<String> listaSwap = new ArrayList<>(List.of("Um", "Dois", "Três", "Quatro"));
        Collections.swap(listaSwap, 0, 3);
        System.out.println(listaSwap);
        System.out.println();

        System.out.println("15. Join Two ArrayLists");
        List<String> listaA = new ArrayList<>(List.of("Vermelho", "Laranja"));
        List<String> listaB = new ArrayList<>(List.of("Roxo", "Rosa"));
        List<String> listaUnida = new ArrayList<>(listaA);
        listaUnida.addAll(listaB);
        System.out.println(listaUnida);
        System.out.println();

        System.out.println("16. Clone ArrayList");
        @SuppressWarnings("unchecked")
        ArrayList<String> listaClone = (ArrayList<String>) ((ArrayList<String>) cores).clone();
        System.out.println("Clone: " + listaClone);
        System.out.println();

        System.out.println("17. Clear ArrayList");
        listaClone.clear();
        System.out.println("Lista após clear: " + listaClone);
        System.out.println();

        System.out.println("18. Check if ArrayList is Empty");
        boolean estaVazia = cores.isEmpty();
        System.out.println("A lista 'cores' está vazia? " + estaVazia);
        boolean cloneVazio = listaClone.isEmpty();
        System.out.println("A lista 'listaClone' está vazia? " + cloneVazio);
        System.out.println();

        System.out.println("19. Trim ArrayList Capacity");
        ((ArrayList<String>) cores).trimToSize();
        System.out.println("trimToSize chamado");
        System.out.println();

        System.out.println("20. Increase ArrayList Capacity");
        ((ArrayList<String>) cores).ensureCapacity(20);
        System.out.println("ensureCapacity chamado");
        System.out.println();

        System.out.println("21. Replace Second Element");
        if (cores.size() > 1) {
            String novoValor = "Ciano";
            cores.set(1, novoValor);
            System.out.println("Segundo elemento substituído por: " + novoValor);
        }
        System.out.println(cores);
        System.out.println();

        System.out.println("22. Print Elements by Position");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println();
    }
}
