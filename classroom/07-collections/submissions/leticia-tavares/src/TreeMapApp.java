package submissions.nome_sobrenome.src;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer, String> cores = new TreeMap<>();

        System.out.println("1. Associate Value with Key");
        cores.put(3, "Azul");
        cores.put(1, "Verde");
        cores.put(4, "Branco");
        cores.put(2, "Amarelo");
        System.out.println(cores);

        System.out.println("\n2. Copy TreeMap");
        TreeMap<Integer, String> copiaCores = new TreeMap<>(cores);
        System.out.println(copiaCores);

        System.out.println("\n3. Search Key");
        int chaveBusca = 2;
        System.out.println("Contém chave " + chaveBusca + ": " + cores.containsKey(chaveBusca));

        System.out.println("\n4. Search Value");
        String valorBusca = "Verde";
        System.out.println("Contém valor '" + valorBusca + "': " + cores.containsValue(valorBusca));

        System.out.println("\n5. Get All Keys");
        System.out.println(cores.keySet());

        System.out.println("\n7. Sort Keys with Comparator");
        TreeMap<Integer, String> reverso = new TreeMap<>(Comparator.reverseOrder());
        reverso.putAll(cores);
        System.out.println("Chaves em ordem reversa: " + reverso.keySet());

        System.out.println("\n8. Greatest and Least Mapping");
        System.out.println("Menor: " + cores.firstEntry());
        System.out.println("Maior: " + cores.lastEntry());

        System.out.println("\n9. Get First and Last Key");
        System.out.println("Menor chave: " + cores.firstKey());
        System.out.println("Maior chave: " + cores.lastKey());

        System.out.println("\n10. Reverse Key View");
        System.out.println(cores.descendingKeySet());

        System.out.println("\n11. Floor Entry");
        System.out.println("Floor Entry (3): " + cores.floorEntry(3));

        System.out.println("\n12. Floor Key");
        System.out.println("Floor Key (3): " + cores.floorKey(3));

        System.out.println("\n13. Head Map (Exclusive)");
        System.out.println("Head Map (3, exclusivo): " + cores.headMap(3));

        System.out.println("\n14. Head Map (Inclusive Option)");
        System.out.println("Head Map (3, inclusivo): " + cores.headMap(3, true));

        System.out.println("\n15. Higher Key");
        System.out.println("Higher Key (2): " + cores.higherKey(2));

        System.out.println("\n16. Lower Entry");
        System.out.println("Lower Entry (2): " + cores.lowerEntry(2));

        System.out.println("\n17. Lower Key");
        System.out.println("Lower Key (2): " + cores.lowerKey(2));

        System.out.println("\n18. NavigableSet View");
        System.out.println(cores.navigableKeySet());

        System.out.println("\n19. Poll First Entry");
        System.out.println("Removido: " + cores.pollFirstEntry());
        System.out.println(cores);

        System.out.println("\n20. Poll Last Entry");
        System.out.println("Removido: " + cores.pollLastEntry());
        System.out.println(cores);

        System.out.println("\n21. SubMap (Inclusive to Exclusive)");
        cores.put(5, "Roxo");
        System.out.println("SubMap (1, inclusivo, até 4, exclusivo): " + cores.subMap(1, 4));

        System.out.println("\n22. SubMap (Range)");
        System.out.println("SubMap (1, inclusivo, até 4, inclusivo): " + cores.subMap(1, true, 4, true));

        System.out.println("\n23. TailMap (Inclusive)");
        System.out.println("TailMap (2, inclusivo): " + cores.tailMap(2));

        System.out.println("\n24. TailMap (Exclusive)");
        System.out.println("TailMap (2, exclusivo): " + cores.tailMap(2, false));

        System.out.println("\n25. Ceiling Entry");
        System.out.println("Ceiling Entry (2): " + cores.ceilingEntry(2));

        System.out.println("\n26. Ceiling Key");
        System.out.println("Ceiling Key (2): " + cores.ceilingKey(2));

        System.out.println("\n6. Clear TreeMap");
        copiaCores.clear();
        System.out.println("Cópia esvaziada: " + copiaCores);
    }
}