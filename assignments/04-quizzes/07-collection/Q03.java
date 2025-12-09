
import java.util.Set;
import java.util.TreeSet;

class Magazine implements Comparable<Magazine>{
    private final String name;

    public Magazine(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Magazine m) {
        return m.name.compareTo(name);
    }
    
    @Override
    public String toString() {
        return name;
    } 
} 

public class Q03 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("Highlights");
        set.add("Newsweek");
        set.add("Highlights");
        System.out.print(set.iterator().next());
        
        System.out.print(" ");

        Set<Magazine> set2 = new TreeSet<>();
        set2.add(new Magazine("Highlights"));
        set2.add(new Magazine("Newsweek"));
        set2.add(new Magazine("Highlights"));
        System.out.print(set2.iterator().next());
    } 
} 
