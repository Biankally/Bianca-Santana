package submissions.nome-sobrenome.src;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapApp {
    public static void main(String[] args) {
        Map<Integer, String> cores = new HashMap<>();

        System.out.println("1. Associate Key with Value");
        cores.put(1, "Verde");
        cores.put(2, "Amarelo");
        cores.put(3, "Azul");
        cores.put(4, "Branco");
        System.out.println(cores);

        System.out.println("\n2. Count Key-Value Mappings");
        System.out.println("Tamanho: " + cores.size());

        System.out.println("\n3. Copy Mappings to Another Map");
        Map<Integer, String> copiaCores = new HashMap<>(cores);
        System.out.println(copiaCores);

        System.out.println("\n6. Get Shallow Copy");
        @SuppressWarnings("unchecked")
        HashMap<Integer, String> coresClonadas = (HashMap<Integer, String>) ((HashMap<Integer, String>) cores).clone();
        System.out.println(coresClonadas);

        System.out.println("\n7. Check If Key Exists");
        int chaveBusca = 3;
        System.out.println("Contém chave " + chaveBusca + ": " + cores.containsKey(chaveBusca));

        System.out.println("\n8. Check If Value Exists");
        String valorBusca = "Verde";
        System.out.println("Contém valor '" + valorBusca + "': " + cores.containsValue(valorBusca));

        System.out.println("\n9. Get Entry Set View");
        Set<Map.Entry<Integer, String>> entradas = cores.entrySet();
        System.out.println(entradas);

        System.out.println("\n10. Get Value by Key");
        System.out.println("Valor para chave 2: " + cores.get(2));

        System.out.println("\n11. Get Key Set");
        Set<Integer> chaves = cores.keySet();
        System.out.println(chaves);

        System.out.println("\n12. Get Values Collection");
        Collection<String> valores = cores.values();
        System.out.println(valores);

        System.out.println("\n4. Remove All Mappings");
        cores.clear();
        System.out.println("Mapa original esvaziado: " + cores);

        System.out.println("\n5. Check If Map is Empty");
        System.out.println("Mapa original vazio: " + cores.isEmpty());
        System.out.println("Cópia vazia: " + copiaCores.isEmpty());
    }
}