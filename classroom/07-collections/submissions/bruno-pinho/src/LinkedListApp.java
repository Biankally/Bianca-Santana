import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListApp {

    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>();

        // 1. Append Element
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("1. Append Element: " + cores);
        System.out.println("--------------------");

        // 2. Iterate LinkedList Elements
        System.out.println("2. Iterate LinkedList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        // 3. Iterate from Position
        int startPos = 1;
        System.out.println("3. Iterate from Position (" + startPos + "):");
        Iterator<String> it = cores.listIterator(startPos);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------------");

        // 4. Iterate in Reverse Order
        System.out.println("4. Iterate in Reverse Order:");
        Iterator<String> dIt = cores.descendingIterator();
        while (dIt.hasNext()) {
            System.out.println(dIt.next());
        }
        System.out.println("--------------------");

        // 5. Insert at Position
        cores.add(2, "Vermelho");
        System.out.println("5. Insert at Position (Index 2): " + cores);
        System.out.println("--------------------");

        // 6. Insert First and Last
        cores.addFirst("Preto");
        cores.addLast("Cinza");
        System.out.println("6. Insert First and Last: " + cores);
        System.out.println("--------------------");

        // 7. Insert at Front
        cores.offerFirst("Laranja");
        System.out.println("7. Insert at Front (offerFirst): " + cores);
        System.out.println("--------------------");

        // 8. Insert at End
        cores.offerLast("Rosa");
        System.out.println("8. Insert at End (offerLast): " + cores);
        System.out.println("--------------------");

        // 9. Insert Multiple at Position
        LinkedList<String> novos = new LinkedList<>();
        novos.add("Roxo");
        novos.add("Prata");
        cores.addAll(3, novos);
        System.out.println("9. Insert Multiple at Position (Index 3): " + cores);
        System.out.println("--------------------");

        // 10. First and Last Occurrence
        cores.add("Verde"); // Adicionando duplicata para o teste
        System.out.println("10. First and Last Occurrence (Lista atual): " + cores);
        System.out.println("   Primeira ocorrencia de 'Verde': " + cores.indexOf("Verde"));
        System.out.println("   Última ocorrencia de 'Verde': " + cores.lastIndexOf("Verde"));
        System.out.println("--------------------");

        // 11. Print Elements with Positions
        System.out.println("11. Print Elements with Positions:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println("--------------------");

        // 12. Remove Element
        cores.remove("Vermelho");
        System.out.println("12. Remove Element ('Vermelho'): " + cores);
        System.out.println("--------------------");

        // 13. Remove First and Last
        cores.removeFirst();
        cores.removeLast();
        System.out.println("13. Remove First and Last: " + cores);
        System.out.println("--------------------");

        // 14. Clear LinkedList
        cores.clear();
        System.out.println("14. Clear LinkedList: " + cores);
        System.out.println("--------------------");
        
        // 25. Check if Empty (realizado após o clear)
        System.out.println("25. Check if Empty (Após Clear): " + cores.isEmpty());
        System.out.println("--------------------");
        
        // Repopulando para os próximos testes
        cores.add("A");
        cores.add("B");
        cores.add("C");
        cores.add("D");
        System.out.println("... Repopulando a lista: " + cores);

        // 15. Swap Elements
        Collections.swap(cores, 1, 3);
        System.out.println("15. Swap Elements (Pos 1 e 3): " + cores);
        System.out.println("--------------------");

        // 16. Shuffle LinkedList
        Collections.shuffle(cores);
        System.out.println("16. Shuffle LinkedList: " + cores);
        System.out.println("--------------------");

        // 17. Join LinkedLists
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("X");
        l2.add("Y");
        LinkedList<String> joined = new LinkedList<>(cores);
        joined.addAll(l2);
        System.out.println("17. Join LinkedLists: " + joined);
        System.out.println("--------------------");

        // 18. Copy LinkedList (usando construtor de cópia)
        LinkedList<String> copia = new LinkedList<>(cores);
        System.out.println("18. Copy LinkedList: " + copia);
        System.out.println("--------------------");
        
        // 19. Poll First Element
        String polled = cores.pollFirst();
        System.out.println("19. Poll First Element (Removido: " + polled + "): " + cores);
        System.out.println("--------------------");

        // 20. Peek First Element
        String peekFirst = cores.peekFirst();
        System.out.println("20. Peek First Element (Elemento: " + peekFirst + "): " + cores);
        System.out.println("--------------------");

        // 21. Peek Last Element
        String peekLast = cores.peekLast();
        System.out.println("21. Peek Last Element (Elemento: " + peekLast + "): " + cores);
        System.out.println("--------------------");

        // 22. Contains Element
        System.out.println("22. Contains Element ('C'): " + cores.contains("C"));
        System.out.println("--------------------");

        // 23. Convert to ArrayList
        ArrayList<String> arrayList = new ArrayList<>(cores);
        System.out.println("23. Convert to ArrayList: " + arrayList);
        System.out.println("--------------------");

        // 24. Compare LinkedLists
        LinkedList<String> l3 = new LinkedList<>(cores);
        System.out.println("24. Compare LinkedLists (com sua cópia): " + cores.equals(l3));
        System.out.println("--------------------");

        // 25. Check if Empty (Já feito no passo 14)
        // 26. Replace Element
        if (cores.size() >= 2) {
            cores.set(1, "Z");
            System.out.println("26. Replace Element (Index 1): " + cores);
        }
        System.out.println("--------------------");
    }
}