import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetCustomComparatorDemo {
    public static void main(String[] args) {
        
        TreeSet<String> ts = new TreeSet<>(new MyComp().reversed());

        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        for (String element : ts) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

class MyComp implements Comparator<String> {
    @Override
    public int compare(String aStr, String bStr) {
        return bStr.compareTo(aStr);
    }
}

