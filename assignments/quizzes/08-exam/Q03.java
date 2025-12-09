import java.util.Collection; 
import java.util.ArrayList; 
import java.util.ArrayDeque; 
import java.util.HashSet; 
import java.util.TreeSet; 

public class Q03 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        addRange(set1, 1);

        ArrayList<Integer> list1 = new ArrayList<>();
        addRange(list1, 2);
        
        TreeSet<Integer> set2 = new TreeSet<>();
        addRange(set2, 3);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        addRange(deque, 5);

        set1.removeAll(list1);
        list1.addAll(set2);
        deque.addAll(list1);
        set1.removeAll(deque);

        System.out.println(set1);
    }

    private static void addRange(Collection<Integer> col, int step) {
        for (int i = step * 2; i <= 25; i += step) {
            col.add(i);
        }
    }
}
