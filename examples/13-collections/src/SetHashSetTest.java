import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetHashSetTest {
    public static void main(String[] args) {

        String[] colors = {"red", "white", "blue", "green", "gray", "orange", "tan", "white", "cyan", "peach", "gray", "orange"};

        List<String> list = Arrays.asList(colors);

        System.out.printf("List: %s%n", list);

        printNonDuplicates(list);
    }
    
    private static void printNonDuplicates(Collection<String> collection) {
        Set<String> set = new HashSet<>(collection);

        System.out.printf("%nNonduplicates are: ");
        for (String value : set) {
            System.out.printf("%s ", value);
        }
        System.out.println();
    }
}
