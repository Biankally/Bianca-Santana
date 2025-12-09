import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {

        System.out.println("\n1. Associar Chave e Valor");
        TreeMap<Integer, String> mapaOrdenado = new TreeMap<>();
        mapaOrdenado.put(10, "Vermelho");
        mapaOrdenado.put(5, "Verde");
        mapaOrdenado.put(20, "Azul");
        mapaOrdenado.put(1, "Amarelo");
        System.out.println("TreeMap: " + mapaOrdenado);

        System.out.println("\n2. Copiar Mapa");
        TreeMap<Integer, String> copiaMapa = new TreeMap<>();
        copiaMapa.putAll(mapaOrdenado);
        System.out.println("Cópia: " + copiaMapa);

        System.out.println("\n3. Buscar Chave");
        System.out.println("Contém chave 5? " + mapaOrdenado.containsKey(5));

        System.out.println("\n4. Buscar Valor");
        System.out.println("Contém valor 'Azul'? " + mapaOrdenado.containsValue("Azul"));

        System.out.println("\n5. Obter Todas as Chaves");
        Set<Integer> chaves = mapaOrdenado.keySet();
        System.out.println("Chaves: " + chaves);

        System.out.println("\n6. Limpar Mapa");
        mapaOrdenado.clear();
        System.out.println("Mapa vazio: " + mapaOrdenado);

        mapaOrdenado.put(10, "Vermelho");
        mapaOrdenado.put(5, "Verde");
        mapaOrdenado.put(20, "Azul");
        mapaOrdenado.put(1, "Amarelo");

        System.out.println("\n7. Ordenar com Comparator (Reverso)");
        TreeMap<Integer, String> mapaReverso = new TreeMap<>(Comparator.reverseOrder());
        mapaReverso.putAll(mapaOrdenado);
        System.out.println("Mapa reverso: " + mapaReverso);

        System.out.println("\n8. Menor e Maior Mapeamento");
        System.out.println("Menor: " + mapaOrdenado.firstEntry());
        System.out.println("Maior: " + mapaOrdenado.lastEntry());

        System.out.println("\n9. Menor e Maior Chave");
        System.out.println("Menor chave: " + mapaOrdenado.firstKey());
        System.out.println("Maior chave: " + mapaOrdenado.lastKey());

        System.out.println("\n10. Visão de Chaves Reversa");
        System.out.println("Chaves reversas: " + mapaOrdenado.descendingKeySet());

        System.out.println("\n11. Mapeamento 'Floor' (piso)");
        System.out.println("Piso (<= 6): " + mapaOrdenado.floorEntry(6));

        System.out.println("\n12. Chave 'Floor' (piso)");
        System.out.println("Piso (<= 6): " + mapaOrdenado.floorKey(6));

        System.out.println("\n13. 'Head Map' (Exclusivo)");
        System.out.println("Mapa (< 10): " + mapaOrdenado.headMap(10));

        System.out.println("\n14. 'Head Map' (Inclusivo)");
        System.out.println("Mapa (<= 10): " + mapaOrdenado.headMap(10, true));

        System.out.println("\n15. Chave 'Higher' (maior)");
        System.out.println("Maior (> 5): " + mapaOrdenado.higherKey(5));

        System.out.println("\n16. Mapeamento 'Lower' (menor)");
        System.out.println("Menor (< 10): " + mapaOrdenado.lowerEntry(10));

        System.out.println("\n17. Chave 'Lower' (menor)");
        System.out.println("Menor (< 10): " + mapaOrdenado.lowerKey(10));

        System.out.println("\n18. Visão 'NavigableSet'");
        NavigableSet<Integer> chavesNavegaveis = mapaOrdenado.navigableKeySet();
        System.out.println("Visão (chaves): " + chavesNavegaveis);

        System.out.println("\n19. Remover Primeiro (pollFirst)");
        Map.Entry<Integer, String> primeiroPar = mapaOrdenado.pollFirstEntry();
        System.out.println("Removido (primeiro): " + primeiroPar);
        System.out.println("Mapa: " + mapaOrdenado);

        System.out.println("\n20. Remover Último (pollLast)");
        Map.Entry<Integer, String> ultimoPar = mapaOrdenado.pollLastEntry();
        System.out.println("Removido (último): " + ultimoPar);
        System.out.println("Mapa: " + mapaOrdenado);

        mapaOrdenado.clear();
        mapaOrdenado.put(1, "Amarelo");
        mapaOrdenado.put(5, "Verde");
        mapaOrdenado.put(7, "Laranja");
        mapaOrdenado.put(10, "Vermelho");
        mapaOrdenado.put(20, "Azul");
        System.out.println("\nMapa restaurado: " + mapaOrdenado);

        System.out.println("\n21. 'SubMap' [Inclusivo, Exclusivo)");
        System.out.println("SubMapa [5, 10): " + mapaOrdenado.subMap(5, 10));

        System.out.println("\n22. 'SubMap' [Inclusivo, Inclusivo]");
        System.out.println("SubMapa [5, 10]: " + mapaOrdenado.subMap(5, true, 10, true));

        System.out.println("\n23. 'TailMap' (Inclusivo)");
        System.out.println("Mapa (>= 7): " + mapaOrdenado.tailMap(7));

        System.out.println("\n24. 'TailMap' (Exclusivo)");
        System.out.println("Mapa (> 7): " + mapaOrdenado.tailMap(7, false));

        System.out.println("\n25. Mapeamento 'Ceiling' (teto)");
        System.out.println("Teto (>= 6): " + mapaOrdenado.ceilingEntry(6));

        System.out.println("\n26. Chave 'Ceiling' (teto)");
        System.out.println("Teto (>= 6): " + mapaOrdenado.ceilingKey(6));
    }
}