import java.util.HashMap;
import java.util.Map;

import static java.lang.IO.println;

void main() {
    println("Associate Key with Value: associe uma chave ao valor correspondente no HashMap.");
    HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "Verde");
    map.put(2, "Amarelo");
    map.put(3, "Azul");
    map.put(4, "Branco");
    println(map);

    println("\nCount Key-Value Mappings: informe a quantidade de pares chave-valor existentes.");
    println(map.size());

    println("\nCopy Mappings to Another Map: copie todas as associações para outro mapa e exiba o resultado.");
    HashMap<Integer, String> map2 = new HashMap<>();
    map2.putAll(map);
    println("Mapa original: " + map);
    println("Mapa copiado: " + map2);

    println("\nRemove All Mappings: remova todos os pares do mapa.");
    println("Antes: " + map2);
    map2.clear();
    println("Depois: " + map2);

    println("\nCheck If Map is Empty: verifique se o mapa está vazio.");
    println("map: " + map.isEmpty());
    println("map2: " + map2.isEmpty());

    println("\nGet Shallow Copy: gere uma cópia superficial do mapa e mostre seu conteúdo.");
    HashMap<Integer, String> clone = (HashMap<Integer, String>) map.clone();
    println("Original: " + map);
    println("Clone: " + clone);

    println("\nCheck If Key Exists: verifique se uma chave específica está presente.");
    println("Contém chave 2? " + map.containsKey(2));
    println("Contém chave 5? " + map.containsKey(5));

    println("\nCheck If Value Exists: verifique se um valor específico está presente.");
    println("Contém valor 'Azul'? " + map.containsValue("Azul"));
    println("Contém valor 'Preto'? " + map.containsValue("Preto"));

    println("\nGet Entry Set View: exiba a visão em Set dos pares (entrySet).");
    Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
    println(entrySet);
    // Iterando
    for (Map.Entry<Integer, String> entry : entrySet) {
        println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
    }

    println("\nGet Value by Key: recupere o valor associado a uma chave (chave 3).");
    println(map.get(3));

    println("\nGet Key Set: exiba o conjunto de chaves do mapa (keySet).");
    Set<Integer> keySet = map.keySet();
    println(keySet);

    println("\nGet Values Collection: mostre a coleção de valores (values).");
    var values = map.values();
    println(values);
}
