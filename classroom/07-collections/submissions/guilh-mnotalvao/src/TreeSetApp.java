import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        System.out.println("Create and Print TreeSet");
        TreeSet<String> set = new TreeSet<>();
        set.add("Verde");
        set.add("Amarelo");
        set.add("Azul");
        System.out.println(set);

        System.out.println("Iterate TreeSet Elements");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("Add Elements to Another TreeSet");
        TreeSet<String> another = new TreeSet<>();
        another.addAll(set);
        System.out.println(another);

        System.out.println("Reverse Order TreeSet");
        NavigableSet<String> reversed = set.descendingSet();
        System.out.println(reversed);

        System.out.println("Get First and Last Elements");
        System.out.println(set.first());
        System.out.println(set.last());

        System.out.println("Clone TreeSet");
        TreeSet<String> cloned = (TreeSet<String>) set.clone();
        System.out.println(cloned);

        System.out.println("TreeSet Size");
        System.out.println(set.size());

        System.out.println("Compare TreeSets");
        System.out.println(set.equals(another));

        System.out.println("Elements Less Than 7");
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(1);
        numbers.add(9);
        System.out.println(numbers.headSet(7));

        System.out.println("Ceiling Element");
        System.out.println(numbers.ceiling(6));

        System.out.println("Floor Element");
        System.out.println(numbers.floor(6));

        System.out.println("Higher Element");
        System.out.println(numbers.higher(7));

        System.out.println("Lower Element");
        System.out.println(numbers.lower(3));

        System.out.println("Poll First Element");
        System.out.println(set.pollFirst());

        System.out.println("Poll Last Element");
        System.out.println(set.pollLast());

        System.out.println("Remove Element");
        System.out.println(set.remove("Azul"));
        System.out.println(set);
    }
}
