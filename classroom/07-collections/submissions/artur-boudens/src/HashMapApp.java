import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class HashMapApp {

    public static void main(String[] args) {

        System.out.println("\n1. Associar Chave e Valor");
        HashMap<Integer, String> mapaCores = new HashMap<>();
        mapaCores.put(1, "Vermelho");
        mapaCores.put(2, "Verde");
        mapaCores.put(3, "Azul");
        mapaCores.put(4, "Amarelo");
        System.out.println("Mapa: " + mapaCores);

        System.out.println("\n2. Contar Mapeamentos");
        System.out.println("Tamanho: " + mapaCores.size());

        System.out.println("\n3. Copiar Mapa");
        HashMap<Integer, String> outroMapa = new HashMap<>();
        outroMapa.putAll(mapaCores);
        System.out.println("Cópia: " + outroMapa);

        System.out.println("\n4. Remover Todos");
        mapaCores.clear();
        System.out.println("Mapa vazio: " + mapaCores);

        System.out.println("\n5. Verificar se Vazio");
        System.out.println("Está vazio? " + mapaCores.isEmpty());

        outroMapa.put(5, "Branco");
        
        System.out.println("\n6. Cópia Superficial (clone)");
        HashMap<Integer, String> mapaClonado = (HashMap<Integer, String>) outroMapa.clone();
        System.out.println("Clone: " + mapaClonado);

        System.out.println("\n7. Verificar se Chave Existe");
        boolean existeChave3 = outroMapa.containsKey(3);
        System.out.println("Contém chave 3? " + existeChave3);

        System.out.println("\n8. Verificar se Valor Existe");
        boolean existeValorVerde = outroMapa.containsValue("Verde");
        System.out.println("Contém valor 'Verde'? " + existeValorVerde);

        System.out.println("\n9. Obter Visão (entrySet)");
        Set<Map.Entry<Integer, String>> pares = outroMapa.entrySet();
        System.out.println("EntrySet: " + pares);
        System.out.println("Iterando:");
        for (Map.Entry<Integer, String> par : pares) {
            System.out.println(par.getKey() + " -> " + par.getValue());
        }

        System.out.println("\n10. Obter Valor por Chave");
        String valor = outroMapa.get(2);
        System.out.println("Valor da chave 2: " + valor);

        System.out.println("\n11. Obter Chaves (keySet)");
        Set<Integer> chaves = outroMapa.keySet();
        System.out.println("KeySet: " + chaves);

        System.out.println("\n12. Obter Valores (values)");
        Collection<String> valores = outroMapa.values();
        System.out.println("Valores: " + valores);
    }
}