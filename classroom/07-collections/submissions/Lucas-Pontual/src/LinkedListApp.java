import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static void main(String[] args) {

        LinkedList<String> cores = new LinkedList<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo");

        System.out.println("1. Append Element");
        cores.add("Preto");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate LinkedList Elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println("3. Iterate from Position");
        int startPosition = 2;
        Iterator<String> it = cores.listIterator(startPosition);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        System.out.println("4. Iterate in Reverse Order");
        Iterator<String> reverseIt = cores.descendingIterator();
        while (reverseIt.hasNext()) {
            System.out.println(reverseIt.next());
        }
        System.out.println();

        System.out.println("5. Insert at Position");
        cores.add(1, "Laranja");
        System.out.println(cores);
        System.out.println();

        System.out.println("6. Insert First and Last");
        cores.addFirst("Branco");
        cores.addLast("Roxo");
        System.out.println(cores);
        System.out.println();

        System.out.println("7. Insert at Front");
        cores.offerFirst("Ciano");
        System.out.println(cores);
        System.out.println();

        System.out.println("8. Insert at End");
        cores.offerLast("Magenta");
        System.out.println(cores);
        System.out.println();

        System.out.println("9. Insert Multiple at Position");
        List<String> novasCores = List.of("Ouro", "Prata");
        cores.addAll(3, novasCores);
        System.out.println(cores);
        System.out.println();

        System.out.println("10. First and Last Occurrence");
        cores.add("Vermelho");
        System.out.println("Primeira ocorrência de 'Vermelho': " + cores.indexOf("Vermelho"));
        System.out.println("Última ocorrência de 'Vermelho': " + cores.lastIndexOf("Vermelho"));
        System.out.println();

        System.out.println("11. Print Elements with Positions");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println();

        System.out.println("12. Remove Element");
        cores.remove("Ciano");
        System.out.println(cores);
        System.out.println();

        System.out.println("13. Remove First and Last");
        cores.removeFirst();
        cores.removeLast();
        System.out.println(cores);
        System.out.println();

        System.out.println("14. Clear LinkedList");
        LinkedList<String> listaParaLimpar = new LinkedList<>(cores);
        listaParaLimpar.clear();
        System.out.println("Lista após clear: " + listaParaLimpar);
        System.out.println();

        System.out.println("15. Swap Elements");
        Collections.swap(cores, 0, cores.size() - 1);
        System.out.println(cores);
        System.out.println();

        System.out.println("16. Shuffle LinkedList");
        Collections.shuffle(cores);
        System.out.println(cores);
        System.out.println();

        System.out.println("17. Join LinkedLists");
        LinkedList<String> listaA = new LinkedList<>(List.of("Um", "Dois"));
        LinkedList<String> listaB = new LinkedList<>(List.of("Três", "Quatro"));
        LinkedList<String> listaUnida = new LinkedList<>(listaA);
        listaUnida.addAll(listaB);
        System.out.println(listaUnida);
        System.out.println();

        System.out.println("18. Copy LinkedList");
        LinkedList<String> copiaCores = new LinkedList<>(cores);
        System.out.println("Cópia da lista: " + copiaCores);
        System.out.println();

        System.out.println("19. Poll First Element");
        String primeiro = cores.pollFirst();
        System.out.println("Elemento removido e retornado: " + primeiro);
        System.out.println(cores);
        System.out.println();

        System.out.println("20. Peek First Element");
        String peekPrimeiro = cores.peekFirst();
        System.out.println("Primeiro elemento (peek): " + peekPrimeiro);
        System.out.println(cores);
        System.out.println();

        System.out.println("21. Peek Last Element");
        String peekUltimo = cores.peekLast();
        System.out.println("Último elemento (peek): " + peekUltimo);
        System.out.println(cores);
        System.out.println();

        System.out.println("22. Contains Element");
        String busca = "Azul";
        boolean contem = cores.contains(busca);
        System.out.println("Contém '" + busca + "'? " + contem);
        System.out.println();

        System.out.println("23. Convert to ArrayList");
        List<String> arrayListCores = new ArrayList<>(cores);
        System.out.println("ArrayList: " + arrayListCores);
        System.out.println();

        System.out.println("24. Compare LinkedLists");
        LinkedList<String> comp1 = new LinkedList<>(List.of("A", "B"));
        LinkedList<String> comp2 = new LinkedList<>(List.of("A", "B"));
        boolean saoIguais = comp1.equals(comp2);
        System.out.println(comp1 + " é igual a " + comp2 + "? " + saoIguais);
        System.out.println();

        System.out.println("25. Check if Empty");
        System.out.println("A lista 'cores' está vazia? " + cores.isEmpty());
        System.out.println("A lista 'listaParaLimpar' está vazia? " + listaParaLimpar.isEmpty());
        System.out.println();

        System.out.println("26. Replace Element");
        int indiceSubstituir = 2;
        if (indiceSubstituir >= 0 && indiceSubstituir < cores.size()) {
            cores.set(indiceSubstituir, "Bronze");
        }
        System.out.println(cores);
        System.out.println();
    }
}
