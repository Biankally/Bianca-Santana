import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q08 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); 
        list.add("Austin"); 
        list.add("Boston"); 
        list.add("San Francisco");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 10) {
                it.remove();
            }
        }
        System.out.println(list.size());         
    }
}
