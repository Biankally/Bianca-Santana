import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

    public static void main(String[] args) {

        HashMap<Integer, String> mapaCores = new HashMap<>();

        System.out.println("--- Associate Key with Value ---");
        mapaCores.put(1, "Vermelho");
        mapaCores.put(2, "Verde");
        mapaCores.put(3, "Azul");
        mapaCores.put(4, "Amarelo");
        System.out.println(mapaCores);

        System.out.println("\n--- Count Key-Value Mappings ---");
        System.out.println("Tamanho: " + mapaCores.size());

        System.out.println("\n--- Copy Mappings to Another Map ---");
        Map<Integer, String> mapaCopia = new HashMap<>();
        mapaCopia.putAll(mapaCores);
        System.out.println("Cópia: " + mapaCopia);

        System.out.println("\n--- Remove All Mappings ---");
        mapaCores.clear();
        System.out.println("Mapa após clear: " + mapaCores);

        System.out.println("\n--- Check If Map is Empty ---");
        System.out.println("Está vazio? " + mapaCores.isEmpty());

        mapaCores.put(10, "Preto");
        mapaCores.put(20, "Branco");
        mapaCores.put(30, "Cinza");
        System.out.println("\n--- Mapa Repopulado ---");
        System.out.println(mapaCores);

        System.out.println("\n--- Get Shallow Copy (clone) ---");
        HashMap<Integer, String> clone = (HashMap<Integer, String>) mapaCores.clone();
        System.out.println("Clone: " + clone);

        System.out.println("\n--- Check If Key Exists (Chave 20) ---");
        System.out.println("Contém chave 20? " + mapaCores.containsKey(20));
        System.out.println("\n--- Check If Key Exists (Chave 99) ---");
        System.out.println("Contém chave 99? " + mapaCores.containsKey(99));

        System.out.println("\n--- Check If Value Exists ('Branco') ---");
        System.out.println("Contém valor 'Branco'? " + mapaCores.containsValue("Branco"));
        System.out.println("\n--- Check If Value Exists ('Roxo') ---");
        System.out.println("Contém valor 'Roxo'? " + mapaCores.containsValue("Roxo"));

        System.out.println("\n--- Get Entry Set View ---");
        System.out.println("EntrySet: " + mapaCores.entrySet());
        for (Map.Entry<Integer, String> entry : mapaCores.entrySet()) {
            System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }

        System.out.println("\n--- Get Value by Key (Chave 10) ---");
        String valor = mapaCores.get(10);
        System.out.println("Valor: " + valor);

        System.out.println("\n--- Get Key Set ---");
        System.out.println("KeySet: " + mapaCores.keySet());

        System.out.println("\n--- Get Values Collection ---");
        System.out.println("Values: " + mapaCores.values());
    }
}