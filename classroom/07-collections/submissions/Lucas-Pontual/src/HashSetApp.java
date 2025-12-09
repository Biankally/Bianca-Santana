import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {

        System.out.println("1. Append Element to HashSet");
        Set<String> cores = new HashSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate HashSet Elements");
        Iterator<String> it = cores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        System.out.println("3. Get HashSet Size");
        System.out.println("Tamanho: " + cores.size());
        System.out.println();

        System.out.println("4. Clear HashSet");
        Set<String> paraLimpar = new HashSet<>(cores);
        paraLimpar.clear();
        System.out.println("Conjunto após clear: " + paraLimpar);
        System.out.println();

        System.out.println("5. Check if HashSet is Empty");
        System.out.println("O conjunto 'cores' está vazio? " + cores.isEmpty());
        System.out.println("O conjunto 'paraLimpar' está vazio? " + paraLimpar.isEmpty());
        System.out.println();

        System.out.println("6. Clone HashSet");
        @SuppressWarnings("unchecked")
        HashSet<String> cloneCores = (HashSet<String>) ((HashSet<String>) cores).clone();
        System.out.println("Clone: " + cloneCores);
        System.out.println();

        System.out.println("7. Convert HashSet to Array");
        String[] arrayCores = cores.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(arrayCores));
        System.out.println();

        System.out.println("8. Convert HashSet to TreeSet");
        Set<String> treeSetCores = new TreeSet<>(cores);
        System.out.println("TreeSet: " + treeSetCores);
        System.out.println();

        System.out.println("9. Find Elements Less Than 7");
        TreeSet<Integer> numeros = new TreeSet<>(Set.of(1, 5, 10, 3, 8, 6, 2, 15));
        System.out.println("Elementos menores que 7: " + numeros.headSet(7));
        System.out.println();

        System.out.println("10. Compare Two HashSets");
        Set<String> set1 = new HashSet<>(Set.of("A", "B", "C"));
        Set<String> set2 = new HashSet<>(Set.of("C", "B", "A"));
        boolean saoIguais = set1.equals(set2);
        System.out.println(set1 + " é igual a " + set2 + "? " + saoIguais);
        System.out.println();

        System.out.println("11. Retain Common Elements");
        Set<String> setRetain = new HashSet<>(Set.of("Maçã", "Banana", "Pêra"));
        Set<String> outroSet = new HashSet<>(Set.of("Banana", "Laranja", "Maçã"));
        setRetain.retainAll(outroSet);
        System.out.println("Elementos comuns: " + setRetain);
        System.out.println();

        System.out.println("12. Remove All from HashSet");
        cores.removeAll(Set.of("Vermelho", "Azul"));
        System.out.println("Conjunto após remoção: " + cores);
        System.out.println();
    }
}
