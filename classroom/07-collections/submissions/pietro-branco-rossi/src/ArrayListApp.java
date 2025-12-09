import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

class ArrayListApp {
    public static void main(String[] args){
        ArrayList<String> cores = new ArrayList<>();

        // 1: Adicionar cores
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        System.out.println("1: Adicionar cores: " + cores);

        // 2: Iterar e imprimir elementos
        System.out.println("2: Iterando sobre os elementos:");
        for (String cor : cores) {
            System.out.println("   Cor: " + cor);
        }

        // 3: Adicionar na posição 0
        cores.add(0, "Roxo");
        System.out.println("3: Adicionar 'Roxo' na posição 0: " + cores);


        // 4: Obter elemento da posição 2
        String corPos2 = cores.get(2);
        System.out.println("4: Elemento na posição 2: " + corPos2 + ". (Lista atual: " + cores + ")");

        // 5: Substituir um elemento (Update)
        // Lista atual: ["Roxo", "Verde", "Amarelo", "Azul", "Branco"]
        String elementoAntigo = cores.set(1, "Lilas");
        System.out.println("5: Substituir elemento [1] ('" + elementoAntigo + "') por 'Lilas': " + cores);


        // 6: Remover elemento da posição 2
        String elementoRemovido = cores.remove(2); // Remove "Amarelo"
        System.out.println("6: Remover elemento da posição 2 ('" + elementoRemovido + "'): " + cores);

        // 7: Verificar se contém "Roxo"
        boolean contemRoxo = cores.contains("Roxo");
        System.out.println("7: Lista contém 'Roxo'? " + contemRoxo + ". (Lista atual: " + cores + ")");

        // 8: Ordenar a lista
        cores.sort(null); 
        System.out.println("8: Ordenar a lista: " + cores);

        // 9: Copiar a lista
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("9: Copiar a lista 'cores' para 'copia': " + copia);

        // 10: Embaralhar a cópia
        Collections.shuffle(copia);
        System.out.println("10: Embaralhar a 'copia': " + copia);

        // 11: Inverter a cópia
        Collections.reverse(copia);
        System.out.println("11: Inverter a 'copia': " + copia);

        // 12: Obter sublista (da lista 'cores')
        List<String> sublista = cores.subList(1, 3); 
        System.out.println("12: Sublista de 'cores' (índices 1 a 3): " + sublista + ". (Lista 'cores': " + cores + ")");

        // 13: Comparar se 'cores' e 'copia' são iguais
        boolean listas_iguais = cores.equals(copia);
        System.out.println("13: 'cores' é igual a 'copia'? " + listas_iguais);
        System.out.println("    cores: " + cores);
        System.out.println("    copia: " + copia);

        // 14: Trocar elementos em 'cores'
        Collections.swap(cores, 0, 2); 
        System.out.println("14: Trocar elementos (0 e 2) em 'cores': " + cores);

        // 15: Unir as duas listas
        ArrayList<String> unida = new ArrayList<>(cores);
        unida.addAll(copia);
        System.out.println("15: Unir 'cores' e 'copia': " + unida);

        // 16: Clonar a lista 'cores'
        @SuppressWarnings("unchecked") // Necessário por causa do .clone()
        ArrayList<String> clone2 = (ArrayList<String>) cores.clone();
        System.out.println("16: Clonar 'cores' para 'clone2': " + clone2);

        // 17: Esvaziar o clone
        clone2.clear();
        System.out.println("17: Esvaziar 'clone2': " + clone2);

        // 18: Verificar o tamanho de 'cores'
        int tamanho = cores.size();
        System.out.println("18: Tamanho da lista 'cores': " + tamanho + ". (Lista 'cores': " + cores + ")");

        // 19: Usar trimToSize
        ArrayList<String> inalteravel = new ArrayList<>(cores);
        inalteravel.add("Laranja");
        inalteravel.add("Cinza");
        
        inalteravel.trimToSize();
        System.out.println("19: Lista 'inalteravel' (após trimToSize): " + inalteravel);

        // 20: Garantir capacidade mínima
        int CapMin = 100;
        cores.ensureCapacity(CapMin);
        System.out.println("20: Garantir capacidade mínima de " + CapMin + " para 'cores'. (Elementos: " + cores + ")");

        // 21: Substituir elemento na posição 1
        cores.set(1, "Preto");
        System.out.println("21: Substituir posição 1 por 'Preto' em 'cores': " + cores);

        // 22: Imprimir elementos com seus índices
        System.out.println("22: Imprimindo 'cores' com índices:");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println("   " + i + " -> " + cores.get(i));
        }
    }
}