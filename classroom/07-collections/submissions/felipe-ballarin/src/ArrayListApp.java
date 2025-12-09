import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import static java.lang.System.out;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> cores = new ArrayList<>();

        //1. ___________________________________
        out.println("\n1.");

        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");


        //2. ___________________________________
        out.println("\n2. ");

        for(int i=0; i<cores.size(); i++){
            out.println(cores.get(i));
        }


        //3. ___________________________________
        out.println("\n3. ");

        cores.add(0, "vermelho");


        //4. ___________________________________
        out.println("\n4.");

        if(cores.size()>2){
            out.print("Elemento de indice = 2: ");
            out.println(cores.get(2));
        }


        //5. ___________________________________
        out.println("\n5.");

        out.println("Substitui Verde por Roxo");
        cores.set(0, "Roxo");
        out.println("Nova posição 0: " + cores.get(0));


        //6. ___________________________________
        out.println("\n6.");

        if(cores.size()>2){
            out.println("Removi o elemento de indice 2: ");
            cores.remove(2);
        }


        //7. ___________________________________
        out.println("\n7.");

        out.print("Verifica se o elemento de Verde esta presente: ");
        out.println(cores.contains("Verde"));


        //8. ___________________________________
        out.println("\n8.");

        Collections.sort(cores);

        out.println("Lista em ordem alfabética:" + cores);


        //9. ___________________________________
        out.println("\n9.");

        ArrayList<String> cores2 = new ArrayList<>();
        cores2 = cores;

        out.println("Lista 2:" + cores2);


        //10. ___________________________________
        out.println("\n10.");

        Collections.shuffle(cores);

        out.println("Embaralhando a lista 1: " + cores);


        //11. ___________________________________
        out.println("\n11.");

        Collections.reverse(cores);

        out.println("Invertendo a lista:" + cores);


        //12. ___________________________________
        out.println("\n12.");

        ArrayList<String> sublista = new ArrayList<>(cores.subList(1, 3));

        out.println("Sublista de 1 a 3:" + sublista);


        //13. ___________________________________
        out.println("\n13.");

        out.println("Lista cores: " + cores);
        out.println("Lista cores2: " + cores2);
        out.println("Verifica se o arraylist cores e cores2 são iguais: " + cores.equals(cores2));
    

        //14. ___________________________________
        out.println("\n14.");

        out.println("Lista antes da troca: " + cores);
        Collections.swap(cores, 1, 3);
        out.println("Lista depois de trocar o índice 1 com o 3: " + cores);


        //15. ___________________________________
        out.println("\n15.");

        ArrayList<String> cores3 = new ArrayList<>(); 

        cores3.addAll(cores);
        cores3.addAll(cores2);

        out.println("Lista cores: " + cores);
        out.println("Lista cores2: " + cores2);

        out.println("Lista cores3 (cores + cores2): " + cores3);


        //16. ___________________________________
        out.println("\n16.");

        cores3 = (ArrayList<String>)cores.clone();
        out.println("Lista clone3 agora é um clone da lista cores: " + cores3);

        cores3.set(1, "Cinza");

        out.println("Lista cores: " + cores);
        out.println("Lista cores3: " + cores3);

        out.println("_____________________________________________\n");


        ArrayList<String> teste = new ArrayList<>();

        teste.add(new String("Felipe"));
        teste.add(new String("Fabricio"));

        ArrayList<String> teste2 = (ArrayList<String>)teste.clone();

        teste2.set(0, "Joao");

        out.println("Lista teste: " + teste);
        out.println("Lista teste2: " + teste2);


        //17. ___________________________________
        System.out.println("\n17.");

        cores2.clear();

        out.println("Limpando a lista cores2: " + cores2);


        //18. ___________________________________
        System.out.println("\n18.");

        out.println("verificando se a lista cores2 está vazia: " + cores2.isEmpty());


        //19. ___________________________________
        System.out.println("\n19.");

        cores.trimToSize();
        out.println("trimtosize na lista cores: " + cores);


        //20. ___________________________________
        System.out.println("\n20.");

        cores.ensureCapacity(8);
        out.println("ensurecapacity na lista cores: " + cores);


        //21. ___________________________________
        System.out.println("\n21.");

        cores2.add("Verde");
        cores2.add("Amarelo");
        cores2.add("Azul");
        cores2.add("Branco");

        cores.set(1, "Felipe");
        out.println("Modificando o elemento de índice 1 para 'Felipe': " + cores);


        //22. ___________________________________
        System.out.println("\n22.");

        out.println("Printando cores2: ");

        for (int i=0; i<cores2.size(); i++) {
            out.println(i + "->" + cores2.get(i));
        }

    }
}
