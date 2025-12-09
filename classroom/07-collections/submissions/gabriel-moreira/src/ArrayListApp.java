
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {
        System.out.println("Create and Print ArrayList:");
        List<String> cores = new ArrayList<>(List.of("Verde", "Amarelo", "Azul", "Branco"));
        System.out.println(cores);

        System.out.println("Iterate ArrayList Elements:");
        for (String cor : cores) System.out.println(cor);

        System.out.println("Insert at First Position:");
        cores.add(0, "Preto");
        System.out.println(cores);

        System.out.println("Retrieve Element by Index:");
        if (cores.size() > 2) System.out.println(cores.get(2));

        System.out.println("Update ArrayList Element:");
        cores.set(1, "Roxo");
        System.out.println(cores);

        System.out.println("Remove Third Element:");
        if (cores.size() > 2) cores.remove(2);
        System.out.println(cores);

        System.out.println("Search Element in ArrayList:");
        System.out.println(cores.contains("Azul"));

        System.out.println("Sort ArrayList:");
        Collections.sort(cores);
        System.out.println(cores);

        System.out.println("Copy ArrayList:");
        List<String> copia = new ArrayList<>(cores);
        System.out.println(copia);

        System.out.println("Shuffle ArrayList:");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("Reverse ArrayList:");
        Collections.reverse(cores);
        System.out.println(cores);

        System.out.println("Extract Sublist from ArrayList:");
        if (cores.size() >= 3) System.out.println(cores.subList(1, 3));

        System.out.println("Compare Two ArrayLists:");
        System.out.println(cores.equals(copia));

        System.out.println("Swap ArrayList Elements:");
        if (cores.size() > 1) Collections.swap(cores, 0, 1);
        System.out.println(cores);

        System.out.println("Join Two ArrayLists:");
        List<String> unida = new ArrayList<>(cores);
        unida.addAll(copia);
        System.out.println(unida);

        System.out.println("Clone ArrayList:");
        List<String> clone = (List<String>) ((ArrayList<String>) cores).clone();
        System.out.println(clone);

        System.out.println("Clear ArrayList:");
        cores.clear();
        System.out.println(cores);

        System.out.println("Check if ArrayList is Empty:");
        System.out.println(cores.isEmpty());

        System.out.println("Trim ArrayList Capacity:");
        ((ArrayList<String>) copia).trimToSize();

        System.out.println("Increase ArrayList Capacity:");
        ((ArrayList<String>) copia).ensureCapacity(100);

        System.out.println("Replace Second Element:");
        if (copia.size() > 1) copia.set(1, "Ciano");
        System.out.println(copia);

        System.out.println("Print Elements by Position:");
        for (int i = 0; i < copia.size(); i++)
            System.out.println(i + " -> " + copia.get(i));
    }
}
