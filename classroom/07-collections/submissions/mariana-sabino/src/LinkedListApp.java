import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListApp {
    public static void main(String[] args) {
        System.out.println("1. Append element");
        LinkedList<String> cores = new LinkedList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate LinkedList elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println("3. Iterate from position");
        int posicaoInicio = 2;
        if (posicaoInicio >= 0 && posicaoInicio < cores.size()) {
            ListIterator<String> iterator = cores.listIterator(posicaoInicio);
            System.out.println("Iterando a partir da posição " + posicaoInicio + ":");
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        System.out.println();

        System.out.println("4. Iterate in reverse order");
        for (int i = cores.size() - 1; i >= 0; i--) {
            System.out.println(cores.get(i));
        }
        System.out.println();

        System.out.println("5. Insert at position");
        int posicao = 2;
        cores.add(posicao, "Roxo");
        System.out.println("Inserido 'Roxo' na posição " + posicao);
        System.out.println(cores);
        System.out.println();

        System.out.println("6. Insert first and last");
        cores.addFirst("Vermelho");
        cores.addLast("Rosa");
        System.out.println("Inserido 'Vermelho' no início e 'Rosa' no final");
        System.out.println(cores);
        System.out.println();

        System.out.println("7. Insert at front");
        cores.addFirst("Preto");
        System.out.println("Inserido 'Preto' no início");
        System.out.println(cores);
        System.out.println();

        System.out.println("8. Insert at end");
        cores.addLast("Cinza");
        System.out.println("Inserido 'Cinza' no final");
        System.out.println(cores);
        System.out.println();

        System.out.println("9. Insert multiple at position");
        int posicaoMultipla = 3;
        LinkedList<String> novosElementos = new LinkedList<>();
        novosElementos.add("Laranja");
        novosElementos.add("Marrom");
        cores.addAll(posicaoMultipla, novosElementos);
        System.out.println("Inseridos múltiplos elementos na posição " + posicaoMultipla);
        System.out.println(cores);
        System.out.println();

        System.out.println("10. First and last occurrence");
        cores.add("Verde");
        String buscar = "Verde";
        int primeira = cores.indexOf(buscar);
        int ultima = cores.lastIndexOf(buscar);
        System.out.println("Primeira ocorrência de '" + buscar + "': " + primeira);
        System.out.println("Última ocorrência de '" + buscar + "': " + ultima);
        System.out.println();

        System.out.println("11. Print elements with positions");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println();

        System.out.println("12. Remove element");
        String remover = "Marrom";
        boolean removido = cores.remove(remover);
        System.out.println("Removido '" + remover + "': " + removido);
        System.out.println(cores);
        System.out.println();

        System.out.println("13. Remove first and last");
        String primeiro = cores.removeFirst();
        String ultimo = cores.removeLast();
        System.out.println("Removido primeiro: " + primeiro);
        System.out.println("Removido último: " + ultimo);
        System.out.println(cores);
        System.out.println();

        System.out.println("14. Clear LinkedList");
        LinkedList<String> listaParaLimpar = new LinkedList<>(cores);
        listaParaLimpar.clear();
        System.out.println("Lista após clear: " + listaParaLimpar);
        System.out.println();

        System.out.println("15. Swap Elements");
        int pos1 = 0;
        int pos2 = cores.size() - 1;
        if (pos1 >= 0 && pos1 < cores.size() && pos2 >= 0 && pos2 < cores.size()) {
            Collections.swap(cores, pos1, pos2);
            System.out.println("Trocados elementos nas posições " + pos1 + " e " + pos2);
        }
        System.out.println(cores);
        System.out.println();

        System.out.println("16. Shuffle LinkedList");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);
        System.out.println();

        System.out.println("17. Join LinkedLists");
        LinkedList<String> lista1 = new LinkedList<>();
        lista1.add("Turquesa");
        lista1.add("Dourado");
        LinkedList<String> listaUnida = new LinkedList<>(cores);
        listaUnida.addAll(lista1);
        System.out.println("Lista unida: " + listaUnida);
        System.out.println();

        System.out.println("18. Copy LinkedList");
        LinkedList<String> coresCopia = new LinkedList<>(cores);
        System.out.println("Lista copiada: " + coresCopia);
        System.out.println();

        System.out.println("19. Poll first element");
        LinkedList<String> listaParaPoll = new LinkedList<>(cores);
        String polled = listaParaPoll.pollFirst();
        System.out.println("Elemento removido (poll): " + polled);
        System.out.println("Lista após poll: " + listaParaPoll);
        System.out.println();

        System.out.println("20. Peek first element");
        String peekFirst = cores.peekFirst();
        System.out.println("Primeiro elemento (peek): " + peekFirst);
        System.out.println("Lista não modificada: " + cores);
        System.out.println();

        System.out.println("21. Peek last element");
        String peekLast = cores.peekLast();
        System.out.println("Último elemento (peek): " + peekLast);
        System.out.println("Lista não modificada: " + cores);
        System.out.println();

        System.out.println("22. Contains element");
        String verificar = "Azul";
        boolean contem = cores.contains(verificar);
        System.out.println("Contém '" + verificar + "': " + contem);
        System.out.println();

        System.out.println("23. Convert to ArrayList");
        ArrayList<String> arrayList = new ArrayList<>(cores);
        System.out.println("Convertido para ArrayList: " + arrayList);
        System.out.println();

        System.out.println("24. Compare LinkedLists");
        LinkedList<String> outraLista = new LinkedList<>(cores);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + outraLista);
        boolean saoIguais = cores.equals(outraLista);
        System.out.println("São iguais: " + saoIguais);
        System.out.println();

        System.out.println("25. Check if empty");
        System.out.println("Lista original está vazia: " + cores.isEmpty());
        System.out.println("Lista limpa está vazia: " + listaParaLimpar.isEmpty());
        System.out.println();

        System.out.println("26. Replace element");
        int indiceSubstituir = 1;
        if (indiceSubstituir >= 0 && indiceSubstituir < cores.size()) {
            String valorNovo = "Violeta";
            String valorAntigo = cores.set(indiceSubstituir, valorNovo);
            System.out.println("Substituído '" + valorAntigo + "' por '" + valorNovo + "' na posição " + indiceSubstituir);
        }
        System.out.println(cores);
        System.out.println();
    }
}