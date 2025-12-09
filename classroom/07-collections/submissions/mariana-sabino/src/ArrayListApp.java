import java.util.ArrayList;
import java.util.Collections;

public class ArrayListApp {
    public static void main(String[] args) {
        System.out.println("1. Create and print ArrayList");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate ArrayList elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println("3. Insert at First Position");
        cores.add(0, "Vermelho");
        System.out.println(cores);
        System.out.println();

        System.out.println("4. Retrieve Element by Index");
        int indice = 2;
        if (indice >= 0 && indice < cores.size()) {
            System.out.println("Elemento no índice " + indice + ": " + cores.get(indice));
        } else {
            System.out.println("Índice inválido");
        }
        System.out.println();

        System.out.println("5. Update ArrayList Element");
        int indiceAtualizar = 1;
        String novoValor = "Laranja";
        if (indiceAtualizar >= 0 && indiceAtualizar < cores.size()) {
            String elementoAntigo = cores.set(indiceAtualizar, novoValor);
            System.out.println("Elemento atualizado de '" + elementoAntigo + "' para '" + novoValor + "'");
        }
        System.out.println(cores);
        System.out.println();

        System.out.println("6. Remove Third Element");
        int indicRemover = 2;
        if (indicRemover >= 0 && indicRemover < cores.size()) {
            String removido = cores.remove(indicRemover);
            System.out.println("Removido: " + removido);
        } else {
            System.out.println("Índice inválido");
        }
        System.out.println(cores);
        System.out.println();

        System.out.println("7. Search Element in ArrayList");
        String buscar = "Azul";
        System.out.println("Contém '" + buscar + "': " + cores.contains(buscar));
        System.out.println();

        System.out.println("8. Sort ArrayList");
        Collections.sort(cores);
        System.out.println(cores);
        System.out.println();

        System.out.println("9. Copy ArrayList ");
        ArrayList<String> coresCopia = new ArrayList<>(cores);
        System.out.println("Lista copiada: " + coresCopia);
        System.out.println();

        System.out.println("10. Shuffle ArrayList");
        Collections.shuffle(cores);
        System.out.println(cores);
        System.out.println();

        System.out.println("11. Reverse ArrayList");
        Collections.reverse(cores);
        System.out.println(cores);
        System.out.println();

        System.out.println("12. Extract sublist from ArrayList");
        int fromIndex = 1;
        int toIndex = 3;
        if (fromIndex >= 0 && toIndex <= cores.size() && fromIndex < toIndex) {
            ArrayList<String> sublista = new ArrayList<>(cores.subList(fromIndex, toIndex));
            System.out.println("Sublista [" + fromIndex + ", " + toIndex + "): " + sublista);
        } else {
            System.out.println("Índices inválidos");
        }
        System.out.println();

        
        System.out.println("13. Compare two ArrayLists");
        ArrayList<String> outraLista = new ArrayList<>(cores);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + outraLista);
        System.out.println("São iguais: " + cores.equals(outraLista));
        System.out.println();

        System.out.println("14. Swap ArrayList elements");
        int pos1 = 0;
        int pos2 = cores.size() - 1;
        if (pos1 >= 0 && pos1 < cores.size() && pos2 >= 0 && pos2 < cores.size()) {
            Collections.swap(cores, pos1, pos2);
            System.out.println("Trocados elementos nas posições " + pos1 + " e " + pos2);
        }
        System.out.println(cores);
        System.out.println();

        System.out.println("15. Join two ArrayLists ");
        ArrayList<String> lista1 = new ArrayList<>();
        lista1.add("Rosa");
        lista1.add("Roxo");
        ArrayList<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(lista1);
        System.out.println("Lista unida: " + listaUnida);
        System.out.println();

        System.out.println("16. Clone ArrayList ");
        @SuppressWarnings("unchecked")
        ArrayList<String> coresClone = (ArrayList<String>) cores.clone();
        System.out.println("Lista clonada: " + coresClone);
        System.out.println();

        System.out.println("17. Clear ArrayList");
        ArrayList<String> listaParaLimpar = new ArrayList<>(cores);
        listaParaLimpar.clear();
        System.out.println("Lista após clear: " + listaParaLimpar);
        System.out.println();

        System.out.println("18. Check if ArrayList is empty");
        System.out.println("Lista original está vazia: " + cores.isEmpty());
        System.out.println("Lista limpa está vazia: " + listaParaLimpar.isEmpty());
        System.out.println();

        System.out.println("19. Trim ArrayList capacity");
        cores.trimToSize();
        System.out.println("Capacidade ajustada com trimToSize");
        System.out.println(cores);
        System.out.println();

        System.out.println("20. Increase ArrayList capacity");
        cores.ensureCapacity(20);
        System.out.println("Capacidade garantida para pelo menos 20 elementos");
        System.out.println(cores);
        System.out.println();

        System.out.println("21. Replace second element");
        int indiceSegundo = 1;
        if (indiceSegundo >= 0 && indiceSegundo < cores.size()) {
            String novoSegundo = "Cinza";
            cores.set(indiceSegundo, novoSegundo);
            System.out.println("Segundo elemento substituído por '" + novoSegundo + "'");
        }
        System.out.println(cores);
        System.out.println();

        
        System.out.println("22. Print elements by position");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}
