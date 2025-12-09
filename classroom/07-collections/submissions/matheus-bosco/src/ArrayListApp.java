import java.util.*;



public class ArrayListApp {


    public static void main(String[] args) {

        System.out.println("Create and Print ArrayList");
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde"); cores.add("Amarelo"); cores.add("Azul"); cores.add("Branco");
        System.out.println(cores);


        System.out.println("Iterate ArrayList Elements");
        for (String c : cores) System.out.println(c);


        System.out.println("Insert at First Position");
        cores.add(0, "Preto");
        System.out.println(cores);
        

        System.out.println("Retrieve Element by Index");
        int idx = 2;
        if (idx >= 0 && idx < cores.size()) System.out.println("idx=2 -> " + cores.get(idx));
        else System.out.println("índice inválido");


        System.out.println("Update ArrayList Element");
        int pos = 1;
        if (pos >= 0 && pos < cores.size()) System.out.println("antes=" + cores.set(pos, "Cinza") + " | depois="+cores.get(pos));
        System.out.println(cores);


        System.out.println("Remove Third Element");
        if (cores.size() > 2) cores.remove(2);
        System.out.println(cores);


        System.out.println("Search Element in ArrayList");
        System.out.println("contém 'Azul'? " + cores.contains("Azul"));


        System.out.println("Sort ArrayList");
        Collections.sort(cores);
        System.out.println(cores);


        System.out.println("Copy ArrayList");
        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println(copia);


        System.out.println("Shuffle ArrayList");
        Collections.shuffle(cores);
        System.out.println(cores);



        System.out.println("Reverse ArrayList");
        Collections.reverse(cores);
        System.out.println(cores);


        System.out.println("Extract Sublist from ArrayList");
        int from = 0, to = Math.min(2, cores.size());
        System.out.println(cores.subList(from, to));


        System.out.println("Compare Two ArrayLists");
        System.out.println("cores.equals(copia)? " + cores.equals(copia));



        System.out.println("Swap ArrayList Elements");
        if (cores.size() >= 2) Collections.swap(cores, 0, 1);
        System.out.println(cores);


        System.out.println("Join Two ArrayLists");
        ArrayList<String> outra = new ArrayList<>(List.of("Rosa","Laranja"));
        ArrayList<String> uniao = new ArrayList<>(cores);
        uniao.addAll(outra);
        System.out.println(uniao);


        System.out.println("Clone ArrayList");
        @SuppressWarnings("unchecked")
        ArrayList<String> clone = (ArrayList<String>) cores.clone();
        System.out.println(clone);


        System.out.println("Clear ArrayList");
        cores.clear();
        System.out.println(cores);


        System.out.println("Check if ArrayList is Empty");
        System.out.println(cores.isEmpty());


        System.out.println("Trim ArrayList Capacity");
        cores.trimToSize();
        System.out.println("trim aplicado");


        System.out.println("Increase ArrayList Capacity");
        cores.ensureCapacity(20);
        System.out.println("ensureCapacity(20) aplicado");


        System.out.println("Replace Second Element");
        cores.addAll(List.of("A","B","C"));
        if (cores.size() > 1) cores.set(1, "Z");
        System.out.println(cores);
        

        System.out.println("Print Elements by Position");
        for (int i = 0; i < cores.size(); i++) System.out.println(i + " -> " + cores.get(i));
    }
}
