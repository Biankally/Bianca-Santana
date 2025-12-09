import java.util.*;

public class ArrayListApp {
    public static void main(String[] args) {
        System.out.println("=== ArrayList Operations ===");

        // Create and Print ArrayList
        System.out.println("\nCreate and Print ArrayList:");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        // Iterate ArrayList Elements
        System.out.println("\nIterate ArrayList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // Insert at First Position
        System.out.println("\nInsert at First Position:");
        cores.add(0, "Preto");
        System.out.println(cores);

        // Retrieve Element by Index
        System.out.println("\nRetrieve Element by Index:");
        int index = 2;
        if (index >= 0 && index < cores.size()) {
            System.out.println("Elemento no índice 2: " + cores.get(index));
        } else {
            System.out.println("Índice inválido!");
        }

        // Update ArrayList Element
        System.out.println("\nUpdate ArrayList Element:");
        if (!cores.isEmpty()) {
            String antigo = cores.set(1, "Roxo");
            System.out.println("Substituído '" + antigo + "' por 'Roxo'");
        }
        System.out.println(cores);

        // Remove Third Element
        System.out.println("\nRemove Third Element:");
        if (cores.size() > 2) {
            cores.remove(2);
        }
        System.out.println(cores);

        // Search Element in ArrayList
        System.out.println("\nSearch Element in ArrayList:");
        System.out.println("Contém 'Azul'? " + cores.contains("Azul"));

        // Sort ArrayList
        System.out.println("\nSort ArrayList:");
        Collections.sort(cores);
        System.out.println(cores);

        // Copy ArrayList
        System.out.println("\nCopy ArrayList:");
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("Cópia: " + copia);

        // Shuffle ArrayList
        System.out.println("\nShuffle ArrayList:");
        Collections.shuffle(cores);
        System.out.println(cores);

        // Reverse ArrayList
        System.out.println("\nReverse ArrayList:");
        Collections.reverse(cores);
        System.out.println(cores);

        // Extract Sublist from ArrayList
        System.out.println("\nExtract Sublist from ArrayList:");
        if (cores.size() >= 3) {
            List<String> sublista = cores.subList(1, 3);
            System.out.println("Sublista (1 a 3): " + sublista);
        }

        // Compare Two ArrayLists
        System.out.println("\nCompare Two ArrayLists:");
        System.out.println("Listas iguais? " + cores.equals(copia));

        // Swap ArrayList Elements
        System.out.println("\nSwap ArrayList Elements:");
        if (cores.size() > 2) {
            Collections.swap(cores, 0, 2);
        }
        System.out.println(cores);

        // Join Two ArrayLists
        System.out.println("\nJoin Two ArrayLists:");
        ArrayList<String> unida = new ArrayList<>(cores);
        unida.addAll(copia);
        System.out.println(unida);

        // Clone ArrayList
        System.out.println("\nClone ArrayList:");
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println("Clone: " + clone);

        // Clear ArrayList
        System.out.println("\nClear ArrayList:");
        cores.clear();
        System.out.println(cores);

        // Check if ArrayList is Empty
        System.out.println("\nCheck if ArrayList is Empty:");
        System.out.println(cores.isEmpty());

        // Trim ArrayList Capacity
        System.out.println("\nTrim ArrayList Capacity:");
        copia.trimToSize();
        System.out.println("Capacidade ajustada da cópia.");

        // Increase ArrayList Capacity
        System.out.println("\nIncrease ArrayList Capacity:");
        copia.ensureCapacity(10);
        System.out.println("Capacidade mínima garantida.");

        // Replace Second Element
        System.out.println("\nReplace Second Element:");
        if (copia.size() > 1) {
            copia.set(1, "Cinza");
        }
        System.out.println(copia);

        // Print Elements by Position
        System.out.println("\nPrint Elements by Position:");
        for (int i = 0; i < copia.size(); i++) {
            System.out.println(i + " -> " + copia.get(i));
        }
    }
}
