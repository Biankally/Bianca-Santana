import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {

        HashSet<String> cores = new HashSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Verde");

        System.out.println(" Conjunto Inicial ");
        System.out.println(cores);
        System.out.println();

        System.out.println(" 1-Append Element to HashSet ");
        cores.add("Amarelo");
        System.out.println("Após adicionar 'Amarelo': " + cores);
        System.out.println();

        System.out.println(" 2-Iterate HashSet Elements ");
        Iterator<String> iterator = cores.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        System.out.println(" 3-Get HashSet Size ");
        System.out.println("Quantidade de elementos: " + cores.size());
        System.out.println();

        HashSet<String> tempCoresParaLimpar = new HashSet<>(cores);
        System.out.println(" 4-Clear HashSet ");
        System.out.println("Conjunto antes de limpar: " + tempCoresParaLimpar);
        tempCoresParaLimpar.clear();
        System.out.println("Conjunto após limpar: " + tempCoresParaLimpar);
        System.out.println();
        
        System.out.println(" 5-Check if HashSet is Empty ");
        System.out.println("O conjunto 'cores' está vazio? " + cores.isEmpty());
        System.out.println("O conjunto 'tempCoresParaLimpar' está vazio? " + tempCoresParaLimpar.isEmpty());
        System.out.println();

        System.out.println(" 6-Clone HashSet ");
        HashSet<String> cloneCores = (HashSet<String>) cores.clone();
        System.out.println("Conjunto Original: " + cores);
        System.out.println("Clone do Conjunto: " + cloneCores);
        System.out.println();

        System.out.println(" 7-Convert HashSet to Array ");
        String[] arrayDeCores = new String[cores.size()];
        cores.toArray(arrayDeCores);
        System.out.println("Elementos do Array:");
        for(String cor : arrayDeCores) {
            System.out.println(cor);
        }
        System.out.println();
        
        System.out.println(" 8-Convert HashSet to TreeSet ");
        TreeSet<String> treeSetCores = new TreeSet<>(cores);
        System.out.println("TreeSet (elementos ordenados): " + treeSetCores);
        System.out.println();

        System.out.println(" 9-Find Elements Less Than 7 ");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(10);
        numeros.add(5);
        numeros.add(8);
        numeros.add(3);
        System.out.println("TreeSet de números: " + numeros);
        System.out.print("Elementos menores que 7: ");
        for(int num : numeros) {
            if (num < 7) {
                System.out.print(num + " ");
            }
        }
        System.out.println("\n");

        System.out.println(" 10-Compare Two HashSets ");
        HashSet<String> coresSet1 = new HashSet<>(Arrays.asList("Vermelho", "Verde", "Azul"));
        HashSet<String> coresSet2 = new HashSet<>(Arrays.asList("Verde", "Azul", "Vermelho"));
        HashSet<String> coresSet3 = new HashSet<>(Arrays.asList("Vermelho", "Verde", "Amarelo"));
        System.out.println("Set 1: " + coresSet1);
        System.out.println("Set 2: " + coresSet2);
        System.out.println("Set 3: " + coresSet3);
        System.out.println("Set 1 e Set 2 são iguais? " + coresSet1.equals(coresSet2));
        System.out.println("Set 1 e Set 3 são iguais? " + coresSet1.equals(coresSet3)); 
        System.out.println();

        System.out.println(" 11-Retain Common Elements ");
        HashSet<String> setPrincipal = new HashSet<>(Arrays.asList("Vermelho", "Verde", "Preto", "Branco"));
        HashSet<String> setSecundario = new HashSet<>(Arrays.asList("Verde", "Branco", "Amarelo"));
        System.out.println("Conjunto principal antes: " + setPrincipal);
        System.out.println("Conjunto a comparar: " + setSecundario);
        setPrincipal.retainAll(setSecundario);
        System.out.println("Conjunto principal depois de reter comuns: " + setPrincipal);
        System.out.println();
        
        System.out.println(" 12-Remove All from HashSet ");
        System.out.println("Conjunto 'cores' antes de remover tudo: " + cores);
        cores.clear();
        System.out.println("Conjunto 'cores' após remover tudo: " + cores);
        System.out.println("Está vazio? " + cores.isEmpty());
        System.out.println();
    }
}