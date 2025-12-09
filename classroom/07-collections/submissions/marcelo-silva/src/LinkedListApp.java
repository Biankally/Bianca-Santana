import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static void main(String[] args) {
        
        LinkedList<String> cores = new LinkedList<>();

        System.out.println("--- Append Element ---");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo");
        System.out.println(cores);

        System.out.println("\n--- Iterate LinkedList Elements ---");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n--- Iterate from Position ---");
        int startPos = 1;
        Iterator<String> it = cores.listIterator(startPos);
        System.out.println("Iterando a partir da posição " + startPos + ":");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\n--- Iterate in Reverse Order ---");
        Iterator<String> dit = cores.descendingIterator();
        while (dit.hasNext()) {
            System.out.println(dit.next());
        }

        System.out.println("\n--- Insert at Position ---");
        cores.add(1, "Branco");
        System.out.println(cores);

        System.out.println("\n--- Insert First and Last ---");
        cores.addFirst("Preto");
        cores.addLast("Cinza");
        System.out.println(cores);

        System.out.println("\n--- Insert at Front ---");
        cores.offerFirst("Laranja");
        System.out.println(cores);

        System.out.println("\n--- Insert at End ---");
        cores.offerLast("Roxo");
        System.out.println(cores);

        System.out.println("\n--- Insert Multiple at Position ---");
        List<String> novasCores = new ArrayList<>();
        novasCores.add("Ciano");
        novasCores.add("Magenta");
        cores.addAll(2, novasCores);
        System.out.println(cores);

        System.out.println("\n--- First and Last Occurrence (de 'Verde') ---");
        cores.add("Verde");
        System.out.println(cores);
        System.out.println("Primeira ocorrência de 'Verde': " + cores.indexOf("Verde"));
        System.out.println("Última ocorrência de 'Verde': " + cores.lastIndexOf("Verde"));

        System.out.println("\n--- Print Elements with Positions ---");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        System.out.println("\n--- Remove Element ('Branco') ---");
        cores.remove("Branco");
        System.out.println(cores);

        System.out.println("\n--- Remove First and Last ---");
        String primeiro = cores.removeFirst();
        String ultimo = cores.removeLast();
        System.out.println("Removido primeiro: " + primeiro);
        System.out.println("Removido último: " + ultimo);
        System.out.println(cores);

        System.out.println("\n--- Clear LinkedList ---");
        cores.clear();
        System.out.println(cores);

        System.out.println("\n--- Repopulando Lista ---");
        cores.add("Carro");
        cores.add("Moto");
        cores.add("Bicicleta");
        cores.add("Aviao");
        System.out.println(cores);

        System.out.println("\n--- Swap Elements (0 e 2) ---");
        Collections.swap(cores, 0, 2);
        System.out.println(cores);

        System.out.println("\n--- Shuffle LinkedList ---");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\n--- Join LinkedLists ---");
        LinkedList<String> lista2 = new LinkedList<>();
        lista2.add("Navio");
        lista2.add("Trem");
        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(lista2);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Unida: " + unida);

        System.out.println("\n--- Copy LinkedList ---");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("Cópia: " + copia);

        System.out.println("\n--- Poll First Element ---");
        String poll = cores.pollFirst();
        System.out.println("Elemento (poll): " + poll);
        System.out.println(cores);

        System.out.println("\n--- Peek First Element ---");
        String peek = cores.peekFirst();
        System.out.println("Elemento (peek): " + peek);
        System.out.println(cores);

        System.out.println("\n--- Peek Last Element ---");
        String peekLast = cores.peekLast();
        System.out.println("Elemento (peekLast): " + peekLast);
        System.out.println(cores);

        System.out.println("\n--- Contains Element ('Bicicleta') ---");
        System.out.println("Contém 'Bicicleta'? " + cores.contains("Bicicleta"));

        System.out.println("\n--- Convert to ArrayList ---");
        List<String> arrayList = new ArrayList<>(cores);
        System.out.println("ArrayList: " + arrayList);

        System.out.println("\n--- Compare LinkedLists ---");
        System.out.println("Original: " + cores);
        System.out.println("Cópia: " + copia);
        System.out.println("São iguais? " + cores.equals(copia));
        System.out.println("Original e ela mesma são iguais? " + cores.equals(cores));

        System.out.println("\n--- Check if Empty ---");
        System.out.println("Está vazia? " + cores.isEmpty());

        System.out.println("\n--- Replace Element (posição 0) ---");
        if (!cores.isEmpty()) {
            cores.set(0, "Patinete");
            System.out.println(cores);
        } else {
            System.out.println("Lista vazia, nada para substituir.");
        }
    }
}