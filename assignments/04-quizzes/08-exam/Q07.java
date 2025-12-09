import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q07 {
    public static void main(String[] args) {
   
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "Hi", "Hello");
        Collections.addAll(list1, "Howdy");
        System.out.println(list1);                      // (1)

        List<String> list2 = new ArrayList<>(list1);
        list2 = Arrays.asList("Hi", "Hello");
        list2 = Arrays.asList("Howdy");
        System.out.println(list2);                      // (2) 

        List<String> list3 = new ArrayList<>();
        list3.addAll(list1);
        System.out.println(list3);                      // (3)

        List<String> list4 = new ArrayList<>(list2);
        System.out.println(list4);                      // (4)    
    }
}
