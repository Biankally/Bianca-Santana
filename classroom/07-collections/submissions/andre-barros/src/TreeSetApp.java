import java.util.TreeSet;

public class TreeSetApp {

    public static void main(String[] args) {

        
        System.out.println(" 1-Create and Print TreeSet ");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Verde");
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Vermelho"); 
        System.out.println("TreeSet (ordenado automaticamente): " + cores);
        System.out.println();

        
        System.out.println(" 2-Iterate TreeSet Elements ");
        for (String cor : cores) {
            System.out.println(cor);
        }
        System.out.println();

        
        System.out.println(" 3-Add Elements to Another TreeSet ");
        TreeSet<String> outrasCores = new TreeSet<>();
        outrasCores.add("Preto");
        outrasCores.add("Cinza");
        outrasCores.addAll(cores);
        System.out.println("Novo TreeSet com todos os elementos: " + outrasCores);
        System.out.println();

        
        System.out.println(" 4-Reverse Order TreeSet ");
        System.out.println("Visão em ordem reversa: " + cores.descendingSet());
        System.out.println();

        
        System.out.println(" 5-Get First and Last Elements ");
        System.out.println("Primeiro elemento (menor): " + cores.first());
        System.out.println("Último elemento (maior): " + cores.last());
        System.out.println();

        
        System.out.println(" 6-Clone TreeSet ");
        TreeSet<String> cloneCores = (TreeSet<String>) cores.clone();
        System.out.println("Original: " + cores);
        System.out.println("Clone: " + cloneCores);
        System.out.println();

        
        System.out.println(" 7-TreeSet Size ");
        System.out.println("Quantidade de elementos: " + cores.size());
        System.out.println();

        
        System.out.println(" 8-Compare TreeSets ");
        TreeSet<String> set1 = new TreeSet<>(cores);
        TreeSet<String> set2 = new TreeSet<>();
        set2.add("Amarelo");
        set2.add("Roxo");
        System.out.println("Set Original: " + cores);
        System.out.println("Set para Comparar 1: " + set1);
        System.out.println("Set para Comparar 2: " + set2);
        System.out.println("Original e Set 1 são iguais? " + cores.equals(set1));
        System.out.println("Original e Set 2 são iguais? " + cores.equals(set2));
        System.out.println();

        
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(10);
        numeros.add(3);
        numeros.add(8);
        numeros.add(15);
        System.out.println(" TreeSet de Números para as próximas operações ");
        System.out.println(numeros);
        System.out.println();

        
        System.out.println(" 9-Elements Less Than 7 ");
        
        System.out.println("Elementos estritamente menores que 7: " + numeros.headSet(7));
        System.out.println();

        
        System.out.println(" 10-Ceiling Element ");
        
        System.out.println("Elemento maior ou igual a 6 (ceiling): " + numeros.ceiling(6));
        System.out.println();

        
        System.out.println(" 11-Floor Element ");
        
        System.out.println("Elemento menor ou igual a 9 (floor): " + numeros.floor(9));
        System.out.println();

        
        System.out.println(" 12-Higher Element ");
        
        System.out.println("Elemento estritamente maior que 8 (higher): " + numeros.higher(8));
        System.out.println();

        
        System.out.println(" 13-Lower Element ");
        
        System.out.println("Elemento estritamente menor que 5 (lower): " + numeros.lower(5));
        System.out.println();

        
        System.out.println(" 14-Poll First Element ");
        System.out.println("Conjunto antes: " + cores);
        String primeiro = cores.pollFirst();
        System.out.println("Elemento removido e retornado: " + primeiro);
        System.out.println("Conjunto depois: " + cores);
        System.out.println();

        
        System.out.println(" 15-Poll Last Element ");
        System.out.println("Conjunto antes: " + cores);
        String ultimo = cores.pollLast();
        System.out.println("Elemento removido e retornado: " + ultimo);
        System.out.println("Conjunto depois: " + cores);
        System.out.println();
        
        
        System.out.println(" 16-Remove Element ");
        System.out.println("Conjunto antes: " + cores);
        cores.remove("Verde");
        System.out.println("Após remover 'Verde': " + cores);
        System.out.println();
    }
}