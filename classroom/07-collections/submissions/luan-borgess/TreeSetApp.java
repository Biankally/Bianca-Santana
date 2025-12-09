import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetApp {

    public static void main(String[] args) {

        System.out.println("Create and Print TreeSet:");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo");
        cores.add("Verde");
        System.out.println(cores);
        System.out.println("---");

        System.out.println("Iterate TreeSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("---");

        System.out.println("Add Elements to Another TreeSet:");
        TreeSet<String> cores2 = new TreeSet<>();
        cores2.add("Branco");
        cores2.addAll(cores);
        System.out.println(cores2);
        System.out.println("---");

        System.out.println("Reverse Order TreeSet:");
        System.out.println(cores.descendingSet());
        System.out.println("---");

        System.out.println("Get First and Last Elements:");
        System.out.println("Primeiro: " + cores.first());
        System.out.println("Ultimo: " + cores.last());
        System.out.println("---");

        System.out.println("Clone TreeSet:");
        TreeSet<String> clone = (TreeSet<String>) cores.clone();
        System.out.println("Clone: " + clone);
        System.out.println("---");

        System.out.println("TreeSet Size:");
        System.out.println("Tamanho: " + cores.size());
        System.out.println("---");

        System.out.println("Compare TreeSets:");
        TreeSet<String> cores3 = new TreeSet<>(cores);
        System.out.println("Conjuntos sao iguais? " + cores.equals(cores3));
        cores3.add("Preto");
        System.out.println("Conjuntos sao iguais apos modificacao? " + cores.equals(cores3));
        System.out.println("---");
        
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(5);
        numeros.add(8);
        numeros.add(10);
        System.out.println("Numeros: " + numeros);

        System.out.println("Elements Less Than 7:");
        System.out.println("Menores que 7: " + numeros.headSet(7));
        System.out.println("---");
        
        System.out.println("Ceiling Element:");
        System.out.println("Maior ou igual a 4: " + numeros.ceiling(4));
        System.out.println("---");

        System.out.println("Floor Element:");
        System.out.println("Menor ou igual a 4: " + numeros.floor(4));
        System.out.println("---");

        System.out.println("Higher Element:");
        System.out.println("Estritamente maior que 5: " + numeros.higher(5));
        System.out.println("---");

        System.out.println("Lower Element:");
        System.out.println("Estritamente menor que 3: " + numeros.lower(3));
        System.out.println("---");
        
        System.out.println("Poll First Element:");
        System.out.println("Numeros antes: " + numeros);
        System.out.println("Removido primeiro: " + numeros.pollFirst());
        System.out.println("Numeros depois: " + numeros);
        System.out.println("---");

        System.out.println("Poll Last Element:");
        System.out.println("Removido ultimo: " + numeros.pollLast());
        System.out.println("NumerosDepois: " + numeros);
        System.out.println("---");

        System.out.println("Remove Element:");
        System.out.println("Cores antes: " + cores);
        cores.remove("Azul");
        System.out.println("Cores depois: " + cores);
        System.out.println("---");
    }
}