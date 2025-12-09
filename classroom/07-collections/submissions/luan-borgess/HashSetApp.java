import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class HashSetApp {

    public static void main(String[] args) {
        
        HashSet<String> cores = new HashSet<>();

        System.out.println("Append Element to HashSet:");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Verde");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Iterate HashSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("---");

        System.out.println("Get HashSet Size:");
        System.out.println("Tamanho: " + cores.size());
        System.out.println("---");

        System.out.println("Clear HashSet:");
        cores.clear();
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Check if HashSet is Empty:");
        System.out.println("Esta vazio? " + cores.isEmpty());
        System.out.println("---");
        
        cores.add("Amarelo");
        cores.add("Branco");

        System.out.println("Clone HashSet:");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println("Clone: " + clone);
        System.out.println("---");

        System.out.println("Convert HashSet to Array:");
        String[] arrayCores = cores.toArray(new String[0]);
        System.out.println(Arrays.toString(arrayCores));
        System.out.println("---");

        System.out.println("Convert HashSet to TreeSet:");
        TreeSet<String> treeSetCores = new TreeSet<>(cores);
        System.out.println(treeSetCores);
        System.out.println("---");

        System.out.println("Find Elements Less Than 7:");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(10);
        numeros.add(3);
        System.out.println("Numeros: " + numeros);
        System.out.println("Menores que 7: " + numeros.headSet(7));
        System.out.println("---");

        System.out.println("Compare Two HashSets:");
        HashSet<String> cores2 = new HashSet<>();
        cores2.add("Amarelo");
        cores2.add("Branco");
        System.out.println("Conjuntos sao iguais? " + cores.equals(cores2));
        cores2.add("Preto");
        System.out.println("Conjuntos sao iguais apos modificacao? " + cores.equals(cores2));
        System.out.println("---");

        System.out.println("Retain Common Elements:");
        HashSet<String> cores3 = new HashSet<>();
        cores3.add("Amarelo");
        cores3.add("Preto");
        
        HashSet<String> coresTemp = new HashSet<>(cores);
        coresTemp.retainAll(cores3);
        System.out.println("Elementos comuns (Amarelo, Preto) com (Amarelo, Branco): " + coresTemp);
        System.out.println("---");

        System.out.println("Remove All from HashSet:");
        cores.clear();
        System.out.println("Conjunto apos clear: " + cores);
        System.out.println("---");
    }
}