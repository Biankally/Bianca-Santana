import java.util.TreeSet;
import java.util.Set;

import static java.lang.IO.println;

void main() {
    println("Create and Print TreeSet: crie um conjunto ordenado, adicione elementos e exiba o resultado.");
    TreeSet<String> set = new TreeSet<>(Set.of("Verde", "Amarelo", "Azul", "Branco"));
    set.add("Preto");
    println(set);

    println("\nIterate TreeSet Elements: percorra todos os elementos do TreeSet.");
    for (String elemento : set) {
        println(elemento);
    }

    println("\nAdd Elements to Another TreeSet: adicione todos os elementos em outro TreeSet e exiba o novo conjunto.");
    TreeSet<String> set2 = new TreeSet<>();
    set2.addAll(set);
    println(set2);

    println("\nReverse Order TreeSet: apresente a visão dos elementos em ordem reversa.");
    println("Ordem natural: " + set);
    println("Ordem reversa (view): " + set.descendingSet());

    println("\nGet First and Last Elements: informe o primeiro e o último elemento do conjunto.");
    println("Primeiro (menor): " + set.first());
    println("Último (maior): " + set.last());

    println("\nClone TreeSet: gere uma cópia do conjunto e exiba o resultado.");
    TreeSet<String> clone = (TreeSet<String>) set.clone();
    println("Original: " + set);
    println("Clone: " + clone);

    println("\nTreeSet Size: informe a quantidade de elementos no conjunto.");
    println(set.size());

    println("\nCompare TreeSets: compare dois conjuntos ordenados e indique se possuem os mesmos elementos.");
    println("set.equals(set2): " + set.equals(set2));
    set2.add("Laranja");
    println("set.equals(set2) (após modificar set2): " + set.equals(set2));

    println("\nElements Less Than 7: a partir de um TreeSet de números, mostre os elementos menores que 7.");
    TreeSet<Integer> numSet = new TreeSet<>(Set.of(1, 5, 10, 2, 8, 3, 7));
    println("Conjunto de números: " + numSet);
    println("Elementos menores que 7: " + numSet.headSet(7)); // exclusivo

    println("\nCeiling Element: recupere o elemento maior ou igual a um valor informado (>= 4).");
    println(numSet.ceiling(4)); // Retorna 5

    println("\nFloor Element: recupere o elemento menor ou igual a um valor informado (<= 4).");
    println(numSet.floor(4)); // Retorna 3

    println("\nHigher Element: recupere o elemento estritamente maior que um valor informado (> 5).");
    println(numSet.higher(5)); // Retorna 7

    println("\nLower Element: recupere o elemento estritamente menor que um valor informado (< 5).");
    println(numSet.lower(5)); // Retorna 3

    println("\nPoll First Element: remova e retorne o primeiro elemento do conjunto.");
    println("Conjunto antes: " + numSet);
    println("Elemento removido: " + numSet.pollFirst());
    println("Conjunto depois: " + numSet);

    println("\nPoll Last Element: remova e retorne o último elemento do conjunto.");
    println("Conjunto antes: " + numSet);
    println("Elemento removido: " + numSet.pollLast());
    println("Conjunto depois: " + numSet);

    println("\nRemove Element: remova um elemento específico do conjunto (elemento 5).");
    println("Conjunto antes: " + numSet);
    numSet.remove(5);
    println("Conjunto depois: " + numSet);
}
