package submissions.nome-sobrenome.src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        Set<String> cores = new HashSet<>();

        System.out.println("1. Append Element to HashSet");
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Verde");
        System.out.println(cores);

        System.out.println("\n2. Iterate HashSet Elements");
        for (String cor : cores) {
            System.out.print(cor + " ");
        }
        System.out.println();

        System.out.println("\n3. Get HashSet Size");
        System.out.println("Tamanho: " + cores.size());

        System.out.println("\n6. Clone HashSet");
        @SuppressWarnings("unchecked")
        HashSet<String> coresClonadas = (HashSet<String>) ((HashSet<String>) cores).clone();
        System.out.println(coresClonadas);

        System.out.println("\n7. Convert HashSet to Array");
        String[] arrayCores = cores.toArray(new String[0]);
        System.out.println(Arrays.toString(arrayCores));

        System.out.println("\n8. Convert HashSet to TreeSet");
        Set<String> coresOrdenadas = new TreeSet<>(cores);
        System.out.println(coresOrdenadas);

        System.out.println("\n9. Find Elements Less Than 7");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(10);
        numeros.add(5);
        numeros.add(8);
        numeros.add(3);
        System.out.println("Subconjunto menor que 7: " + numeros.headSet(7));

        System.out.println("\n10. Compare Two HashSets");
        Set<String> outroConjunto = new HashSet<>();
        outroConjunto.add("Amarelo");
        outroConjunto.add("Verde");
        outroConjunto.add("Azul");
        outroConjunto.add("Branco");
        System.out.println("Cores vs OutroConjunto: " + cores.equals(outroConjunto));

        System.out.println("\n11. Retain Common Elements");
        Set<String> comum = new HashSet<>();
        comum.add("Verde");
        comum.add("Amarelo");
        comum.add("Roxo");
        cores.retainAll(comum);
        System.out.println("Elementos comuns retidos: " + cores);

        System.out.println("\n12. Remove All from HashSet");
        cores.removeAll(cores);
        System.out.println(cores);

        System.out.println("\n4. Clear HashSet");
        coresClonadas.clear();
        System.out.println("Conjunto clonado esvaziado: " + coresClonadas);

        System.out.println("\n5. Check if HashSet is Empty");
        System.out.println("Cores vazio: " + cores.isEmpty());
        System.out.println("CoresClonadas vazio: " + coresClonadas.isEmpty());
    }
}