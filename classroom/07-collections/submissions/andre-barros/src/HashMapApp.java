import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapApp {

    public static void main(String[] args) {

        System.out.println(" 1-Associate Key with Value ");
        HashMap<Integer, String> mapaCores = new HashMap<>();
        mapaCores.put(1, "Vermelho");
        mapaCores.put(2, "Verde");
        mapaCores.put(3, "Azul");
        mapaCores.put(4, "Branco");
        System.out.println("Mapa de cores: " + mapaCores);
        System.out.println();

        System.out.println(" 2-Count Key-Value Mappings ");
        System.out.println("Quantidade de pares chave-valor: " + mapaCores.size());
        System.out.println();

        System.out.println(" 3-Copy Mappings to Another Map ");
        HashMap<Integer, String> outroMapa = new HashMap<>();
        outroMapa.putAll(mapaCores);
        System.out.println("Conteúdo do novo mapa: " + outroMapa);
        System.out.println();

        System.out.println(" 4-Remove All Mappings ");
        System.out.println("Novo mapa antes de limpar: " + outroMapa);
        outroMapa.clear();
        System.out.println("Novo mapa após limpar: " + outroMapa);
        System.out.println();

        System.out.println(" 5-Check If Map is Empty ");
        System.out.println("O mapa 'mapaCores' está vazio? " + mapaCores.isEmpty());
        System.out.println("O mapa 'outroMapa' está vazio? " + outroMapa.isEmpty());
        System.out.println();

        System.out.println(" 6-Get Shallow Copy ");
        HashMap<Integer, String> cloneMapa = (HashMap<Integer, String>) mapaCores.clone();
        System.out.println("Mapa original: " + mapaCores);
        System.out.println("Cópia superficial (clone): " + cloneMapa);
        System.out.println();

        System.out.println(" 7-Check If Key Exists ");
        Integer chaveBusca = 3;
        System.out.println("O mapa contém a chave " + chaveBusca + "? " + mapaCores.containsKey(chaveBusca));
        chaveBusca = 5;
        System.out.println("O mapa contém a chave " + chaveBusca + "? " + mapaCores.containsKey(chaveBusca));
        System.out.println();

        System.out.println(" 8-Check If Value Exists ");
        String valorBusca = "Verde";
        System.out.println("O mapa contém o valor '" + valorBusca + "'? " + mapaCores.containsValue(valorBusca));
        valorBusca = "Preto";
        System.out.println("O mapa contém o valor '" + valorBusca + "'? " + mapaCores.containsValue(valorBusca));
        System.out.println();

        System.out.println(" 9-Get Entry Set View ");
        Set<Map.Entry<Integer, String>> entrySet = mapaCores.entrySet();
        System.out.println("Visão em Set dos pares (entrySet):");
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println(" 10-Get Value by Key ");
        Integer chave = 2;
        String valor = mapaCores.get(chave);
        System.out.println("O valor associado à chave " + chave + " é: " + valor);
        System.out.println();

        System.out.println(" 11-Get Key Set ");
        Set<Integer> chaves = mapaCores.keySet();
        System.out.println("Conjunto de chaves (keySet): " + chaves);
        System.out.println();

        System.out.println(" 12-Get Values Collection ");
        Collection<String> valores = mapaCores.values();
        System.out.println("Coleção de valores (values): " + valores);
        System.out.println();
    }
}