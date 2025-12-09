import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        System.out.println("1. Create and Print TreeSet");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Rosa");
        System.out.println(cores);
        System.out.println();

        System.out.println("2. Iterate TreeSet elements");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        System.out.println("3. Add elements to another TreeSet");
        TreeSet<String> outroConjunto = new TreeSet<>();
        outroConjunto.add("Marrom");
        outroConjunto.add("Roxo");
        outroConjunto.addAll(cores);
        System.out.println("Novo conjunto: " + outroConjunto);
        System.out.println();

        System.out.println("4. Reverse order TreeSet");
        TreeSet<String> ordemReversa = (TreeSet<String>) cores.descendingSet();
        System.out.println("Ordem reversa: " + ordemReversa);
        System.out.println();

        System.out.println("5. Get first and last elements");
        System.out.println("Primeiro elemento: " + cores.first());
        System.out.println("Último elemento: " + cores.last());
        System.out.println();

        System.out.println("6. Clone TreeSet");
        @SuppressWarnings("unchecked")
        TreeSet<String> coresClone = (TreeSet<String>) cores.clone();
        System.out.println("Conjunto clonado: " + coresClone);
        System.out.println();

        System.out.println("7. TreeSet size");
        System.out.println("Tamanho do conjunto: " + cores.size());
        System.out.println();

        System.out.println("8. Compare TreeSets");
        TreeSet<String> conjunto1 = new TreeSet<>(cores);
        TreeSet<String> conjunto2 = new TreeSet<>(cores);
        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);
        System.out.println("São iguais: " + conjunto1.equals(conjunto2));
        System.out.println();

        System.out.println("9. Elements less than 7");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(3);
        numeros.add(8);
        numeros.add(5);
        numeros.add(12);
        numeros.add(1);
        numeros.add(7);
        numeros.add(9);
        numeros.add(4);
        System.out.println("TreeSet de números: " + numeros);
        TreeSet<Integer> menoresQue7 = new TreeSet<>(numeros.headSet(7));
        System.out.println("Elementos menores que 7: " + menoresQue7);
        System.out.println();

        System.out.println("10. Ceiling element");
        int valorCeiling = 6;
        Integer ceiling = numeros.ceiling(valorCeiling);
        System.out.println("Ceiling de " + valorCeiling + ": " + ceiling);
        System.out.println();

        System.out.println("11. Floor element");
        int valorFloor = 6;
        Integer floor = numeros.floor(valorFloor);
        System.out.println("Floor de " + valorFloor + ": " + floor);
        System.out.println();

        System.out.println("12. Higher element");
        int valorHigher = 7;
        Integer higher = numeros.higher(valorHigher);
        System.out.println("Higher de " + valorHigher + ": " + higher);
        System.out.println();

        System.out.println("13. Lower element");
        int valorLower = 7;
        Integer lower = numeros.lower(valorLower);
        System.out.println("Lower de " + valorLower + ": " + lower);
        System.out.println();

        System.out.println("14. Poll first element");
        TreeSet<Integer> numerosParaPoll = new TreeSet<>(numeros);
        Integer primeiroRemovido = numerosParaPoll.pollFirst();
        System.out.println("Primeiro elemento removido: " + primeiroRemovido);
        System.out.println("Conjunto após pollFirst: " + numerosParaPoll);
        System.out.println();

        System.out.println("15. Poll last element");
        TreeSet<Integer> numerosParaPollLast = new TreeSet<>(numeros);
        Integer ultimoRemovido = numerosParaPollLast.pollLast();
        System.out.println("Último elemento removido: " + ultimoRemovido);
        System.out.println("Conjunto após pollLast: " + numerosParaPollLast);
        System.out.println();

        System.out.println("16. Remove element");
        TreeSet<String> coresParaRemover = new TreeSet<>(cores);
        String elementoRemover = "Azul";
        boolean removido = coresParaRemover.remove(elementoRemover);
        System.out.println("Removido '" + elementoRemover + "': " + removido);
        System.out.println("Conjunto após remoção: " + coresParaRemover);
        System.out.println();
    }
}