import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set; 

class HashMapApp {
    public static void main(String[] args) {

        HashMap<Integer, String> cores = new HashMap<>();
        cores.put(1, "Vermelho");
        cores.put(2, "Verde");
        cores.put(3, "Azul");
        cores.put(4, "Amarelo");
        System.out.println("1. Associate Key with Value (put): " + cores);

        int tamanho = cores.size();
        System.out.println("2. Count Key-Value Mappings (size): " + tamanho);

        HashMap<Integer, String> mapaCopia = new HashMap<>();
        mapaCopia.put(10, "Preto"); 
        mapaCopia.putAll(cores);
        System.out.println("3. Copy Mappings to Another Map (putAll): " + mapaCopia);

        HashMap<Integer, String> tempParaLimpar = new HashMap<>(cores);
        tempParaLimpar.clear();
        System.out.println("4. Remove All Mappings (clear) (em uma cópia): " + tempParaLimpar);

        System.out.println("5. Check If 'cores' is Empty: " + cores.isEmpty());
        System.out.println("   Check If 'tempParaLimpar' is Empty: " + tempParaLimpar.isEmpty());

        @SuppressWarnings("unchecked") 
        HashMap<Integer, String> clone = (HashMap<Integer, String>) cores.clone();
        System.out.println("6. Get Shallow Copy (clone): " + clone);

        Integer chaveBusca = 3; 
        boolean temChave = cores.containsKey(chaveBusca);
        System.out.println("7. Check If Key Exists (" + chaveBusca + "): " + temChave);
        chaveBusca = 99;
        temChave = cores.containsKey(chaveBusca);
        System.out.println("   Check If Key Exists (" + chaveBusca + "): " + temChave);

        String valorBusca = "Verde";
        boolean temValor = cores.containsValue(valorBusca);
        System.out.println("8. Check If Value Exists ('" + valorBusca + "'): " + temValor);
        valorBusca = "Cinza";
        temValor = cores.containsValue(valorBusca);
        System.out.println("   Check If Value Exists ('" + valorBusca + "'): " + temValor);

        
        Set<Map.Entry<Integer, String>> entrySet = cores.entrySet();
        System.out.println("9. Get Entry Set View (entrySet): " + entrySet);

        Integer chaveGet = 2;
        String valor = cores.get(chaveGet);
        System.out.println("10. Get Value by Key (" + chaveGet + "): " + valor);

        Set<Integer> keySet = cores.keySet();
        System.out.println("11. Get Key Set (keySet): " + keySet);

        Collection<String> values = cores.values();
        System.out.println("12. Get Values Collection (values): " + values);
    }
}