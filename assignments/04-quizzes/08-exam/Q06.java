import java.util.Set;
import java.util.TreeSet;

public class Q06 {
    public static void main(String[] args){
        Integer x = 1, y = 2, z = 3;
        Set<Integer> coordinates = new TreeSet<>();
        coordinates.add(x);
        coordinates.add(y);
        coordinates.add(y);
        coordinates.add(z);
        coordinates.remove(x);
        System.out.print(coordinates);
    }
}
