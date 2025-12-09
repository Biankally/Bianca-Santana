import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Verde");
        list.add("Amarelo");
        list.add("Azul");

        System.out.println("Append Element");
        list.add("Branco");
        System.out.println(list);

        System.out.println("Iterate LinkedList Elements");
        for (String value : list) {
            System.out.println(value);
        }

        System.out.println("Iterate from Position");
        int startPosition = 1;
        for (int i = startPosition; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Iterate in Reverse Order");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

        System.out.println("Insert at Position");
        int insertPosition = 2;
        if (insertPosition >= 0 && insertPosition <= list.size()) {
            list.add(insertPosition, "Preto");
        }
        System.out.println(list);

        System.out.println("Insert First and Last");
        list.addFirst("Rosa");
        list.addLast("Cinza");
        System.out.println(list);

        System.out.println("Insert at Front");
        list.offerFirst("Laranja");
        System.out.println(list);

        System.out.println("Insert at End");
        list.offerLast("Violeta");
        System.out.println(list);

        System.out.println("Insert Multiple at Position");
        LinkedList<String> extras = new LinkedList<>();
        extras.add("Magenta");
        extras.add("Ciano");
        int multiPosition = 1;
        if (multiPosition >= 0 && multiPosition <= list.size()) {
            list.addAll(multiPosition, extras);
        }
        System.out.println(list);

        System.out.println("First and Last Occurrence");
        String target = "Azul";
        System.out.println("first=" + list.indexOf(target) + ", last=" + list.lastIndexOf(target));

        System.out.println("Print Elements with Positions");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " -> " + list.get(i));
        }

        System.out.println("Remove Element");
        list.remove("Preto");
        System.out.println(list);

        System.out.println("Remove First and Last");
        if (!list.isEmpty()) {
            list.removeFirst();
        }
        if (!list.isEmpty()) {
            list.removeLast();
        }
        System.out.println(list);

        System.out.println("Clear LinkedList");
        LinkedList<String> clearCopy = new LinkedList<>(list);
        clearCopy.clear();
        System.out.println(clearCopy);

        System.out.println("Swap Elements");
        if (list.size() > 2) {
            Collections.swap(list, 0, 2);
        }
        System.out.println(list);

        System.out.println("Shuffle LinkedList");
        Collections.shuffle(list);
        System.out.println(list);

        System.out.println("Join LinkedLists");
        LinkedList<String> other = new LinkedList<>();
        other.add("Branco");
        other.add("Preto");
        LinkedList<String> joined = new LinkedList<>(list);
        joined.addAll(other);
        System.out.println(joined);

        System.out.println("Copy LinkedList");
        LinkedList<String> copied = new LinkedList<>(list);
        System.out.println(copied);

        System.out.println("Poll First Element");
        String polled = list.pollFirst();
        System.out.println(polled);

        System.out.println("Peek First Element");
        System.out.println(list.peekFirst());

        System.out.println("Peek Last Element");
        System.out.println(list.peekLast());

        System.out.println("Contains Element");
        System.out.println(list.contains("Amarelo"));

        System.out.println("Convert to ArrayList");
        ArrayList<String> asArrayList = new ArrayList<>(list);
        System.out.println(asArrayList);

        System.out.println("Compare LinkedLists");
        System.out.println(list.equals(copied));

        System.out.println("Check if Empty");
        System.out.println(list.isEmpty());

        System.out.println("Replace Element");
        int replacePosition = 0;
        if (replacePosition >= 0 && replacePosition < list.size()) {
            list.set(replacePosition, "Dourado");
        }
        System.out.println(list);
    }
}
