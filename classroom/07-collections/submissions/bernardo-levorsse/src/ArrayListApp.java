import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListApp {
    public static void main(String[] args) {
        System.out.println("1) Create and Print ArrayList");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde"); cores.add("Amarelo"); cores.add("Azul"); cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n2) Iterate ArrayList Elements");
        for (String c : cores) System.out.println(c);

        System.out.println("\n3) Insert at First Position");
        cores.add(0, "Preto");
        System.out.println(cores);

        System.out.println("\n4) Retrieve Element by Index (2)");
        int idx = 2;
        if (idx >= 0 && idx < cores.size()) System.out.println("Elemento(2) = " + cores.get(2));
        else System.out.println("Índice inválido");

        System.out.println("\n5) Update ArrayList Element");
        String antigo = cores.set(1, "Laranja");
        System.out.println("Trocou '" + antigo + "' por 'Laranja' -> " + cores);

        System.out.println("\n6) Remove Third Element (index 2)");
        if (cores.size() > 2) System.out.println("Removido: " + cores.remove(2));
        System.out.println(cores);

        System.out.println("\n7) Search Element in ArrayList ('Azul')");
        System.out.println(cores.contains("Azul"));

        System.out.println("\n8) Sort ArrayList");
        Collections.sort(cores);
        System.out.println(cores);

        System.out.println("\n9) Copy ArrayList");
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println(copia);

        System.out.println("\n10) Shuffle ArrayList");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\n11) Reverse ArrayList");
        Collections.reverse(cores);
        System.out.println(cores);

        System.out.println("\n12) Extract Sublist (0, Math.min(2,size))");
        int to = Math.min(2, cores.size());
        System.out.println(cores.subList(0, to));

        System.out.println("\n13) Compare Two ArrayLists (cores vs copia)");
        System.out.println(cores.equals(copia));

        System.out.println("\n14) Swap ArrayList Elements (0 <-> last)");
        if (cores.size() >= 2) Collections.swap(cores, 0, cores.size()-1);
        System.out.println(cores);

        System.out.println("\n15) Join Two ArrayLists");
        ArrayList<String> outra = new ArrayList<>(Arrays.asList("Cinza","Rosa"));
        ArrayList<String> uniao = new ArrayList<>(cores);
        uniao.addAll(outra);
        System.out.println(uniao);

        System.out.println("\n16) Clone ArrayList");
        @SuppressWarnings("unchecked")
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println(clone);

        System.out.println("\n17) Clear ArrayList");
        cores.clear();
        System.out.println(cores);

        System.out.println("\n18) Check if ArrayList is Empty");
        System.out.println(cores.isEmpty());

        System.out.println("\n19) Trim ArrayList Capacity");
        cores.trimToSize();
        System.out.println("trimToSize chamado (lista: " + cores + ")");

        System.out.println("\n20) Increase ArrayList Capacity (ensureCapacity 10)");
        cores.ensureCapacity(10);
        System.out.println("ensureCapacity(10) chamado");

        System.out.println("\n21) Replace Second Element (index 1) — adicionando antes");
        cores.addAll(Arrays.asList("A","B","C"));
        if (cores.size() > 1) cores.set(1, "Z");
        System.out.println(cores);

        System.out.println("\n22) Print Elements by Position");
        for (int i=0;i<cores.size();i++) System.out.println(i + " -> " + cores.get(i));
    }
}
