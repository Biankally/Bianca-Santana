import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> cores = new LinkedList<>();
        LinkedList<String> cores2 = new LinkedList<>(); // Necessária para a operação 17
        cores2.add("Dourado");
        cores2.add("Prata");


        //1. ___________________________________
        out.println("\n1.");

        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");

        out.println("Lista após adicionar elementos: " + cores);


        //2. ___________________________________
        out.println("\n2.");

        out.println("Elementos da lista:");

        for(String cor : cores){
            out.println(cor);
        }

        
        //3. ___________________________________
        out.println("\n3.");

        out.println("Iterando a partir da Posição 1:");
        Iterator<String> iterator = cores.listIterator(1);

        while (iterator.hasNext()) {
            out.println(iterator.next());
        }


        //4. ___________________________________
        out.println("\n17.");

        out.println("Iterando na Ordem Inversa:");

        Iterator<String> reverseIterator = cores.descendingIterator();

        while (reverseIterator.hasNext()) {
            out.println(reverseIterator.next());
        }


        //5. ___________________________________
        out.println("\n5.");

        cores.add(2, "Roxo");
        out.println("Lista após inserir 'Roxo' na Posição 2: " + cores);


        //6. ___________________________________
        out.println("\n6.");

        cores.addFirst("Branco");
        cores.addLast("Preto");
        out.println("Lista após inserir 'Branco' no início e 'Preto' no fim: " + cores);


        //7. ___________________________________
        out.println("\n7.");

        cores.addFirst("Laranja");
        out.println("Lista após inserir 'Laranja' na Frente: " + cores);


        //8. ___________________________________
        out.println("\n8.");

        cores.addLast("Cinza");
        out.println("Lista após inserir 'Cinza' no Fim: " + cores);


        //9. ___________________________________
        out.println("\n9.");

        LinkedList<String> novosElementos = new LinkedList<>();
        novosElementos.add("Ouro");
        novosElementos.add("Prata");
        cores.addAll(1, novosElementos);
        out.println("\nLista após inserir múltiplos ('Ouro','Prata') na Posição 1: " + cores);


        //10. ___________________________________
        out.println("\n10.");

        cores.add("Verde"); // Garante duas ocorrências para teste
        out.println("\nPrimeira e Última Ocorrência de 'Verde':");
        out.println("Lista: " + cores);
        out.println("Primeira ocorrência de 'Verde' (Índice): " + cores.indexOf("Verde"));
        out.println("Última ocorrência de 'Verde' (Índice): " + cores.lastIndexOf("Verde"));


        //11. ___________________________________
        out.println("\n11.");

        out.println("\nElementos com Posições (índice -> elemento):");

        for (int i = 0; i < cores.size(); i++) {
            out.println(i + " -> " + cores.get(i));
        }


        //12. ___________________________________
        out.println("\n12.");

        cores.remove("Azul");
        out.println("\nLista após remover o elemento 'Azul': " + cores);


        //13. ___________________________________
        out.println("\n13.");

        out.println("\nRemovendo Primeiro e Último Elemento:");

        cores.removeFirst();
        cores.removeLast();

        out.println("Lista após remoção: " + cores);


        //14. ___________________________________
        out.println("\n14.");

        LinkedList<String> listaParaLimpar = new LinkedList<>(cores);
        listaParaLimpar.clear();
        out.println("\nLista 'listaParaLimpar' após limpar: " + listaParaLimpar);


        //15. ___________________________________
        out.println("\n15.");

        out.println("\nTrocando Elementos (Índice 1 e 3):");
        out.println("Lista antes da troca: " + cores);
        Collections.swap(cores, 1, 3);
        out.println("Lista depois da troca: " + cores);


        //16. ___________________________________
        out.println("\n16.");

        Collections.shuffle(cores);

        out.println("Lista após Embaralhar: " + cores);


        //17. ___________________________________        
        out.println("\n17.");

        out.println("Criando nova Lista Encadeada unindo 'cores' e 'cores2':");
        
        LinkedList<String> listalinked = new LinkedList<String>();

        listalinked.addAll(cores);
        listalinked.addAll(cores2);

        out.println("Nova LinkedList (Uniãao): " + listalinked);


        //18. ___________________________________        
        out.println("\n18.");
        
        LinkedList<String> listalinked_copia = new LinkedList<>(listalinked);

        out.println("Cópia da LinkedList: " + listalinked_copia);


        //19. ___________________________________
        out.println("\n19.");
        
        out.println("Elemento removido (Poll First): " + listalinked.pollFirst());
        out.println("LinkedList sem o primeiro elemento (poll): " + listalinked);


        //20. ___________________________________
        out.println("\n20.");

        out.println("Primeiro elemento (Peek First, sem remover): " + listalinked.peekFirst());


        //21. ___________________________________
        out.println("\n21.");

        out.println("Último elemento (Peek Last, sem remover): " + listalinked.peekLast());


        //22. ___________________________________
        out.println("\n22.");

        out.println("Verificando se 'Amarelo' está presente: " + listalinked.contains("Amarelo"));

        //23. ___________________________________
        out.println("\n23.");
        
        ArrayList<String> arrayListCores = new ArrayList<>(listalinked);
        out.println("ArrayList convertido: " + arrayListCores);


        //24. ___________________________________
        out.println("\n24. Comparando LinkedLists:");
        
        LinkedList<String> listaIgual = new LinkedList<>(listalinked);
        out.println("Lista 'listalinked' é igual à 'listaIgual'? " + listalinked.equals(listaIgual));


        //25. ___________________________________
        out.println("\n25.");

        out.println("A lista 'listalinked' está vazia? " + listalinked.isEmpty());


        //26. ___________________________________
        out.println("\n26.");

        out.println("LinkedList atual: " + listalinked);
        // Utilizando o índice 6 para seguir o exemplo, embora a lista possa ser menor após as operações
        if (listalinked.size() > 6) { 
            listalinked.set(6, "Fabricio");
            out.println("LinkedList modificando a posição 6 para 'Fabricio': " + listalinked);
        } else {
            out.println("Lista muito curta. Elemento de índice 0 substituído para 'Fabricio'.");
            listalinked.set(0, "Fabricio");
            out.println("LinkedList modificada: " + listalinked);
        }

    }
}