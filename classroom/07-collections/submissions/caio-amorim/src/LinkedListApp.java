import java.util.*;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>(Arrays.asList("Verde", "Amarelo", "Azul", "Branco"));

        System.out.println("Append Element:");
        cores.add("Preto");
        System.out.println(cores);

        System.out.println("\nIterate LinkedList Elements:");
        for (String cor : cores) System.out.println(cor);

        System.out.println("\nIterate from Position (2):");
        for (int i = 2; i < cores.size(); i++) System.out.println(cores.get(i));

        System.out.println("\nIterate in Reverse Order:");
        Iterator<String> it = cores.descendingIterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nInsert at Position (2):");
        cores.add(2, "Rosa");
        System.out.println(cores);

        System.out.println("\nInsert First and Last:");
        cores.addFirst("Laranja");
        cores.addLast("Cinza");
        System.out.println(cores);

        System.out.println("\nInsert at Front:");
        cores.addFirst("Marrom");
        System.out.println(cores);

        System.out.println("\nInsert at End:");
        cores.addLast("Roxo");
        System.out.println(cores);

        System.out.println("\nInsert Multiple at Position (3):");
        cores.addAll(3, Arrays.asList("Dourado", "Prata"));
        System.out.println(cores);

        System.out.println("\nFirst and Last Occurrence of 'Azul':");
        System.out.println("Primeira: " + cores.indexOf("Azul"));
        System.out.println("Última: " + cores.lastIndexOf("Azul"));

        System.out.println("\nPrint Elements with Positions:");
        for (int i = 0; i < cores.size(); i++)
            System.out.println(i + " -> " + cores.get(i));

        System.out.println("\nRemove Element 'Rosa':");
        cores.remove("Rosa");
        System.out.println(cores);

        System.out.println("\nRemove First and Last:");
        cores.removeFirst();
        cores.removeLast();
        System.out.println(cores);

        System.out.println("\nSwap Elements (0 e 2):");
        Collections.swap(cores, 0, 2);
        System.out.println(cores);

        System.out.println("\nShuffle LinkedList:");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\nJoin LinkedLists:");
        LinkedList<String> outra = new LinkedList<>(Arrays.asList("Preto", "Branco"));
        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(outra);
        System.out.println(unida);

        System.out.println("\nCopy LinkedList:");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println(copia);

        System.out.println("\nPoll First Element:");
        System.out.println(cores.pollFirst());
        System.out.println(cores);

        System.out.println("\nPeek First and Last Elements:");
        System.out.println("Primeiro: " + cores.peekFirst());
        System.out.println("Último: " + cores.peekLast());

        System.out.println("\nContains Element 'Azul':");
        System.out.println(cores.contains("Azul"));

        System.out.println("\nConvert to ArrayList:");
        ArrayList<String> lista = new ArrayList<>(cores);
        System.out.println(lista);

        System.out.println("\nCompare LinkedLists:");
        System.out.println(cores.equals(copia));

        System.out.println("\nCheck if Empty:");
        System.out.println(cores.isEmpty());

        System.out.println("\nReplace Element at index 1:");
        if (cores.size() > 1) cores.set(1, "Roxo");
        System.out.println(cores);
    }
}
