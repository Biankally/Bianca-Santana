import java.util.HashMap;

public class HashMapApp {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<>();
        System.out.println("Associate Key with Value:");
        mapa.put(1, "Verde");
        mapa.put(2, "Amarelo");
        mapa.put(3, "Azul");
        System.out.println(mapa);

        System.out.println("Count Key-Value Mappings:");
        System.out.println(mapa.size());

        System.out.println("Copy Mappings to Another Map:");
        HashMap<Integer, String> copia = new HashMap<>(mapa);
        System.out.println(copia);

        System.out.println("Check If Key Exists:");
        System.out.println(mapa.containsKey(2));

        System.out.println("Check If Value Exists:");
        System.out.println(mapa.containsValue("Azul"));

        System.out.println("Get Entry Set View:");
        System.out.println(mapa.entrySet());

        System.out.println("Get Value by Key:");
        System.out.println(mapa.get(1));

        System.out.println("Get Key Set:");
        System.out.println(mapa.keySet());

        System.out.println("Get Values Collection:");
        System.out.println(mapa.values());

        System.out.println("Get Shallow Copy:");
        HashMap<Integer, String> clone = (HashMap<Integer, String>) mapa.clone();
        System.out.println(clone);

        System.out.println("Remove All Mappings:");
        mapa.clear();
        System.out.println(mapa);

        System.out.println("Check If Map is Empty:");
        System.out.println(mapa.isEmpty());
    }
}
