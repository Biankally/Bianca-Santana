import java.util.Map.Entry;
import java.util.SequencedMap;
import java.util.TreeMap;

public class Q10{

    public static void main(String[] args) {
        SequencedMap<Integer, String> cats = new TreeMap<>();
        Entry<Integer, String> e;

        cats.put(3, "Snowball");
        cats.put(2, "Sugar");
        cats.put(1, "Minnie Mouse");
                
        e = cats.pollFirstEntry();

        System.out.print(e.getValue() + " removed. ");

        e = cats.pollFirstEntry();

        System.out.print(e.getValue() + " removed. ");

        System.out.print(cats.firstEntry().getValue() + " is the new first entry");
    }
}
