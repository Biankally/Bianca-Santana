import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static void main(String[] args) {

        LinkedList<String> cores = new LinkedList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");

        System.out.println(" Lista Inicial ");
        System.out.println(cores);
        System.out.println();

        System.out.println(" 1-Append Element ");
        cores.add("Preto");
        System.out.println(cores);
        System.out.println();

        System.out.println(" 2-Iterate LinkedList Elements ");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println(" 3-Iterate from Position ");
        int startPosition = 2;
        Iterator<String> iterator = cores.listIterator(startPosition);
        System.out.println("Iterando a partir da posição " + startPosition + ":");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        System.out.println(" 4-Iterate in Reverse Order ");
        Iterator<String> reverseIterator = cores.descendingIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
        System.out.println();

        System.out.println(" 5-Insert at Position ");
        cores.add(1, "Laranja");
        System.out.println(cores);
        System.out.println();

        System.out.println(" 6-Insert First and Last ");
        cores.addFirst("Roxo");
        cores.addLast("Cinza");
        System.out.println(cores);
        System.out.println();

        System.out.println(" 7-Insert at Front ");
        cores.offerFirst("Marrom");
        System.out.println(cores);
        System.out.println();

        System.out.println(" 8-Insert at End ");
        cores.offerLast("Magenta");
        System.out.println(cores);
        System.out.println();

        System.out.println(" 9-Insert Multiple at Position ");
        LinkedList<String> novasCores = new LinkedList<>();
        novasCores.add("Ciano");
        novasCores.add("Turquesa");
        cores.addAll(2, novasCores);
        System.out.println(cores);
        System.out.println();

        System.out.println(" 10-First and Last Occurrence ");
        cores.add("Verde"); 
        System.out.println("Lista atual: " + cores);
        System.out.println("Primeira ocorrência de 'Verde': índice " + cores.indexOf("Verde"));
        System.out.println("Última ocorrência de 'Verde': índice " + cores.lastIndexOf("Verde"));
        System.out.println();

        System.out.println(" 11-Print Elements with Positions ");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println();

        System.out.println(" 12-Remove Element ");
        cores.remove("Magenta");
        System.out.println("Após remover 'Magenta': " + cores);
        System.out.println();

        System.out.println(" 13-Remove First and Last ");
        cores.removeFirst();
        cores.removeLast();
        System.out.println("Após remover o primeiro e o último: " + cores);
        System.out.println();

        System.out.println(" 14-Clear LinkedList ");
        LinkedList<String> listaParaLimpar = new LinkedList<>(cores);
        System.out.println("Lista antes de limpar: " + listaParaLimpar);
        listaParaLimpar.clear();
        System.out.println("Lista após limpar: " + listaParaLimpar);
        System.out.println();

        System.out.println(" 15-Swap Elements ");
        System.out.println("Antes da troca: " + cores);
        Collections.swap(cores, 0, 3);
        System.out.println("Trocando posições 0 e 3: " + cores);
        System.out.println();

        System.out.println(" 16-Shuffle LinkedList ");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);
        System.out.println();

        System.out.println(" 17-Join LinkedLists ");
        LinkedList<String> listaA = new LinkedList<>();
        listaA.add("A");
        listaA.add("B");
        LinkedList<String> listaB = new LinkedList<>();
        listaB.add("C");
        listaB.add("D");
        LinkedList<String> uniao = new LinkedList<>(listaA);
        uniao.addAll(listaB);
        System.out.println("Lista A: " + listaA);
        System.out.println("Lista B: " + listaB);
        System.out.println("União: " + uniao);
        System.out.println();

        System.out.println(" 18-Copy LinkedList ");
        LinkedList<String> copiaCores = new LinkedList<>(cores);
        System.out.println("Original: " + cores);
        System.out.println("Cópia: " + copiaCores);
        System.out.println();

        System.out.println(" 19-Poll First Element ");
        System.out.println("Lista antes: " + cores);
        String primeiroElemento = cores.poll();
        System.out.println("Elemento removido e retornado: " + primeiroElemento);
        System.out.println("Lista depois: " + cores);
        System.out.println();

        System.out.println(" 20-Peek First Element ");
        String elementoEspiado = cores.peek();
        System.out.println("Elemento recuperado (sem remover): " + elementoEspiado);
        System.out.println("Lista permanece igual: " + cores);
        System.out.println();

        System.out.println(" 21-Peek Last Element ");
        String ultimoElementoEspiado = cores.peekLast();
        System.out.println("Último elemento recuperado (sem remover): " + ultimoElementoEspiado);
        System.out.println("Lista permanece igual: " + cores);
        System.out.println();

        System.out.println(" 22-Contains Element ");
        System.out.println("A lista contém 'Azul'? " + cores.contains("Azul"));
        System.out.println("A lista contém 'Rosa'? " + cores.contains("Rosa"));
        System.out.println();

        System.out.println(" 23-Convert to ArrayList ");
        List<String> arrayListCores = new ArrayList<>(cores);
        System.out.println("LinkedList: " + cores);
        System.out.println("ArrayList:  " + arrayListCores);
        System.out.println();

        System.out.println(" 24-Compare LinkedLists ");
        LinkedList<String> listaComp1 = new LinkedList<>(cores);
        LinkedList<String> listaComp2 = new LinkedList<>();
        listaComp2.add("A");
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + listaComp1);
        System.out.println("Lista 3: " + listaComp2);
        System.out.println("Lista 1 e Lista 2 são iguais? " + cores.equals(listaComp1));
        System.out.println("Lista 1 e Lista 3 são iguais? " + cores.equals(listaComp2));
        System.out.println();

        System.out.println(" 25-Check if Empty ");
        System.out.println("A lista 'cores' está vazia? " + cores.isEmpty());
        System.out.println("A lista 'listaParaLimpar' está vazia? " + listaParaLimpar.isEmpty());
        System.out.println();

        System.out.println(" 26-Replace Element ");
        System.out.println("Lista antes de substituir: " + cores);
        cores.set(1, "VIOLETA");
        System.out.println("Lista após substituir o elemento na posição 1: " + cores);
        System.out.println();
    }
}