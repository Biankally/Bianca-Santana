import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        HashMap<Integer, String> colorMap = new HashMap<>();

        colorMap.put(1, "Verde");
        colorMap.put(2, "Amarelo");
        colorMap.put(3, "Azul");
        System.out.println("Associate Key with Value: " + colorMap);

        System.out.println("Count Key-Value Mappings: " + colorMap.size());

        HashMap<Integer, String> copiedMap = new HashMap<>(colorMap);
        System.out.println("Copy Mappings to Another Map: " + copiedMap);

        HashMap<Integer, String> clearedMap = new HashMap<>(colorMap);
        clearedMap.clear();
        System.out.println("Remove All Mappings: " + clearedMap);

        System.out.println("Check If Map is Empty: " + clearedMap.isEmpty());

        @SuppressWarnings("unchecked")
        HashMap<Integer, String> shallowCopy = (HashMap<Integer, String>) colorMap.clone();
        System.out.println("Get Shallow Copy: " + shallowCopy);

        System.out.println("Check If Key Exists (2): " + colorMap.containsKey(2));
        System.out.println("Check If Value Exists (Azul): " + colorMap.containsValue("Azul"));

        System.out.println("Get Entry Set View: " + colorMap.entrySet());
        System.out.println("Get Value by Key (3): " + colorMap.get(3));
        System.out.println("Get Key Set: " + colorMap.keySet());
        System.out.println("Get Values Collection: " + colorMap.values());
    }
}
