import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedListApp {

    public static void main(String[] args) {
        
        LinkedList<String> cores = new LinkedList<>();

        System.out.println("Append Element:");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Iterate LinkedList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("---");

        System.out.println("Iterate from Position:");
        int startPosition = 1;
        if (startPosition < cores.size()) {
            ListIterator<String> it = cores.listIterator(startPosition);
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
        System.out.println("---");

        System.out.println("Iterate in Reverse Order:");
        Iterator<String> dIt = cores.descendingIterator();
        while (dIt.hasNext()) {
            System.out.println(dIt.next());
        }
        System.out.println("---");

        System.out.println("Insert at Position:");
        cores.add(1, "Laranja");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Insert First and Last:");
        cores.addFirst("Inicio");
        cores.addLast("Fim");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Insert at Front:");
        cores.offerFirst("OutroInicio");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Insert at End:");
        cores.offerLast("OutroFim");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Insert Multiple at Position:");
        List<String> maisCores = new ArrayList<>();
        maisCores.add("Amarelo");
        maisCores.add("Branco");
        cores.addAll(2, maisCores);
        System.out.println(cores);
        System.out.println("---");

        System.out.println("First and Last Occurrence:");
        cores.add("Verde");
        System.out.println("Primeira ocorrencia de 'Verde': " + cores.indexOf("Verde"));
        System.out.println("Ultima ocorrencia de 'Verde': " + cores.lastIndexOf("Verde"));
        System.out.println("---");

        System.out.println("Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println("---");

        System.out.println("Remove Element:");
        cores.remove("Laranja");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Remove First and Last:");
        cores.removeFirst();
        cores.removeLast();
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Clear LinkedList:");
        cores.clear();
        System.out.println(cores);
        System.out.println("---");
        
        cores.add("A");
        cores.add("B");
        cores.add("C");

        System.out.println("Swap Elements:");
        Collections.swap(cores, 0, 2);
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Shuffle LinkedList:");
        Collections.shuffle(cores);
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Join LinkedLists:");
        LinkedList<String> cores2 = new LinkedList<>();
        cores2.add("D");
        cores2.add("E");
        
        LinkedList<String> listaUnida = new LinkedList<>(cores);
        listaUnida.addAll(cores2);
        System.out.println(listaUnida);
        System.out.println("---");

        System.out.println("Copy LinkedList:");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("Copia: " + copia);
        System.out.println("---");

        System.out.println("Poll First Element:");
        String primeiro = cores.pollFirst();
        System.out.println("Removido: " + primeiro);
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Peek First Element:");
        System.out.println("Elemento: " + cores.peekFirst());
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Peek Last Element:");
        System.out.println("Elemento: " + cores.peekLast());
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Contains Element:");
        System.out.println("Contem 'A'? " + cores.contains("A"));
        System.out.println("---");

        System.out.println("Convert to ArrayList:");
        List<String> arrayList = new ArrayList<>(cores);
        System.out.println(arrayList);
        System.out.println("---");

        System.out.println("Compare LinkedLists:");
        LinkedList<String> cores3 = new LinkedList<>(cores);
        System.out.println("Listas sao iguais? " + cores.equals(cores3));
        System.out.println("---");

        System.out.println("Check if Empty:");
        System.out.println("Esta vazia? " + cores.isEmpty());
        System.out.println("---");

        System.out.println("Replace Element:");
        if (!cores.isEmpty()) {
            cores.set(0, "Substituto");
            System.out.println(cores);
        }
        System.out.println("---");
    }
}