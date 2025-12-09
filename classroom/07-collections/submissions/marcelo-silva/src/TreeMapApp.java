import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {

        TreeMap<Integer, String> mapaCores = new TreeMap<>();

        System.out.println("--- Associate Value with Key ---");
        mapaCores.put(10, "Vermelho");
        mapaCores.put(50, "Verde");
        mapaCores.put(30, "Azul");
        mapaCores.put(20, "Amarelo");
        mapaCores.put(40, "Branco");
        System.out.println(mapaCores);

        System.out.println("\n--- Copy TreeMap ---");
        TreeMap<Integer, String> copia = new TreeMap<>();
        copia.putAll(mapaCores);
        System.out.println("Cópia: " + copia);

        System.out.println("\n--- Search Key (Chave 30) ---");
        System.out.println("Contém chave 30? " + mapaCores.containsKey(30));

        System.out.println("\n--- Search Value ('Verde') ---");
        System.out.println("Contém valor 'Verde'? " + mapaCores.containsValue("Verde"));

        System.out.println("\n--- Get All Keys ---");
        System.out.println("KeySet: " + mapaCores.keySet());

        System.out.println("\n--- Clear TreeMap ---");
        copia.clear();
        System.out.println("Cópia após clear: " + copia);
        System.out.println("Original: " + mapaCores);


        System.out.println("\n--- Sort Keys with Comparator (Ordem Reversa) ---");
        TreeMap<Integer, String> reverso = new TreeMap<>(Comparator.reverseOrder());
        reverso.putAll(mapaCores);
        System.out.println("Mapa reverso: " + reverso);
        System.out.println("Chaves reversas: " + reverso.keySet());

        System.out.println("\n--- Greatest and Least Mapping ---");
        System.out.println("Menor (First) Entry: " + mapaCores.firstEntry());
        System.out.println("Maior (Last) Entry: " + mapaCores.lastEntry());

        System.out.println("\n--- Get First and Last Key ---");
        System.out.println("Menor (First) Key: " + mapaCores.firstKey());
        System.out.println("Maior (Last) Key: " + mapaCores.lastKey());

        System.out.println("\n--- Reverse Key View ---");
        System.out.println("Visão de chaves reversas: " + mapaCores.descendingKeySet());

        int chaveRef = 30;
        System.out.println("\n--- Operações de Navegação (Chave Ref: " + chaveRef + ") ---");
        
        System.out.println("Floor Entry (<= 30): " + mapaCores.floorEntry(chaveRef));
        
        System.out.println("Floor Key (<= 30): " + mapaCores.floorKey(chaveRef));
        
        System.out.println("Head Map (< 30): " + mapaCores.headMap(chaveRef));
        
        System.out.println("Head Map (<= 30): " + mapaCores.headMap(chaveRef, true));
        
        System.out.println("Higher Key (> 30): " + mapaCores.higherKey(chaveRef));
        
        System.out.println("Lower Entry (< 30): " + mapaCores.lowerEntry(chaveRef));
        
        System.out.println("Lower Key (< 30): " + mapaCores.lowerKey(chaveRef));

        System.out.println("NavigableSet View (das chaves): " + mapaCores.navigableKeySet());

        System.out.println("\n--- Poll First Entry ---");
        Map.Entry<Integer, String> first = mapaCores.pollFirstEntry();
        System.out.println("Removido: " + first);
        System.out.println("Mapa atual: " + mapaCores);

        System.out.println("\n--- Poll Last Entry ---");
        Map.Entry<Integer, String> last = mapaCores.pollLastEntry();
        System.out.println("Removido: " + last);
        System.out.println("Mapa atual: " + mapaCores);
        
        mapaCores.put(first.getKey(), first.getValue());
        mapaCores.put(last.getKey(), last.getValue());
        System.out.println("Mapa repopulado: " + mapaCores);

        System.out.println("\n--- SubMap (Inclusive to Exclusive) [20, 40) ---");
        SortedMap<Integer, String> subMap1 = mapaCores.subMap(20, 40);
        System.out.println(subMap1);

        System.out.println("\n--- SubMap (Range) [20, 40] ---");
        NavigableMap<Integer, String> subMap2 = mapaCores.subMap(20, true, 40, true);
        System.out.println(subMap2);

        System.out.println("\n--- TailMap (Inclusive) [>= 30] ---");
        SortedMap<Integer, String> tailMap1 = mapaCores.tailMap(30);
        System.out.println(tailMap1);
        
        System.out.println("\n--- TailMap (Exclusive) [> 30] ---");
        NavigableMap<Integer, String> tailMap2 = mapaCores.tailMap(30, false);
        System.out.println(tailMap2);

        System.out.println("\n--- Ceiling Entry (>= 30) ---");
        System.out.println(mapaCores.ceilingEntry(30));

        System.out.println("\n--- Ceiling Key (>= 30) ---");
        System.out.println(mapaCores.ceilingKey(30));
    }
}