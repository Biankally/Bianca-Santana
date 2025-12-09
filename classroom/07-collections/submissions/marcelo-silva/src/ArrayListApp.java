import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {

    public static void main(String[] args) {
        
        System.out.println("--- Create and Print ArrayList ---");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n--- Iterate ArrayList Elements ---");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n--- Insert at First Position ---");
        cores.add(0, "Vermelho");
        System.out.println(cores);

        System.out.println("\n--- Retrieve Element by Index ---");
        int indice = 2;
        if (indice >= 0 && indice < cores.size()) {
            String elemento = cores.get(indice);
            System.out.println("Elemento no índice " + indice + ": " + elemento);
        } else {
            System.out.println("Índice " + indice + " está fora dos limites.");
        }
        System.out.println(cores);

        System.out.println("\n--- Update ArrayList Element ---");
        String elementoAtualizado = cores.set(1, "Laranja");
        System.out.println("Elemento substituído: " + elementoAtualizado);
        System.out.println(cores);

        System.out.println("\n--- Remove Third Element ---");
        int indiceRemover = 2;
        if (indiceRemover >= 0 && indiceRemover < cores.size()) {
            String removido = cores.remove(indiceRemover);
            System.out.println("Elemento removido: " + removido);
        } else {
            System.out.println("Índice " + indiceRemover + " não existe para remoção.");
        }
        System.out.println(cores);

        System.out.println("\n--- Search Element in ArrayList ---");
        String busca = "Azul";
        boolean contem = cores.contains(busca);
        System.out.println("A lista contém '" + busca + "'? " + contem);

        System.out.println("\n--- Sort ArrayList ---");
        Collections.sort(cores);
        System.out.println(cores);

        System.out.println("\n--- Copy ArrayList ---");
        List<String> copia = new ArrayList<>(cores);
        System.out.println("Cópia: " + copia);

        System.out.println("\n--- Shuffle ArrayList ---");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\n--- Reverse ArrayList ---");
        Collections.reverse(cores);
        System.out.println(cores);

        System.out.println("\n--- Extract Sublist from ArrayList ---");
        if (cores.size() >= 3) {
            List<String> sublista = cores.subList(1, 3);
            System.out.println("Sublista (índices 1 a 2): " + sublista);
        } else {
            System.out.println("Não é possível extrair sublista, tamanho insuficiente.");
        }

        System.out.println("\n--- Compare Two ArrayLists ---");
        System.out.println("Original: " + cores);
        System.out.println("Cópia: " + copia);
        boolean saoIguais = cores.equals(copia);
        System.out.println("Lista original e cópia são iguais? " + saoIguais);
        boolean selfCompare = cores.equals(cores);
        System.out.println("Lista original e ela mesma são iguais? " + selfCompare);

        System.out.println("\n--- Swap ArrayList Elements ---");
        if (cores.size() >= 2) {
            Collections.swap(cores, 0, 1);
            System.out.println("Após trocar elementos 0 e 1: " + cores);
        } else {
            System.out.println("Não é possível trocar, tamanho insuficiente.");
        }

        System.out.println("\n--- Join Two ArrayLists ---");
        List<String> cores2 = new ArrayList<>();
        cores2.add("Preto");
        cores2.add("Cinza");
        List<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(cores2);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + cores2);
        System.out.println("Lista Unida: " + listaUnida);

        System.out.println("\n--- Clone ArrayList ---");
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println("Clone: " + clone);

        System.out.println("\n--- Clear ArrayList ---");
        cores.clear();
        System.out.println("Lista após clear: " + cores);

        System.out.println("\n--- Check if ArrayList is Empty ---");
        System.out.println("A lista está vazia? " + cores.isEmpty());

        cores.add("Roxo");
        cores.add("Ciano");
        cores.add("Magenta");
        System.out.println("\n--- Lista Repopulada ---");
        System.out.println(cores);

        System.out.println("\n--- Trim ArrayList Capacity ---");
        cores.trimToSize();
        System.out.println("Capacidade da lista ajustada (trimToSize).");

        System.out.println("\n--- Increase ArrayList Capacity ---");
        cores.ensureCapacity(20);
        System.out.println("Capacidade mínima garantida (ensureCapacity 20).");

        System.out.println("\n--- Replace Second Element ---");
        if (cores.size() >= 2) {
            cores.set(1, "Marrom");
            System.out.println("Após substituir o segundo elemento: " + cores);
        } else {
            System.out.println("Não há segundo elemento para substituir.");
        }

        System.out.println("\n--- Print Elements by Position ---");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}