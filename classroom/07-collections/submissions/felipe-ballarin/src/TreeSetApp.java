import java.util.ArrayList;
import java.util.TreeSet;
import static java.lang.System.out;


public class TreeSetApp {
    public static void main(String[] args) {

        //1. ___________________________________
        out.println("\n1.");

        TreeSet<String> cores = new TreeSet<>();
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Roxo");

        out.println("TreeSet em ordem alfabética: " + cores);


        //2. ___________________________________
        out.println("\n2. ");

        out.println("Iterarando os Elementos: ");
        for (String cor : cores) {
            out.println(cor);
        }


        //3. ___________________________________
        out.println("\n3. ");

        TreeSet<String> cores2 = new TreeSet<>();
        TreeSet<String> maisCores = new TreeSet<>();

        cores2.add("Preto");
        cores2.add("Branco");

        out.println("Novo TreeSet cores2: " + cores2);

        maisCores.addAll(cores);

        out.println("Novo conjunto 'maisCores'com tudo: " + maisCores);


        //4. ___________________________________
        out.println("\n4.");

        out.println("maisCores em ordem reversa: " + maisCores.descendingSet());


        //5. ___________________________________
        out.println("\n5.");

        out.println("Primeiro elemento: " + maisCores.first());
        out.println("Último elemento: " + maisCores.last()); 


        //6. ___________________________________
        out.println("\n6.");

        TreeSet<String> cloneCores = (TreeSet<String>) cores.clone();
        out.println("Clone: " + cloneCores);


        //7. ___________________________________
        out.println("\n7.");

        out.println("Quantidade de cores: " + cores.size()); 


        //8. ___________________________________
        out.println("\n8.");

        out.println("cores e cores2 são iguais? " + cores.equals(cores)); 


        //9. ___________________________________
        out.println("\n9.");

        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(12);
        numeros.add(4);
        numeros.add(5);
        numeros.add(46);

        out.println("Set original: " + numeros);
        out.println("numeros < 7: " + numeros.headSet(7));


        //10. ___________________________________
        out.println("\n10.");

        out.println("Elemento 'ceiling' maior ou igual a 10: " + numeros.ceiling(10));


        //11. ___________________________________
        out.println("\n11.");

        out.println("Elemento 'floor' menor ou igual a 10: " + numeros.floor(10));


        //12. ___________________________________
        out.println("\n12.");

        out.println("Elemento 'higher' estritamente maior que 5: " + numeros.higher(5));


        //13. ___________________________________
        out.println("\n13.");

        out.println("Elemento 'lower' estritamente menor que 5: " + numeros.lower(5));


        //14. ___________________________________
        out.println("\n14.");

        Integer primeiro = numeros.pollFirst();

        out.println("Elemento removido (primeiro): " + primeiro);
        out.println("treeSet numeros apos pollFirst: " + numeros);


        //15. ___________________________________
        out.println("\n15.");

        Integer ultimo = numeros.pollLast();

        out.println("Elemento removido (ultimo): " + ultimo);
        out.println("treeSet apos pollLast: " + numeros);


        //16. ___________________________________
        out.println("\n16.");

        boolean removeu = numeros.remove(12);

        out.println("Removeu o 12? " + removeu);
        out.println("Set numeros depois de remover: " + numeros);


    }
}
