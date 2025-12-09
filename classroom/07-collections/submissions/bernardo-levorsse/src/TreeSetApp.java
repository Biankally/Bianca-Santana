import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        System.out.println("1) Create and Print TreeSet");
        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(5,1,9,3,7));
        System.out.println(ts);

        System.out.println("\n2) Iterate TreeSet Elements");
        for (Integer x: ts) System.out.println(x);

        System.out.println("\n3) Add Elements to Another TreeSet");
        TreeSet<Integer> ts2 = new TreeSet<>(ts);
        System.out.println(ts2);

        System.out.println("\n4) Reverse Order TreeSet");
        System.out.println(ts.descendingSet());

        System.out.println("\n5) Get First and Last Elements");
        System.out.println("first=" + ts.first() + ", last=" + ts.last());

        System.out.println("\n6) Clone TreeSet");
        @SuppressWarnings("unchecked")
        TreeSet<Integer> clone = (TreeSet<Integer>) ts.clone();
        System.out.println(clone);

        System.out.println("\n7) TreeSet Size");
        System.out.println(ts.size());

        System.out.println("\n8) Compare TreeSets (ts vs ts2)");
        System.out.println(ts.equals(ts2));

        System.out.println("\n9) Elements Less Than 7");
        System.out.println(ts.headSet(7)); // < 7

        System.out.println("\n10) Ceiling Element (>= 6)");
        System.out.println(ts.ceiling(6));

        System.out.println("\n11) Floor Element (<= 6)");
        System.out.println(ts.floor(6));

        System.out.println("\n12) Higher Element (> 5)");
        System.out.println(ts.higher(5));

        System.out.println("\n13) Lower Element (< 5)");
        System.out.println(ts.lower(5));

        System.out.println("\n14) Poll First Element");
        System.out.println(ts.pollFirst()); System.out.println(ts);

        System.out.println("\n15) Poll Last Element");
        System.out.println(ts.pollLast()); System.out.println(ts);

        System.out.println("\n16) Remove Element (remover 7)");
        ts.remove(7); System.out.println(ts);
    }
}
