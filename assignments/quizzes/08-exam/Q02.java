import java.util.ArrayList; 
import java.util.List; 

public class Q02 {
    public static void main(String[] args) {
        String[] data1 = {"A","B","B","A"};
        List<String> data2 = new ArrayList<>();
        for (String s : data1) {
            data2.add(s);
        }
        data2.set(2, "C");
        data2.add("D");
        data2.remove(3);
        System.out.println(data2);
    } 
} 
