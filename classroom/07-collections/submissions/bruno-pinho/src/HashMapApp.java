import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapApp {

    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<>();

        mapa.put(1, "Verde");
        mapa.put(2, "Azul");
        mapa.put(3, "Amarelo");
        System.out.println("1. Associate Key with Value: " + mapa);
        System.out.println("--------------------");

        System.out.println("2. Count Key-Value Mappings: " + mapa.size());
        System.out.println("--------------------");

        HashMap<Integer, String> m2 = new HashMap<>();
        m2.put(10, "Preto"); 
        m2.putAll(mapa);
        System.out.println("3. Copy Mappings to Another Map: " + m2);
        System.out.println("--------------------");

        mapa.clear();
        System.out.println("4. Remove All Mappings (clear): " + mapa);
        System.out.println("--------------------");

        System.out.println("5. Check If Map is Empty: " + mapa.isEmpty());
        System.out.println("--------------------");

        mapa.put(100, "Branco");
        mapa.put(200, "Cinza");
        System.out.println("... Repopulando: " + mapa);

        HashMap<Integer, String> cloned = (HashMap<Integer, String>) mapa.clone();
        System.out.println("6. Get Shallow Copy (clone): " + cloned);
        System.out.println("--------------------");

        System.out.println("7. Check If Key Exists (Chave 100): " + mapa.containsKey(100));
        System.out.println("   Check If Key Exists (Chave 999): " + mapa.containsKey(999));
        System.out.println("--------------------");

        System.out.println("8. Check If Value Exists (Valor 'Cinza'): " + mapa.containsValue("Cinza"));
        System.out.println("   Check If Value Exists (Valor 'Roxo'): " + mapa.containsValue("Roxo"));
        System.out.println("--------------------");

        Set<Map.Entry<Integer, String>> entrySet = mapa.entrySet();
        System.out.println("9. Get Entry Set View: " + entrySet);
        System.out.println("--------------------");

        String valor = mapa.get(200);
        System.out.println("10. Get Value by Key (Chave 200): " + valor);
        System.out.println("--------------------");

        Set<Integer> keySet = mapa.keySet();
        System.out.println("11. Get Key Set: " + keySet);
        System.out.println("--------------------");

        Collection<String> values = mapa.values();
        System.out.println("12. Get Values Collection: " + values);
        System.out.println("--------------------");
    }
}