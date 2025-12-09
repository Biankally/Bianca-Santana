import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

class TreeMapApp {
    public static void main(String[] args) {
        // 1. Associate Value with Key: associa um valor à chave.
        TreeMap<Integer, String> cores = new TreeMap<>();
        cores.put(3, "Azul");
        cores.put(1, "Vermelho");
        cores.put(10, "Amarelo");
        cores.put(5, "Verde");
        System.out.println("1. Associate Value with Key (put): " + cores);
        // Mapa ordenado: {1=Vermelho, 3=Azul, 5=Verde, 10=Amarelo}

        // 2. Copy TreeMap: copie todo o conteúdo para outro TreeMap.
        TreeMap<Integer, String> copia = new TreeMap<>(cores);
        System.out.println("2. Copy TreeMap (constructor): " + copia);

        // 3. Search Key: verifique se uma chave específica está presente.
        System.out.println("3. Search Key (5): " + cores.containsKey(5));
        System.out.println("   Search Key (99): " + cores.containsKey(99));

        // 4. Search Value: verifique se um valor específico está presente.
        System.out.println("4. Search Value ('Azul'): " + cores.containsValue("Azul"));
        System.out.println("   Search Value ('Preto'): " + cores.containsValue("Preto"));

        // 5. Get All Keys: exiba todas as chaves do mapa.
        Set<Integer> chaves = cores.keySet();
        System.out.println("5. Get All Keys (keySet): " + chaves);

        // 6. Clear TreeMap: remova todos os pares do mapa.
        copia.clear();
        System.out.println("6. Clear TreeMap (on 'copia'): " + copia);

        // 7. Sort Keys with Comparator: crie um TreeMap com um Comparator (ordem reversa).
        TreeMap<Integer, String> reverso = new TreeMap<>(Comparator.reverseOrder());
        reverso.putAll(cores);
        System.out.println("7. Sort Keys with Comparator (reverse): " + reverso);

        // 8. Greatest and Least Mapping: mostre o par com a maior e menor chave.
        System.out.println("8. Greatest (lastEntry) Mapping: " + cores.lastEntry());
        System.out.println("   Least (firstEntry) Mapping: " + cores.firstEntry());

        // 9. Get First and Last Key: informe a menor e a maior chave.
        System.out.println("9. Get First (firstKey): " + cores.firstKey() + " and Last (lastKey): " + cores.lastKey());

        // 10. Reverse Key View: apresente as chaves em ordem reversa.
        System.out.println("10. Reverse Key View (descendingMap): " + cores.descendingMap());

        // 11. Floor Entry: (maior chave <= chave informada)
        System.out.println("11. Floor Entry (key <= 4): " + cores.floorEntry(4)); 

        // 12. Floor Key: (maior chave <= chave informada)
        System.out.println("12. Floor Key (key <= 4): " + cores.floorKey(4)); 

        // 13. Head Map (Exclusive): (chaves < chave informada)
        System.out.println("13. Head Map (Exclusive) (key < 5): " + cores.headMap(5));

        // 14. Head Map (Inclusive Option): (chaves <= chave informada)
        System.out.println("14. Head Map (Inclusive Option) (key <= 5): " + cores.headMap(5, true)); 

        // 15. Higher Key: (menor chave > chave informada)
        System.out.println("15. Higher Key (key > 5): " + cores.higherKey(5)); 

        // 16. Lower Entry: (maior chave < chave informada)
        System.out.println("16. Lower Entry (key < 3): " + cores.lowerEntry(3));

        // 17. Lower Key: (maior chave < chave informada)
        System.out.println("17. Lower Key (key < 3): " + cores.lowerKey(3)); 

        // 18. NavigableSet View: exiba a visão NavigableSet das chaves.
        NavigableSet<Integer> nSet = cores.navigableKeySet();
        System.out.println("18. NavigableSet View (navigableKeySet): " + nSet);

        // 19. Poll First Entry: remova e retorne o primeiro par. (Operação destrutiva)
        Map.Entry<Integer, String> firstEntry = cores.pollFirstEntry();
        System.out.println("19. Poll First Entry (retornou: " + firstEntry + "). Mapa agora: " + cores);
        // Mapa agora: {3=Azul, 5=Verde, 10=Amarelo}

        // 20. Poll Last Entry: remova e retorne o último par. (Operação destrutiva)
        Map.Entry<Integer, String> lastEntry = cores.pollLastEntry();
        System.out.println("20. Poll Last Entry (retornou: " + lastEntry + "). Mapa agora: " + cores);
        // Mapa agora: {3=Azul, 5=Verde}

        cores.put(firstEntry.getKey(), firstEntry.getValue());
        cores.put(lastEntry.getKey(), lastEntry.getValue());
        System.out.println("    (Repopulando o mapa): " + cores); // {1=Vermelho, 3=Azul, 5=Verde, 10=Amarelo}

        // 21. SubMap (Inclusive to Exclusive): (fromKey <= key < toKey)
        System.out.println("21. SubMap (Inclusive to Exclusive) (3 <= key < 10): " + cores.subMap(3, 10));

        // 22. SubMap (Range): (fromKey <= key <= toKey)
        System.out.println("22. SubMap (Range) (3 <= key <= 10): " + cores.subMap(3, true, 10, true)); 

        // 23. TailMap (Inclusive): (chaves >= chave informada)
        System.out.println("23. TailMap (Inclusive) (key >= 5): " + cores.tailMap(5));

        // 24. TailMap (Exclusive): (chaves > chave informada)
        System.out.println("24. TailMap (Exclusive) (key > 5): " + cores.tailMap(5, false)); 

        // 25. Ceiling Entry: (menor chave >= chave informada)
        System.out.println("25. Ceiling Entry (key >= 4): " + cores.ceilingEntry(4)); 

        // 26. Ceiling Key: (menor chave >= chave informada)
        System.out.println("26. Ceiling Key (key >= 4): " + cores.ceilingKey(4)); 
    }
}