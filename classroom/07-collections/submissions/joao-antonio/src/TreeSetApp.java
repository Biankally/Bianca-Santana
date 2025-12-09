import java.util.TreeSet;

class TreeSetApp {
    public static void main(String[] args) {

        TreeSet<String> cores = new TreeSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo"); 
        cores.add("Verde"); 
        System.out.println("1. criar e Print TreeSet: " + cores);

        System.out.println("2. Iterate TreeSet Elements:");
        for (String cor : cores) {
            System.out.println("   - " + cor);
        }

        TreeSet<String> cores2 = new TreeSet<>();
        cores2.add("Preto");
        cores2.add("Branco");
        cores2.addAll(cores);
        System.out.println("3. Add Elements to Another TreeSet ('cores2' + 'cores'): " + cores2);

        System.out.println("4. Reverse Order TreeSet (view): " + cores.descendingSet());

        String primeiro = cores.first();
        String ultimo = cores.last();
        System.out.println("5. Get First ('" + primeiro + "') and Last ('" + ultimo + "') Elements: " + cores);

        @SuppressWarnings("unchecked")
        TreeSet<String> clone = (TreeSet<String>) cores.clone();
        System.out.println("6. Clone TreeSet: " + clone);

        int tamanho = cores.size();
        System.out.println("7. TreeSet Size: " + tamanho);

        boolean saoIguais = cores.equals(clone);
        System.out.println("8. Compare 'cores' vs 'clone': " + saoIguais);
        saoIguais = cores.equals(cores2);
        System.out.println("Compare 'cores' vs 'cores2': " + saoIguais);


        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(5);
        numeros.add(1);
        numeros.add(10);
        numeros.add(7);
        numeros.add(2);
        numeros.add(15);
        System.out.println("--- Criado TreeSet de números: " + numeros + " ---");

        System.out.println("9. Elements Less Than 7 (em " + numeros + "): " + numeros.headSet(7));

        Integer valorBusca = 6;
        Integer ceiling = numeros.ceiling(valorBusca);
        System.out.println("10. Ceiling Element (maior ou igual a " + valorBusca + "): " + ceiling);

        valorBusca = 6;
        Integer floor = numeros.floor(valorBusca);
        System.out.println("11. Floor Element (menor ou igual a " + valorBusca + "): " + floor);

        valorBusca = 7;
        Integer higher = numeros.higher(valorBusca);
        System.out.println("12. Higher Element (estritamente > " + valorBusca + "): " + higher);

        valorBusca = 7;
        Integer lower = numeros.lower(valorBusca);
        System.out.println("13. Lower Element (estritamente < " + valorBusca + "): " + lower);

        Integer polledFirst = numeros.pollFirst();
        System.out.println("14. Poll First Element (retornou: " + polledFirst + "). 'numeros' agora: " + numeros);

        Integer polledLast = numeros.pollLast();
        System.out.println("15. Poll Last Element (retornou: " + polledLast + "). 'numeros' agora: " + numeros);

        System.out.println("16. Remove Element ('Verde') de 'cores' (" + cores + ")");
        cores.remove("Verde");
        System.out.println("Resultado: " + cores);
    }
}