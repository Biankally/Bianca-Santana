import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        System.out.println("Append Element to HashSet");
        Set<String> colors = new HashSet<>();
        colors.add("Verde");
        colors.add("Amarelo");
        colors.add("Azul");
        System.out.println(colors);

        System.out.println("Iterate HashSet Elements");
        for (String c : colors) {
            System.out.println(c);
        }

        System.out.println("Get HashSet Size");
        System.out.println(colors.size());

        System.out.println("Clear HashSet");
        Set<String> temp = new HashSet<>(colors);
        temp.clear();
        System.out.println(temp);

        System.out.println("Check if HashSet is Empty");
        System.out.println(temp.isEmpty());

        System.out.println("Clone HashSet");
        HashSet<String> cloned = new HashSet<>(colors);
        System.out.println(cloned);

        System.out.println("Convert HashSet to Array");
        Object[] arr = colors.toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println("Convert HashSet to TreeSet");
        TreeSet<String> asTree = new TreeSet<>(colors);
        System.out.println(asTree);

        System.out.println("Find Elements Less Than 7");
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(1);
        numbers.add(9);
        System.out.println(numbers.headSet(7));

        System.out.println("Compare Two HashSets");
        Set<String> another = new HashSet<>(colors);
        System.out.println(colors.equals(another));

        System.out.println("Retain Common Elements");
        Set<String> commons = new HashSet<>();
        commons.add("Verde");
        commons.add("Branco");
        HashSet<String> retained = new HashSet<>(colors);
        retained.retainAll(commons);
        System.out.println(retained);

        System.out.println("Remove All from HashSet");
        HashSet<String> removeAllSet = new HashSet<>(colors);
        removeAllSet.removeAll(colors);
        System.out.println(removeAllSet);
    }
}
