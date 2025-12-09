import java.util.TreeSet;

class TreeSetApp {
    public static void main(String[] args) {

        // 1. Create and Print TreeSet: crie um conjunto ordenado, adicione elementos e exiba.
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo"); 
        cores.add("Verde"); 
        System.out.println("1. Create and Print TreeSet (ordenado): " + cores);

        // 2. Iterate TreeSet Elements: percorra todos os elementos do TreeSet.
        System.out.println("2. Iterate TreeSet Elements:");
        for (String cor : cores) {
            System.out.println("   - " + cor);
        }

        // 3. Add Elements to Another TreeSet: adicione todos os elementos em outro TreeSet.
        TreeSet<String> cores2 = new TreeSet<>();
        cores2.add("Preto");
        cores2.add("Branco");
        cores2.addAll(cores);
        System.out.println("3. Add Elements to Another TreeSet ('cores2' + 'cores'): " + cores2);

        // 4. Reverse Order TreeSet: apresente a visão dos elementos em ordem reversa.
        System.out.println("4. Reverse Order TreeSet (view): " + cores.descendingSet());

        // 5. Get First and Last Elements: informe o primeiro e o último elemento.
        String primeiro = cores.first();
        String ultimo = cores.last();
        System.out.println("5. Get First ('" + primeiro + "') and Last ('" + ultimo + "') Elements: " + cores);

        // 6. Clone TreeSet: gere uma cópia do conjunto e exiba o resultado.
        @SuppressWarnings("unchecked") // Necessário por causa do .clone()
        TreeSet<String> clone = (TreeSet<String>) cores.clone();
        System.out.println("6. Clone TreeSet: " + clone);

        // 7. TreeSet Size: informe a quantidade de elementos no conjunto.
        int tamanho = cores.size();
        System.out.println("7. TreeSet Size: " + tamanho);

        // 8. Compare TreeSets: compare dois conjuntos ordenados.
        boolean saoIguais = cores.equals(clone);
        System.out.println("8. Compare 'cores' vs 'clone': " + saoIguais);
        // Comparando com 'cores2' (que é diferente)
        saoIguais = cores.equals(cores2);
        System.out.println("   Compare 'cores' vs 'cores2': " + saoIguais);


        // --- Criando um TreeSet de números para as próximas operações ---
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(5);
        numeros.add(1);
        numeros.add(10);
        numeros.add(7);
        numeros.add(2);
        numeros.add(15);
        System.out.println("--- Criado TreeSet de números: " + numeros + " ---");
        // Conjunto ordenado: [1, 2, 5, 7, 10, 15]

        // 9. Elements Less Than 7: mostre os elementos menores que 7.
        System.out.println("9. Elements Less Than 7 (em " + numeros + "): " + numeros.headSet(7));

        // 10. Ceiling Element: recupere o elemento maior ou igual a um valor informado.
        Integer valorBusca = 6;
        Integer ceiling = numeros.ceiling(valorBusca);
        System.out.println("10. Ceiling Element (maior ou igual a " + valorBusca + "): " + ceiling); // Deve ser 7

        // 11. Floor Element: recupere o elemento menor ou igual a um valor informado.
        valorBusca = 6;
        Integer floor = numeros.floor(valorBusca);
        System.out.println("11. Floor Element (menor ou igual a " + valorBusca + "): " + floor); // Deve ser 5

        // 12. Higher Element: recupere o elemento estritamente maior que um valor informado.
        valorBusca = 7;
        Integer higher = numeros.higher(valorBusca);
        System.out.println("12. Higher Element (estritamente > " + valorBusca + "): " + higher); // Deve ser 10

        // 13. Lower Element: recupere o elemento estritamente menor que um valor informado.
        valorBusca = 7;
        Integer lower = numeros.lower(valorBusca);
        System.out.println("13. Lower Element (estritamente < " + valorBusca + "): " + lower); // Deve ser 5

        // 14. Poll First Element: remova e retorne o primeiro elemento do conjunto 'numeros'.
        Integer polledFirst = numeros.pollFirst();
        System.out.println("14. Poll First Element (retornou: " + polledFirst + "). 'numeros' agora: " + numeros);

        // 15. Poll Last Element: remova e retorne o último elemento do conjunto 'numeros'.
        Integer polledLast = numeros.pollLast();
        System.out.println("15. Poll Last Element (retornou: " + polledLast + "). 'numeros' agora: " + numeros);
        // 'numeros' agora é [2, 5, 7, 10]

        // 16. Remove Element: remova um elemento específico do conjunto 'cores'.
        System.out.println("16. Remove Element ('Azul') de 'cores' (" + cores + ")");
        cores.remove("Azul");
        System.out.println("    Resultado: " + cores);
    }
}