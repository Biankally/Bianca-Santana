import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        HashSet<String> cores = new HashSet<>();

        cores.add("Verde");
        System.out.println("Append Element to HashSet: " + cores);

        System.out.println("Iterate HashSet Elements:");
        for (String c : cores) System.out.println(c);

        System.out.println("Get HashSet Size: " + cores.size());

        cores.clear();
        System.out.println("Clear HashSet: " + cores);

        System.out.println("Check if HashSet is Empty: " + cores.isEmpty());

        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println("Clone HashSet: " + clone);

        Object[] array = cores.toArray();
        System.out.println("Convert HashSet to Array:");
        for (Object o : array) System.out.println(o);

        TreeSet<String> tree = new TreeSet<>(cores);
        System.out.println("Convert HashSet to TreeSet: " + tree);

        TreeSet<Integer> numeros = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9));
        System.out.println("Find Elements Less Than 7: " + numeros.headSet(7));

        HashSet<String> outro = new HashSet<>(Arrays.asList("Azul", "Preto"));
        System.out.println("Compare Two HashSets: " + cores.equals(outro));

        cores.retainAll(outro);
        System.out.println("Retain Common Elements: " + cores);

        cores.removeAll(cores);
        System.out.println("Remove All from HashSet: " + cores);
    }
}
