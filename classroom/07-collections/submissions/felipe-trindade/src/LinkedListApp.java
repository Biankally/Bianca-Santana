import java.util.*;

public class LinkedListApp{
    public static void main(String[] args){
        System.out.println("=== LinkedList ===");

        LinkedList<String> cores = new LinkedList<>(Arrays.asList("Verde", "Amarelo", "Azul"));
        System.out.println("Start -> " + cores);

        cores.add("Branco");
        System.out.println("Append Element -> " + cores);

        System.out.println("Iterate LinkedList Elements");
        for(String c : cores) System.out.println(c);

        System.out.println("Iterate from Position (1)");
        for(int i = 1; i < cores.size(); i++) System.out.println(cores.get(i));

        System.out.println("Iterate in Reverse Order");
        Iterator<String> it = cores.descendingIterator();
        while(it.hasNext()) System.out.println(it.next());

        cores.add(1, "Preto");
        System.out.println("Insert at Position (1) -> " + cores);

        cores.addFirst("Rosa");
        cores.addLast("Cinza");
        System.out.println("Insert First and Last -> " + cores);

        cores.addFirst("Laranja");
        System.out.println("Insert at Front -> " + cores);

        cores.addLast("Vermelho");
        System.out.println("Insert at End -> " + cores);

        cores.addAll(2, Arrays.asList("Magenta", "Ciano"));
        System.out.println("Insert Multiple at Position (2) -> " + cores);

        System.out.println("First Occurrence of 'Azul' -> " + cores.indexOf("Azul"));
        System.out.println("Last  Occurrence of 'Azul' -> " + cores.lastIndexOf("Azul"));

        System.out.println("Print Elements with Positions");
        for(int i = 0; i < cores.size(); i++) System.out.println(i + " -> " + cores.get(i));

        cores.remove("Amarelo");
        System.out.println("Remove Element ('Amarelo') -> " + cores);

        if(!cores.isEmpty()) cores.removeFirst();
        if(!cores.isEmpty()) cores.removeLast();
        System.out.println("Remove First and Last -> " + cores);

        LinkedList<String> tmp = new LinkedList<>(cores);
        tmp.clear();
        System.out.println("Clear LinkedList (tmp) -> " + tmp);

        if(cores.size() >= 2) Collections.swap(cores, 0, 1);
        System.out.println("Swap Elements -> " + cores);

        Collections.shuffle(cores);
        System.out.println("Shuffle LinkedList -> " + cores);

        LinkedList<String> outra = new LinkedList<>(Arrays.asList("Dourado", "Prata"));
        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(outra);
        System.out.println("Join LinkedLists -> " + unida);

        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("Copy LinkedList -> " + copia);

        String polled = cores.pollFirst();
        System.out.println("Poll First Element -> " + polled + " | resto: " + cores);

        System.out.println("Peek First Element -> " + cores.peekFirst());
        System.out.println("Peek Last Element  -> " + cores.peekLast());
        System.out.println("Contains Element ('Azul') -> " + cores.contains("Azul"));

        ArrayList<String> arrayList = new ArrayList<>(cores);
        System.out.println("Convert to ArrayList -> " + arrayList);

        System.out.println("Compare LinkedLists -> " + cores.equals(copia));
        System.out.println("Check if Empty (tmp) -> " + tmp.isEmpty());

        if(!cores.isEmpty()) cores.set(0, "Substituido");
        System.out.println("Replace Element (0) -> " + cores);
    }
}