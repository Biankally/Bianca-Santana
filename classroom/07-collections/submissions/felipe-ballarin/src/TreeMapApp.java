import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import static java.lang.System.out;


public class TreeMapApp {
    public static void main(String[] args) {

        TreeMap<Integer, String> mapaCores = new TreeMap<>();

        //1. ___________________________________
        out.println("\n1.");
        
        mapaCores.put(10, "Vermelho");
        mapaCores.put(50, "Azul");
        mapaCores.put(30, "Verde");
        mapaCores.put(20, "Amarelo");
        mapaCores.put(40, "Roxo");
        
        out.println("TreeMap: " + mapaCores);


        //2. ___________________________________
        out.println("\n2.");

        TreeMap<Integer, String> mapaCopia = new TreeMap<>();
        mapaCopia.putAll(mapaCores);

        out.println("Mapa 'mapaCopia': " + mapaCopia);


        //3. ___________________________________
        out.println("\n3.");

        boolean existeChave30 = mapaCores.containsKey(30);
        boolean existeChave99 = mapaCores.containsKey(99);

        out.println("Mapa tem a chave 30? " + existeChave30);
        out.println("Mapa tem a chave 99? " + existeChave99);


        //4. ___________________________________
        out.println("\n4.");

        boolean existeValorVerde = mapaCores.containsValue("Verde");
        boolean existeValorPreto = mapaCores.containsValue("Preto");

        out.println("Mapa tem o valor Verde? " + existeValorVerde);
        out.println("Mapa tem o valor Preto? " + existeValorPreto);


        //5. ___________________________________
        out.println("\n5.");

        Set<Integer> chaves = mapaCores.keySet();
        out.println("Conjunto de chaves (keySet): " + chaves);


        //6. ___________________________________
        out.println("\n6.");
        
        mapaCopia.clear();
        out.println("Mapa 'mapaCopia' depois de clear(): " + mapaCopia);


        //7. ___________________________________
        out.println("\n7.");
        
        Comparator<Integer> comparadorReverso = Comparator.reverseOrder();

        TreeMap<Integer, String> mapaReverso = new TreeMap<>(comparadorReverso);

        mapaReverso.putAll(mapaCores);

        out.println("Mapa com chaves em ordem reversa (via Comparator): " + mapaReverso);


        //8. ___________________________________
        out.println("\n8.");
        
        Map.Entry<Integer, String> menorPar = mapaCores.firstEntry();
        Map.Entry<Integer, String> maiorPar = mapaCores.lastEntry();
        
        out.println("Menor par (firstEntry): " + menorPar);
        out.println("Maior par (lastEntry): " + maiorPar);


        //9. ___________________________________
        out.println("\n9.");

        Integer menorChave = mapaCores.firstKey();
        Integer maiorChave = mapaCores.lastKey();

        out.println("Menor chave (firstKey): " + menorChave);
        out.println("Maior chave (lastKey): " + maiorChave);


        //10. ___________________________________
        out.println("\n10.");

        Map<Integer, String> visaoReversa = mapaCores.descendingMap();

        out.println("Visao do mapa em ordem reversa (chaves): " + visaoReversa.keySet());


        //11. ___________________________________
        out.println("\n11.");
        
        Map.Entry<Integer, String> parPiso = mapaCores.floorEntry(35);

        out.println("Par com maior chave <= 35 (floorEntry(35)): " + parPiso);
        

        //12. ___________________________________
        out.println("\n12.");

        Integer chavePiso = mapaCores.floorKey(35);

        out.println("Maior chave <= 35 (floorKey(35)): " + chavePiso);


        //13. ___________________________________
        out.println("\n13.");
        
        Map<Integer, String> subMapaMenor = mapaCores.headMap(30);

        out.println("Mapa com chaves < 30 (headMap(30)): " + subMapaMenor);


        //14. ___________________________________
        out.println("\n14.");

        Map<Integer, String> subMapaMenorInc = mapaCores.headMap(30, true);

        out.println("Mapa com chaves <= 30 (headMap(30, true)): " + subMapaMenorInc);


        //15. ___________________________________
        out.println("\n15.");
        
        Integer chaveMaior = mapaCores.higherKey(30);

        out.println("Menor chave > 30 (higherKey(30)): " + chaveMaior);


        //16. ___________________________________
        out.println("\n16.");
        
        Map.Entry<Integer, String> parMenor = mapaCores.lowerEntry(30);

        out.println("Par com maior chave < 30 (lowerEntry(30)): " + parMenor);


        //17. ___________________________________
        out.println("\n17.");
        
        Integer chaveMenor = mapaCores.lowerKey(30);

        out.println("Maior chave < 30 (lowerKey(30)): " + chaveMenor);


        //18. ___________________________________
        out.println("\n18.");

        NavigableSet<Integer> chavesNavegaveis = mapaCores.navigableKeySet();

        out.println("Visão NavigableSet das chaves: " + chavesNavegaveis);


        //19. ___________________________________
        out.println("\n19.");

        TreeMap<Integer, String> mapaTemp1 = new TreeMap<>(mapaCores);
        Map.Entry<Integer, String> primeiroPar = mapaTemp1.pollFirstEntry();
        
        out.println("Primeiro par removido: " + primeiroPar);
        out.println("Mapa apos pollFirstEntry: " + mapaTemp1);


        //20. ___________________________________
        out.println("\n20.");

        TreeMap<Integer, String> mapaTemp2 = new TreeMap<>(mapaCores);
        Map.Entry<Integer, String> ultimoPar = mapaTemp2.pollLastEntry();
        
        out.println("Ultimo par removido: " + ultimoPar);
        out.println("Mapa apos pollLastEntry: " + mapaTemp2);


        //21. ___________________________________
        out.println("\n21.");
        
        Map<Integer, String> subMapa = mapaCores.subMap(20, 40);

        out.println("SubMapa de 20 (inc) até 40 (exc): " + subMapa);


        //22. ___________________________________
        out.println("\n22.");
        
        Map<Integer, String> subMapaInc = mapaCores.subMap(20, true, 40, true);

        out.println("SubMapa de 20 (inc) até 40 (inc): " + subMapaInc);


        //23. ___________________________________
        out.println("\n23.");
        
        Map<Integer, String> subMapaMaior = mapaCores.tailMap(30);

        out.println("Mapa com chaves >= 30 (tailMap(30)): " + subMapaMaior);


        //24. ___________________________________
        out.println("\n24.");

        Map<Integer, String> subMapaMaiorExc = mapaCores.tailMap(30, false);

        out.println("Mapa com chaves > 30 (tailMap(30, false)): " + subMapaMaiorExc);


        //25. ___________________________________
        out.println("\n25.");

        Map.Entry<Integer, String> parTeto = mapaCores.ceilingEntry(25);

        out.println("Par com menor chave >= 25 (ceilingEntry(25)): " + parTeto);
        

        //26. ___________________________________
        out.println("\n26.");

        Integer chaveTeto = mapaCores.ceilingKey(25);
        
        out.println("Menor chave >= 25 (ceilingKey(25)): " + chaveTeto);

    }
}