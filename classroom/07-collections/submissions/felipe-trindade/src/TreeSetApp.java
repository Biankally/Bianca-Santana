import java.util.*;

public class TreeSetApp{
    public static void main(String[] args){
        System.out.println("=== TreeSet ===");

        TreeSet<String> cores = new TreeSet<>(Arrays.asList("Verde","Amarelo","Azul","Branco"));
        System.out.println("Create and Print TreeSet -> " + cores);

        System.out.println("Iterate TreeSet Elements");
        for(String c : cores) System.out.println(c);

        TreeSet<String> outro = new TreeSet<>();
        outro.addAll(cores);
        System.out.println("Add Elements to Another TreeSet -> " + outro);

        System.out.println("Reverse Order TreeSet -> " + cores.descendingSet());

        System.out.println("Get First and Last Elements -> first=" + cores.first() + ", last=" + cores.last());

        TreeSet<String> clone = (TreeSet<String>) cores.clone();
        System.out.println("Clone TreeSet -> " + clone);

        System.out.println("TreeSet Size -> " + cores.size());
        System.out.println("Compare TreeSets -> " + cores.equals(outro));

        TreeSet<Integer> nums = new TreeSet<>(Arrays.asList(1,2,3,7,8,10));
        System.out.println("Elements Less Than 7 -> " + nums.headSet(7));

        System.out.println("Ceiling Element (>= \"Branco\") -> " + cores.ceiling("Branco"));
        System.out.println("Floor Element (<= \"Branco\") -> " + cores.floor("Branco"));
        System.out.println("Higher Element (>  \"Branco\") -> " + cores.higher("Branco"));
        System.out.println("Lower Element  (<  \"Branco\") -> " + cores.lower("Branco"));

        String first = cores.pollFirst();
        System.out.println("Poll First Element -> " + first + " | resto: " + cores);

        String last = cores.pollLast();
        System.out.println("Poll Last Element -> " + last + " | resto: " + cores);

        cores.remove("Azul");
        System.out.println("Remove Element ('Azul') -> " + cores);
    }
}