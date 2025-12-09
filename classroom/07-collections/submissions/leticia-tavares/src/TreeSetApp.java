package submissions.nome-sobrenome.src;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        TreeSet<String> cores = new TreeSet<>();

        System.out.println("1. Create and Print TreeSet");
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n2. Iterate TreeSet Elements");
        for (String cor : cores) {
            System.out.print(cor + " ");
        }
        System.out.println();

        System.out.println("\n3. Add Elements to Another TreeSet");
        TreeSet<String> coresAdicionais = new TreeSet<>();
        coresAdicionais.add("Roxo");
        coresAdicionais.add("Preto");
        TreeSet<String> novoConjunto = new TreeSet<>(cores);
        novoConjunto.addAll(coresAdicionais);
        System.out.println(novoConjunto);

        System.out.println("\n4. Reverse Order TreeSet");
        System.out.println(cores.descendingSet());

        System.out.println("\n5. Get First and Last Elements");
        System.out.println("Primeiro: " + cores.first());
        System.out.println("Último: " + cores.last());

        System.out.println("\n6. Clone TreeSet");
        @SuppressWarnings("unchecked")
        TreeSet<String> coresClonadas = (TreeSet<String>) cores.clone();
        System.out.println(coresClonadas);

        System.out.println("\n7. TreeSet Size");
        System.out.println("Tamanho: " + cores.size());

        System.out.println("\n8. Compare TreeSets");
        TreeSet<String> outroConjunto = new TreeSet<>(cores);
        System.out.println("Cores vs OutroConjunto: " + cores.equals(outroConjunto));
        
        System.out.println("\n9. Elements Less Than 7");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(10);
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(3);
        System.out.println("Subconjunto menor que 7: " + numeros.headSet(7));
        
        System.out.println("\n10. Ceiling Element");
        System.out.println("Ceiling (5): " + numeros.ceiling(5));
        System.out.println("Ceiling (6): " + numeros.ceiling(6));

        System.out.println("\n11. Floor Element");
        System.out.println("Floor (5): " + numeros.floor(5));
        System.out.println("Floor (6): " + numeros.floor(6));

        System.out.println("\n12. Higher Element");
        System.out.println("Higher (5): " + numeros.higher(5));

        System.out.println("\n13. Lower Element");
        System.out.println("Lower (5): " + numeros.lower(5));

        System.out.println("\n14. Poll First Element");
        System.out.println("Removido: " + numeros.pollFirst());
        System.out.println(numeros);

        System.out.println("\n15. Poll Last Element");
        System.out.println("Removido: " + numeros.pollLast());
        System.out.println(numeros);

        System.out.println("\n16. Remove Element");
        cores.remove("Amarelo");
        System.out.println(cores);
    }
}