import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;

public class TreeMapApp {

    public static void main(String[] args) {
        
        TreeMap<Integer, String> mapaCores = new TreeMap<>();

        System.out.println("Associate Value with Key:");
        mapaCores.put(3, "Azul");
        mapaCores.put(1, "Vermelho");
        mapaCores.put(2, "Verde");
        mapaCores.put(5, "Laranja");
        mapaCores.put(4, "Amarelo");
        System.out.println(mapaCores);
        System.out.println("---");

        System.out.println("Copy TreeMap:");
        TreeMap<Integer, String> copia = new TreeMap<>(mapaCores);
        System.out.println("Copia: " + copia);
        System.out.println("---");

        System.out.println("Search Key:");
        System.out.println("Contem chave 3? " + mapaCores.containsKey(3));
        System.out.println("Contem chave 6? " + mapaCores.containsKey(6));
        System.out.println("---");

        System.out.println("Search Value:");
        System.out.println("Contem valor 'Verde'? " + mapaCores.containsValue("Verde"));
        System.out.println("Contem valor 'Preto'? " + mapaCores.containsValue("Preto"));
        System.out.println("---");

        System.out.println("Get All Keys:");
        System.out.println(mapaCores.keySet());
        System.out.println("---");
        
        System.out.println("Sort Keys with Comparator:");
        TreeMap<Integer, String> reverso = new TreeMap<>(Comparator.reverseOrder());
        reverso.putAll(mapaCores);
        System.out.println("Mapa reverso: " + reverso);
        System.out.println("---");

        System.out.println("Greatest and Least Mapping:");
        System.out.println("Menor (primeiro): " + mapaCores.firstEntry());
        System.out.println("Maior (ultimo): " + mapaCores.lastEntry());
        System.out.println("---");

        System.out.println("Get First and Last Key:");
        System.out.println("Primeira chave: " + mapaCores.firstKey());
        System.out.println("Ultima chave: " + mapaCores.lastKey());
        System.out.println("---");

        System.out.println("Reverse Key View:");
        System.out.println(mapaCores.descendingKeySet());
        System.out.println("---");

        System.out.println("Floor Entry:");
        System.out.println("Maior entrada <= 3: " + mapaCores.floorEntry(3));
        System.out.println("---");

        System.out.println("Floor Key:");
        System.out.println("Maior chave <= 3: " + mapaCores.floorKey(3));
        System.out.println("---");

        System.out.println("Head Map (Exclusive):");
        System.out.println("Chaves < 3: " + mapaCores.headMap(3));
        System.out.println("---");

        System.out.println("Head Map (Inclusive Option):");
        System.out.println("Chaves <= 3: " + mapaCores.headMap(3, true));
        System.out.println("---");
        
        System.out.println("Higher Key:");
        System.out.println("Menor chave > 3: " + mapaCores.higherKey(3));
        System.out.println("---");

        System.out.println("Lower Entry:");
        System.out.println("Maior entrada < 3: " + mapaCores.lowerEntry(3));
        System.out.println("---");

        System.out.println("Lower Key:");
        System.out.println("Maior chave < 3: " + mapaCores.lowerKey(3));
        System.out.println("---");

        System.out.println("NavigableSet View:");
        System.out.println(mapaCores.navigableKeySet());
        System.out.println("---");

        System.out.println("Poll First Entry:");
        Map.Entry<Integer, String> primeiro = mapaCores.pollFirstEntry();
        System.out.println("Removido: " + primeiro);
        System.out.println("Mapa atual: " + mapaCores);
        System.out.println("---");

        System.out.println("Poll Last Entry:");
        Map.Entry<Integer, String> ultimo = mapaCores.pollLastEntry();
        System.out.println("Removido: " + ultimo);
        System.out.println("Mapa atual: " + mapaCores);
        System.out.println("---");

        System.out.println("SubMap (Inclusive to Exclusive):");
        System.out.println("Intervalo [2, 4): " + mapaCores.subMap(2, 4));
        System.out.println("---");

        System.out.println("SubMap (Range):");
        System.out.println("Intervalo [2, 4]: " + mapaCores.subMap(2, true, 4, true));
        System.out.println("---");

        System.out.println("TailMap (Inclusive):");
        System.out.println("Chaves >= 3: " + mapaCores.tailMap(3));
        System.out.println("---");

        System.out.println("TailMap (Exclusive):");
        System.out.println("Chaves > 3: " + mapaCores.tailMap(3, false));
        System.out.println("---");

        System.out.println("Ceiling Entry:");
        System.out.println("Menor entrada >= 3: " + mapaCores.ceilingEntry(3));
        System.out.println("---");
        
        System.out.println("Ceiling Key:");
        System.out.println("Menor chave >= 3: " + mapaCores.ceilingKey(3));
        System.out.println("---");
        
        System.out.println("Clear TreeMap:");
        mapaCores.clear();
        System.out.println(mapaCores);
        System.out.println("---");
    }
}