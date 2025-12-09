import java.util.*;

public class ArrayListApp {
    public static void main(String[] args) {
        System.out.println("Create and Print ArrayList:");
        ArrayList<String> cores = new ArrayList<>(Arrays.asList("Verde", "Amarelo", "Azul", "Branco"));
        System.out.println(cores);

        System.out.println("\nIterate ArrayList Elements:");
        for (String cor : cores) System.out.println(cor);

        System.out.println("\nInsert at First Position:");
        cores.add(0, "Vermelho");
        System.out.println(cores);

        System.out.println("\nRetrieve Element by Index:");
        int index = 2;
        if (index >= 0 && index < cores.size()) System.out.println("Elemento no índice 2: " + cores.get(index));

        System.out.println("\nUpdate ArrayList Element:");
        cores.set(1, "Rosa");
        System.out.println(cores);

        System.out.println("\nRemove Third Element:");
        if (cores.size() > 2) cores.remove(2);
        System.out.println(cores);

        System.out.println("\nSearch Element in ArrayList:");
        System.out.println(cores.contains("Azul"));

        System.out.println("\nSort ArrayList:");
        Collections.sort(cores);
        System.out.println(cores);

        System.out.println("\nCopy ArrayList:");
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println(copia);

        System.out.println("\nShuffle ArrayList:");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\nReverse ArrayList:");
        Collections.reverse(cores);
        System.out.println(cores);

        System.out.println("\nExtract Sublist from ArrayList:");
        if (cores.size() >= 3) System.out.println(cores.subList(0, 3));

        System.out.println("\nCompare Two ArrayLists:");
        System.out.println(cores.equals(copia));

        System.out.println("\nSwap ArrayList Elements:");
        if (cores.size() > 2) Collections.swap(cores, 0, 2);
        System.out.println(cores);

        System.out.println("\nJoin Two ArrayLists:");
        ArrayList<String> nova = new ArrayList<>(cores);
        nova.addAll(copia);
        System.out.println(nova);

        System.out.println("\nClone ArrayList:");
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println(clone);

        System.out.println("\nClear ArrayList:");
        cores.clear();
        System.out.println(cores);

        System.out.println("\nCheck if ArrayList is Empty:");
        System.out.println(cores.isEmpty());

        System.out.println("\nTrim ArrayList Capacity:");
        copia.trimToSize();
        System.out.println(copia);

        System.out.println("\nIncrease ArrayList Capacity:");
        copia.ensureCapacity(10);
        System.out.println("Capacidade mínima garantida (10)");

        System.out.println("\nReplace Second Element:");
        if (copia.size() > 1) copia.set(1, "Cinza");
        System.out.println(copia);

        System.out.println("\nPrint Elements by Position:");
        for (int i = 0; i < copia.size(); i++)
            System.out.println(i + " -> " + copia.get(i));
    }
}
