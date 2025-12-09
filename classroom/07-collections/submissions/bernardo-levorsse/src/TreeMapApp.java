import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        System.out.println("1) Associate Value with Key");
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(3,"Azul"); tm.put(1,"Verde"); tm.put(5,"Amarelo"); tm.put(7,"Branco");
        System.out.println(tm);

        System.out.println("\n2) Copy TreeMap");
        TreeMap<Integer,String> tm2 = new TreeMap<>(tm);
        System.out.println(tm2);

        System.out.println("\n3) Search Key (5)");
        System.out.println(tm.containsKey(5));

        System.out.println("\n4) Search Value ('Azul')");
        System.out.println(tm.containsValue("Azul"));

        System.out.println("\n5) Get All Keys");
        System.out.println(tm.keySet());

        System.out.println("\n6) Clear TreeMap (cópia)");
        TreeMap<Integer,String> copia = new TreeMap<>(tm);
        copia.clear(); System.out.println(copia);

        System.out.println("\n7) Sort Keys with Comparator (reverso)");
        NavigableMap<Integer,String> reverso = tm.descendingMap();
        System.out.println(reverso.keySet());

        System.out.println("\n8) Greatest and Least Mapping");
        System.out.println("max=" + tm.lastEntry() + " | min=" + tm.firstEntry());

        System.out.println("\n9) Get First and Last Key");
        System.out.println("firstKey=" + tm.firstKey() + ", lastKey=" + tm.lastKey());

        System.out.println("\n10) Reverse Key View");
        System.out.println(tm.descendingKeySet());

        System.out.println("\n11) Floor Entry (<=4)");
        System.out.println(tm.floorEntry(4));

        System.out.println("\n12) Floor Key (<=4)");
        System.out.println(tm.floorKey(4));

        System.out.println("\n13) Head Map (Exclusive) <5");
        System.out.println(tm.headMap(5));

        System.out.println("\n14) Head Map (Inclusive Option) <=5");
        System.out.println(tm.headMap(5, true));

        System.out.println("\n15) Higher Key (>5)");
        System.out.println(tm.higherKey(5));

        System.out.println("\n16) Lower Entry (<5)");
        System.out.println(tm.lowerEntry(5));

        System.out.println("\n17) Lower Key (<5)");
        System.out.println(tm.lowerKey(5));

        System.out.println("\n18) NavigableSet View (keys)");
        System.out.println(tm.navigableKeySet());

        System.out.println("\n19) Poll First Entry");
        System.out.println(tm.pollFirstEntry()); System.out.println(tm);

        System.out.println("\n20) Poll Last Entry");
        System.out.println(tm.pollLastEntry()); System.out.println(tm);

        System.out.println("\n21) SubMap (Inclusive to Exclusive) [3,7)");
        System.out.println(tm.subMap(3, true, 7, false));

        System.out.println("\n22) SubMap (Range) [3..7] inclusivo");
        System.out.println(tm.subMap(3, true, 7, true));

        System.out.println("\n23) TailMap (Inclusive) >=5");
        System.out.println(tm.tailMap(5, true));

        System.out.println("\n24) TailMap (Exclusive) >5");
        System.out.println(tm.tailMap(5, false));

        System.out.println("\n25) Ceiling Entry (>=4)");
        System.out.println(tm.ceilingEntry(4));

        System.out.println("\n26) Ceiling Key (>=4)");
        System.out.println(tm.ceilingKey(4));
    }
}
