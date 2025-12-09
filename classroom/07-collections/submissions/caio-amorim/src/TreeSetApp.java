import java.util.Set;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        Set<String> cores = new TreeSet<>();

        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");

        System.out.println("Conjunto ordenado de cores (TreeSet): " + cores);

        cores.remove("Verde");

        System.out.println("Após remover Verde: " + cores);
        System.out.println("Primeira cor: " + ((TreeSet<String>) cores).first());
        System.out.println("Última cor: " + ((TreeSet<String>) cores).last());
    }
}

