import java.util.Collection; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.Set; 
import static java.lang.System.out;


public class HashMapApp {
    public static void main(String[] args) {

        HashMap<Integer, String> mapaCores = new HashMap<>();

        //1. ___________________________________
        out.println("\n1.");

        mapaCores.put(1, "Vermelho");
        mapaCores.put(5, "Azul");
        mapaCores.put(3, "Verde");
        mapaCores.put(8, "Amarelo");
        
        out.println("HashMap: " + mapaCores);


        //2. ___________________________________
        out.println("\n2.");

        int quantidade = mapaCores.size();

        out.println("Quantidade de pares (tamanho): " + quantidade);


        //3. ___________________________________
        out.println("\n3.");

        HashMap<Integer, String> mapaCopia = new HashMap<>();

        mapaCopia.putAll(mapaCores);

        out.println("Novo mapa mapaCopia: " + mapaCopia);


        //4. ___________________________________
        out.println("\n4.");

        mapaCopia.clear();

        out.println("Mapa mapaCopia após clear: " + mapaCopia);


        //5. ___________________________________
        out.println("\n5.");
        
        out.println("O mapaCopia está vazio? " + mapaCopia.isEmpty());
        out.println("O mapaCores está vazio? " + mapaCores.isEmpty());


        //6. ___________________________________
        out.println("\n6.");

        HashMap<Integer, String> cloneMapa = (HashMap<Integer, String>) mapaCores.clone();

        out.println("Clone do mapa original: " + cloneMapa);


        //7. ___________________________________
        out.println("\n7.");

        boolean existeChave3 = mapaCores.containsKey(3); 
        boolean existeChave99 = mapaCores.containsKey(99); 

        out.println("Mapa contém a chave 3? " + existeChave3);
        out.println("Mapa contém a chave 99? " + existeChave99);


        //8. ___________________________________
        out.println("\n8.");

        boolean existeValorVerde = mapaCores.containsValue("Verde"); 
        boolean existeValorPreto = mapaCores.containsValue("Preto"); 

        out.println("Mapa contém o valor Verde? " + existeValorVerde);
        out.println("Mapa contém o valor Preto? " + existeValorPreto);


        //9. ___________________________________
        out.println("\n9.");

        Set<Map.Entry<Integer, String>> pares = mapaCores.entrySet();

        out.println("Visão em Set dos pares (entrySet): " + pares);


        //10. ___________________________________
        out.println("\n10.");

        String cor = mapaCores.get(5); 

        out.println("Valor associado a chave 5: " + cor);


        //11. ___________________________________
        out.println("\n11.");

        Set<Integer> chaves = mapaCores.keySet();

        out.println("Conjunto de chaves (keySet): " + chaves);


        //12. ___________________________________
        out.println("\n12.");

        Collection<String> valores = mapaCores.values();

        out.println("Coleção de valores (values): " + valores);

    }
}