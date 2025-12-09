import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {

    public static void main(String[] args) {
        
        System.out.println("Create and Print ArrayList:");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Iterate ArrayList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("---");

        System.out.println("Insert at First Position:");
        cores.add(0, "Vermelho");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Retrieve Element by Index:");
        int index = 2;
        if (index >= 0 && index < cores.size()) {
            System.out.println("Elemento no indice " + index + ": " + cores.get(index));
        } else {
            System.out.println("Indice invalido.");
        }
        System.out.println("---");

        System.out.println("Update ArrayList Element:");
        String elementoAtualizado = cores.set(1, "Laranja");
        System.out.println("Elemento substituido: " + elementoAtualizado);
        System.out.println("Lista atualizada: " + cores);
        System.out.println("---");

        System.out.println("Remove Third Element:");
        int removeIndex = 2;
        if (removeIndex >= 0 && removeIndex < cores.size()) {
            String elementoRemovido = cores.remove(removeIndex);
            System.out.println("Elemento removido: " + elementoRemovido);
            System.out.println(cores);
        } else {
            System.out.println("Indice invalido para remocao.");
        }
        System.out.println("---");

        System.out.println("Search Element in ArrayList:");
        String busca = "Azul";
        System.out.println("A lista contem '" + busca + "'? " + cores.contains(busca));
        System.out.println("---");

        System.out.println("Sort ArrayList:");
        Collections.sort(cores);
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Copy ArrayList:");
        List<String> copia = new ArrayList<>(cores);
        System.out.println("Copia: " + copia);
        System.out.println("---");

        System.out.println("Shuffle ArrayList:");
        Collections.shuffle(cores);
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Reverse ArrayList:");
        Collections.reverse(cores);
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Extract Sublist from ArrayList:");
        if (cores.size() >= 3) {
            List<String> sublista = cores.subList(0, 2);
            System.out.println("Sublista (0 a 2): " + sublista);
        }
        System.out.println("---");

        System.out.println("Compare Two ArrayLists:");
        ArrayList<String> cores2 = new ArrayList<>(cores);
        System.out.println("Listas sao iguais? " + cores.equals(cores2));
        cores2.add("Preto");
        System.out.println("Listas sao iguais apos modificacao? " + cores.equals(cores2));
        System.out.println("---");

        System.out.println("Swap ArrayList Elements:");
        if (cores.size() >= 2) {
            Collections.swap(cores, 0, 1);
            System.out.println(cores);
        }
        System.out.println("---");

        System.out.println("Join Two ArrayLists:");
        ArrayList<String> coresExtras = new ArrayList<>();
        coresExtras.add("Cinza");
        coresExtras.add("Preto");
        
        ArrayList<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(coresExtras);
        System.out.println(listaUnida);
        System.out.println("---");

        System.out.println("Clone ArrayList:");
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println("Clone: " + clone);
        System.out.println("---");

        System.out.println("Clear ArrayList:");
        cores.clear();
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Check if ArrayList is Empty:");
        System.out.println("A lista esta vazia? " + cores.isEmpty());
        System.out.println("---");
        
        cores.add("Roxo");
        cores.add("Ciano");
        
        System.out.println("Trim ArrayList Capacity:");
        cores.trimToSize();
        System.out.println("Capacidade ajustada.");
        System.out.println("---");

        System.out.println("Increase ArrayList Capacity:");
        cores.ensureCapacity(10);
        System.out.println("Capacidade aumentada.");
        System.out.println("---");

        System.out.println("Replace Second Element:");
        if (cores.size() >= 2) {
            cores.set(1, "Magenta");
            System.out.println(cores);
        }
        System.out.println("---");

        System.out.println("Print Elements by Position:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println("---");
    }
}