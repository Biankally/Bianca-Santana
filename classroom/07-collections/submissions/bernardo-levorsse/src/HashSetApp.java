import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        System.out.println("1) Append Element to HashSet");
        HashSet<String> hs = new HashSet<>();
        hs.add("Verde"); hs.add("Amarelo"); hs.add("Azul"); System.out.println(hs);

        System.out.println("\n2) Iterate HashSet Elements");
        for (String s: hs) System.out.println(s);

        System.out.println("\n3) Get HashSet Size");
        System.out.println(hs.size());

        System.out.println("\n4) Clear HashSet");
        HashSet<String> backup = new HashSet<>(hs);
        hs.clear(); System.out.println(hs);

        System.out.println("\n5) Check if HashSet is Empty");
        System.out.println(hs.isEmpty());

        System.out.println("\n6) Clone HashSet");
        hs.addAll(Arrays.asList("A","B","C"));
        @SuppressWarnings("unchecked")
        HashSet<String> clone = (HashSet<String>) hs.clone();
        System.out.println(clone);

        System.out.println("\n7) Convert HashSet to Array");
        Object[] arr = hs.toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println("\n8) Convert HashSet to TreeSet");
        TreeSet<String> ts = new TreeSet<>(hs);
        System.out.println(ts);

        System.out.println("\n9) Find Elements Less Than 7 (TreeSet<Integer>)");
        TreeSet<Integer> nums = new TreeSet<>(Arrays.asList(1,3,5,7,9,2,8));
        System.out.println(nums.headSet(7)); // menores que 7

        System.out.println("\n10) Compare Two HashSets");
        HashSet<String> hs2 = new HashSet<>(hs);
        System.out.println(hs.equals(hs2));

        System.out.println("\n11) Retain Common Elements (hs ∩ backup)");
        hs.retainAll(backup);
        System.out.println(hs);

        System.out.println("\n12) Remove All from HashSet");
        hs.clear();
        System.out.println(hs);
    }
}
