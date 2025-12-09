import java.util.*;

public class TreeMapApp{
    public static void main(String[] args){
        System.out.println("=== TreeMap ===");

        TreeMap<Integer, String> mapa = new TreeMap<>();
        mapa.put(10, "Verde");
        mapa.put(20, "Amarelo");
        mapa.put(30, "Azul");
        mapa.put(40, "Branco");
        System.out.println("Associate Value with Key -> " + mapa);

        TreeMap<Integer, String> copia = new TreeMap<>(mapa);
        System.out.println("Copy TreeMap -> " + copia);

        System.out.println("Search Key (20) -> " + mapa.containsKey(20));
        System.out.println("Search Value ('Azul') -> " + mapa.containsValue("Azul"));
        System.out.println("Get All Keys -> " + mapa.keySet());

        TreeMap<Integer, String> ordenadoCustom = new TreeMap<>(Comparator.reverseOrder());
        ordenadoCustom.putAll(mapa);
        System.out.println("Sort Keys with Comparator (reverse) -> " + ordenadoCustom);

        System.out.println("Greatest and Least Mapping -> last=" + mapa.lastEntry() + ", first=" + mapa.firstEntry());
        System.out.println("Get First and Last Key -> firstKey=" + mapa.firstKey() + ", lastKey=" + mapa.lastKey());
        System.out.println("Reverse Key View -> " + mapa.descendingKeySet());
        System.out.println("Floor Entry (<=25) -> " + mapa.floorEntry(25));
        System.out.println("Floor Key   (<=25) -> " + mapa.floorKey(25));
        System.out.println("Head Map (Exclusive <30) -> " + mapa.headMap(30, false));
        System.out.println("Head Map (Inclusive <=30) -> " + mapa.headMap(30, true));
        System.out.println("Higher Key (>20) -> " + mapa.higherKey(20));
        System.out.println("Lower Entry (<30) -> " + mapa.lowerEntry(30));
        System.out.println("Lower Key (<30) -> " + mapa.lowerKey(30));
        System.out.println("NavigableSet View -> " + mapa.navigableKeySet());
        System.out.println("SubMap (Inclusive to Exclusive [20,40)) -> " + mapa.subMap(20, true, 40, false));
        System.out.println("SubMap (Range [10,30)) -> " + mapa.subMap(10, 30));
        System.out.println("TailMap (Inclusive >=30) -> " + mapa.tailMap(30, true));
        System.out.println("TailMap (Exclusive >30) -> " + mapa.tailMap(30, false));
        System.out.println("Ceiling Entry (>=25) -> " + mapa.ceilingEntry(25));
        System.out.println("Ceiling Key   (>=25) -> " + mapa.ceilingKey(25));

        Map.Entry<Integer,String> first = mapa.pollFirstEntry();
        System.out.println("Poll First Entry -> " + first + " | resto: " + mapa);
        Map.Entry<Integer,String> last = mapa.pollLastEntry();
        System.out.println("Poll Last Entry -> " + last + " | resto: " + mapa);

        mapa.clear();
        System.out.println("Clear TreeMap -> " + mapa);
    }
}