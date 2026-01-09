import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListLinkedListToArrayTest {
    public static void main(String[] args) {

        String[] colors = {"black", "blue", "yellow"};

        List<String> list = new LinkedList<>(Arrays.asList(colors));

        list.addLast("red");
        list.add("pink");
        list.add(3, "green");
        list.add("cyan");

        String[] newColors = list.toArray(new String[list.size()]);

        System.out.println("colors:");
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("new colors:");

        for (String color : newColors) {
            System.out.println(color);
        }
    }
}
