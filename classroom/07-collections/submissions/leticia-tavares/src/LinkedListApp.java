package submissions.nome-sobrenome.src;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>();

        System.out.println("1. Append Element");
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n2. Iterate LinkedList Elements");
        for (String cor : cores) {
            System.out.print(cor + " ");
        }
        System.out.println();

        System.out.println("\n3. Iterate from Position");
        int inicio = 2;
        Iterator<String> it = cores.listIterator(inicio);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("\n4. Iterate in Reverse Order");
        Iterator<String> reverseIt = cores.descendingIterator();
        while (reverseIt.hasNext()) {
            System.out.print(reverseIt.next() + " ");
        }
        System.out.println();

        System.out.println("\n5. Insert at Position");
        cores.add(1, "Vermelho");
        System.out.println(cores);

        System.out.println("\n6. Insert First and Last");
        cores.addFirst("Roxo");
        cores.addLast("Preto");
        System.out.println(cores);

        System.out.println("\n7. Insert at Front");
        cores.offerFirst("Ciano");
        System.out.println(cores);

        System.out.println("\n8. Insert at End");
        cores.offerLast("Magenta");
        System.out.println(cores);

        System.out.println("\n9. Insert Multiple at Position");
        LinkedList<String> novasCores = new LinkedList<>();
        novasCores.add("Ouro");
        novasCores.add("Prata");
        cores.addAll(3, novasCores);
        System.out.println(cores);

        System.out.println("\n10. First and Last Occurrence");
        System.out.println("Primeira ocorrência de 'Verde': " + cores.indexOf("Verde"));
        cores.add("Verde");
        System.out.println("Última ocorrência de 'Verde': " + cores.lastIndexOf("Verde"));

        System.out.println("\n11. Print Elements with Positions");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        System.out.println("\n12. Remove Element");
        cores.remove("Branco");
        System.out.println(cores);

        System.out.println("\n13. Remove First and Last");
        cores.removeFirst();
        cores.removeLast();
        System.out.println(cores);

        System.out.println("\n14. Clear LinkedList");
        LinkedList<String> copiaCores = new LinkedList<>(cores);
        copiaCores.clear();
        System.out.println("Cópia esvaziada: " + copiaCores);

        System.out.println("\n15. Swap Elements");
        Collections.swap(cores, 1, 3);
        System.out.println(cores);

        System.out.println("\n16. Shuffle LinkedList");
        Collections.shuffle(cores);
        System.out.println(cores);

        System.out.println("\n17. Join LinkedLists");
        LinkedList<String> coresAdicionais = new LinkedList<>(novasCores);
        coresAdicionais.add("Marrom");
        coresAdicionais.addAll(cores);
        System.out.println(coresAdicionais);

        System.out.println("\n18. Copy LinkedList");
        LinkedList<String> listaClonada = (LinkedList<String>) cores.clone();
        System.out.println(listaClonada);

        System.out.println("\n19. Poll First Element");
        System.out.println("Elemento removido: " + cores.pollFirst());
        System.out.println(cores);

        System.out.println("\n20. Peek First Element");
        System.out.println("Primeiro elemento: " + cores.peekFirst());
        System.out.println(cores);

        System.out.println("\n21. Peek Last Element");
        System.out.println("Último elemento: " + cores.peekLast());

        System.out.println("\n22. Contains Element");
        System.out.println("Contém 'Amarelo': " + cores.contains("Amarelo"));

        System.out.println("\n23. Convert to ArrayList");
        List<String> arrayLista = new LinkedList<>(cores);
        System.out.println(arrayLista);

        System.out.println("\n24. Compare LinkedLists");
        LinkedList<String> mesmaOrdem = new LinkedList<>(cores);
        System.out.println("Cores vs MesmaOrdem: " + cores.equals(mesmaOrdem));

        System.out.println("\n25. Check if Empty");
        System.out.println("Lista está vazia: " + cores.isEmpty());

        System.out.println("\n26. Replace Element");
        cores.set(0, "Indigo");
        System.out.println(cores);
    }
}