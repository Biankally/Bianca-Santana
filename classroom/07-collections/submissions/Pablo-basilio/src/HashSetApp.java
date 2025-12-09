import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {
        System.out.println("### Iniciando HashSetApp ###\n");

        Set<String> cores = new HashSet<>();

        System.out.println("[Operação 1]: Append Element to HashSet");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Verde");
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 2]: Iterate HashSet Elements");
        System.out.println("Resultado:");
        for (String cor : cores) {
            System.out.println("- " + cor);
        }

        System.out.println("\n[Operação 3]: Get HashSet Size");
        System.out.println("Resultado: " + cores.size());

        System.out.println("\n[Operação 4]: Clear HashSet");
        cores.clear();
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 5]: Check if HashSet is Empty");
        System.out.println("Resultado: " + cores.isEmpty());

        System.out.println("\n[Operação 6]: Clone HashSet");
        cores.add("Amarelo");
        cores.add("Laranja");
        HashSet<String> cloneSet = (HashSet<String>) ((HashSet<String>) cores).clone();
        System.out.println("Resultado: " + cloneSet);

        System.out.println("\n[Operação 7]: Convert HashSet to Array");
        String[] arrayCores = cores.toArray(new String[0]);
        System.out.println("Resultado: " + Arrays.toString(arrayCores));

        System.out.println("\n[Operação 8]: Convert HashSet to TreeSet (ordena)");
        Set<String> treeSetCores = new TreeSet<>(cores);
        System.out.println("Resultado: " + treeSetCores);

        System.out.println("\n[Operação 9]: Find Elements Less Than 7 (em TreeSet)");
        TreeSet<Integer> numeros = new TreeSet<>(Set.of(1, 5, 8, 3, 10, 6));
        System.out.println("Números originais: " + numeros);
        System.out.println("Resultado (< 7): " + numeros.headSet(7));

        System.out.println("\n[Operação 10]: Compare Two HashSets");
        Set<String> s2 = new HashSet<>(cores);
        System.out.println("Resultado: " + cores.equals(s2));

        System.out.println("\n[Operação 11]: Retain Common Elements (interseção)");
        Set<String> retainSet = new HashSet<>(Set.of("Laranja", "Preto", "Branco"));
        System.out.println("Set original: " + cores);
        System.out.println("Set para reter: " + retainSet);
        cores.retainAll(retainSet);
        System.out.println("Resultado: " + cores);

        System.out.println("\n[Operação 12]: Remove All from HashSet (diferença)");
        cores.add("Vermelho");
        cores.add("Verde");
        Set<String> removeSet = new HashSet<>(Set.of("Verde", "Azul"));
        System.out.println("Set original: " + cores);
        System.out.println("Set para remover: " + removeSet);
        cores.removeAll(removeSet);
        System.out.println("Resultado: " + cores);

        System.out.println("\n### HashSetApp Finalizado ###");
    }
}