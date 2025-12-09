import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>();

        System.out.println("--- Inicializando a lista ---");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        System.out.println("Lista inicial: " + cores);
        System.out.println("---------------------------------");


        // 1. Append Element: adicione um elemento ao final da lista encadeada.
        cores.add("Amarelo");
        System.out.println("1. Append Element ('Amarelo'): " + cores);

        // 2. Iterate LinkedList Elements: percorra todos os elementos da lista.
        System.out.println("2. Iterate LinkedList Elements:");
        for (String cor : cores) {
            System.out.println("   - " + cor);
        }

        // 3. Iterate from Position: percorra a lista iniciando de uma posição específica.
        int startPos = 2; // Começar do "Azul"
        System.out.println("3. Iterate from Position (" + startPos + "):");
        Iterator<String> it = cores.listIterator(startPos);
        while (it.hasNext()) {
            System.out.println("   - " + it.next());
        }

        // 4. Iterate in Reverse Order: percorra a lista na ordem inversa.
        System.out.println("4. Iterate in Reverse Order:");
        Iterator<String> dit = cores.descendingIterator();
        while (dit.hasNext()) {
            System.out.println("   - " + dit.next());
        }

        // 5. Insert at Position: insira um elemento na posição informada.
        cores.add(1, "Laranja");
        System.out.println("5. Insert at Position (1, 'Laranja'): " + cores);

        // 6. Insert First and Last: insira elementos nas extremidades.
        cores.addFirst("Preto");
        cores.addLast("Branco");
        System.out.println("6. Insert First ('Preto') and Last ('Branco'): " + cores);

        // 7. Insert at Front: adicione um elemento no início da lista.
        cores.addFirst("Cinza"); // Similar a addFirst
        System.out.println("7. Insert at Front ('Cinza'): " + cores);

        // 8. Insert at End: adicione um elemento no final da lista.
        cores.offerLast("Roxo"); // Similar a addLast
        System.out.println("8. Insert at End ('Roxo'): " + cores);

        // 9. Insert Multiple at Position: insira vários elementos a partir de uma posição.
        List<String> novasCores = new ArrayList<>();
        novasCores.add("Rosa");
        novasCores.add("Prata");
        cores.addAll(2, novasCores);
        System.out.println("9. Insert Multiple at Position (2, ['Rosa', 'Prata']): " + cores);

        // 10. First and Last Occurrence: informe a primeira e a última ocorrência.
        cores.add("Preto"); // Adicionando um duplicado para o teste
        System.out.println("   (Adicionado 'Preto' duplicado para o teste: " + cores + ")");
        int firstPreto = cores.indexOf("Preto");
        int lastPreto = cores.lastIndexOf("Preto");
        System.out.println("10. First ('Preto': " + firstPreto + ") and Last ('Preto': " + lastPreto + ") Occurrence");

        // 11. Print Elements with Positions: exiba cada elemento junto com sua posição.
        System.out.println("11. Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println("   " + i + " -> " + cores.get(i));
        }

        // 12. Remove Element: remova um elemento específico da lista.
        cores.remove("Prata"); // Remove a primeira ocorrência de "Prata"
        System.out.println("12. Remove Element ('Prata'): " + cores);

        // 13. Remove First and Last: remova o primeiro e o último elemento.
        String primeiroRemovido = cores.removeFirst();
        String ultimoRemovido = cores.removeLast(); // Remove o "Preto" duplicado
        System.out.println("13. Remove First ('" + primeiroRemovido + "') and Last ('" + ultimoRemovido + "'): " + cores);

        // 14. Clear LinkedList: remova todos os elementos da lista.
        // Vamos criar uma lista temporária para não perder os dados para os próximos passos
        LinkedList<String> tempParaLimpar = new LinkedList<>(cores);
        tempParaLimpar.clear();
        System.out.println("14. Clear LinkedList (em uma cópia): " + tempParaLimpar + ". (Lista original: " + cores + ")");

        // 15. Swap Elements: troque os elementos de duas posições informadas.
        Collections.swap(cores, 0, 2); // Troca 'Rosa' com 'Vermelho'
        System.out.println("15. Swap Elements (0 e 2): " + cores);

        // 16. Shuffle LinkedList: embaralhe os elementos da lista.
        Collections.shuffle(cores);
        System.out.println("16. Shuffle LinkedList: " + cores);

        // 17. Join LinkedLists: una duas listas em uma nova LinkedList.
        LinkedList<String> listaExtra = new LinkedList<>();
        listaExtra.add("Ouro");
        listaExtra.add("Bronze");

        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(listaExtra);
        System.out.println("17. Join LinkedLists ('cores' + ['Ouro', 'Bronze']): " + unida);

        // 18. Copy LinkedList: crie uma nova lista cópia da lista original.
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("18. Copy LinkedList (de 'cores'): " + copia);

        // 19. Poll First Element: remova e retorne o primeiro elemento da lista.
        String pollado = cores.poll(); // poll() é o mesmo que pollFirst()
        System.out.println("19. Poll First Element (retornou: '" + pollado + "'): " + cores);

        // 20. Peek First Element: recupere, sem remover, o primeiro elemento.
        String espiado = cores.peek(); // peek() é o mesmo que peekFirst()
        System.out.println("20. Peek First Element (retornou: '" + espiado + "'): " + cores);

        // 21. Peek Last Element: recupere, sem remover, o último elemento.
        String espiadoUltimo = cores.peekLast();
        System.out.println("21. Peek Last Element (retornou: '" + espiadoUltimo + "'): " + cores);

        // 22. Contains Element: verifique se um elemento específico está presente.
        boolean temVerde = cores.contains("Verde");
        System.out.println("22. Contains Element ('Verde')? " + temVerde + ". (Lista: " + cores + ")");

        // 23. Convert to ArrayList: converta a LinkedList para uma ArrayList.
        ArrayList<String> arrayListCores = new ArrayList<>(cores);
        System.out.println("23. Convert to ArrayList: " + arrayListCores + " (Tipo: " + arrayListCores.getClass().getName() + ")");

        // 24. Compare LinkedLists: verifique se duas listas possuem os mesmos elementos.
        boolean saoIguais = cores.equals(copia);
        System.out.println("24. Compare LinkedLists ('cores' vs 'copia' da etapa 18)? " + saoIguais);
        System.out.println("    'cores': " + cores);
        System.out.println("    'copia': " + copia);

        // 25. Check if Empty: informe se a lista está vazia.
        System.out.println("25. Check if Empty ('cores'): " + cores.isEmpty());
        LinkedList<String> vazia = new LinkedList<>();
        System.out.println("    Check if Empty (nova lista 'vazia'): " + vazia.isEmpty());

        // 26. Replace Element: substitua o valor de um elemento na posição informada.
        String substituido = cores.set(0, "Ciano");
        System.out.println("26. Replace Element (0, 'Ciano') (substituiu '" + substituido + "'): " + cores);
    }
}