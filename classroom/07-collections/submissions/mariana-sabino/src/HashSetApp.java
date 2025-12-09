import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        System.out.println("1. Append Element to HashSet");
        HashSet<String> cores = new HashSet<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Rosa");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate HashSet elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println("3. Get HashSet size");
        System.out.println("Tamanho do conjunto: " + cores.size());
        System.out.println();

        System.out.println("4. Clear HashSet");
        HashSet<String> conjuntoParaLimpar = new HashSet<>(cores);
        conjuntoParaLimpar.clear();
        System.out.println("Conjunto após clear: " + conjuntoParaLimpar);
        System.out.println();

        System.out.println("5. Check if HashSet is empty");
        System.out.println("Conjunto original está vazio: " + cores.isEmpty());
        System.out.println("Conjunto limpo está vazio: " + conjuntoParaLimpar.isEmpty());
        System.out.println();

        System.out.println("6. Clone HashSet");
        @SuppressWarnings("unchecked")
        HashSet<String> coresClone = (HashSet<String>) cores.clone();
        System.out.println("Conjunto clonado: " + coresClone);
        System.out.println();

        System.out.println("7. Convert HashSet to array");
        String[] arrayDeCores = cores.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(arrayDeCores));
        System.out.println();

        System.out.println("8. Convert HashSet to treeSet");
        TreeSet<String> treeSetCores = new TreeSet<>(cores);
        System.out.println("TreeSet (ordenado): " + treeSetCores);
        System.out.println();

        System.out.println("9. Find elements less than 7");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(3);
        numeros.add(8);
        numeros.add(5);
        numeros.add(12);
        numeros.add(1);
        numeros.add(7);
        numeros.add(9);
        System.out.println("TreeSet original: " + numeros);
        TreeSet<Integer> menoresQue7 = new TreeSet<>(numeros.headSet(7));
        System.out.println("Elementos menores que 7: " + menoresQue7);
        System.out.println();

        System.out.println("10. Compare two HashSets");
        HashSet<String> conjunto1 = new HashSet<>(cores);
        HashSet<String> conjunto2 = new HashSet<>(cores);
        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);
        System.out.println("São iguais: " + conjunto1.equals(conjunto2));
        System.out.println();

        System.out.println("11. Retain common elements");
        HashSet<String> conjuntoA = new HashSet<>();
        conjuntoA.add("Verde");
        conjuntoA.add("Amarelo");
        conjuntoA.add("Azul");
        conjuntoA.add("Roxo");
        HashSet<String> conjuntoB = new HashSet<>();
        conjuntoB.add("Amarelo");
        conjuntoB.add("Azul");
        conjuntoB.add("Rosa");
        System.out.println("Conjunto A antes: " + conjuntoA);
        System.out.println("Conjunto B: " + conjuntoB);
        conjuntoA.retainAll(conjuntoB);
        System.out.println("Conjunto A após retainAll: " + conjuntoA);
        System.out.println();

        System.out.println("12. Remove all from HashSet");
        HashSet<String> conjuntoParaRemover = new HashSet<>(cores);
        HashSet<String> elementosRemover = new HashSet<>();
        elementosRemover.add("Verde");
        elementosRemover.add("Azul");
        System.out.println("Conjunto antes: " + conjuntoParaRemover);
        System.out.println("Elementos a remover: " + elementosRemover);
        conjuntoParaRemover.removeAll(elementosRemover);
        System.out.println("Conjunto após removeAll: " + conjuntoParaRemover);
        System.out.println();
    }
}