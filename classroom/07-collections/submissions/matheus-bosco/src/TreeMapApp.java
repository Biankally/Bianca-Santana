import java.util.*;



public class TreeMapApp {


    public static void main(String[] args) {
        System.out.println("Associate Value with Key");
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(10,"Verde"); tm.put(20,"Amarelo"); tm.put(30,"Azul"); tm.put(40,"Branco");
        System.out.println(tm);

        System.out.println("Copy TreeMap");
        TreeMap<Integer,String> tm2 = new TreeMap<>(tm);
        System.out.println(tm2);

        System.out.println("Search Key");
        System.out.println(tm.containsKey(20));

        System.out.println("Search Value");
        System.out.println(tm.containsValue("Azul"));

        System.out.println("Get All Keys");
        System.out.println(tm.keySet());

        System.out.println("Clear TreeMap");
        TreeMap<Integer,String> tmp = new TreeMap<>(tm);
        tmp.clear();
        System.out.println(tmp);

        System.out.println("Sort Keys with Comparator");
        TreeMap<Integer,String> byDesc = new TreeMap<>(Comparator.reverseOrder());
        byDesc.putAll(tm);
        System.out.println(byDesc);

        System.out.println("Greatest and Least Mapping");
        System.out.println(tm.lastEntry() + " | " + tm.firstEntry());

        System.out.println("Get First and Last Key");
        System.out.println(tm.firstKey() + " / " + tm.lastKey());

        System.out.println("Reverse Key View");
        System.out.println(tm.descendingKeySet());

        System.out.println("Floor Entry");
        System.out.println(tm.floorEntry(25));

        System.out.println("Floor Key");
        System.out.println(tm.floorKey(25));

        System.out.println("Head Map (Exclusive)");
        System.out.println(tm.headMap(30));         // < 30

        System.out.println("Head Map (Inclusive Option)");
        System.out.println(tm.headMap(30, true));   // ≤ 30

        System.out.println("Higher Key");
        System.out.println(tm.higherKey(30));       // > 30

        System.out.println("Lower Entry");
        System.out.println(tm.lowerEntry(30));      // < 30

        System.out.println("Lower Key");
        System.out.println(tm.lowerKey(30));        // < 30

        System.out.println("NavigableSet View");
        System.out.println(tm.navigableKeySet());

        System.out.println("Poll First Entry");
        System.out.println(tm.pollFirstEntry());
        System.out.println(tm);

        System.out.println("Poll Last Entry");
        System.out.println(tm.pollLastEntry());
        System.out.println(tm);

        System.out.println("SubMap (Inclusive to Exclusive)");
        TreeMap<Integer,String> base = new TreeMap<>(Map.of(1,"A",2,"B",3,"C",4,"D",5,"E"));
        System.out.println(base.subMap(2, 5));      // [2..5)

        System.out.println("SubMap (Range)");
        System.out.println(base.subMap(2, true, 4, true)); // [2..4]

        System.out.println("TailMap (Inclusive)");
        System.out.println(base.tailMap(3));        // ≥ 3

        System.out.println("TailMap (Exclusive)");
        System.out.println(base.tailMap(3, false)); // > 3

        System.out.println("Ceiling Entry");
        System.out.println(base.ceilingEntry(3));   // ≥ 3

        System.out.println("Ceiling Key");
        System.out.println(base.ceilingKey(3));     // ≥ 3
    }

}
