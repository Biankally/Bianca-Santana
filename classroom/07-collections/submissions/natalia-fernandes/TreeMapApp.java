import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {
        System.out.println("### Iniciando TreeMapApp ###\n");

        TreeMap<Integer, String> mapaCores = new TreeMap<>();

        System.out.println("[Operação 1]: Associate Value with Key");
        mapaCores.put(10, "Vermelho");
        mapaCores.put(50, "Verde");
        mapaCores.put(30, "Azul");
        mapaCores.put(20, "Branco");
        mapaCores.put(40, "Amarelo");
        System.out.println("Resultado (ordenado por chave): " + mapaCores);

        System.out.println("\n[Operação 2]: Copy TreeMap");
        TreeMap<Integer, String> mapa2 = new TreeMap<>();
        mapa2.putAll(mapaCores);
        System.out.println("Resultado: " + mapa2);

        System.out.println("\n[Operação 3]: Search Key (chave 30)");
        System.out.println("Resultado: " + mapaCores.containsKey(30));

        System.out.println("\n[Operação 4]: Search Value ('Verde')");
        System.out.println("Resultado: " + mapaCores.containsValue("Verde"));

        System.out.println("\n[Operação 5]: Get All Keys");
        System.out.println("Resultado: " + mapaCores.keySet());

        System.out.println("\n[Operação 6]: Clear TreeMap");
        TreeMap<Integer, String> mapaParaLimpar = new TreeMap<>(mapaCores);
        mapaParaLimpar.clear();
        System.out.println("Resultado: " + mapaParaLimpar);

        System.out.println("\n[Operação 7]: Sort Keys with Comparator (ordem reversa)");
        Comparator<Integer> reverseComp = Collections.reverseOrder();
        Map<Integer, String> reverseMap = new TreeMap<>(reverseComp);
        reverseMap.putAll(mapaCores);
        System.out.println("Resultado: " + reverseMap);

        System.out.println("\n[Operação 8]: Greatest and Least Mapping");
        System.out.println("Menor (First Entry): " + mapaCores.firstEntry());
        System.out.println("Maior (Last Entry): " + mapaCores.lastEntry());

        System.out.println("\n[Operação 9]: Get First and Last Key");
        System.out.println("Menor (First Key): " + mapaCores.firstKey());
        System.out.println("Maior (Last Key): " + mapaCores.lastKey());

        System.out.println("\n[Operação 10]: Reverse Key View");
        System.out.println("Resultado: " + mapaCores.descendingKeySet());

        System.out.println("\n[Operação 11]: Floor Entry (maior chave <= 35)");
        System.out.println("Resultado: " + mapaCores.floorEntry(35));

        System.out.println("\n[Operação 12]: Floor Key (maior chave <= 20)");
        System.out.println("Resultado: " + mapaCores.floorKey(20));

        System.out.println("\n[Operação 13]: Head Map (Exclusive) (< 30)");
        System.out.println("Resultado: " + mapaCores.headMap(30));

        System.out.println("\n[Operação 14]: Head Map (Inclusive Option) (<= 30)");
        System.out.println("Resultado: " + mapaCores.headMap(30, true));

        System.out.println("\n[Operação 15]: Higher Key (> 30)");
        System.out.println("Resultado: " + mapaCores.higherKey(30));

        System.out.println("\n[Operação 16]: Lower Entry (< 20)");
        System.out.println("Resultado: " + mapaCores.lowerEntry(20));

        System.out.println("\n[Operação 17]: Lower Key (< 20)");
        System.out.println("Resultado: " + mapaCores.lowerKey(20));

        System.out.println("\n[Operação 18]: NavigableSet View (das chaves)");
        System.out.println("Resultado: " + mapaCores.navigableKeySet());

        System.out.println("\n[Operação 19]: Poll First Entry (remove e retorna)");
        Map.Entry<Integer, String> first = mapaCores.pollFirstEntry();
        System.out.println("Removido: " + first);
        System.out.println("Mapa restante: " + mapaCores);

        System.out.println("\n[Operação 20]: Poll Last Entry (remove e retorna)");
        Map.Entry<Integer, String> last = mapaCores.pollLastEntry();
        System.out.println("Removido: " + last);
        System.out.println("Mapa restante: " + mapaCores);

        System.out.println("\n[Operação 21]: SubMap (Inclusive to Exclusive) [20, 40)");
        System.out.println("Resultado: " + mapaCores.subMap(20, 40));

        System.out.println("\n[Operação 22]: SubMap (Range) [20, 40] (inclusivo)");
        System.out.println("Resultado: " + mapaCores.subMap(20, true, 40, true));

        System.out.println("\n[Operação 23]: TailMap (Inclusive) (>= 30)");
        System.out.println("Resultado: " + mapaCores.tailMap(30));

        System.out.println("\n[Operação 24]: TailMap (Exclusive) (> 30)");
        System.out.println("Resultado: " + mapaCores.tailMap(30, false));

        System.out.println("\n[Operação 25]: Ceiling Entry (menor chave >= 25)");
        System.out.println("Resultado: " + mapaCores.ceilingEntry(25));

        System.out.println("\n[Operação 26]: Ceiling Key (menor chave >= 30)");
        System.out.println("Resultado: " + mapaCores.ceilingKey(30));

        System.out.println("\n### TreeMapApp Finalizado ###");
    }
}