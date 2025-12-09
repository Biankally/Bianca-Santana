import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer, String> cores = new TreeMap<>();
        cores.put(3, "Azul");
        cores.put(1, "Vermelho");
        cores.put(10, "Amarelo");
        cores.put(5, "Verde");
        System.out.println("1. Associate Value with Key (put): " + cores);
        
        TreeMap<Integer, String> copia = new TreeMap<>(cores);
        System.out.println("2. Copy TreeMap (constructor): " + copia);

        System.out.println("3. Search Key (5): " + cores.containsKey(5));
        System.out.println("   Search Key (99): " + cores.containsKey(99));

        System.out.println("4. Search Value ('Azul'): " + cores.containsValue("Azul"));
        System.out.println("   Search Value ('Preto'): " + cores.containsValue("Preto"));

        Set<Integer> chaves = cores.keySet();
        System.out.println("5. Get All Keys (keySet): " + chaves);

        copia.clear();
        System.out.println("6. Clear TreeMap (on 'copia'): " + copia);

        TreeMap<Integer, String> reverso = new TreeMap<>(Comparator.reverseOrder());
        reverso.putAll(cores);
        System.out.println("7. Sort Keys with Comparator (reverse): " + reverso);

        System.out.println("8. Greatest (lastEntry) Mapping: " + cores.lastEntry());
        System.out.println("   Least (firstEntry) Mapping: " + cores.firstEntry());

        System.out.println("9. Get First (firstKey): " + cores.firstKey() + " and Last (lastKey): " + cores.lastKey());

        System.out.println("10. Reverse Key View (descendingMap): " + cores.descendingMap());

        System.out.println("11. Floor Entry (key <= 4): " + cores.floorEntry(4)); 

        System.out.println("12. Floor Key (key <= 4): " + cores.floorKey(4)); 

        System.out.println("13. Head Map (Exclusive) (key < 5): " + cores.headMap(5));

        System.out.println("14. Head Map (Inclusive Option) (key <= 5): " + cores.headMap(5, true)); 

        System.out.println("15. Higher Key (key > 5): " + cores.higherKey(5)); 

        System.out.println("16. Lower Entry (key < 3): " + cores.lowerEntry(3));

        System.out.println("17. Lower Key (key < 3): " + cores.lowerKey(3)); 

        NavigableSet<Integer> nSet = cores.navigableKeySet();
        System.out.println("18. NavigableSet View (navigableKeySet): " + nSet);

        Map.Entry<Integer, String> firstEntry = cores.pollFirstEntry();
        System.out.println("19. Poll First Entry (retornou: " + firstEntry + "). Mapa agora: " + cores);
        
        Map.Entry<Integer, String> lastEntry = cores.pollLastEntry();
        System.out.println("20. Poll Last Entry (retornou: " + lastEntry + "). Mapa agora: " + cores);
        
        cores.put(firstEntry.getKey(), firstEntry.getValue());
        cores.put(lastEntry.getKey(), lastEntry.getValue());
        System.out.println("    (Repopulando o mapa): " + cores); 

        System.out.println("21. SubMap (Inclusive to Exclusive) (3 <= key < 10): " + cores.subMap(3, 10));

        System.out.println("22. SubMap (Range) (3 <= key <= 10): " + cores.subMap(3, true, 10, true)); 

        System.out.println("23. TailMap (Inclusive) (key >= 5): " + cores.tailMap(5));

        System.out.println("24. TailMap (Exclusive) (key > 5): " + cores.tailMap(5, false)); 

        System.out.println("25. Ceiling Entry (key >= 4): " + cores.ceilingEntry(4)); 

        System.out.println("26. Ceiling Key (key >= 4): " + cores.ceilingKey(4)); 
    }
}