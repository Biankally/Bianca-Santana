import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        System.out.println("Append Element to HashSet:");
        HashSet<String> cores = new HashSet<>(List.of("Verde", "Amarelo", "Azul"));
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("Iterate HashSet Elements:");
        for (String c : cores) System.out.println(c);

        System.out.println("Get HashSet Size:");
        System.out.println(cores.size());

        System.out.println("Clone HashSet:");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println(clone);

        System.out.println("Convert HashSet to Array:");
        Object[] array = cores.toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("Convert HashSet to TreeSet:");
        TreeSet<String> tree = new TreeSet<>(cores);
        System.out.println(tree);

        System.out.println("Find Elements Less Than 7:");
        TreeSet<Integer> nums = new TreeSet<>(List.of(1, 4, 7, 9, 3, 6));
        System.out.println(nums.headSet(7));

        System.out.println("Compare Two HashSets:");
        HashSet<String> outro = new HashSet<>(List.of("Azul", "Verde", "Amarelo", "Branco"));
        System.out.println(cores.equals(outro));

        System.out.println("Retain Common Elements:");
        cores.retainAll(outro);
        System.out.println(cores);

        System.out.println("Remove All from HashSet:");
        cores.clear();
        System.out.println(cores);

        System.out.println("Check if HashSet is Empty:");
        System.out.println(cores.isEmpty());
    }
}
