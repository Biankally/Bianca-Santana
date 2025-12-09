import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        System.out.println("1. Associate key with value");
        HashMap<Integer, String> cores = new HashMap<>();
        cores.put(1, "Verde");
        cores.put(2, "Amarelo");
        cores.put(3, "Azul");
        cores.put(4, "Branco");
        cores.put(5, "Rosa");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Count key-value mappings");
        System.out.println("Quantidade de pares: " + cores.size());
        System.out.println();

        System.out.println("3. Copy mappings to another map");
        HashMap<Integer, String> outroMapa = new HashMap<>();
        outroMapa.putAll(cores);
        System.out.println("Mapa copiado: " + outroMapa);
        System.out.println();

        System.out.println("4. Remove all mappings");
        HashMap<Integer, String> mapaParaLimpar = new HashMap<>(cores);
        mapaParaLimpar.clear();
        System.out.println("Mapa após clear: " + mapaParaLimpar);
        System.out.println();

        System.out.println("5. Check if map is empty");
        System.out.println("Mapa original está vazio: " + cores.isEmpty());
        System.out.println("Mapa limpo está vazio: " + mapaParaLimpar.isEmpty());
        System.out.println();

        System.out.println("6. Get shallow copy");
        @SuppressWarnings("unchecked")
        HashMap<Integer, String> coresClone = (HashMap<Integer, String>) cores.clone();
        System.out.println("Cópia superficial: " + coresClone);
        System.out.println();

        System.out.println("7. Check if key exists");
        int chave = 3;
        System.out.println("Contém chave " + chave + ": " + cores.containsKey(chave));
        System.out.println("Contém chave 10: " + cores.containsKey(10));
        System.out.println();

        System.out.println("8. Check if value exists");
        String valor = "Azul";
        System.out.println("Contém valor '" + valor + "': " + cores.containsValue(valor));
        System.out.println("Contém valor 'Marrom': " + cores.containsValue("Rosa"));
        System.out.println();

        System.out.println("9. Get entry set view");
        System.out.println("Entry Set:");
        for (Map.Entry<Integer, String> entry : cores.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("10. Get value by key");
        int chaveBusca = 2;
        String valorRecuperado = cores.get(chaveBusca);
        System.out.println("Valor da chave " + chaveBusca + ": " + valorRecuperado);
        System.out.println();

        System.out.println("11. Get key set");
        System.out.println("Conjunto de chaves: " + cores.keySet());
        System.out.println();

        System.out.println("12. Get values collection");
        System.out.println("Coleção de valores: " + cores.values());
        System.out.println();
    }
}