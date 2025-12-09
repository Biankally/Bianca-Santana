import java.util.Iterator;
import java.util.LinkedList;

public class Q05{
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(); 
        list.add("Grapes of Wrath"); 
        list.add("1984");
        for (String s : list) System.out.printf("%s ", s);


        Iterator<String> it = list.iterator(); 
        while (it.hasNext()){
            it.next();
            it.remove();
            System.out.printf("%s ", it.next()); 
        } 

    }
}
