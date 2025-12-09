import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        Map<Integer, String> cores = new HashMap<>();

        cores.put(1, "Azul");
        cores.put(2, "Verde");
        cores.put(3, "Vermelho");

        System.out.println("Mapa de cores (HashMap): " + cores);

        cores.remove(2);

        System.out.println("Após remover a chave 2: " + cores);
        System.out.println("Cor com chave 1: " + cores.get(1));
    }
}
