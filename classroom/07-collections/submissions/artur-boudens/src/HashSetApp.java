import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {

        System.out.println("\n1. Adicionar Elemento");
        HashSet<String> cores = new HashSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Verde");
        System.out.println(cores);

        System.out.println("\n2. Iterar Elementos");
        Iterator<String> it = cores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\n3. Obter Tamanho");
        System.out.println("Tamanho: " + cores.size());

        System.out.println("\n4. Limpar Conjunto");
        cores.clear();
        System.out.println("Conjunto vazio: " + cores);

        System.out.println("\n5. Verificar se Vazio");
        System.out.println("Está vazio? " + cores.isEmpty());

        cores.add("Amarelo");
        cores.add("Branco");

        System.out.println("\n6. Clonar Conjunto");
        HashSet<String> conjuntoClonado = (HashSet<String>) cores.clone();
        System.out.println("Clone: " + conjuntoClonado);

        System.out.println("\n7. Converter para Array");
        String[] arrayDeCores = new String[cores.size()];
        cores.toArray(arrayDeCores);
        System.out.print("Array: ");
        for (String cor : arrayDeCores) {
            System.out.print(cor + " ");
        }
        System.out.println();

        System.out.println("\n8. Converter para TreeSet");
        TreeSet<String> treeSetDeCores = new TreeSet<>(cores);
        System.out.println("TreeSet: " + treeSetDeCores);

        System.out.println("\n9. Elementos Menores que 7");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(10);
        numeros.add(3);
        
        Set<Integer> menoresQue7 = numeros.headSet(7);
        System.out.println("Números: " + numeros);
        System.out.println("Menores que 7: " + menoresQue7);

        System.out.println("\n10. Comparar Conjuntos");
        HashSet<String> cores2 = new HashSet<>();
        cores2.add("Branco");
        cores2.add("Amarelo");
        boolean saoIguais = cores.equals(cores2);
        System.out.println("Set 1: " + cores);
        System.out.println("Set 2: " + cores2);
        System.out.println("São iguais? " + saoIguais);

        System.out.println("\n11. Manter Elementos Comuns");
        cores.add("Verde");
        cores2.add("Azul");
        System.out.println("Set 1 (antes): " + cores);
        System.out.println("Set 2 (reter): " + cores2);
        cores.retainAll(cores2);
        System.out.println("Set 1 (depois): " + cores);

        System.out.println("\n12. Remover Todos");
        cores.clear();
        System.out.println("Conjunto vazio: " + cores);
    }
}