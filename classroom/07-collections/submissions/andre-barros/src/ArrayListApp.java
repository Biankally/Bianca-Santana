import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {

        System.out.println("\n1. Create and Print ArrayList ");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Roxo");
        cores.add("Marrom");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n2. Iterate ArrayList Elements ");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n3. Insert at First Position ");
        cores.add(0, "Vermelho");
        System.out.println(cores);

        System.out.println("\n4. Retrieve Element by Index ");
        int indexToRetrieve = 2;
        if (indexToRetrieve >= 0 && indexToRetrieve < cores.size()) {
            String elemento = cores.get(indexToRetrieve);
            System.out.println("Elemento no indice " + indexToRetrieve + ": " + elemento);
        } else {
            System.out.println("indice " + indexToRetrieve + "\ninvalido.");
        }

        System.out.println("\n5. Update ArrayList Element ");
        System.out.println("Lista antes da atualização: " + cores);
        cores.set(1, "Laranja");
        System.out.println("Elemento 'Roxo' foi substituído por 'Laranja'.");
        System.out.println("Lista após a atualização: " + cores);

        System.out.println("\n6. Remove Third Element ");
        int indexToRemove = 2;
        if (indexToRemove >= 0 && indexToRemove < cores.size()) {
            cores.remove(indexToRemove);
            System.out.println("Elemento no índice " + indexToRemove + "\nremovido.");
        } else {
             System.out.println("Não há elemento no índice " + indexToRemove + "\npara remover.");
        }
        System.out.println(cores);

        System.out.println("\n7. Search Element in ArrayList ");
        String elementoBusca = "Azul";
        boolean contem = cores.contains(elementoBusca);
        System.out.println("A lista contém o elemento '" + elementoBusca + "'? " + contem);

        System.out.println("\n8. Sort ArrayList ");
        Collections.sort(cores);
        System.out.println("Lista ordenada: " + cores);

        System.out.println("\n9. Copy ArrayList ");
        ArrayList<String> copiaCores = new ArrayList<>(cores);
        System.out.println("Lista original: " + cores);
        System.out.println("Lista copiada: " + copiaCores);

        System.out.println("\n10. Shuffle ArrayList ");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);

        System.out.println("\n11. Reverse ArrayList ");
        Collections.reverse(cores);
        System.out.println("Lista invertida: " + cores);

        System.out.println("\n12. Extract Sublist from ArrayList ");
        if (cores.size() >= 2) {
             List<String> sublista = cores.subList(0, 2);
             System.out.println("Sublista (índices 0 a 1): " + sublista);
        } else {
            System.out.println("Não é possível extrair sublista, tamanho insuficiente.");
        }

        System.out.println("\n13. Compare Two ArrayLists ");
        ArrayList<String> coresParaComparar1 = new ArrayList<>(cores);
        ArrayList<String> coresParaComparar2 = new ArrayList<>();
        coresParaComparar2.add("Preto");
        coresParaComparar2.add("Roxo");

        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + coresParaComparar1);
        System.out.println("Lista 3: " + coresParaComparar2);
        System.out.println("Lista 1 e Lista 2 são iguais? " + cores.equals(coresParaComparar1));
        System.out.println("Lista 1 e Lista 3 são iguais? " + cores.equals(coresParaComparar2));

        System.out.println("\n14. Swap ArrayList Elements ");
        System.out.println("Lista antes da troca: " + cores);
        if (cores.size() >= 3) {
            Collections.swap(cores, 0, 2);
            System.out.println("Trocando elementos nos índices 0 e 2.");
            System.out.println("Lista após a troca: " + cores);
        } else {
            System.out.println("Tamanho insuficiente para trocar elementos.");
        }

        System.out.println("\n15. Join Two ArrayLists ");
        ArrayList<String> novasCores = new ArrayList<>();
        novasCores.add("Cinza");
        novasCores.add("Magenta");
        
        ArrayList<String> uniao = new ArrayList<>(cores);
        uniao.addAll(novasCores);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + novasCores);
        System.out.println("União das listas: " + uniao);

        System.out.println("\n16. Clone ArrayList ");
        ArrayList<String> cloneCores = (ArrayList<String>) cores.clone();
        System.out.println("Lista original: " + cores);
        System.out.println("Clone da lista: " + cloneCores);

        System.out.println("\n17. Clear ArrayList ");
        System.out.println("Lista antes de limpar: " + cloneCores);
        cloneCores.clear();
        System.out.println("Lista após limpar: " + cloneCores);

        System.out.println("\n18. Check if ArrayList is Empty ");
        System.out.println("A lista 'cores' está vazia? " + cores.isEmpty());
        System.out.println("A lista 'cloneCores' está vazia? " + cloneCores.isEmpty());

        System.out.println("\n19. Trim ArrayList Capacity ");
        ArrayList<String> listaComCapacidade = new ArrayList<>(10);
        listaComCapacidade.add("A");
        listaComCapacidade.add("B");
        listaComCapacidade.trimToSize();
        System.out.println("A capacidade da lista foi ajustada ao seu tamanho atual.");
        System.out.println(listaComCapacidade);

        System.out.println("\n20. Increase ArrayList Capacity ");
        ArrayList<String> listaParaAumentar = new ArrayList<>();
        listaParaAumentar.ensureCapacity(20);
        System.out.println("A capacidade mínima da lista foi garantida para 20 elementos.");

        System.out.println("\n21. Replace Second Element ");
        System.out.println("Lista antes da substituição: " + cores);
        if (cores.size() >= 2) {
            cores.set(1, "Preto");
            System.out.println("Substituindo o segundo elemento por 'Preto'.");
            System.out.println("Lista após a substituição: " + cores);
        } else {
            System.out.println("A lista não possui um segundo elemento para substituir.");
        }

        System.out.println("\n22. Print Elements by Position ");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + "-> " + cores.get(i));
        }
    }
}