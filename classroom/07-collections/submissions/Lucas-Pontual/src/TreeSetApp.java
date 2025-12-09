import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetApp {

    public static void main(String[] args) {

        System.out.println("1. Create and Print TreeSet");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate TreeSet Elements");
        Iterator<String> it = cores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        System.out.println("3. Add Elements to Another TreeSet");
        TreeSet<String> outroTreeSet = new TreeSet<>();
        outroTreeSet.addAll(cores);
        System.out.println("Novo TreeSet: " + outroTreeSet);
        System.out.println();

        System.out.println("4. Reverse Order TreeSet");
        System.out.println(cores.descendingSet());
        System.out.println();

        System.out.println("5. Get First and Last Elements");
        System.out.println("Primeiro: " + cores.first());
        System.out.println("Último: " + cores.last());
        System.out.println();

        System.out.println("6. Clone TreeSet");
        @SuppressWarnings("unchecked")
        TreeSet<String> cloneCores = (TreeSet<String>) cores.clone();
        System.out.println("Clone: " + cloneCores);
        System.out.println();

        System.out.println("7. TreeSet Size");
        System.out.println("Tamanho: " + cores.size());
        System.out.println();

        System.out.println("8. Compare TreeSets");
        TreeSet<String> set1 = new TreeSet<>(Set.of("A", "B", "C"));
        TreeSet<String> set2 = new TreeSet<>(Set.of("A", "B", "C"));
        TreeSet<String> set3 = new TreeSet<>(Set.of("C", "B", "A"));
        boolean comparacao1 = set1.equals(set2);
        boolean comparacao2 = set1.equals(set3);
        System.out.println(set1 + " é igual a " + set2 + "? " + comparacao1);
        System.out.println(set1 + " é igual a " + set3 + "? " + comparacao2);
        System.out.println();

        System.out.println("9. Elements Less Than 7");
        TreeSet<Integer> numeros = new TreeSet<>(Set.of(1, 5, 10, 3, 8, 6, 2, 15));
        System.out.println("Elementos menores que 7: " + numeros.headSet(7));
        System.out.println();

        System.out.println("10. Ceiling Element");
        System.out.println("Ceiling de 4: " + numeros.ceiling(4));
        System.out.println();

        System.out.println("11. Floor Element");
        System.out.println("Floor de 4: " + numeros.floor(4));
        System.out.println();

        System.out.println("12. Higher Element");
        System.out.println("Higher de 4: " + numeros.higher(4));
        System.out.println();

        System.out.println("13. Lower Element");
        System.out.println("Lower de 4: " + numeros.lower(4));
        System.out.println();

        System.out.println("14. Poll First Element");
        System.out.println("Poll First: " + numeros.pollFirst());
        System.out.println("TreeSet atualizado: " + numeros);
        System.out.println();

        System.out.println("15. Poll Last Element");
        System.out.println("Poll Last: " + numeros.pollLast());
        System.out.println("TreeSet atualizado: " + numeros);
        System.out.println();

        System.out.println("16. Remove all elements");
        cores.clear();
        System.out.println("TreeSet de cores após clear: " + cores);
        System.out.println();
    }
}
