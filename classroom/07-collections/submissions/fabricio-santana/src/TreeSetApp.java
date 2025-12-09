import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList("Verde", "Amarelo", "Azul", "Branco"));
        System.out.println("Create and Print TreeSet: " + treeSet);

        System.out.println("Iterate TreeSet Elements:");
        for (String color : treeSet) {
            System.out.println(color);
        }

        TreeSet<String> anotherSet = new TreeSet<>(Arrays.asList("Preto", "Cinza"));
        anotherSet.addAll(treeSet);
        System.out.println("Add Elements to Another TreeSet: " + anotherSet);

        NavigableSet<String> reverseView = treeSet.descendingSet();
        System.out.println("Reverse Order TreeSet: " + reverseView);

        if (!treeSet.isEmpty()) {
            System.out.println("Get First and Last Elements: " + treeSet.first() + ", " + treeSet.last());
        }

        @SuppressWarnings("unchecked")
        TreeSet<String> clonedSet = (TreeSet<String>) treeSet.clone();
        System.out.println("Clone TreeSet: " + clonedSet);

        System.out.println("TreeSet Size: " + treeSet.size());

        TreeSet<String> comparisonSet = new TreeSet<>(Arrays.asList("Amarelo", "Azul", "Branco", "Verde"));
        System.out.println("Compare TreeSets: " + treeSet.equals(comparisonSet));

        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9));
        System.out.println("Elements Less Than 7: " + numbers.headSet(7));

        System.out.println("Ceiling Element for 'Azul': " + treeSet.ceiling("Azul"));
        System.out.println("Floor Element for 'Azul': " + treeSet.floor("Azul"));
        System.out.println("Higher Element than 'Azul': " + treeSet.higher("Azul"));
        System.out.println("Lower Element than 'Azul': " + treeSet.lower("Azul"));

        TreeSet<String> pollFirstSet = new TreeSet<>(treeSet);
        String pollFirst = pollFirstSet.pollFirst();
        System.out.println("Poll First TreeSet Element: " + pollFirst + ", " + pollFirstSet);

        TreeSet<String> pollLastSet = new TreeSet<>(treeSet);
        String pollLast = pollLastSet.pollLast();
        System.out.println("Poll Last TreeSet Element: " + pollLast + ", " + pollLastSet);

        TreeSet<String> removableSet = new TreeSet<>(treeSet);
        boolean removed = removableSet.remove("Branco");
        System.out.println("Remove Element (Branco): " + removed + ", " + removableSet);
    }
}
