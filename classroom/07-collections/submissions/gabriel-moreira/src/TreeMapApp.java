import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer, String> mapa = new TreeMap<>();
        System.out.println("Associate Value with Key:");
        mapa.put(3, "Azul");
        mapa.put(1, "Verde");
        mapa.put(2, "Amarelo");
        mapa.put(5, "Branco");
        mapa.put(4, "Preto");
        System.out.println(mapa);

        System.out.println("Copy TreeMap:");
        TreeMap<Integer, String> copia = new TreeMap<>(mapa);
        System.out.println(copia);

        System.out.println("Search Key 3:");
        System.out.println(mapa.containsKey(3));

        System.out.println("Search Value 'Azul':");
        System.out.println(mapa.containsValue("Azul"));

        System.out.println("Get All Keys:");
        System.out.println(mapa.keySet());

        System.out.println("Sort Keys with Comparator:");
        TreeMap<Integer, String> invertido = new TreeMap<>(Comparator.reverseOrder());
        invertido.putAll(mapa);
        System.out.println(invertido);

        System.out.println("Greatest and Least Mapping:");
        System.out.println(mapa.lastEntry());
        System.out.println(mapa.firstEntry());

        System.out.println("Reverse Key View:");
        System.out.println(mapa.descendingKeySet());

        System.out.println("Floor and Ceiling Entry:");
        System.out.println(mapa.floorEntry(3));
        System.out.println(mapa.ceilingEntry(3));

        System.out.println("SubMap (Inclusive to Exclusive 2->5):");
        System.out.println(mapa.subMap(2, 5));

        System.out.println("TailMap (Inclusive 3):");
        System.out.println(mapa.tailMap(3, true));

        System.out.println("HeadMap (Exclusive 4):");
        System.out.println(mapa.headMap(4, false));

        System.out.println("Poll First and Last Entry:");
        System.out.println(mapa.pollFirstEntry());
        System.out.println(mapa.pollLastEntry());
        System.out.println(mapa);
    }
}
