import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

class ArrayListApp {
    public static void main(String[] args){
        ArrayList<String> cores = new ArrayList<>();

        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println(cores);

        System.out.println("2: Iterando sobre os elementos:");
        for (String cor : cores) {
            System.out.println("   Cor: " + cor);
        }

        cores.add(0, "Roxo");
        System.out.println("3: Adicionar 'Roxo' na posição 0: " + cores);


        String corPos2 = cores.get(2);
        System.out.println("4: Elemento na posição 2: " + corPos2 + ". (Lista atual: " + cores + ")");

        String elementoAntigo = cores.set(1, "Lilas");
        System.out.println("5: Substituir elemento 2 ('" + elementoAntigo + "') por 'Lilas': " + cores);


        String elementoRemovido = cores.remove(2); 
        System.out.println("6: Remover elemento da posição 2 ('" + elementoRemovido + "'): " + cores);

        boolean contemRoxo = cores.contains("Roxo");
        System.out.println("7: Lista contém 'Roxo'? " + contemRoxo + ". (Lista atual: " + cores + ")");

        cores.sort(null); 
        System.out.println("8: Ordenar a lista: " + cores);

        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("9: Copiar a lista 'cores' para 'copia': " + copia);

        Collections.shuffle(copia);
        System.out.println("10: Embaralhar a 'copia': " + copia);

        Collections.reverse(copia);
        System.out.println("11: Inverter a 'copia': " + copia);

        List<String> sublista = cores.subList(1, 3); 
        System.out.println("12: Sublista de 'cores' (índices 1 a 3): " + sublista + ". (Lista 'cores': " + cores + ")");

        boolean listas_iguais = cores.equals(copia);
        System.out.println("13: 'cores' é igual a 'copia'? " + listas_iguais);
        System.out.println("    cores: " + cores);
        System.out.println("    copia: " + copia);

        Collections.swap(cores, 0, 2); 
        System.out.println("14: Trocar elementos (0 e 2) em 'cores': " + cores);

        ArrayList<String> unida = new ArrayList<>(cores);
        unida.addAll(copia);
        System.out.println("15: Unir 'cores' e 'copia': " + unida);

        @SuppressWarnings("unchecked") 
        ArrayList<String> clone2 = (ArrayList<String>) cores.clone();
        System.out.println("16: Clonar 'cores' para 'clone2': " + clone2);

        clone2.clear();
        System.out.println("17: Esvaziar 'clone2': " + clone2);

        int tamanho = cores.size();
        System.out.println("18: Tamanho da lista 'cores': " + tamanho + ". (Lista 'cores': " + cores + ")");

        ArrayList<String> inalteravel = new ArrayList<>(cores);
        inalteravel.add("Laranja");
        inalteravel.add("Cinza");
        
        inalteravel.trimToSize();
        System.out.println("19: Lista 'inalteravel' (após trimToSize): " + inalteravel);

        int CapMin = 100;
        cores.ensureCapacity(CapMin);
        System.out.println("20: Garantir capacidade mínima de " + CapMin + " para 'cores'. (Elementos: " + cores + ")");

        cores.set(1, "Preto");
        System.out.println("21: Substituir posição 1 por 'Preto' em 'cores': " + cores);

        System.out.println("22: Imprimindo 'cores' com índices:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println("   " + i + " -> " + cores.get(i));
        }
    }
}