import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set; 

class HashMapApp {
    public static void main(String[] args) {

        // 1. Associate Key with Value: associe uma chave ao valor no HashMap.
        HashMap<Integer, String> cores = new HashMap<>();
        cores.put(1, "Vermelho");
        cores.put(2, "Verde");
        cores.put(3, "Azul");
        cores.put(4, "Amarelo");
        System.out.println("1. Associate Key with Value (put): " + cores);

        // 2. Count Key-Value Mappings: informe a quantidade de pares.
        int tamanho = cores.size();
        System.out.println("2. Count Key-Value Mappings (size): " + tamanho);

        // 3. Copy Mappings to Another Map: copie todas as associações para outro mapa.
        HashMap<Integer, String> mapaCopia = new HashMap<>();
        mapaCopia.put(10, "Preto"); // Adiciona um item antes para mostrar a cópia
        mapaCopia.putAll(cores);
        System.out.println("3. Copy Mappings to Another Map (putAll): " + mapaCopia);

        // 4. Remove All Mappings: remova todos os pares do mapa.
        HashMap<Integer, String> tempParaLimpar = new HashMap<>(cores);
        tempParaLimpar.clear();
        System.out.println("4. Remove All Mappings (clear) (em uma cópia): " + tempParaLimpar);

        // 5. Check If Map is Empty: verifique se o mapa está vazio.
        System.out.println("5. Check If 'cores' is Empty: " + cores.isEmpty());
        System.out.println("   Check If 'tempParaLimpar' is Empty: " + tempParaLimpar.isEmpty());

        // 6. Get Shallow Copy: gere uma cópia superficial do mapa.
        @SuppressWarnings("unchecked") // Necessário por causa do .clone()
        HashMap<Integer, String> clone = (HashMap<Integer, String>) cores.clone();
        System.out.println("6. Get Shallow Copy (clone): " + clone);

        // 7. Check If Key Exists: verifique se uma chave específica está presente.
        Integer chaveBusca = 3; // "Azul"
        boolean temChave = cores.containsKey(chaveBusca);
        System.out.println("7. Check If Key Exists (" + chaveBusca + "): " + temChave);
        chaveBusca = 99;
        temChave = cores.containsKey(chaveBusca);
        System.out.println("   Check If Key Exists (" + chaveBusca + "): " + temChave);

        // 8. Check If Value Exists: verifique se um valor específico está presente.
        String valorBusca = "Verde";
        boolean temValor = cores.containsValue(valorBusca);
        System.out.println("8. Check If Value Exists ('" + valorBusca + "'): " + temValor);
        valorBusca = "Cinza";
        temValor = cores.containsValue(valorBusca);
        System.out.println("   Check If Value Exists ('" + valorBusca + "'): " + temValor);

        // 9. Get Entry Set View: exiba a visão em Set dos pares (entrySet).
        Set<Map.Entry<Integer, String>> entrySet = cores.entrySet();
        System.out.println("9. Get Entry Set View (entrySet): " + entrySet);

        // 10. Get Value by Key: recupere o valor associado a uma chave.
        Integer chaveGet = 2; // "Verde"
        String valor = cores.get(chaveGet);
        System.out.println("10. Get Value by Key (" + chaveGet + "): " + valor);

        // 11. Get Key Set: exiba o conjunto de chaves do mapa (keySet).
        Set<Integer> keySet = cores.keySet();
        System.out.println("11. Get Key Set (keySet): " + keySet);

        // 12. Get Values Collection: mostre a coleção de valores (values).
        Collection<String> values = cores.values();
        System.out.println("12. Get Values Collection (values): " + values);
    }
}