import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapApp {
    public static void main(String[] args) {
        System.out.println("Associate Key with Value");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Verde");
        map.put(2, "Amarelo");
        map.put(3, "Azul");
        System.out.println(map);

        System.out.println("Count Key-Value Mappings");
        System.out.println(map.size());

        System.out.println("Copy Mappings to Another Map");
        Map<Integer, String> copy = new HashMap<>();
        copy.putAll(map);
        System.out.println(copy);

        System.out.println("Remove All Mappings");
        Map<Integer, String> toClear = new HashMap<>(map);
        toClear.clear();
        System.out.println(toClear);

        System.out.println("Check If Map is Empty");
        System.out.println(toClear.isEmpty());

        System.out.println("Get Shallow Copy");
        Map<Integer, String> shallow = new HashMap<>(map);
        System.out.println(shallow);

        System.out.println("Check If Key Exists");
        System.out.println(map.containsKey(2));

        System.out.println("Check If Value Exists");
        System.out.println(map.containsValue("Azul"));

        System.out.println("Get Entry Set View");
        System.out.println(map.entrySet());

        System.out.println("Get Value by Key");
        System.out.println(map.get(3));

        System.out.println("Get Key Set");
        Set<Integer> keys = map.keySet();
        System.out.println(keys);

        System.out.println("Get Values Collection");
        Collection<String> values = map.values();
        System.out.println(values);
    }
}
