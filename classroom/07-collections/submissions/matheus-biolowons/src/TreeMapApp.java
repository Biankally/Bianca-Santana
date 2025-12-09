import java.util.TreeMap;
import java.util.Comparator;

import static java.lang.IO.println;

void main() {
    println("Associate Value with Key: associe um valor à chave correspondente no TreeMap.");
    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(3, "Azul");
    map.put(1, "Verde");
    map.put(2, "Amarelo");
    map.put(5, "Branco");
    map.put(10, "Preto");
    println(map);

    println("\nCopy TreeMap: copie todo o conteúdo para outro TreeMap e exiba o resultado.");
    TreeMap<Integer, String> map2 = new TreeMap<>();
    map2.putAll(map);
    println(map2);

    println("\nSearch Key: verifique se uma chave específica está presente no mapa.");
    println("Contém chave 2? " + map.containsKey(2));
    println("Contém chave 6? " + map.containsKey(6));

    println("\nSearch Value: verifique se um valor específico está presente no mapa.");
    println("Contém valor 'Verde'? " + map.containsValue("Verde"));
    println("Contém valor 'Laranja'? " + map.containsValue("Laranja"));

    println("\nGet All Keys: exiba todas as chaves do mapa.");
    println(map.keySet());

    println("\nClear TreeMap: remova todos os pares do mapa.");
    println("Antes: " + map2);
    map2.clear();
    println("Depois: \"Click\" + map2");

    println("\nSort Keys with Comparator: crie uma visão ordenada das chaves usando um Comparator personalizado (ordem reversa).");
    TreeMap<Integer, String> mapReverso = new TreeMap<>(Comparator.reverseOrder());
    mapReverso.putAll(map);
    println("Original: " + map);
    println("Reverso: " + mapReverso);

    println("\nGreatest and Least Mapping: mostre o par associado à maior chave e o par associado à menor chave.");
    println("Menor (First Entry): " + map.firstEntry());
    println("Maior (Last Entry): " + map.lastEntry());

    println("\nGet First and Last Key: informe a menor e a maior chave do mapa.");
    println("Menor Chave (First Key): " + map.firstKey());
    println("Maior Chave (Last Key): " + map.lastKey());

    println("\nReverse Key View: apresente as chaves em ordem reversa.");
    println("Visão do mapa reverso: " + map.descendingMap());
    println("Visão das chaves reversas: " + map.descendingKeySet());

    println("\nFloor Entry: recupere o par com a maior chave menor ou igual à chave informada (<= 4).");
    println(map.floorEntry(4)); // Chave 3

    println("\nFloor Key: recupere a maior chave menor ou igual à chave informada (<= 4).");
    println(map.floorKey(4)); // Chave 3

    println("\nHead Map (Exclusive): exiba o trecho do mapa cujas chaves são estritamente menores que a chave informada (< 3).");
    println(map.headMap(3)); // Chaves 1, 2

    println("\nHead Map (Inclusive Option): exiba o trecho do mapa com chaves menores ou iguais à chave informada (<= 3).");
    println(map.headMap(3, true)); // Chaves 1, 2, 3

    println("\nHigher Key: recupere a menor chave estritamente maior que a chave informada (> 3).");
    println(map.higherKey(3)); // Chave 5

    println("\nLower Entry: recupere o par com a maior chave estritamente menor que a chave informada (< 3).");
    println(map.lowerEntry(3)); // Chave 2

    println("\nLower Key: recupere a maior chave estritamente menor que a chave informada (< 3).");
    println(map.lowerKey(3)); // Chave 2

    println("\nNavigableSet View: exiba a visão NavigableSet das chaves.");
    println(map.navigableKeySet());

    println("\nPoll First Entry: remova e retorne o primeiro par do mapa.");
    TreeMap<Integer, String> mapTemp1 = new TreeMap<>(map);
    println("Antes: " + mapTemp1);
    println("Removido: " + mapTemp1.pollFirstEntry());
    println("Depois: " + mapTemp1);

    println("\nPoll Last Entry: remova e retorne o último par do mapa.");
    TreeMap<Integer, String> mapTemp2 = new TreeMap<>(map);
    println("Antes: " + mapTemp2);
    println("Removido: " + mapTemp2.pollLastEntry());
    println("Depois: " + mapTemp2);

    println("\nSubMap (Inclusive to Exclusive): exiba o trecho do mapa com chaves de um valor (inclusivo) até outro (exclusivo) [2, 10).");
    println(map.subMap(2, 10)); // Inclui 2, 3, 5. Exclui 10.

    println("\nSubMap (Range): exiba o trecho do mapa com chaves dentro do intervalo informado [2, 5].");
    println(map.subMap(2, true, 5, true)); // Inclui 2, 3, 5.

    println("\nTailMap (Inclusive): exiba o trecho do mapa com chaves maiores ou iguais à chave informada (>= 3).");
    println(map.tailMap(3)); // Inclui 3, 5, 10

    println("\nTailMap (Exclusive): exiba o trecho do mapa com chaves estritamente maiores que a chave informada (> 3).");
    println(map.tailMap(3, false)); // Inclui 5, 10

    println("\nCeiling Entry: recupere o par com a menor chave maior ou igual à chave informada (>= 4).");
    println(map.ceilingEntry(4)); // Chave 5

    println("\nCeiling Key: recupere a menor chave maior ou igual à chave informada (>= 4).");
    println(map.ceilingKey(4)); // Chave 5
}
