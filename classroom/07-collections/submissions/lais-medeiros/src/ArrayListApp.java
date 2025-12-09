import java.util.ArrayList;
import java.util.Collections;

public class ArrayListApp {
    public static void main(String[] args) {

        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("Create and Print ArrayList: " + cores);

        System.out.println("Iterate ArrayList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }

        cores.add(0, "Laranja");
        System.out.println("Insert at First Position: " + cores);

        if (cores.size() > 2) {
            System.out.println("Retrieve Element by Index 2: " + cores.get(2));
        }

        if (!cores.isEmpty()) {
            String atualizado = cores.set(1, "Preto");
            System.out.println("Update ArrayList Element: " + cores);
        }

        if (cores.size() > 2) {
            cores.remove(2);
            System.out.println("Remove Third Element: " + cores);
        }

        System.out.println("Search 'Azul': " + cores.contains("Azul"));

        Collections.sort(cores);
        System.out.println("Sort ArrayList: " + cores);

        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("Copy ArrayList: " + copia);

        Collections.shuffle(cores);
        System.out.println("Shuffle ArrayList: " + cores);

        Collections.reverse(cores);
        System.out.println("Reverse ArrayList: " + cores);

        if (cores.size() >= 2) {
            System.out.println("Extract Sublist: " + cores.subList(0, 2));
        }

        System.out.println("Compare Two ArrayLists: " + cores.equals(copia));

        if (cores.size() > 2) {
            Collections.swap(cores, 0, 2);
            System.out.println("Swap Elements: " + cores);
        }

        ArrayList<String> unida = new ArrayList<>(cores);
        unida.addAll(copia);
        System.out.println("Join Two ArrayLists: " + unida);

        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println("Clone ArrayList: " + clone);

        cores.clear();
        System.out.println("Clear ArrayList: " + cores);

        System.out.println("Check Empty: " + cores.isEmpty());

        cores.trimToSize();
        System.out.println("Trim Capacity: completed");

        cores.ensureCapacity(5);
        System.out.println("Increase Capacity: completed");

        cores.add("Rosa");
        cores.add("Cinza");

        if (cores.size() > 1) {
            cores.set(1, "Vermelho");
        }
        System.out.println("Replace Second Element: " + cores);

        System.out.println("Print Elements by Position:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}
