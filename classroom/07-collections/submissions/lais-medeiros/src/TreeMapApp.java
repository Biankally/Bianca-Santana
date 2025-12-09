import java.util.Collections;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        // Adicionando elementos ao mapa (chave e valor)
        System.out.println("Associate Value with Key:");
        map.put(1, "Vermelho");
        map.put(3, "Azul");
        map.put(5, "Verde");
        map.put(7, "Amarelo");
        map.put(9, "Roxo");
        System.out.println(map);

        // Copiar conteúdo para outro TreeMap
        System.out.println("Copy TreeMap:");
        TreeMap<Integer, String> copyMap = new TreeMap<>(map);
        System.out.println(copyMap);

        // Procurar uma chave
        System.out.println("Search Key:");
        System.out.println(map.containsKey(3));

        // Procurar um valor
        System.out.println("Search Value:");
        System.out.println(map.containsValue("Verde"));

        // Exibir todas as chaves
        System.out.println("Get All Keys:");
        System.out.println(map.keySet());

        // Limpar o mapa
        System.out.println("Clear TreeMap:");
        TreeMap<Integer, String> map2 = new TreeMap<>(map);
        map2.clear();
        System.out.println(map2);

        // Ordenação personalizada (decrescente)
        System.out.println("Sort Keys with Comparator:");
        TreeMap<Integer, String> reverseMap = new TreeMap<>(Collections.reverseOrder());
        reverseMap.putAll(map);
        System.out.println(reverseMap);

        // Menor e maior chave
        System.out.println("Greatest and Least Mapping:");
        System.out.println("Menor: " + map.firstEntry());
        System.out.println("Maior: " + map.lastEntry());

        // Pegar menor e maior chave
        System.out.println("Get First and Last Key:");
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        // Chaves em ordem reversa
        System.out.println("Reverse Key View:");
        System.out.println(map.descendingKeySet());

        // Floor Entry
        System.out.println("Floor Entry (<= valor informado):");
        System.out.println(map.floorEntry(6));

        // Floor Key
        System.out.println("Floor Key:");
        System.out.println(map.floorKey(6));

        // HeadMap exclusivo
        System.out.println("Head Map (Exclusive):");
        System.out.println(map.headMap(7));

        // HeadMap inclusivo
        System.out.println("Head Map (Inclusive):");
        System.out.println(map.headMap(7, true));

        // Higher Key
        System.out.println("Higher Key:");
        System.out.println(map.higherKey(5));

        // Lower Entry
        System.out.println("Lower Entry:");
        System.out.println(map.lowerEntry(5));

        // Lower Key
        System.out.println("Lower Key:");
        System.out.println(map.lowerKey(5));

        // Visão NavigableSet das chaves
        System.out.println("NavigableSet View:");
        System.out.println(map.navigableKeySet());

        // Remover e retornar primeiro par
        System.out.println("Poll First Entry:");
        System.out.println(map.pollFirstEntry());
        System.out.println(map);

        // Remover e retornar último par
        System.out.println("Poll Last Entry:");
        System.out.println(map.pollLastEntry());
        System.out.println(map);

        // SubMap entre intervalo (inclusivo ao exclusivo)
        System.out.println("SubMap (Inclusive to Exclusive):");
        System.out.println(map.subMap(3, 9));

        // SubMap por intervalo
        System.out.println("SubMap (Range):");
        System.out.println(map.subMap(3, true, 9, true));

        // TailMap inclusivo
        System.out.println("TailMap (Inclusive):");
        System.out.println(map.tailMap(5, true));

        // TailMap exclusivo
        System.out.println("TailMap (Exclusive):");
        System.out.println(map.tailMap(5, false));

        // Ceiling Entry
        System.out.println("Ceiling Entry (>= valor informado):");
        System.out.println(map.ceilingEntry(4));

        // Ceiling Key
        System.out.println("Ceiling Key:");
        System.out.println(map.ceilingKey(4));
    }
}