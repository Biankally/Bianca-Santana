import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static java.lang.IO.println;

void main() {
    println("\nCreate and Print ArrayList: construa uma lista de cores (ArrayList<String>), adicione pelo menos quatro elementos (\"Verde\", \"Amarelo\", \"Azul\", \"Branco\").");

    ArrayList<String> array = new ArrayList<>(List.of("Verde", "Amarelo"));
    array.add("Preto");
    Collections.addAll(array, "Azul", "Branco");

    println("\nIterate ArrayList Elements: percorra todos os elementos, imprimindo-os um por linha.");
    for (String s : array) {
        println(s);
    }

    println("\nInsert at First Position: insira um elemento na primeira posicao da lista (indice 0).");
    println("Utilizando a função array.addFirst/array.add(0, ...)");
    array.addFirst("addFirst/add");
    println(array);

    println("Utilizando a função array.set");
    array.set(0, "Set");
    println(array);

    println("Retrieve Element by Index: recupere o elemento de índice igual a 2 (valide o indice antes de acessar).");
    System.out.printf("Valor do índice 2: %s\n", array.get(2));

    println("\nUpdate ArrayList Element: substitua um item existente pelo novo valor informado e retorne o elemento atualizado.");
    System.out.printf("Valor Antigo: %s\n", array.get(4));
    array.set(4, "Updated");
    System.out.printf("Valor Atualizado: %s\n", array.get(4));

    println("\nRemove Third Element: remova o terceiro elemento (indice 2) caso exista.");
    println(array);
    array.remove(2);
    println(array);

    println("\nSearch Element in ArrayList: verifique se um elemento esta presente na lista e imprima true ou false.");
    println(array.contains("Preto"));

    println("\nSort ArrayList: ordene a lista em ordem alfabetica utilizando Collections.sort.");
    println(array);
    Collections.sort(array);
    println(array);

    println("\nCopy ArrayList: crie uma nova lista copiando todos os elementos da lista original.");
    ArrayList<String> copy = new ArrayList<>(array);
    println(copy);

    println("\nShuffle ArrayList: embaralhe os elementos da lista usando Collections.shuffle.");
    println(array);
    Collections.shuffle(array);
    println(array);

    println("\nReverse ArrayList: inverta a ordem dos elementos da lista com Collections.reverse.");
    println(array);
    Collections.reverse(array);
    println(array);

    println("\nExtract Sublist from ArrayList: retorne uma sublista (fromIndex: 1, toIndex: 4).");
    int fromIndex = 1;
    int toIndex = 4;
    List<String> sublist = array.subList(fromIndex, toIndex);
    println(array);
    println(sublist);

    println("\nCompare Two ArrayLists: compare duas listas e retorne true se elas possuirem os mesmos elementos (mesmo tamanho e mesma ordem).");
    println("array == sublist?");
    println(array.equals(sublist));

    println("\nSwap ArrayList Elements: troque os elementos de duas posicoes (0, 3) informadas da lista.");
    println(array);
    Collections.swap(array, 0, 3);
    println(array);

    println("\nJoin Two ArrayLists: crie uma nova lista que una todos os elementos de duas listas.");
    println(array);
    ArrayList<String> join = new ArrayList<>(array);
    join.addAll(copy);
    println(join);

    println("\nClone ArrayList: gere uma copia superficial (clone) da lista atual e exiba o resultado.");
    ArrayList<String> clone = (ArrayList<String>) array.clone();
    println(array);
    println(clone);

    println("\nClear ArrayList: esvazie completamente a lista.");
    println(array);
    array.clear();
    println(array);

    println("\nCheck if ArrayList is Empty: verifique se a lista está vazia.");
    println(array.isEmpty());

    println("\nTrim ArrayList Capacity: chame trimToSize para liberar memoria excedente de uma lista que nao sofrera novas insercoes.");
    array.trimToSize();

    println("\nIncrease ArrayList Capacity: garanta capacidade minima chamando ensureCapacity.");
    array.ensureCapacity(2);

    println("Replace Second Element: substitua o segundo elemento (indice 1) da lista por um novo valor.");
    array.add("Elemento A");
    array.add("Elemento B");
    println(array);
    array.set(1, "Elemento C");
    println(array);

    println("\nPrint Elements by Position: percorra a lista por indice e imprima cada posicao com seu respectivo valor (index -> element).");
    for (int index = 0; index < array.size(); index++) {
        System.out.printf("\n%d -> %s", index, array.get(index));
    }
}
