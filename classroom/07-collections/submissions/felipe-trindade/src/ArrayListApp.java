import java.util.*;

public class ArrayListApp{
    public static void main(String[] args){
        System.out.println("----- ArrayList -----");

        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("Create and Print ArrayList -> " + cores);

        System.out.println("Iterate ArrayList Elements");
        for(String c : cores) System.out.println(c);

        cores.add(0, "Preto");
        System.out.println("Insert at First Position -> " + cores);

        int idx = 2;
        String valIdx2 = (idx >= 0 && idx < cores.size()) ? cores.get(idx) : null;
        System.out.println("Retrieve Element by Index (2) -> " + valIdx2);

        int posAmarelo = cores.indexOf("Amarelo");
        if(posAmarelo != -1) cores.set(posAmarelo, "Ambar");
        System.out.println("Update ArrayList Element -> " + cores);

        if(cores.size() > 2) cores.remove(2);
        System.out.println("Remove Third Element -> " + cores);

        System.out.println("Search Element in ArrayList ('Azul') -> " + cores.contains("Azul"));

        Collections.sort(cores);
        System.out.println("Sort ArrayList -> " + cores);

        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("Copy ArrayList -> " + copia);

        Collections.shuffle(cores);
        System.out.println("Shuffle ArrayList -> " + cores);

        Collections.reverse(cores);
        System.out.println("Reverse ArrayList -> " + cores);

        int to = Math.min(2, cores.size());
        List<String> sub = cores.subList(0, to);
        System.out.println("Extract Sublist from ArrayList (0," + to + ") -> " + sub);

        System.out.println("Compare Two ArrayLists -> " + cores.equals(copia));

        if(cores.size() >= 2) Collections.swap(cores, 0, cores.size() - 1);
        System.out.println("Swap ArrayList Elements -> " + cores);

        ArrayList<String> outra = new ArrayList<>(Arrays.asList("Rosa", "Cinza"));
        ArrayList<String> unida = new ArrayList<>(cores);
        unida.addAll(outra);
        System.out.println("Join Two ArrayLists -> " + unida);

        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println("Clone ArrayList -> " + clone);

        clone.clear();
        System.out.println("Clear ArrayList (clone) -> " + clone);

        System.out.println("Check if ArrayList is Empty (clone) -> " + clone.isEmpty());

        cores.trimToSize();
        System.out.println("Trim ArrayList Capacity -> ok");

        cores.ensureCapacity(20);
        System.out.println("Increase ArrayList Capacity (ensureCapacity 20) -> ok");

        if(cores.size() > 1) cores.set(1, "SegundoElementoNovo");
        System.out.println("Replace Second Element -> " + cores);

        System.out.println("Print Elements by Position");
        for(int i = 0; i < cores.size(); i++) System.out.println(i + " -> " + cores.get(i));
    }
}