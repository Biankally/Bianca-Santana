import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetApp {

    public static void main(String[] args) {

        // 1. Create and Print TreeSet
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Verde");
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Amarelo");
        System.out.println("1. Create and Print TreeSet: " + cores);
        System.out.println("--------------------");

        // 2. Iterate TreeSet Elements
        System.out.println("2. Iterate TreeSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        // 3. Add Elements to Another TreeSet
        TreeSet<String> t2 = new TreeSet<>();
        t2.add("Preto");
        t2.addAll(cores);
        System.out.println("3. Add Elements to Another TreeSet: " + t2);
        System.out.println("--------------------");

        // 4. Reverse Order TreeSet
        NavigableSet<String> reverseView = cores.descendingSet();
        System.out.println("4. Reverse Order TreeSet: " + reverseView);
        System.out.println("--------------------");

        // 5. Get First and Last Elements
        System.out.println("5. Get First and Last Elements:");
        System.out.println("   First: " + cores.first());
        System.out.println("   Last: " + cores.last());
        System.out.println("--------------------");

        // 6. Clone TreeSet
        TreeSet<String> cloned = (TreeSet<String>) cores.clone();
        System.out.println("6. Clone TreeSet: " + cloned);
        System.out.println("--------------------");

        // 7. TreeSet Size
        System.out.println("7. TreeSet Size: " + cores.size());
        System.out.println("--------------------");

        // 8. Compare TreeSets
        TreeSet<String> t3 = new TreeSet<>(cores);
        System.out.println("8. Compare TreeSets (com sua cópia): " + cores.equals(t3));
        System.out.println("--------------------");

        // Configurando um TreeSet de números para os próximos testes
        TreeSet<Integer> numeros = new TreeSet<>(Arrays.asList(1, 4, 6, 7, 9, 10, 15));
        System.out.println("... Conjunto de números para testes: " + numeros);

        // 9. Elements Less Than 7
        // headSet(7, false) ou apenas headSet(7)
        System.out.println("9. Elements Less Than 7: " + numeros.headSet(7));
        System.out.println("--------------------");

        // 10. Ceiling Element (>= 5)
        System.out.println("10. Ceiling Element (>= 5): " + numeros.ceiling(5));
        System.out.println("   Ceiling Element (>= 8): " + numeros.ceiling(8));
        System.out.println("--------------------");

        // 11. Floor Element (<= 5)
        System.out.println("11. Floor Element (<= 5): " + numeros.floor(5));
        System.out.println("   Floor Element (<= 8): " + numeros.floor(8));
        System.out.println("--------------------");

        // 12. Higher Element (> 6)
        System.out.println("12. Higher Element (> 6): " + numeros.higher(6));
        System.out.println("   Higher Element (> 7): " + numeros.higher(7));
        System.out.println("--------------------");

        // 13. Lower Element (< 6)
        System.out.println("13. Lower Element (< 6): " + numeros.lower(6));
        System.out.println("   Lower Element (< 4): " + numeros.lower(4));
        System.out.println("--------------------");

        // 14. Poll First Element
        System.out.println("14. Poll First Element (Original: " + numeros + ")");
        Integer polledFirst = numeros.pollFirst();
        System.out.println("   Elemento removido: " + polledFirst);
        System.out.println("   Conjunto restante: " + numeros);
        System.out.println("--------------------");

        // 15. Poll Last Element
        System.out.println("15. Poll Last Element (Original: " + numeros + ")");
        Integer polledLast = numeros.pollLast();
        System.out.println("   Elemento removido: " + polledLast);
        System.out.println("   Conjunto restante: " + numeros);
        System.out.println("--------------------");

        // 16. Remove Element (voltando ao set de cores)
        System.out.println("16. Remove Element (Original cores: " + cores + ")");
        cores.remove("Vermelho");
        System.out.println("   Após remover 'Vermelho': " + cores);
        System.out.println("--------------------");
    }
}