import java.util.Comparator;
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetApp {

    public static void main(String[] args) {

        System.out.println("\n1. Criar e Imprimir TreeSet");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Verde");
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Amarelo");
        System.out.println("TreeSet: " + cores);

        System.out.println("\n2. Iterar Elementos");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n3. Adicionar a Outro TreeSet");
        TreeSet<String> maisCores = new TreeSet<>();
        maisCores.add("Branco");
        maisCores.add("Preto");
        
        cores.addAll(maisCores);
        System.out.println("Conjunto atualizado: " + cores);

        System.out.println("\n4. Ordem Reversa");
        System.out.println("Visão reversa: " + cores.descendingSet());
        
        Iterator<String> it = cores.descendingIterator();
        while(it.hasNext()) {
            System.out.println("- " + it.next());
        }

        System.out.println("\n5. Primeiro e Último Elemento");
        System.out.println("Primeiro: " + cores.first());
        System.out.println("Último: " + cores.last());

        System.out.println("\n6. Clonar Conjunto");
        TreeSet<String> conjuntoClonado = (TreeSet<String>) cores.clone();
        System.out.println("Clone: " + conjuntoClonado);

        System.out.println("\n7. Tamanho do Conjunto");
        System.out.println("Tamanho: " + cores.size());

        System.out.println("\n8. Comparar Conjuntos");
        TreeSet<String> coresComparacao = new TreeSet<>(cores);
        boolean saoIguais = cores.equals(coresComparacao);
        System.out.println("Set 1: " + cores);
        System.out.println("Set 2: " + coresComparacao);
        System.out.println("São iguais? " + saoIguais);

        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(10);
        numeros.add(5);
        numeros.add(1);
        numeros.add(20);
        numeros.add(7);
        System.out.println("\n--- Conjunto de Números: " + numeros + " ---");

        System.out.println("\n9. Elementos Menores que 7");
        System.out.println("Menores que 7: " + numeros.headSet(7));

        System.out.println("\n10. Elemento 'Ceiling' (teto)");
        System.out.println("Teto (>= 8): " + numeros.ceiling(8));

        System.out.println("\n11. Elemento 'Floor' (piso)");
        System.out.println("Piso (<= 6): " + numeros.floor(6));

        System.out.println("\n12. Elemento 'Higher' (maior)");
        System.out.println("Maior (> 7): " + numeros.higher(7));

        System.out.println("\n13. Elemento 'Lower' (menor)");
        System.out.println("Menor (< 7): " + numeros.lower(7));

        System.out.println("\n14. Remover Primeiro (pollFirst)");
        Integer primeiroNum = numeros.pollFirst();
        System.out.println("Removido (primeiro): " + primeiroNum);
        System.out.println("Conjunto: " + numeros);

        System.out.println("\n15. Remover Último (pollLast)");
        Integer ultimoNum = numeros.pollLast();
        System.out.println("Removido (último): " + ultimoNum);
        System.out.println("Conjunto: " + numeros);

        System.out.println("\n16. Remover Elemento");
        numeros.remove(7);
        System.out.println("Conjunto sem 7: " + numeros);
    }
}