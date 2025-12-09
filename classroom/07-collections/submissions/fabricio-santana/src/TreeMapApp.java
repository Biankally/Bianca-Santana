import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer, String> colorMap = new TreeMap<>();
        colorMap.put(3, "Azul");
        colorMap.put(1, "Verde");
        colorMap.put(4, "Amarelo");
        colorMap.put(2, "Vermelho");
        colorMap.put(5, "Branco");
        System.out.println("Associate Value with Key: " + colorMap);

        TreeMap<Integer, String> copiedMap = new TreeMap<>(colorMap);
        System.out.println("Copy TreeMap: " + copiedMap);

        System.out.println("Search Key (2): " + colorMap.containsKey(2));
        System.out.println("Search Value (Azul): " + colorMap.containsValue("Azul"));

        System.out.println("Get All Keys: " + colorMap.keySet());

        TreeMap<Integer, String> clearedMap = new TreeMap<>(colorMap);
        clearedMap.clear();
        System.out.println("Clear TreeMap: " + clearedMap);

        TreeMap<Integer, String> reverseOrderMap = new TreeMap<>((a, b) -> b.compareTo(a));
        reverseOrderMap.putAll(colorMap);
        System.out.println("Sort Keys with Comparator (reverse): " + reverseOrderMap);

        Map.Entry<Integer, String> greatestEntry = colorMap.lastEntry();
        Map.Entry<Integer, String> leastEntry = colorMap.firstEntry();
        System.out.println("Greatest and Least Mapping: " + greatestEntry + ", " + leastEntry);

        if (!colorMap.isEmpty()) {
            System.out.println("Get First and Last Key: " + colorMap.firstKey() + ", " + colorMap.lastKey());
        }

        NavigableSet<Integer> reverseKeys = colorMap.descendingKeySet();
        System.out.println("Reverse Key View: " + reverseKeys);

        System.out.println("Floor Entry (3): " + colorMap.floorEntry(3));
        System.out.println("Floor Key (3): " + colorMap.floorKey(3));
        System.out.println("Head Map (Exclusive 3): " + colorMap.headMap(3));
        System.out.println("Head Map (Inclusive 3): " + colorMap.headMap(3, true));
        System.out.println("Higher Key (3): " + colorMap.higherKey(3));
        System.out.println("Lower Entry (3): " + colorMap.lowerEntry(3));
        System.out.println("Lower Key (3): " + colorMap.lowerKey(3));

        System.out.println("NavigableSet View of Keys: " + colorMap.navigableKeySet());

        TreeMap<Integer, String> pollFirstMap = new TreeMap<>(colorMap);
        Map.Entry<Integer, String> polledFirst = pollFirstMap.pollFirstEntry();
        System.out.println("Poll First Entry: " + polledFirst + ", " + pollFirstMap);

        TreeMap<Integer, String> pollLastMap = new TreeMap<>(colorMap);
        Map.Entry<Integer, String> polledLast = pollLastMap.pollLastEntry();
        System.out.println("Poll Last Entry: " + polledLast + ", " + pollLastMap);

        System.out.println("SubMap (Inclusive 2 to Exclusive 5): " + colorMap.subMap(2, 5));
        System.out.println("SubMap (Range 2 to 4 inclusive): " + colorMap.subMap(2, true, 4, true));
        System.out.println("TailMap (Inclusive 3): " + colorMap.tailMap(3));
        System.out.println("TailMap (Exclusive 3): " + colorMap.tailMap(3, false));
        System.out.println("Ceiling Entry (3): " + colorMap.ceilingEntry(3));
        System.out.println("Ceiling Key (3): " + colorMap.ceilingKey(3));
    }
}
