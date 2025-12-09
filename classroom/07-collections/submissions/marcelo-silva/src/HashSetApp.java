import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {

        HashSet<String> cores = new HashSet<>();

        System.out.println("--- Append Element to HashSet ---");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");
        System.out.println(cores);

        System.out.println("\n--- Iterate HashSet Elements ---");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n--- Get HashSet Size ---");
        System.out.println("Tamanho: " + cores.size());

        System.out.println("\n--- Clear HashSet ---");
        cores.clear();
        System.out.println(cores);

        System.out.println("\n--- Check if HashSet is Empty ---");
        System.out.println("Está vazio? " + cores.isEmpty());

        cores.add("Preto");
        cores.add("Branco");
        cores.add("Cinza");

        System.out.println("\n--- Clone HashSet ---");
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println("Clone: " + clone);

        System.out.println("\n--- Convert HashSet to Array ---");
        String[] arrayCores = new String[cores.size()];
        cores.toArray(arrayCores);
        System.out.println("Array: " + Arrays.toString(arrayCores));

        System.out.println("\n--- Convert HashSet to TreeSet ---");
        Set<String> treeSet = new TreeSet<>(cores);
        System.out.println("TreeSet (ordenado): " + treeSet);

        System.out.println("\n--- Find Elements Less Than 7 ---");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(10);
        numeros.add(3);
        System.out.println("Números: " + numeros);
        Set<Integer> menoresQue7 = numeros.headSet(7);
        System.out.println("Menores que 7: " + menoresQue7);

        System.out.println("\n--- Compare Two HashSets ---");
        System.out.println("Set original: " + cores);
        System.out.println("Clone: " + clone);
        boolean saoIguais = cores.equals(clone);
        System.out.println("São iguais? " + saoIguais);

        System.out.println("\n--- Retain Common Elements ---");
        HashSet<String> cores2 = new HashSet<>();
        cores2.add("Branco");
        cores2.add("Azul");
        cores2.add("Roxo");
        System.out.println("Set 1: " + cores);
        System.out.println("Set 2: " + cores2);
        cores.retainAll(cores2);
        System.out.println("Elementos comuns (em Set 1): " + cores);

        System.out.println("\n--- Remove All from HashSet ---");
        cores.clear();
        System.out.println(cores);
        System.out.println("Está vazio? " + cores.isEmpty());
    }
}