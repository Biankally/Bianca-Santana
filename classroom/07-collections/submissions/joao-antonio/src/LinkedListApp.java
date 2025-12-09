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


        cores.add("Amarelo");
        System.out.println("1. Append Element ('Amarelo'): " + cores);

        System.out.println("2. Iterate LinkedList Elements:");
        for (String cor : cores) {
            System.out.println("   - " + cor);
        }

        int startPos = 2; 
        System.out.println("3. Iterate from Position (" + startPos + "):");
        Iterator<String> it = cores.listIterator(startPos);
        while (it.hasNext()) {
            System.out.println("   - " + it.next());
        }

         System.out.println("4. Iterate in Reverse Order:");
        Iterator<String> dit = cores.descendingIterator();
        while (dit.hasNext()) {
            System.out.println("   - " + dit.next());
        }

        cores.add(1, "Laranja");
        System.out.println("5. Insert at Position (1, 'Laranja'): " + cores);

       
        cores.addFirst("Preto");
        cores.addLast("Branco");
        System.out.println("6. Insert First ('Preto') and Last ('Branco'): " + cores);

        
        cores.addFirst("Cinza"); 
        System.out.println("7. Insert at Front ('Cinza'): " + cores);

        
        cores.offerLast("Roxo");
        System.out.println("8. Insert at End ('Roxo'): " + cores);

        List<String> novasCores = new ArrayList<>();
        novasCores.add("Rosa");
        novasCores.add("Prata");
        cores.addAll(2, novasCores);
        System.out.println("9. Insert Multiple at Position (2, ['Rosa', 'Prata']): " + cores);

        cores.add("Preto");
        System.out.println("   (Adicionado 'Preto' duplicado para o teste: " + cores + ")");
        int firstPreto = cores.indexOf("Preto");
        int lastPreto = cores.lastIndexOf("Preto");
        System.out.println("10. First ('Preto': " + firstPreto + ") and Last ('Preto': " + lastPreto + ") Occurrence");

        System.out.println("11. Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println("   " + i + " -> " + cores.get(i));
        }

        
        cores.remove("Prata"); 
        System.out.println("12. Remove Element ('Prata'): " + cores);

        String primeiroRemovido = cores.removeFirst();
        String ultimoRemovido = cores.removeLast(); 
        System.out.println("13. Remove First ('" + primeiroRemovido + "') and Last ('" + ultimoRemovido + "'): " + cores);

        LinkedList<String> tempParaLimpar = new LinkedList<>(cores);
        tempParaLimpar.clear();
        System.out.println("14. Clear LinkedList (em uma cópia): " + tempParaLimpar + ". (Lista original: " + cores + ")");

        Collections.swap(cores, 0, 2); 
        System.out.println("15. Swap Elements (0 e 2): " + cores);

        Collections.shuffle(cores);
        System.out.println("16. Shuffle LinkedList: " + cores);

        LinkedList<String> listaExtra = new LinkedList<>();
        listaExtra.add("Ouro");
        listaExtra.add("Bronze");

        LinkedList<String> unida = new LinkedList<>(cores);
        unida.addAll(listaExtra);
        System.out.println("17. Join LinkedLists ('cores' + ['Ouro', 'Bronze']): " + unida);

        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("18. Copy LinkedList (de 'cores'): " + copia);

        String pollado = cores.poll(); 
        System.out.println("19. Poll First Element (retornou: '" + pollado + "'): " + cores);

        String espiado = cores.peek(); 
        System.out.println("20. Peek First Element (retornou: '" + espiado + "'): " + cores);

        String espiadoUltimo = cores.peekLast();
        System.out.println("21. Peek Last Element (retornou: '" + espiadoUltimo + "'): " + cores);

        boolean temVerde = cores.contains("Verde");
        System.out.println("22. Contains Element ('Verde')? " + temVerde + ". (Lista: " + cores + ")");

        ArrayList<String> arrayListCores = new ArrayList<>(cores);
        System.out.println("23. Convert to ArrayList: " + arrayListCores + " (Tipo: " + arrayListCores.getClass().getName() + ")");

        boolean saoIguais = cores.equals(copia);
        System.out.println("24. Compare LinkedLists ('cores' vs 'copia' da etapa 18)? " + saoIguais);
        System.out.println("    'cores': " + cores);
        System.out.println("    'copia': " + copia);

        System.out.println("25. Check if Empty ('cores'): " + cores.isEmpty());
        LinkedList<String> vazia = new LinkedList<>();
        System.out.println("    Check if Empty (nova lista 'vazia'): " + vazia.isEmpty());

        String substituido = cores.set(0, "Ciano");
        System.out.println("26. Replace Element (0, 'Ciano') (substituiu '" + substituido + "'): " + cores);
    }
}