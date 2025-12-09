
import java.util.Arrays;
import java.util.Comparator;

class MyComparator implements Comparator<String>{

    @Override
    public int compare(String a, String b){
        return b.toLowerCase().compareTo(a.toLowerCase());
    }

}
public class Q09{
    public static void main(String[] args){
        String[] values = {"123", "Abb", "aabb"};

        Arrays.sort(values, new MyComparator());

        for (var s: values){
            System.out.print(s + " ");
        }
    }
}
