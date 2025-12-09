import java.util.*;



public class HashSetApp {


    public static void main(String[] args) {
        System.out.println("Append Element to HashSet");
        HashSet<String> set = new HashSet<>();
        set.add("Verde"); set.add("Amarelo"); set.add("Azul");
        System.out.println(set);

        System.out.println("Iterate HashSet Elements");
        for (String s : set) System.out.println(s);

        System.out.println("Get HashSet Size");
        System.out.println(set.size());

        System.out.println("Clear HashSet");
        HashSet<String> original = new HashSet<>(set);
        set.clear();
        System.out.println(set);

        System.out.println("Check if HashSet is Empty");
        System.out.println(set.isEmpty());

        System.out.println("Clone HashSet");
        @SuppressWarnings("unchecked")
        HashSet<String> clone = (HashSet<String>) original.clone();
        System.out.println(clone);

        System.out.println("Convert HashSet to Array");
        String[] arr = clone.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));

        System.out.println("Convert HashSet to TreeSet");
        TreeSet<String> ts = new TreeSet<>(clone);
        System.out.println(ts);

        System.out.println("Find Elements Less Than 7");
        TreeSet<Integer> nums = new TreeSet<>(Set.of(2,4,6,8,10,1,7));
        System.out.println(nums.headSet(7)); // < 7

        System.out.println("Compare Two HashSets");
        HashSet<String> set2 = new HashSet<>(List.of("Azul","Verde","Amarelo"));
        System.out.println(clone.equals(set2));

        System.out.println("Retain Common Elements");
        HashSet<String> a = new HashSet<>(List.of("A","B","C"));
        HashSet<String> b = new HashSet<>(List.of("B","C","D"));
        a.retainAll(b);
        System.out.println(a);

        System.out.println("Remove All from HashSet");
        b.removeAll(b);
        System.out.println(b);
    }
}
