import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {

        System.out.println(" 1-Associate Value with Key ");
        TreeMap<Integer, String> mapaCores = new TreeMap<>();
        mapaCores.put(10, "Vermelho");
        mapaCores.put(50, "Verde");
        mapaCores.put(30, "Azul");
        mapaCores.put(20, "Branco");
        mapaCores.put(40, "Preto");
        System.out.println("TreeMap (chaves ordenadas): " + mapaCores);
        System.out.println();

        System.out.println(" 2-Copy TreeMap ");
        TreeMap<Integer, String> copiaMapa = new TreeMap<>();
        copiaMapa.putAll(mapaCores);
        System.out.println("Cópia do TreeMap: " + copiaMapa);
        System.out.println();

        System.out.println(" 3-Search Key ");
        System.out.println("O mapa contém a chave 30? " + mapaCores.containsKey(30));
        System.out.println("O mapa contém a chave 60? " + mapaCores.containsKey(60));
        System.out.println();

        System.out.println(" 4-Search Value ");
        System.out.println("O mapa contém o valor 'Azul'? " + mapaCores.containsValue("Azul"));
        System.out.println("O mapa contém o valor 'Amarelo'? " + mapaCores.containsValue("Amarelo"));
        System.out.println();

        System.out.println(" 5-Get All Keys ");
        System.out.println("Todas as chaves: " + mapaCores.keySet());
        System.out.println();

        System.out.println(" 6-Clear TreeMap ");
        System.out.println("Cópia antes de limpar: " + copiaMapa);
        copiaMapa.clear();
        System.out.println("Cópia após limpar: " + copiaMapa);
        System.out.println();

        System.out.println(" 7-Sort Keys with Comparator ");
        TreeMap<Integer, String> mapaReverso = new TreeMap<>(Comparator.reverseOrder());
        mapaReverso.putAll(mapaCores);
        System.out.println("Mapa com chaves em ordem reversa: " + mapaReverso);
        System.out.println();

        System.out.println(" 8-Greatest and Least Mapping ");
        System.out.println("Par com a menor chave: " + mapaCores.firstEntry());
        System.out.println("Par com a maior chave: " + mapaCores.lastEntry());
        System.out.println();

        System.out.println(" 9-Get First and Last Key ");
        System.out.println("Menor chave: " + mapaCores.firstKey());
        System.out.println("Maior chave: " + mapaCores.lastKey());
        System.out.println();

        System.out.println(" 10-Reverse Key View ");
        System.out.println("Visão das chaves em ordem reversa: " + mapaCores.descendingKeySet());
        System.out.println();

        System.out.println(" 11-Floor Entry ");
        System.out.println("Par com maior chave <= 35: " + mapaCores.floorEntry(35));
        System.out.println();

        System.out.println(" 12-Floor Key ");
        System.out.println("Maior chave <= 35: " + mapaCores.floorKey(35));
        System.out.println();

        System.out.println(" 13-Head Map (Exclusive) ");
        System.out.println("Mapa com chaves < 30: " + mapaCores.headMap(30));
        System.out.println();

        System.out.println(" 14-Head Map (Inclusive Option) ");
        System.out.println("Mapa com chaves <= 30: " + mapaCores.headMap(30, true));
        System.out.println();

        System.out.println(" 15-Higher Key ");
        System.out.println("Menor chave > 30: " + mapaCores.higherKey(30));
        System.out.println();

        System.out.println(" 16-Lower Entry ");
        System.out.println("Par com maior chave < 30: " + mapaCores.lowerEntry(30));
        System.out.println();

        System.out.println(" 17-Lower Key ");
        System.out.println("Maior chave < 30: " + mapaCores.lowerKey(30));
        System.out.println();

        System.out.println(" 18-NavigableSet View ");
        NavigableSet<Integer> navigableKeys = mapaCores.navigableKeySet();
        System.out.println("Visão NavigableSet das chaves: " + navigableKeys);
        System.out.println();

        System.out.println(" 19-Poll First Entry ");
        System.out.println("Mapa antes: " + mapaCores);
        Map.Entry<Integer, String> primeiroPar = mapaCores.pollFirstEntry();
        System.out.println("Par removido e retornado: " + primeiroPar);
        System.out.println("Mapa depois: " + mapaCores);
        System.out.println();

        System.out.println(" 20-Poll Last Entry ");
        System.out.println("Mapa antes: " + mapaCores);
        Map.Entry<Integer, String> ultimoPar = mapaCores.pollLastEntry();
        System.out.println("Par removido e retornado: " + ultimoPar);
        System.out.println("Mapa depois: " + mapaCores);
        System.out.println();
        mapaCores.put(10, "Vermelho");
        mapaCores.put(50, "Verde");

        System.out.println(" 21-SubMap (Inclusive to Exclusive) ");
        System.out.println("Submapa com chaves de 20 (inclusivo) a 40 (exclusivo): " + mapaCores.subMap(20, 40));
        System.out.println();

        System.out.println(" 22-SubMap (Range) ");
        System.out.println("Submapa com chaves de 20 (inclusivo) a 40 (inclusivo): " + mapaCores.subMap(20, true, 40, true));
        System.out.println();

        System.out.println(" 23-TailMap (Inclusive) ");
        System.out.println("Mapa com chaves >= 30: " + mapaCores.tailMap(30));
        System.out.println();
        
        System.out.println(" 24-TailMap (Exclusive) ");
        System.out.println("Mapa com chaves > 30: " + mapaCores.tailMap(30, false));
        System.out.println();

        System.out.println(" 25-Ceiling Entry ");
        System.out.println("Par com menor chave >= 25: " + mapaCores.ceilingEntry(25));
        System.out.println();

        System.out.println(" 26-Ceiling Key ");
        System.out.println("Menor chave >= 25: " + mapaCores.ceilingKey(25));
        System.out.println();
    }
}