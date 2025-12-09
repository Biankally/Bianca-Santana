import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static void main(String[] args) {
        System.out.println("### Iniciando LinkedListApp ###\n");

        LinkedList<String> cores = new LinkedList<>();

        System.out.println("[Operação 1]: Append Element");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 2]: Iterate LinkedList Elements");
        System.out.println("Resultado:");
        for (String cor : cores) {
            System.out.println("- " + cor);
        }

        System.out.println("\n[Operação 3]: Iterate from Position (índice 1)");
        System.out.println("Resultado:");
        Iterator<String> it = cores.listIterator(1);
        while (it.hasNext()) {
            System.out.println("- " + it.next());
        }

        System.out.println("\n[Operação 4]: Iterate in Reverse Order");
        System.out.println("Resultado:");
        Iterator<String> revIt = cores.descendingIterator();
        while (revIt.hasNext()) {
            System.out.println("- " + revIt.next());
        }

        System.out.println("\n[Operação 5]: Insert at Position (índice 1, 'Amarelo')");
        cores.add(1, "Amarelo");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 6]: Insert First and Last");
        cores.addFirst("Branco");
        cores.addLast("Preto");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 7]: Insert at Front ('Cinza')");
        cores.offerFirst("Cinza");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 8]: Insert at End ('Roxo')");
        cores.offerLast("Roxo");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 9]: Insert Multiple at Position (índice 2)");
        List<String> novos = Arrays.asList("Laranja", "Rosa");
        cores.addAll(2, novos);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 10]: First and Last Occurrence ('Verde')");
        System.out.println("Primeira ocorrência: " + cores.indexOf("Verde"));
        System.out.println("Última ocorrência: " + cores.lastIndexOf("Verde"));

        System.out.println("\n[Operação 11]: Print Elements with Positions");
        System.out.println("Resultado:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        System.out.println("\n[Operação 12]: Remove Element ('Laranja')");
        cores.remove("Laranja");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 13]: Remove First and Last");
        cores.removeFirst();
        cores.removeLast();
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 14]: Clear LinkedList");
        cores.clear();
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 15]: Swap Elements (índice 0 e 2)");
        cores.add("ItemA");
        cores.add("ItemB");
        cores.add("ItemC");
        Collections.swap(cores, 0, 2);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 16]: Shuffle LinkedList");
        Collections.shuffle(cores);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 17]: Join LinkedLists");
        LinkedList<String> l2 = new LinkedList<>(Arrays.asList("ItemD", "ItemE"));
        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(l2);
        System.out.println("Resultado: " + unida);

        System.out.println("\n[Operação 18]: Copy LinkedList");
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("Resultado: " + copia);

        System.out.println("\n[Operação 19]: Poll First Element (remove e retorna)");
        String primeiro = cores.pollFirst();
        System.out.println("Elemento removido: " + primeiro);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 20]: Peek First Element (apenas retorna)");
        String verPrimeiro = cores.peekFirst();
        System.out.println("Elemento visto: " + verPrimeiro);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 21]: Peek Last Element (apenas retorna)");
        String verUltimo = cores.peekLast();
        System.out.println("Elemento visto: " + verUltimo);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 22]: Contains Element ('ItemC')");
        System.out.println("Resultado: " + cores.contains("ItemC"));

        System.out.println("\n[Operação 23]: Convert to ArrayList");
        List<String> arrayListCores = new ArrayList<>(cores);
        System.out.println("Resultado (ArrayList): " + arrayListCores);

        System.out.println("\n[Operação 24]: Compare LinkedLists");
        LinkedList<String> l3 = new LinkedList<>(cores);
        System.out.println("Resultado: " + cores.equals(l3));

        System.out.println("\n[Operação 25]: Check if Empty");
        cores.clear();
        System.out.println("Resultado: " + cores.isEmpty());

        System.out.println("\n[Operação 26]: Replace Element (índice 1)");
        cores.add("X");
        cores.add("Y");
        cores.set(1, "Z");
        System.out.println("Resultado: " + cores);

        System.out.println("\n### LinkedListApp Finalizado ###");
    }
}