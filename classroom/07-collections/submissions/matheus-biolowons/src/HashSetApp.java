import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Arrays;

import static java.lang.IO.println;

void main() {
    println("Append Element to HashSet: adicione um elemento ao conjunto.");
    HashSet<String> set = new HashSet<>();
    set.add("Verde");
    set.add("Amarelo");
    set.add("Azul");
    set.add("Branco");
    set.add("Verde"); // Testando duplicata
    println(set);

    println("\nIterate HashSet Elements: percorra todos os elementos do conjunto.");
    for (String elemento : set) {
        println(elemento);
    }

    println("\nGet HashSet Size: informe a quantidade de elementos.");
    println(set.size());

    println("\nClear HashSet: esvazie completamente o conjunto.");
    HashSet<String> setParaLimpar = new HashSet<>(set);
    println("Antes: " + setParaLimpar);
    setParaLimpar.clear();
    println("Depois: " + setParaLimpar);

    println("\nCheck if HashSet is Empty: verifique se o conjunto está vazio.");
    println("set: " + set.isEmpty());
    println("setParaLimpar: " + setParaLimpar.isEmpty());

    println("\nClone HashSet: gere uma cópia superficial do conjunto e exiba o resultado.");
    HashSet<String> clone = (HashSet<String>) set.clone();
    println("Original: " + set);
    println("Clone: " + clone);

    println("\nConvert HashSet to Array: converta o conjunto para um array e exiba os elementos.");
    Object[] array = set.toArray();
    println(Arrays.toString(array));
    // Array tipado
    String[] arrayTipado = set.toArray(new String[0]);
    println(Arrays.toString(arrayTipado));

    println("\nConvert HashSet to TreeSet: crie um TreeSet com os mesmos elementos.");
    TreeSet<String> treeSet = new TreeSet<>(set);
    println("HashSet (sem ordem): " + set);
    println("TreeSet (ordenado): " + treeSet);

    println("\nFind Elements Less Than 7: dado um TreeSet de números, mostre os elementos menores que 7.");
    TreeSet<Integer> numSet = new TreeSet<>(Set.of(1, 5, 10, 2, 8, 3));
    println("Conjunto de números: " + numSet);
    // headSet(7) retorna elementos < 7 (exclusive)
    println("Elementos menores que 7: " + numSet.headSet(7));

    println("\nCompare Two HashSets: verifique se dois conjuntos possuem os mesmos elementos.");
    HashSet<String> set1 = new HashSet<>(Set.of("Verde", "Amarelo", "Azul", "Branco"));
    HashSet<String> set2 = new HashSet<>(Set.of("Amarelo", "Branco", "Verde", "Azul"));
    HashSet<String> set3 = new HashSet<>(Set.of("Verde", "Preto"));
    println("set1.equals(set2) (mesmos elementos): " + set1.equals(set2));
    println("set1.equals(set3) (elementos diferentes): " + set1.equals(set3));

    println("\nRetain Common Elements: mantenha no conjunto apenas os elementos comuns a outro conjunto.");
    HashSet<String> setRetain = new HashSet<>(set); // set é [Azul, Verde, Amarelo, Branco]
    println("Set original: " + setRetain);
    setRetain.retainAll(Set.of("Verde", "Preto", "Azul"));
    println("Set após retainAll: " + setRetain);

    println("\nRemove All from HashSet: remova todos os elementos do conjunto.");
    println("Set antes de clear: " + setRetain);
    setRetain.clear();
    println("Set após clear: " + setRetain);
}
