import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.out;

public class HashSetApp {
        public static void main(String[] args) {
        //1. ___________________________________
        out.println("\n1.");

        HashSet<String> cores = new HashSet<>();

        out.println("Elementos adicionados ao conjunto");

        cores.add("azul");
        cores.add("verde");
        cores.add("amarelo");
        cores.add("vermelho");


        //2. ___________________________________
        out.println("\n2. ");

        out.println("Elementos do conjunto: " + cores);


        //3. ___________________________________
        out.println("\n3. ");

        out.println("Tamanho do conjunto: " + cores.size());


        //4. ___________________________________
        out.println("\n4.");

        cores.clear();

        out.println("Esvaziando o conjunto: " + cores);


        //5. ___________________________________
        out.println("\n5.");

        out.println("Checando se o conjunto está vazio: " + cores.isEmpty());


        //6. ___________________________________
        out.println("\n6.");

        cores.add("azul");
        cores.add("verde");
        cores.add("amarelo");
        cores.add("vermelho");
        out.println("Adicionei elementos ao conjunto novamente antes de clonar");

        HashSet<String> copia = (HashSet<String>) cores.clone();

        out.println("Mostrando o conjunto cores original: " + cores);
        out.println("Mostrando a copia: " + copia);


        //7. ___________________________________
        out.println("\n7.");

        String[] arrayDeCores = cores.toArray(new String[0]);

        out.println("Mostrando o array: " + Arrays.toString(arrayDeCores));


        //8. ___________________________________
        out.println("\n8.");

        TreeSet<String> treeSet = new TreeSet<>(cores);
        out.println("Mostrando o treeset: " + treeSet);


        //9. ___________________________________
        out.println("\n9.");

        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(10);
        numeros.add(5);
        numeros.add(1);
        numeros.add(8);
        numeros.add(3);

        out.println("TreeSet completo: " + numeros);

        Set<Integer> menoresQue7 = numeros.headSet(7);

        out.println("Elementos menores que 7: " + menoresQue7);


        //10. ___________________________________
        out.println("\n10.");

        HashSet<String> carros = new HashSet<>();
        carros.add("fusca");
        carros.add("honda wrv");
        carros.add("mustang");

        out.println("Mostrando o conjunto cores: " + cores);
        out.println("Criei o conjunto carros: " + carros);

        out.println("cores e carros são iguais? " + cores.equals(carros)); 


        //11. ___________________________________
        out.println("\n11.");

        out.println("Adicionei uma cor no elemtno carros so pra ter uma igual");

        carros.add("vermelho");

        out.println("Mostrando o conjunto carros: " + carros);
        out.println("Mostrando o conjunto cores: " + cores);

        carros.retainAll(cores);

        out.println("Conjunto carros depois  da interseção: " + carros);


        //12. ___________________________________
        out.println("\n12.");

        cores.removeAll(cores);

        out.println("Conjunto cores depois da remoçao: " + cores);



    }
}
