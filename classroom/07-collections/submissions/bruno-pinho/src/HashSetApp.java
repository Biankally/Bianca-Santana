import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {
        HashSet<String> cores = new HashSet<>();

        // 1. Append Element to HashSet
        cores.add("Verde");
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Verde"); // Duplicata (será ignorada)
        System.out.println("1. Append Element to HashSet: " + cores);
        System.out.println("--------------------");

        // 2. Iterate HashSet Elements
        System.out.println("2. Iterate HashSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        // 3. Get HashSet Size
        System.out.println("3. Get HashSet Size: " + cores.size());
        System.out.println("--------------------");

        // 4. Clear HashSet
        cores.clear();
        System.out.println("4. Clear HashSet: " + cores);
        System.out.println("--------------------");

        // 5. Check if HashSet is Empty
        System.out.println("5. Check if HashSet is Empty: " + cores.isEmpty());
        System.out.println("--------------------");

        // Repopulando
        cores.add("Preto");
        cores.add("Branco");
        cores.add("Cinza");
        System.out.println("... Repopulando: " + cores);

        // 6. Clone HashSet
        HashSet<String> cloned = (HashSet<String>) cores.clone();
        System.out.println("6. Clone HashSet: " + cloned);
        System.out.println("--------------------");

        // 7. Convert HashSet to Array
        Object[] array = cores.toArray();
        System.out.println("7. Convert HashSet to Array: " + Arrays.toString(array));
        System.out.println("--------------------");

        // 8. Convert HashSet to TreeSet
        TreeSet<String> treeSet = new TreeSet<>(cores);
        System.out.println("8. Convert HashSet to TreeSet (ordenado): " + treeSet);
        System.out.println("--------------------");

        // 9. Find Elements Less Than 7 (em um TreeSet de números)
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(3);
        numeros.add(10);
        numeros.add(7);
        System.out.println("9. Find Elements Less Than 7 (Conjunto: " + numeros + ")");
        // headSet(7) retorna elementos < 7
        TreeSet<Integer> menoresQueSete = (TreeSet<Integer>) numeros.headSet(7);
        System.out.println("   Elementos < 7: " + menoresQueSete);
        System.out.println("--------------------");

        // 10. Compare Two HashSets
        HashSet<String> h2 = new HashSet<>(cores);
        System.out.println("10. Compare Two HashSets (com sua cópia): " + cores.equals(h2));
        System.out.println("--------------------");

        // 11. Retain Common Elements
        HashSet<String> h3 = new HashSet<>();
        h3.add("Branco");
        h3.add("Amarelo");
        h3.add("Preto");
        System.out.println("11. Retain Common Elements (Conjunto atual: " + cores + ")");
        System.out.println("   (Conjunto para reter: " + h3 + ")");
        cores.retainAll(h3);
        System.out.println("   Resultado: " + cores); // Deve sobrar "Preto" e "Branco"
        System.out.println("--------------------");

        // 12. Remove All from HashSet (Interpretado como clear())
        cores.clear();
        System.out.println("12. Remove All from HashSet (clear): " + cores);
        System.out.println("--------------------");
    }
}