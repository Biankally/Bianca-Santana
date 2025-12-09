import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        System.out.println("1. Associate Value with Key");
        TreeMap<Integer, String> cores = new TreeMap<>();
        cores.put(5, "Verde");
        cores.put(2, "Amarelo");
        cores.put(8, "Azul");
        cores.put(1, "Branco");
        cores.put(10, "Rosa");
        cores.put(3, "Marrom");
        cores.put(7, "Roxo");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Copy TreeMap");
        TreeMap<Integer, String> mapaCopiado = new TreeMap<>(cores);
        System.out.println("Mapa copiado: " + mapaCopiado);
        System.out.println();

        System.out.println("3. Search key");
        int chaveBusca = 5;
        System.out.println("Contém chave " + chaveBusca + ": " + cores.containsKey(chaveBusca));
        System.out.println("Contém chave 15: " + cores.containsKey(15));
        System.out.println();

        System.out.println("4. Search value");
        String valorBusca = "Azul";
        System.out.println("Contém valor '" + valorBusca + "': " + cores.containsValue(valorBusca));
        System.out.println("Contém valor 'Preto': " + cores.containsValue("Preto"));
        System.out.println();

        System.out.println("5. Get all keys");
        System.out.println("Todas as chaves: " + cores.keySet());
        System.out.println();

        System.out.println("6. Clear TreeMap");
        TreeMap<Integer, String> mapaParaLimpar = new TreeMap<>(cores);
        mapaParaLimpar.clear();
        System.out.println("Mapa após clear: " + mapaParaLimpar);
        System.out.println();

        System.out.println("7. Sort keys with comparator");
        TreeMap<Integer, String> mapaOrdenado = new TreeMap<>(Comparator.reverseOrder());
        mapaOrdenado.putAll(cores);
        System.out.println("Mapa com chaves em ordem reversa: " + mapaOrdenado);
        System.out.println();

        System.out.println("8. Greatest and least mapping");
        Map.Entry<Integer, String> menorPar = cores.firstEntry();
        Map.Entry<Integer, String> maiorPar = cores.lastEntry();
        System.out.println("Menor par: " + menorPar.getKey() + " -> " + menorPar.getValue());
        System.out.println("Maior par: " + maiorPar.getKey() + " -> " + maiorPar.getValue());
        System.out.println();

        System.out.println("9. Get first and last key");
        System.out.println("Primeira chave: " + cores.firstKey());
        System.out.println("Última chave: " + cores.lastKey());
        System.out.println();

        System.out.println("10. Reverse key view");
        System.out.println("Chaves em ordem reversa: " + cores.descendingKeySet());
        System.out.println();

        System.out.println("11. Floor entry");
        int chaveFloorEntry = 6;
        Map.Entry<Integer, String> floorEntry = cores.floorEntry(chaveFloorEntry);
        System.out.println("Floor entry de " + chaveFloorEntry + ": " + floorEntry.getKey() + " -> " + floorEntry.getValue());
        System.out.println();

        System.out.println("12. Floor key");
        int chaveFloor = 6;
        Integer floorKey = cores.floorKey(chaveFloor);
        System.out.println("Floor key de " + chaveFloor + ": " + floorKey);
        System.out.println();

        System.out.println("13. Head Map (exclusive)");
        int chaveHead = 7;
        TreeMap<Integer, String> headMap = new TreeMap<>(cores.headMap(chaveHead));
        System.out.println("Head map (chaves < " + chaveHead + "): " + headMap);
        System.out.println();

        System.out.println("14. Head Map (inclusive option)");
        int chaveHeadInc = 7;
        TreeMap<Integer, String> headMapInc = new TreeMap<>(cores.headMap(chaveHeadInc, true));
        System.out.println("Head map (chaves <= " + chaveHeadInc + "): " + headMapInc);
        System.out.println();

        System.out.println("15. Higher key");
        int chaveHigher = 5;
        Integer higherKey = cores.higherKey(chaveHigher);
        System.out.println("Higher key de " + chaveHigher + ": " + higherKey);
        System.out.println();

        System.out.println("16. Lower entry");
        int chaveLowerEntry = 7;
        Map.Entry<Integer, String> lowerEntry = cores.lowerEntry(chaveLowerEntry);
        System.out.println("Lower entry de " + chaveLowerEntry + ": " + lowerEntry.getKey() + " -> " + lowerEntry.getValue());
        System.out.println();

        System.out.println("17. Lower key");
        int chaveLower = 7;
        Integer lowerKey = cores.lowerKey(chaveLower);
        System.out.println("Lower key de " + chaveLower + ": " + lowerKey);
        System.out.println();

        System.out.println("18. NavigableSet view");
        System.out.println("NavigableSet das chaves: " + cores.navigableKeySet());
        System.out.println();

        System.out.println("19. Poll first entry");
        TreeMap<Integer, String> mapaParaPollFirst = new TreeMap<>(cores);
        Map.Entry<Integer, String> primeiroRemovido = mapaParaPollFirst.pollFirstEntry();
        System.out.println("Primeiro par removido: " + primeiroRemovido.getKey() + " -> " + primeiroRemovido.getValue());
        System.out.println("Mapa após pollFirstEntry: " + mapaParaPollFirst);
        System.out.println();

        System.out.println("20. Poll last entry");
        TreeMap<Integer, String> mapaParaPollLast = new TreeMap<>(cores);
        Map.Entry<Integer, String> ultimoRemovido = mapaParaPollLast.pollLastEntry();
        System.out.println("Último par removido: " + ultimoRemovido.getKey() + " -> " + ultimoRemovido.getValue());
        System.out.println("Mapa após pollLastEntry: " + mapaParaPollLast);
        System.out.println();

        System.out.println("21. SubMap (inclusive to exclusive)");
        int chaveDe = 3;
        int chaveAte = 8;
        TreeMap<Integer, String> subMap = new TreeMap<>(cores.subMap(chaveDe, chaveAte));
        System.out.println("SubMap [" + chaveDe + ", " + chaveAte + "): " + subMap);
        System.out.println();

        System.out.println("22. SubMap (eange)");
        int chaveDeRange = 2;
        int chaveAteRange = 8;
        TreeMap<Integer, String> subMapRange = new TreeMap<>(cores.subMap(chaveDeRange, true, chaveAteRange, true));
        System.out.println("SubMap [" + chaveDeRange + ", " + chaveAteRange + "]: " + subMapRange);
        System.out.println();

        System.out.println("23. TailMap (inclusive)");
        int chaveTail = 5;
        TreeMap<Integer, String> tailMap = new TreeMap<>(cores.tailMap(chaveTail));
        System.out.println("TailMap (chaves >= " + chaveTail + "): " + tailMap);
        System.out.println();

        System.out.println("24. TailMap (exclusive)");
        int chaveTailExc = 5;
        TreeMap<Integer, String> tailMapExc = new TreeMap<>(cores.tailMap(chaveTailExc, false));
        System.out.println("TailMap (chaves > " + chaveTailExc + "): " + tailMapExc);
        System.out.println();

        System.out.println("25. Ceiling entry");
        int chaveCeilingEntry = 6;
        Map.Entry<Integer, String> ceilingEntry = cores.ceilingEntry(chaveCeilingEntry);
        System.out.println("Ceiling entry de " + chaveCeilingEntry + ": " + ceilingEntry.getKey() + " -> " + ceilingEntry.getValue());
        System.out.println();

        System.out.println("26. Ceiling key");
        int chaveCeiling = 6;
        Integer ceilingKey = cores.ceilingKey(chaveCeiling);
        System.out.println("Ceiling key de " + chaveCeiling + ": " + ceilingKey);
        System.out.println();
    }
}