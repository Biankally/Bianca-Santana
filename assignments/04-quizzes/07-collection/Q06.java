import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Q06{
    public static void main(String[] args){

        ArrayList<String> al = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayDeque<Object> ad = new ArrayDeque<>(Arrays.asList("d", "e", "f"));
        TreeSet<Object> ts = new TreeSet<>(Arrays.asList("g", "h", "i"));

        al.add(null);
        ad.add(null);
        ts.add(null);

        System.out.print(al);
        System.out.print(ad);
        System.out.print(ts);
    }
}
