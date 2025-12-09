import java.util.*;


public class TreeSetApp {

    public static void main(String[] args) {
        System.out.println("Create and Print TreeSet");
        TreeSet<String> ts = new TreeSet<>(Set.of("Verde","Amarelo","Azul","Branco"));
        System.out.println(ts);

        System.out.println("Iterate TreeSet Elements");
        for (String s : ts) System.out.println(s);

        System.out.println("Add Elements to Another TreeSet");
        TreeSet<String> t2 = new TreeSet<>(ts);
        t2.add("Preto");
        System.out.println(t2);

        System.out.println("Reverse Order TreeSet");
        System.out.println(ts.descendingSet());

        System.out.println("Get First and Last Elements");
        System.out.println(ts.first() + " / " + ts.last());

        System.out.println("Clone TreeSet");
        @SuppressWarnings("unchecked")
        TreeSet<String> clone = (TreeSet<String>) ts.clone();
        System.out.println(clone);

        System.out.println("TreeSet Size");
        System.out.println(ts.size());

        System.out.println("Compare TreeSets");
        System.out.println(ts.equals(new TreeSet<>(clone)));

        System.out.println("Elements Less Than 7");
        TreeSet<Integer> nums = new TreeSet<>(Set.of(1,3,5,7,9));
        System.out.println(nums.headSet(7)); // < 7

        System.out.println("Ceiling Element");
        System.out.println(nums.ceiling(6));

        System.out.println("Floor Element");
        System.out.println(nums.floor(6));

        System.out.println("Higher Element");
        System.out.println(nums.higher(5));

        System.out.println("Lower Element");
        System.out.println(nums.lower(5));

        System.out.println("Poll First Element");
        System.out.println(nums.pollFirst());
        System.out.println(nums);

        System.out.println("Poll Last Element");
        System.out.println(nums.pollLast());
        System.out.println(nums);

        System.out.println("Remove Element");
        System.out.println("remove 3 -> " + nums.remove(3));
        System.out.println(nums);
    }
}
