import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>(Arrays.asList("Verde", "Amarelo", "Azul", "Branco"));

        colors.add("Preto");
        System.out.println("Append Element: " + colors);

        System.out.println("Iterate LinkedList Elements:");
        for (String color : colors) {
            System.out.println(color);
        }

        int startIndex = Math.min(2, colors.size());
        System.out.println("Iterate from Position (" + startIndex + "):");
        for (ListIterator<String> iterator = colors.listIterator(startIndex); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        System.out.println("Iterate in Reverse Order:");
        for (Iterator<String> iterator = colors.descendingIterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        colors.add(1, "Laranja");
        System.out.println("Insert at Position: " + colors);

        colors.addFirst("Roxo");
        colors.addLast("Cinza");
        System.out.println("Insert First and Last: " + colors);

        colors.addFirst("Marrom");
        System.out.println("Insert at Front: " + colors);

        colors.addLast("Bege");
        System.out.println("Insert at End: " + colors);

        colors.addAll(3, Arrays.asList("Ciano", "Magenta"));
        System.out.println("Insert Multiple at Position: " + colors);

        int firstIndex = colors.indexOf("Azul");
        int lastIndex = colors.lastIndexOf("Azul");
        System.out.println("First and Last Occurrence of Azul: " + firstIndex + ", " + lastIndex);

        System.out.println("Print Elements with Positions:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(i + " -> " + colors.get(i));
        }

        boolean removedSpecific = colors.remove("Preto");
        System.out.println("Remove Element (Preto): " + removedSpecific + ", " + colors);

        if (!colors.isEmpty()) {
            String removedFirst = colors.removeFirst();
            String removedLast = colors.removeLast();
            System.out.println("Remove First and Last: " + removedFirst + ", " + removedLast + " -> " + colors);
        } else {
            System.out.println("Remove First and Last: lista vazia");
        }

        colors.clear();
        System.out.println("Clear LinkedList: " + colors);

        if (colors.isEmpty()) {
            colors.addAll(Arrays.asList("Vermelho", "Verde", "Azul", "Amarelo", "Lilás"));
            System.out.println("Repopulate LinkedList: " + colors);
        }

        if (colors.size() > 1) {
            Collections.swap(colors, 0, colors.size() - 1);
            System.out.println("Swap Elements: " + colors);
        } else {
            System.out.println("Swap Elements: lista pequena demais");
        }

        Collections.shuffle(colors);
        System.out.println("Shuffle LinkedList: " + colors);

        LinkedList<String> otherColors = new LinkedList<>(Arrays.asList("Preto", "Branco"));
        LinkedList<String> joinedList = new LinkedList<>(colors);
        joinedList.addAll(otherColors);
        System.out.println("Join LinkedLists: " + joinedList);

        LinkedList<String> copiedList = new LinkedList<>(colors);
        System.out.println("Copy LinkedList: " + copiedList);

        String polledFirst = colors.pollFirst();
        System.out.println("Poll First Element: " + polledFirst + ", " + colors);

        String peekFirst = colors.peekFirst();
        System.out.println("Peek First Element: " + peekFirst);

        String peekLast = colors.peekLast();
        System.out.println("Peek Last Element: " + peekLast);

        boolean containsAzul = colors.contains("Azul");
        System.out.println("Contains Element (Azul): " + containsAzul);

        ArrayList<String> arrayList = new ArrayList<>(colors);
        System.out.println("Convert to ArrayList: " + arrayList);

        LinkedList<String> comparisonList = new LinkedList<>(colors);
        boolean sameLists = colors.equals(comparisonList);
        System.out.println("Compare LinkedLists: " + sameLists);

        System.out.println("Check if Empty: " + colors.isEmpty());

        if (!colors.isEmpty()) {
            String replaced = colors.set(0, "Dourado");
            System.out.println("Replace Element: substituido " + replaced + " por Dourado -> " + colors);
        } else {
            System.out.println("Replace Element: lista vazia");
        }
    }
}
