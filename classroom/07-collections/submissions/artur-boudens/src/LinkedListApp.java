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

        System.out.println("\n1. Anexar Elemento");
        cores.addLast("Branco");
        System.out.println(cores);

        System.out.println("\n2. Iterar Elementos");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n3. Iterar de Posição Específica");
        int startPosition = 1;
        Iterator<String> it = cores.listIterator(startPosition);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\n4. Iterar em Ordem Inversa");
        Iterator<String> descendingIt = cores.descendingIterator();
        while (descendingIt.hasNext()) {
            System.out.println(descendingIt.next());
        }

        System.out.println("\n5. Inserir em Posição");
        cores.add(2, "Roxo");
        System.out.println(cores);

        System.out.println("\n6. Inserir Início e Fim");
        cores.addFirst("Preto");
        cores.addLast("Cinza");
        System.out.println(cores);

        System.out.println("\n7. Inserir na Frente");
        cores.offerFirst("Laranja");
        System.out.println(cores);

        System.out.println("\n8. Inserir no Fim");
        cores.offerLast("Magenta");
        System.out.println(cores);

        System.out.println("\n9. Inserir Múltiplos");
        LinkedList<String> novasCores = new LinkedList<>();
        novasCores.add("Ciano");
        novasCores.add("Marrom");
        cores.addAll(1, novasCores);
        System.out.println(cores);

        System.out.println("\n10. Primeira e Última Ocorrência");
        cores.add("Verde");
        System.out.println("Primeira 'Verde': " + cores.indexOf("Verde"));
        System.out.println("Última 'Verde': " + cores.lastIndexOf("Verde"));

        System.out.println("\n11. Imprimir com Posições");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        System.out.println("\n12. Remover Elemento");
        cores.remove("Marrom");
        System.out.println(cores);

        System.out.println("\n13. Remover Primeiro e Último");
        String primeiro = cores.removeFirst();
        String ultimo = cores.removeLast();
        System.out.println("Removidos: " + primeiro + ", " + ultimo);
        System.out.println(cores);

        System.out.println("\n14. Limpar Lista");
        cores.clear();
        System.out.println("Lista vazia: " + cores);

        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");

        System.out.println("\n15. Trocar Elementos");
        Collections.swap(cores, 1, 3);
        System.out.println("Após troca: " + cores);

        System.out.println("\n16. Embaralhar Lista");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);

        System.out.println("\n17. Unir Listas");
        LinkedList<String> cores2 = new LinkedList<>();
        cores2.add("Roxo");
        cores2.add("Preto");
        
        LinkedList<String> listaUnida = new LinkedList<>(cores);
        listaUnida.addAll(cores2);
        System.out.println("Lista unida: " + listaUnida);

        System.out.println("\n18. Copiar Lista");
        LinkedList<String> listaCopia = (LinkedList<String>) cores.clone();
        System.out.println("Cópia (clone): " + listaCopia);

        System.out.println("\n19. Remover e Retornar Primeiro (poll)");
        String elementoPoll = cores.poll();
        System.out.println("Removido (poll): " + elementoPoll);
        System.out.println("Lista: " + cores);

        System.out.println("\n20. Recuperar Primeiro (peek)");
        String elementoPeek = cores.peek();
        System.out.println("Recuperado (peek): " + elementoPeek);
        System.out.println("Lista: " + cores);

        System.out.println("\n21. Recuperar Último (peekLast)");
        String elementoPeekLast = cores.peekLast();
        System.out.println("Recuperado (peekLast): " + elementoPeekLast);
        System.out.println("Lista: " + cores);

        System.out.println("\n22. Verificar se Contém");
        boolean contem = cores.contains("Verde");
        System.out.println("Contém 'Verde'? " + contem);

        System.out.println("\n23. Converter para ArrayList");
        List<String> arrayListConvertido = new ArrayList<>(cores);
        System.out.println("Convertido: " + arrayListConvertido);

        System.out.println("\n24. Comparar Listas");
        LinkedList<String> listaComparacao = new LinkedList<>(cores);
        boolean saoIguais = cores.equals(listaComparacao);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + listaComparacao);
        System.out.println("São iguais? " + saoIguais);

        System.out.println("\n25. Verificar se Vazia");
        System.out.println("Está vazia? " + cores.isEmpty());

        System.out.println("\n26. Substituir Elemento");
        cores.set(0, "Laranja");
        System.out.println("Lista após substituição: " + cores);
    }
}