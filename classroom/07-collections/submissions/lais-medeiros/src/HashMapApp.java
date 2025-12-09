import java.util.HashMap;

public class HashMapApp {
    public static void main(String[] args) {
        HashMap<Integer, String> cores = new HashMap<>();

        cores.put(1, "Verde");
        cores.put(2, "Amarelo");
        cores.put(3, "Azul");
        System.out.println("Associate Key with Value: " + cores);

        System.out.println("Count Key-Value Mappings: " + cores.size());

        HashMap<Integer, String> copia = new HashMap<>();
        copia.putAll(cores);
        System.out.println("Copy Mappings to Another Map: " + copia);

        cores.clear();
        System.out.println("Remove All Mappings: " + cores);

        System.out.println("Check If Map is Empty: " + cores.isEmpty());

        cores.putAll(copia);
        HashMap<Integer, String> clone = (HashMap<Integer, String>) cores.clone();
        System.out.println("Get Shallow Copy: " + clone);

        System.out.println("Check If Key Exists (2): " + cores.containsKey(2));
        System.out.println("Check If Value Exists ('Azul'): " + cores.containsValue("Azul"));

        System.out.println("Get Entry Set View: " + cores.entrySet());

        System.out.println("Get Value by Key (3): " + cores.get(3));

        System.out.println("Get Key Set: " + cores.keySet());

        System.out.println("Get Values Collection: " + cores.values());
    }
}