import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(5);
        numeros.add(7);
        numeros.add(9);
        System.out.println("Create and Print TreeSet: " + numeros);

        System.out.println("Iterate TreeSet Elements:");
        for (Integer n : numeros) System.out.println(n);

        TreeSet<Integer> outro = new TreeSet<>();
        outro.addAll(numeros);
        System.out.println("Add Elements to Another TreeSet: " + outro);

        System.out.println("Reverse Order TreeSet: " + numeros.descendingSet());

        System.out.println("Get First and Last Elements: " + numeros.first() + ", " + numeros.last());

        TreeSet<Integer> clone = (TreeSet<Integer>) numeros.clone();
        System.out.println("Clone TreeSet: " + clone);

        System.out.println("TreeSet Size: " + numeros.size());

        System.out.println("Compare TreeSets: " + numeros.equals(outro));

        System.out.println("Elements Less Than 7: " + numeros.headSet(7));

        System.out.println("Ceiling Element (>=6): " + numeros.ceiling(6));
        System.out.println("Floor Element (<=6): " + numeros.floor(6));
        System.out.println("Higher Element (>3): " + numeros.higher(3));
        System.out.println("Lower Element (<3): " + numeros.lower(3));

        System.out.println("Poll First Element: " + numeros.pollFirst());
        System.out.println("After Poll First: " + numeros);

        System.out.println("Poll Last Element: " + numeros.pollLast());
        System.out.println("After Poll Last: " + numeros);

        numeros.remove(5);
        System.out.println("Remove Element: " + numeros);
    }
}
