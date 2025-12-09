import java.util.Set;
import java.util.TreeSet;

public class TreeSetApp {

    public static void main(String[] args) {
        System.out.println("### Iniciando TreeSetApp ###\n");

        System.out.println("[Operação 1]: Create and Print TreeSet");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo");
        System.out.println("Resultado (ordenado): " + cores);

        System.out.println("\n[Operação 2]: Iterate TreeSet Elements");
        System.out.println("Resultado:");
        for (String cor : cores) {
            System.out.println("- " + cor);
        }

        System.out.println("\n[Operação 3]: Add Elements to Another TreeSet");
        TreeSet<String> ts2 = new TreeSet<>();
        ts2.addAll(cores);
        System.out.println("Resultado: " + ts2);

        System.out.println("\n[Operação 4]: Reverse Order TreeSet (visão)");
        System.out.println("Resultado: " + cores.descendingSet());

        System.out.println("\n[Operação 5]: Get First and Last Elements");
        System.out.println("Primeiro: " + cores.first());
        System.out.println("Último: " + cores.last());

        System.out.println("\n[Operação 6]: Clone TreeSet");
        TreeSet<String> cloneSet = (TreeSet<String>) cores.clone();
        System.out.println("Resultado: " + cloneSet);

        System.out.println("\n[Operação 7]: TreeSet Size");
        System.out.println("Resultado: " + cores.size());

        System.out.println("\n[Operação 8]: Compare TreeSets");
        TreeSet<String> ts3 = new TreeSet<>(cores);
        System.out.println("Resultado: " + cores.equals(ts3));

        TreeSet<Integer> numeros = new TreeSet<>(Set.of(1, 5, 8, 3, 10, 6, 20));
        System.out.println("\n--- Usando TreeSet de números: " + numeros + " ---");

        System.out.println("[Operação 9]: Elements Less Than 7");
        System.out.println("Resultado: " + numeros.headSet(7));

        System.out.println("\n[Operação 10]: Ceiling Element (>= 7)");
        System.out.println("Resultado: " + numeros.ceiling(7));

        System.out.println("\n[Operação 11]: Floor Element (<= 7)");
        System.out.println("Resultado: " + numeros.floor(7));

        System.out.println("\n[Operação 12]: Higher Element (> 8)");
        System.out.println("Resultado: " + numeros.higher(8));

        System.out.println("\n[Operação 13]: Lower Element (< 5)");
        System.out.println("Resultado: " + numeros.lower(5));

        System.out.println("\n[Operação 14]: Poll First Element (remove e retorna)");
        Integer primeiro = numeros.pollFirst();
        System.out.println("Elemento removido: " + primeiro);
        System.out.println("Resultado: " + numeros);

        System.out.println("\n[Operação 15]: Poll Last Element (remove e retorna)");
        Integer ultimo = numeros.pollLast();
        System.out.println("Elemento removido: " + ultimo);
        System.out.println("Resultado: " + numeros);
        
        System.out.println("\n[Operação 16]: Remove Element ('Verde' do set de cores)");
        cores.remove("Verde");
        System.out.println("Resultado: " + cores);

        System.out.println("\n### TreeSetApp Finalizado ###");
    }
}