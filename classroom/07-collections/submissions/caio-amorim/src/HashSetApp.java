import java.util.HashSet;
import java.util.Set;

public class HashSetApp {
    public static void main(String[] args) {
        Set<String> cores = new HashSet<>();

        cores.add("Azul");
        cores.add("Verde");
        cores.add("Vermelho");
        cores.add("Amarelo");
        cores.add("Azul"); // duplicado, não será adicionado

        System.out.println("Conjunto de cores (HashSet): " + cores);

        cores.remove("Amarelo");

        System.out.println("Após remover Amarelo: " + cores);
        System.out.println("Contém Verde? " + cores.contains("Verde"));
    }
}
