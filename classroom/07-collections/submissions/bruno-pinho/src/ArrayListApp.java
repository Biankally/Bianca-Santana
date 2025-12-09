import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {

    public static void main(String[] args) {

        // 1. Create and Print ArrayList
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("1. Create and Print ArrayList: " + cores);
        System.out.println("--------------------");

        // 2. Iterate ArrayList Elements
        System.out.println("2. Iterate ArrayList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println("--------------------");

        // 3. Insert at First Position
        cores.add(0, "Vermelho");
        System.out.println("3. Insert at First Position: " + cores);
        System.out.println("--------------------");

        // 4. Retrieve Element by Index
        int indexRetrieve = 2;
        if (indexRetrieve >= 0 && indexRetrieve < cores.size()) {
            String elemento = cores.get(indexRetrieve);
            System.out.println("4. Retrieve Element by Index (Index 2): " + elemento);
        } else {
            System.out.println("4. Retrieve Element by Index (Index 2): Índice inválido.");
        }
        System.out.println("--------------------");

        // 5. Update ArrayList Element
        String elementoAntigo = cores.set(1, "Laranja");
        System.out.println("5. Update ArrayList Element (Index 1): " + cores + " (Elemento substituído: " + elementoAntigo + ")");
        System.out.println("--------------------");

        // 6. Remove Third Element
        int indexRemove = 2;
        if (indexRemove >= 0 && indexRemove < cores.size()) {
            cores.remove(indexRemove);
            System.out.println("6. Remove Third Element (Index 2): " + cores);
        } else {
            System.out.println("6. Remove Third Element (Index 2): Índice inválido.");
        }
        System.out.println("--------------------");

        // 7. Search Element in ArrayList
        String search = "Azul";
        boolean encontrado = cores.contains(search);
        System.out.println("7. Search Element in ArrayList ('" + search + "'): " + encontrado);
        System.out.println("--------------------");

        // 8. Sort ArrayList
        Collections.sort(cores);
        System.out.println("8. Sort ArrayList: " + cores);
        System.out.println("--------------------");

        // 9. Copy ArrayList
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("9. Copy ArrayList: " + copia);
        System.out.println("--------------------");

        // 10. Shuffle ArrayList
        Collections.shuffle(cores);
        System.out.println("10. Shuffle ArrayList: " + cores);
        System.out.println("--------------------");

        // 11. Reverse ArrayList
        Collections.reverse(cores);
        System.out.println("11. Reverse ArrayList: " + cores);
        System.out.println("--------------------");

        // 12. Extract Sublist from ArrayList
        // Garantir que temos índices válidos (0 e 2)
        if (cores.size() >= 2) {
            List<String> sublista = cores.subList(0, 2);
            System.out.println("12. Extract Sublist from ArrayList (0-2): " + sublista);
        } else {
            System.out.println("12. Extract Sublist from ArrayList (0-2): Tamanho insuficiente para sublista.");
        }
        System.out.println("--------------------");

        // 13. Compare Two ArrayLists
        ArrayList<String> coresComparacao = new ArrayList<>(cores);
        boolean saoIguais = cores.equals(coresComparacao);
        System.out.println("13. Compare Two ArrayLists (com sua cópia): " + saoIguais);
        coresComparacao.add("Preto"); // Modificando a cópia
        saoIguais = cores.equals(coresComparacao);
        System.out.println("   Compare Two ArrayLists (com lista modificada): " + saoIguais);
        System.out.println("--------------------");

        // 14. Swap ArrayList Elements
        // Garantir que temos índices válidos (0 e 1)
        if (cores.size() >= 2) {
            Collections.swap(cores, 0, 1);
            System.out.println("14. Swap ArrayList Elements (Pos 0 e 1): " + cores);
        }
        System.out.println("--------------------");

        // 15. Join Two ArrayLists
        ArrayList<String> listaExtra = new ArrayList<>();
        listaExtra.add("Preto");
        listaExtra.add("Cinza");
        
        ArrayList<String> listaJuntada = new ArrayList<>(cores);
        listaJuntada.addAll(listaExtra);
        System.out.println("15. Join Two ArrayLists: " + listaJuntada);
        System.out.println("--------------------");

        // 16. Clone ArrayList
        ArrayList<String> listaClonada = (ArrayList<String>) cores.clone();
        System.out.println("16. Clone ArrayList: " + listaClonada);
        System.out.println("--------------------");

        // 17. Clear ArrayList
        cores.clear();
        System.out.println("17. Clear ArrayList: " + cores);
        System.out.println("--------------------");

        // 18. Check if ArrayList is Empty
        System.out.println("18. Check if ArrayList is Empty: " + cores.isEmpty());
        System.out.println("--------------------");

        // Repopulando a lista para os próximos testes
        cores.add("Roxo");
        cores.add("Marrom");
        cores.add("Ciano");
        System.out.println("... Repopulando a lista: " + cores);

        // 19. Trim ArrayList Capacity
        cores.trimToSize();
        System.out.println("19. Trim ArrayList Capacity: (Operação realizada)");
        System.out.println("--------------------");

        // 20. Increase ArrayList Capacity
        cores.ensureCapacity(10);
        System.out.println("20. Increase ArrayList Capacity (Min 10): (Operação realizada)");
        System.out.println("--------------------");

        // 21. Replace Second Element
        if (cores.size() >= 2) {
            cores.set(1, "Prata");
            System.out.println("21. Replace Second Element (Index 1): " + cores);
        }
        System.out.println("--------------------");

        // 22. Print Elements by Position
        System.out.println("22. Print Elements by Position:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
        System.out.println("--------------------");
    }
}