import java.util.*;

public class HashMapApp{
    public static void main(String[] args){
        System.out.println("=== HashMap ===");

        HashMap<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Verde");
        mapa.put(2, "Amarelo");
        mapa.put(3, "Azul");
        System.out.println("Associate Key with Value -> " + mapa);

        System.out.println("Count Key-Value Mappings -> " + mapa.size());

        HashMap<Integer, String> copia = new HashMap<>();
        copia.putAll(mapa);
        System.out.println("Copy Mappings to Another Map -> " + copia);

        HashMap<Integer, String> clone = (HashMap<Integer, String>) mapa.clone();
        System.out.println("Get Shallow Copy (clone) -> " + clone);

        System.out.println("Check If Key Exists (2) -> " + mapa.containsKey(2));
        System.out.println("Check If Value Exists ('Azul') -> " + mapa.containsValue("Azul"));
        System.out.println("Get Entry Set View -> " + mapa.entrySet());
        System.out.println("Get Value by Key (3) -> " + mapa.get(3));
        System.out.println("Get Key Set -> " + mapa.keySet());
        System.out.println("Get Values Collection -> " + mapa.values());

        mapa.clear();
        System.out.println("Remove All Mappings -> " + mapa);
        System.out.println("Check If Map is Empty -> " + mapa.isEmpty());
    }
}