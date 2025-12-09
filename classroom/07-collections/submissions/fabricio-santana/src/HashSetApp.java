import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>(Arrays.asList("Verde", "Amarelo", "Azul"));

        colors.add("Vermelho");
        System.out.println("Append Element to HashSet: " + colors);

        System.out.println("Iterate HashSet Elements:");
        for (String color : colors) {
            System.out.println(color);
        }

        System.out.println("Get HashSet Size: " + colors.size());

        HashSet<String> clearedSet = new HashSet<>(colors);
        clearedSet.clear();
        System.out.println("Clear HashSet: " + clearedSet);

        System.out.println("Check if HashSet is Empty: " + clearedSet.isEmpty());

        @SuppressWarnings("unchecked")
        HashSet<String> clonedSet = (HashSet<String>) colors.clone();
        System.out.println("Clone HashSet: " + clonedSet);

        String[] array = colors.toArray(new String[0]);
        System.out.println("Convert HashSet to Array: " + Arrays.toString(array));

        TreeSet<String> treeSet = new TreeSet<>(colors);
        System.out.println("Convert HashSet to TreeSet: " + treeSet);

        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9));
        System.out.println("Find Elements Less Than 7: " + numbers.headSet(7));

        HashSet<String> anotherSet = new HashSet<>(Arrays.asList("Verde", "Azul", "Preto"));
        System.out.println("Compare Two HashSets: " + colors.equals(anotherSet));

        HashSet<String> retained = new HashSet<>(colors);
        retained.retainAll(anotherSet);
        System.out.println("Retain Common Elements: " + retained);

        HashSet<String> removedAll = new HashSet<>(colors);
        removedAll.clear();
        System.out.println("Remove All from HashSet: " + removedAll);
    }
}
