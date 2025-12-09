import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>(List.of("Verde", "Amarelo", "Azul", "Branco"));
        System.out.println("Append Element:");
        cores.add("Roxo");
        System.out.println(cores);

        System.out.println("Iterate LinkedList Elements:");
        for (String c : cores) System.out.println(c);

        System.out.println("Iterate from Position:");
        for (int i = 2; i < cores.size(); i++) System.out.println(cores.get(i));

        System.out.println("Iterate in Reverse Order:");
        Iterator<String> it = cores.descendingIterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("Insert at Position:");
        cores.add(2, "Preto");
        System.out.println(cores);

        System.out.println("Insert First and Last:");
        cores.addFirst("Cinza");
        cores.addLast("Marrom");
        System.out.println(cores);

        System.out.println("Insert at Front:");
        cores.offerFirst("Laranja");
        System.out.println(cores);

        System.out.println("Insert at End:");
        cores.offerLast("Rosa");
        System.out.println(cores);

        System.out.println("Insert Multiple at Position:");
        cores.addAll(3, List.of("Dourado", "Prata"));
        System.out.println(cores);

        System.out.println("First and Last Occurrence of 'Azul':");
        System.out.println(cores.indexOf("Azul") + ", " + cores.lastIndexOf("Azul"));

        System.out.println("Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++)
            System.out.println(i + " -> " + cores.get(i));

        System.out.println("Remove Element:");
        cores.remove("Roxo");
        System.out.println(cores);

        System.out.println("Remove First and Last:");
        cores.removeFirst();
        cores.removeLast();
        System.out.println(cores);

        System.out.println("Clear LinkedList:");
        LinkedList<String> copia = new LinkedList<>(cores);
        cores.clear();
        System.out.println(cores);

        System.out.println("Swap Elements:");
        if (copia.size() > 2) Collections.swap(copia, 0, 2);
        System.out.println(copia);

        System.out.println("Shuffle LinkedList:");
        Collections.shuffle(copia);
        System.out.println(copia);

        System.out.println("Join LinkedLists:");
        LinkedList<String> outra = new LinkedList<>(List.of("Branco", "Roxo"));
        LinkedList<String> unida = new LinkedList<>(copia);
        unida.addAll(outra);
        System.out.println(unida);

        System.out.println("Copy LinkedList:");
        LinkedList<String> copia2 = new LinkedList<>(unida);
        System.out.println(copia2);

        System.out.println("Poll First Element:");
        System.out.println(copia2.pollFirst());

        System.out.println("Peek First and Last:");
        System.out.println(copia2.peekFirst());
        System.out.println(copia2.peekLast());

        System.out.println("Contains Element 'Azul':");
        System.out.println(copia2.contains("Azul"));

        System.out.println("Convert to ArrayList:");
        ArrayList<String> array = new ArrayList<>(copia2);
        System.out.println(array);

        System.out.println("Compare LinkedLists:");
        System.out.println(copia2.equals(unida));

        System.out.println("Check if Empty:");
        System.out.println(copia2.isEmpty());

        System.out.println("Replace Element:");
        if (copia2.size() > 1) copia2.set(1, "Amarelo Claro");
        System.out.println(copia2);
    }
}
