import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListArrayListIteratorTest {
    public static void main(String[] args) {

        String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};

        List<String> list = new ArrayList<>();

        for (String color : colors) {
            list.add(color);
        }

        String[] removeColors = {"RED", "WHITE", "BLUE"};
        List<String> removeList = new ArrayList<>();

        for (String color : removeColors) {
            removeList.add(color);
        }

        System.out.println("ArrayList:");
        for (int i = 0; i < list.size(); i++){ //for (String color : list) {
            System.out.printf("%s ", list.get(i));//System.out.printf("%s ", color);
        }

        removeColors(list, removeList);

        System.out.printf("%n%nArrayList after calling removeColors:%n");

        for (String color : list) {
            System.out.printf("%s ", color);
        }
        System.out.printf("%n ");
    }

    private static void removeColors(Collection<String> collection1, Collection<String> collection2) {

        Iterator<String> iterator = collection1.iterator();

        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next())) {
                iterator.remove();
            }
        }
    }
}