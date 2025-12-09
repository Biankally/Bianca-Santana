import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

    public static void main(String[] args) {
        System.out.println("### Iniciando HashMapApp ###\n");

        Map<Integer, String> mapaCores = new HashMap<>();

        System.out.println("[Operação 1]: Associate Key with Value");
        mapaCores.put(1, "Vermelho");
        mapaCores.put(2, "Verde");
        mapaCores.put(3, "Azul");
        System.out.println("Resultado: " + mapaCores);

        System.out.println("\n[Operação 2]: Count Key-Value Mappings");
        System.out.println("Resultado: " + mapaCores.size());

        System.out.println("\n[Operação 3]: Copy Mappings to Another Map");
        Map<Integer, String> mapa2 = new HashMap<>();
        mapa2.putAll(mapaCores);
        System.out.println("Resultado: " + mapa2);

        System.out.println("\n[Operação 4]: Remove All Mappings");
        mapaCores.clear();
        System.out.println("Resultado: " + mapaCores);

        System.out.println("\n[Operação 5]: Check If Map is Empty");
        System.out.println("Resultado: " + mapaCores.isEmpty());

        System.out.println("\n[Operação 6]: Get Shallow Copy");
        mapaCores.put(4, "Amarelo");
        mapaCores.put(5, "Laranja");
        HashMap<Integer, String> cloneMap = (HashMap<Integer, String>) ((HashMap<Integer, String>) mapaCores).clone();
        System.out.println("Resultado: " + cloneMap);

        System.out.println("\n[Operação 7]: Check If Key Exists (chave 4)");
        System.out.println("Resultado: " + mapaCores.containsKey(4));

        System.out.println("\n[Operação 8]: Check If Value Exists ('Verde')");
        System.out.println("Resultado: " + mapaCores.containsValue("Verde"));

        System.out.println("\n[Operação 9]: Get Entry Set View");
        System.out.println("Resultado: " + mapaCores.entrySet());

        System.out.println("\n[Operação 10]: Get Value by Key (chave 5)");
        System.out.println("Resultado: " + mapaCores.get(5));

        System.out.println("\n[Operação 11]: Get Key Set");
        System.out.println("Resultado: " + mapaCores.keySet());

        System.out.println("\n[Operação 12]: Get Values Collection");
        System.out.println("Resultado: " + mapaCores.values());

        System.out.println("\n### HashMapApp Finalizado ###");
    }
}