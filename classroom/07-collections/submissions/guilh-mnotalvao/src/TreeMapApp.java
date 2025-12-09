import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        System.out.println("Associate Value with Key");
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(3, "Azul");
        tm.put(1, "Verde");
        tm.put(2, "Amarelo");
        System.out.println(tm);

        System.out.println("Copy TreeMap");
        TreeMap<Integer, String> copy = new TreeMap<>(tm);
        System.out.println(copy);

        System.out.println("Search Key");
        System.out.println(tm.containsKey(2));

        System.out.println("Search Value");
        System.out.println(tm.containsValue("Azul"));

        System.out.println("Get All Keys");
        Set<Integer> keys = tm.keySet();
        System.out.println(keys);

        System.out.println("Clear TreeMap");
        TreeMap<Integer, String> cleared = new TreeMap<>(tm);
        cleared.clear();
        System.out.println(cleared);

        System.out.println("Sort Keys with Comparator");
        TreeMap<Integer, String> custom = new TreeMap<>(Comparator.reverseOrder());
        custom.putAll(tm);
        System.out.println(custom.keySet());

        System.out.println("Greatest and Least Mapping");
        Map.Entry<Integer, String> greatest = tm.lastEntry();
        Map.Entry<Integer, String> least = tm.firstEntry();
        System.out.println("greatest=" + greatest + ", least=" + least);

        System.out.println("Get First and Last Key");
        System.out.println(tm.firstKey());
        System.out.println(tm.lastKey());

        System.out.println("Reverse Key View");
        NavigableSet<Integer> reversedKeys = tm.descendingKeySet();
        System.out.println(reversedKeys);

        System.out.println("Floor Entry");
        System.out.println(tm.floorEntry(2));

        System.out.println("Floor Key");
        System.out.println(tm.floorKey(2));

        System.out.println("Head Map (Exclusive)");
        System.out.println(tm.headMap(2, false));

        System.out.println("Head Map (Inclusive Option)");
        System.out.println(tm.headMap(2, true));

        System.out.println("Higher Key");
        System.out.println(tm.higherKey(2));

        System.out.println("Lower Entry");
        System.out.println(tm.lowerEntry(2));

        System.out.println("Lower Key");
        System.out.println(tm.lowerKey(2));

        System.out.println("NavigableSet View");
        NavigableSet<Integer> nset = tm.navigableKeySet();
        System.out.println(nset);

        System.out.println("Poll First Entry");
        TreeMap<Integer, String> toPoll = new TreeMap<>(tm);
        System.out.println(toPoll.pollFirstEntry());

        System.out.println("Poll Last Entry");
        System.out.println(toPoll.pollLastEntry());

        System.out.println("SubMap (Inclusive to Exclusive)");
        NavigableMap<Integer, String> sub1 = tm.subMap(1, true, 3, false);
        System.out.println(sub1);

        System.out.println("SubMap (Range)");
        System.out.println(tm.subMap(1, 3));

        System.out.println("TailMap (Inclusive)");
        System.out.println(tm.tailMap(2, true));

        System.out.println("TailMap (Exclusive)");
        System.out.println(tm.tailMap(2, false));

        System.out.println("Ceiling Entry");
        System.out.println(tm.ceilingEntry(2));

        System.out.println("Ceiling Key");
        System.out.println(tm.ceilingKey(2));
    }
}
