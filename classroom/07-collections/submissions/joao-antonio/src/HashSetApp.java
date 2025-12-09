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

        cores.add("Azul");
        System.out.println("1. Append Element ('Azul'): " + cores);
        
        boolean addDuplicado = cores.add("Verde");
        System.out.println("Tentativa de adicionar duplicado ('Verde'): " + addDuplicado + ". Conjunto: " + cores);

        System.out.println("2. Iterate HashSet Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }

        int tamanho = cores.size();
        System.out.println("3. Get HashSet Size: " + tamanho);

        HashSet<String> tempParaLimpar = new HashSet<>(cores);
        tempParaLimpar.clear();
        System.out.println("4. Clear HashSet: " + tempParaLimpar);

        System.out.println("5. Check if 'cores' is Empty: " + cores.isEmpty());
        System.out.println("Check if 'tempParaLimpar' is Empty: " + tempParaLimpar.isEmpty());

        @SuppressWarnings("unchecked") 
        HashSet<String> clone = (HashSet<String>) cores.clone();
        System.out.println("6. Clone HashSet: " + clone);

        String[] arrayCores = new String[cores.size()];
        cores.toArray(arrayCores);
        System.out.println("7. Convert HashSet to Array: " + Arrays.toString(arrayCores));

        TreeSet<String> treeSetCores = new TreeSet<>(cores);
        System.out.println("8. Convert HashSet to TreeSet (ordenado): " + treeSetCores);

        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(2);
        numeros.add(10);
        System.out.println("9. Find Elements Less Than 7 (em " + numeros + "):");
        TreeSet<Integer> menoresQue7 = (TreeSet<Integer>) numeros.headSet(7);
        System.out.println("Elementos < 7: " + menoresQue7);

        boolean saoIguais = cores.equals(clone);
        System.out.println("10. Compare 'cores' vs 'clone': " + saoIguais);

        HashSet<String> diferente = new HashSet<>(cores);
        diferente.add("Amarelo");
        boolean saoDiferentes = cores.equals(diferente);
        System.out.println("Compare 'cores' vs 'diferente': " + saoDiferentes);

        HashSet<String> set1 = new HashSet<>(cores);
        set2.add("Verde");
        set2.add("Azul");
        set2.add("Amarelo");
        System.out.println("11. Retain Common Elements:");
        System.out.println("Set 1 (cópia): " + set1);
        System.out.println("Set 2 (novo): " + set2);
        set1.retainAll(set2);
        System.out.println("Resultado (Set 1.retainAll(Set 2)): " + set1);

        HashSet<String> setParaRemover = new HashSet<>(cores); 
        HashSet<String> elementosARemover = new HashSet<>();
        elementosARemover.add("Vermelho");
        elementosARemover.add("Preto"); 
        System.out.println("12. Remove All from HashSet (removeAll):");
        System.out.println("Set Original (cópia): " + setParaRemover);
        System.out.println("Elementos a remover: " + elementosARemover);
        setParaRemover.removeAll(elementosARemover);
        System.out.println("Resultado: " + setParaRemover);
    }
}