package submissions.<nome-sobrenome>.src;

import java.util.*;

public class TreeSetApp {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>(List.of(3, 5, 1, 7, 2, 9));
        System.out.println("Create and Print TreeSet:");
        System.out.println(numeros);

        System.out.println("Iterate TreeSet Elements:");
        for (int n : numeros) System.out.println(n);

        System.out.println("Add Elements to Another TreeSet:");
        TreeSet<Integer> copia = new TreeSet<>(numeros);
        System.out.println(copia);

        System.out.println("Reverse Order TreeSet:");
        System.out.println(copia.descendingSet());

        System.out.println("Get First and Last Elements:");
        System.out.println(copia.first() + " / " + copia.last());

        System.out.println("Clone TreeSet:");
        TreeSet<Integer> clone = (TreeSet<Integer>) copia.clone();
        System.out.println(clone);

        System.out.println("TreeSet Size:");
        System.out.println(copia.size());

        System.out.println("Compare TreeSets:");
        System.out.println(copia.equals(clone));

        System.out.println("Elements Less Than 7:");
        System.out.println(copia.headSet(7));

        System.out.println("Ceiling, Floor, Higher, Lower Elements:");
        System.out.println("Ceiling(4): " + copia.ceiling(4));
        System.out.println("Floor(4): " + copia.floor(4));
        System.out.println("Higher(4): " + copia.higher(4));
        System.out.println("Lower(4): " + copia.lower(4));

        System.out.println("Poll First and Last:");
        System.out.println(copia.pollFirst());
        System.out.println(copia.pollLast());
        System.out.println(copia);

        System.out.println("Remove Element 5:");
        copia.remove(5);
        System.out.println(copia);
    }
}
