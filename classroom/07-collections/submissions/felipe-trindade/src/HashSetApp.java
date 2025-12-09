import java.util.*;

public class HashSetApp{
    public static void main(String[] args){
        System.out.println("=== HashSet ===");

        HashSet<String> set = new HashSet<>();
        set.add("Verde");
        set.add("Amarelo");
        set.add("Azul");
        System.out.println("Append Element to HashSet -> " + set);

        System.out.println("Iterate HashSet Elements");
        for(String s : set) System.out.println(s);

        System.out.println("Get HashSet Size -> " + set.size());

        HashSet<String> clone = (HashSet<String>) set.clone();
        System.out.println("Clone HashSet -> " + clone);

        String[] arr = set.toArray(new String[0]);
        System.out.println("Convert HashSet to Array -> " + Arrays.toString(arr));

        TreeSet<String> tree = new TreeSet<>(set);
        System.out.println("Convert HashSet to TreeSet -> " + tree);

        TreeSet<Integer> numeros = new TreeSet<>(Arrays.asList(1,2,3,7,8,10));
        System.out.println("Find Elements Less Than 7 -> " + numeros.headSet(7));

        System.out.println("Compare Two HashSets -> " + set.equals(clone));

        HashSet<String> outro = new HashSet<>(Arrays.asList("Azul", "Branco"));
        set.retainAll(outro);
        System.out.println("Retain Common Elements (com " + outro + ") -> " + set);

        set.clear();
        System.out.println("Remove All from HashSet -> " + set);

        System.out.println("Check if HashSet is Empty -> " + set.isEmpty());

        clone.clear();
        System.out.println("Clear HashSet (clone) -> " + clone);
    }
}