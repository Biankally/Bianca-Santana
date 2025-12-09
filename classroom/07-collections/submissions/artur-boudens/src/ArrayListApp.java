import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {

    public static void main(String[] args) {

        System.out.println("\n1. Criar e Imprimir ArrayList");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("\n2. Iterar Elementos");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("\n3. Inserir na Primeira Posição");
        cores.add(0, "Vermelho");
        System.out.println(cores);

        System.out.println("\n4. Recuperar por Índice");
        int index = 2;
        if (index >= 0 && index < cores.size()) {
            String cor = cores.get(index);
            System.out.println("Índice " + index + ": " + cor);
        } else {
            System.out.println("Índice inválido: " + index);
        }

        System.out.println("\n5. Atualizar Elemento");
        String corAntiga = cores.set(3, "Roxo");
        System.out.println("Substituído: " + corAntiga);
        System.out.println("Lista: " + cores);

        System.out.println("\n6. Remover Terceiro Elemento");
        int indexRemover = 2;
        if (indexRemover >= 0 && indexRemover < cores.size()) {
            String corRemovida = cores.remove(indexRemover);
            System.out.println("Removido: " + corRemovida);
        } else {
            System.out.println("Índice inválido: " + indexRemover);
        }
        System.out.println("Lista: " + cores);

        System.out.println("\n7. Buscar Elemento");
        String busca = "Vermelho";
        boolean contem = cores.contains(busca);
        System.out.println("Contém '" + busca + "'? " + contem);

        System.out.println("\n8. Ordenar Lista");
        Collections.sort(cores);
        System.out.println("Lista ordenada: " + cores);

        System.out.println("\n9. Copiar Lista");
        ArrayList<String> copiaCores = new ArrayList<>(cores);
        System.out.println("Cópia: " + copiaCores);

        System.out.println("\n10. Embaralhar Lista");
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);

        System.out.println("\n11. Inverter Lista");
        Collections.reverse(cores);
        System.out.println("Lista invertida: " + cores);

        System.out.println("\n12. Extrair Sub-lista");
        if (cores.size() >= 3) {
            List<String> subLista = cores.subList(1, 3);
            System.out.println("Sub-lista [1-3): " + subLista);
        } else {
            System.out.println("Elementos insuficientes.");
        }

        System.out.println("\n13. Comparar Listas");
        ArrayList<String> coresComparacao = new ArrayList<>(cores);
        boolean saoIguais = cores.equals(coresComparacao);
        System.out.println("Lista 1: " + cores);
        System.out.println("Lista 2: " + coresComparacao);
        System.out.println("São iguais? " + saoIguais);

        System.out.println("\n14. Trocar Elementos");
        if (cores.size() > 2) {
            Collections.swap(cores, 0, 2);
            System.out.println("Lista após troca: " + cores);
        }

        System.out.println("\n15. Unir Listas");
        ArrayList<String> novasCores = new ArrayList<>();
        novasCores.add("Preto");
        novasCores.add("Cinza");
        
        ArrayList<String> listaUnida = new ArrayList<>(cores);
        listaUnida.addAll(novasCores);
        System.out.println("Lista unida: " + listaUnida);

        System.out.println("\n16. Clonar Lista");
        ArrayList<String> listaClonada = (ArrayList<String>) cores.clone();
        System.out.println("Clone: " + listaClonada);

        System.out.println("\n17. Limpar Lista");
        cores.clear();
        System.out.println("Lista 'cores' vazia: " + cores);

        System.out.println("\n18. Verificar se Vazia");
        boolean estaVazia = cores.isEmpty();
        System.out.println("Está vazia? " + estaVazia);

        System.out.println("\n19. Otimizar Capacidade (trimToSize)");
        cores.add("Ciano");
        cores.add("Magenta");
        cores.ensureCapacity(50);
        cores.trimToSize();
        System.out.println("Capacidade otimizada.");
        System.out.println("Lista: " + cores);

        System.out.println("\n20. Aumentar Capacidade (ensureCapacity)");
        cores.ensureCapacity(100);
        System.out.println("Capacidade aumentada.");

        System.out.println("\n21. Substituir Segundo Elemento");
        if (cores.size() >= 2) {
            cores.set(1, "Laranja");
            System.out.println("Lista após substituição: " + cores);
        } else {
            System.out.println("Elemento não existe.");
        }

        System.out.println("\n22. Imprimir com Posições");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}