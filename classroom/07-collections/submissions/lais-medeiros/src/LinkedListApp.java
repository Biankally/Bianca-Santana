import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>();

        cores.add("Verde");
        System.out.println("Append Element: " + cores);

        System.out.println("Iterate LinkedList Elements:");
        for (String c : cores) System.out.println(c);

        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");

        System.out.println("Iterate from Position:");
        for (int i = 1; i < cores.size(); i++) System.out.println(cores.get(i));

        System.out.println("Iterate in Reverse Order:");
        Iterator<String> it = cores.descendingIterator();
        while (it.hasNext()) System.out.println(it.next());

        cores.add(1, "Preto");
        System.out.println("Insert at Position: " + cores);

        cores.addFirst("Laranja");
        cores.addLast("Roxo");
        System.out.println("Insert First and Last: " + cores);

        cores.addFirst("Cinza");
        System.out.println("Insert at Front: " + cores);

        cores.addLast("Rosa");
        System.out.println("Insert at End: " + cores);

        List<String> novas = Arrays.asList("Dourado", "Prata");
        cores.addAll(2, novas);
        System.out.println("Insert Multiple at Position: " + cores);

        System.out.println("First and Last Occurrence: " + cores.indexOf("Azul") + ", " + cores.lastIndexOf("Azul"));

        System.out.println("Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++) System.out.println(i + " -> " + cores.get(i));

        cores.remove("Preto");
        System.out.println("Remove Element: " + cores);

        cores.removeFirst();
        cores.removeLast();
        System.out.println("Remove First and Last: " + cores);

        LinkedList<String> copia = new LinkedList<>(cores);
        cores.clear();
        System.out.println("Clear LinkedList: " + cores);

        cores.addAll(copia);
        Collections.swap(cores, 0, 2);
        System.out.println("Swap Elements: " + cores);

        Collections.shuffle(cores);
        System.out.println("Shuffle LinkedList: " + cores);

        LinkedList<String> outra = new LinkedList<>(Arrays.asList("Marrom", "Bege"));
        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(outra);
        System.out.println("Join LinkedLists: " + unida);

        LinkedList<String> copia2 = new LinkedList<>(cores);
        System.out.println("Copy LinkedList: " + copia2);

        System.out.println("Poll First Element: " + cores.pollFirst());
        System.out.println("Poll Result: " + cores);

        System.out.println("Peek First Element: " + cores.peekFirst());
        System.out.println("Peek Last Element: " + cores.peekLast());

        System.out.println("Contains Element 'Azul': " + cores.contains("Azul"));

        ArrayList<String> listaArray = new ArrayList<>(cores);
        System.out.println("Convert to ArrayList: " + listaArray);

        System.out.println("Compare LinkedLists: " + cores.equals(copia2));

        System.out.println("Check if Empty: " + cores.isEmpty());

        if (!cores.isEmpty()) cores.set(0, "Alterado");
        System.out.println("Replace Element: " + cores);
    }
}
