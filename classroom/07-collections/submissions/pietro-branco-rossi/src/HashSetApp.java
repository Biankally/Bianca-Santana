import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;


class HashSetApp {
    public static void main(String[] args) {
        HashSet<String> cores = new HashSet<>();

        System.out.println("--- Inicializando o conjunto ---");
        cores.add("Vermelho");
        cores.add("Verde");
        System.out.println("Conjunto inicial: " + cores);
        System.out.println("---------------------------------");

        // 1. Append Element to HashSet: adicione um elemento ao conjunto.
        cores.add("Azul");
        System.out.println("1. Append Element ('Azul'): " + cores);
        // Demonstrando que não se pode adicionar duplicatas
        boolean addDuplicado = cores.add("Verde");
        System.out.println("Tentativa de adicionar duplicado ('Verde'): " + addDuplicado + ". Conjunto: " + cores);

        // 2. Iterate HashSet Elements: percorra todos os elementos do conjunto.
        System.out.println("2. Iterate HashSet Elements:");
        for (String cor : cores) {
            System.out.println("   - " + cor);
        }

        // 3. Get HashSet Size: informe a quantidade de elementos.
        int tamanho = cores.size();
        System.out.println("3. Get HashSet Size: " + tamanho);

        // 4. Clear HashSet: esvazie completamente o conjunto.
        HashSet<String> tempParaLimpar = new HashSet<>(cores);
        tempParaLimpar.clear();
        System.out.println("4. Clear HashSet (em uma cópia): " + tempParaLimpar);

        // 5. Check if HashSet is Empty: verifique se o conjunto está vazio.
        System.out.println("5. Check if 'cores' is Empty: " + cores.isEmpty());
        System.out.println("Check if 'tempParaLimpar' is Empty: " + tempParaLimpar.isEmpty());

        // 6. Clone HashSet: gere uma cópia superficial do conjunto.
        @SuppressWarnings("unchecked") 
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println("6. Clone HashSet: " + clone);

        // 7. Convert HashSet to Array: converta o conjunto para um array.
        String[] arrayCores = new String[cores.size()];
        cores.toArray(arrayCores);
        System.out.println("7. Convert HashSet to Array: " + Arrays.toString(arrayCores));

        // 8. Convert HashSet to TreeSet: crie um TreeSet com os mesmos elementos.
        TreeSet<String> treeSetCores = new TreeSet<>(cores);
        System.out.println("8. Convert HashSet to TreeSet (ordenado): " + treeSetCores);

        // 9. Find Elements Less Than 7: (operação específica com TreeSet)
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(2);
        numeros.add(10);
        System.out.println("9. Find Elements Less Than 7 (em " + numeros + "):");
        // headSet(7) pega todos os elementos ANTES (menores) que 7
        TreeSet<Integer> menoresQue7 = (TreeSet<Integer>) numeros.headSet(7);
        System.out.println("   Elementos < 7: " + menoresQue7);

        // 10. Compare Two HashSets: verifique se dois conjuntos possuem os mesmos elementos.
        boolean saoIguais = cores.equals(clone);
        System.out.println("10. Compare 'cores' vs 'clone': " + saoIguais);

        HashSet<String> diferente = new HashSet<>(cores);
        diferente.add("Amarelo");
        boolean saoDiferentes = cores.equals(diferente);
        System.out.println("Compare 'cores' vs 'diferente': " + saoDiferentes);

        // 11. Retain Common Elements: mantenha apenas os elementos comuns a outro conjunto.
        HashSet<String> set1 = new HashSet<>(cores); // [Vermelho, Verde, Azul]
        HashSet<String> set2 = new HashSet<>();
        set2.add("Verde");
        set2.add("Azul");
        set2.add("Amarelo");
        System.out.println("11. Retain Common Elements:");
        System.out.println("Set 1 (cópia): " + set1);
        System.out.println("Set 2 (novo): " + set2);
        set1.retainAll(set2);
        System.out.println("Resultado (Set 1.retainAll(Set 2)): " + set1);

        // 12. Remove All from HashSet: remova todos os elementos de 'cores' que
        //     também existem em outra coleção (diferença de conjuntos).
        HashSet<String> setParaRemover = new HashSet<>(cores); // [Vermelho, Verde, Azul]
        HashSet<String> elementosARemover = new HashSet<>();
        elementosARemover.add("Vermelho");
        elementosARemover.add("Preto"); 
        System.out.println("12. Remove All from HashSet (removeAll):");
        System.out.println("    Set Original (cópia): " + setParaRemover);
        System.out.println("    Elementos a remover: " + elementosARemover);
        setParaRemover.removeAll(elementosARemover);
        System.out.println("    Resultado: " + setParaRemover);
    }
}