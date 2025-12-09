import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

    public static void main(String[] args) {
        
        HashMap<Integer, String> mapaCores = new HashMap<>();

        System.out.println("Associate Key with Value:");
        mapaCores.put(1, "Vermelho");
        mapaCores.put(2, "Verde");
        mapaCores.put(3, "Azul");
        System.out.println(mapaCores);
        System.out.println("---");

        System.out.println("Count Key-Value Mappings:");
        System.out.println("Tamanho: " + mapaCores.size());
        System.out.println("---");

        System.out.println("Copy Mappings to Another Map:");
        Map<Integer, String> copia = new HashMap<>();
        copia.putAll(mapaCores);
        System.out.println("Copia: " + copia);
        System.out.println("---");

        System.out.println("Remove All Mappings:");
        mapaCores.clear();
        System.out.println(mapaCores);
        System.out.println("---");

        System.out.println("Check If Map is Empty:");
        System.out.println("Esta vazio? " + mapaCores.isEmpty());
        System.out.println("---");
        
        mapaCores.put(1, "Branco");
        mapaCores.put(2, "Preto");

        System.out.println("Get Shallow Copy:");
        HashMap<Integer, String> clone = (HashMap<Integer, String>) mapaCores.clone();
        System.out.println("Clone: " + clone);
        System.out.println("---");

        System.out.println("Check If Key Exists:");
        System.out.println("Contem chave 2? " + mapaCores.containsKey(2));
        System.out.println("Contem chave 5? " + mapaCores.containsKey(5));
        System.out.println("---");

        System.out.println("Check If Value Exists:");
        System.out.println("Contem valor 'Branco'? " + mapaCores.containsValue("Branco"));
        System.out.println("Contem valor 'Roxo'? " + mapaCores.containsValue("Roxo"));
        System.out.println("---");

        System.out.println("Get Entry Set View:");
        System.out.println(mapaCores.entrySet());
        System.out.println("---");

        System.out.println("Get Value by Key:");
        System.out.println("Valor da chave 1: " + mapaCores.get(1));
        System.out.println("---");

        System.out.println("Get Key Set:");
        System.out.println(mapaCores.keySet());
        System.out.println("---");

        System.out.println("Get Values Collection:");
        System.out.println(mapaCores.values());
        System.out.println("---");
    }
}