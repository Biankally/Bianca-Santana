import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Q04 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("A"); l.add("B"); l.add("C"); l.add("D"); l.add("E");
        ListIterator<String> i = l.listIterator();
        i.next(); i.next(); i.next(); i.next();
        i.remove();
        i.previous(); i.previous();
        i.remove();
        System.out.println(l);
    } 
} 
