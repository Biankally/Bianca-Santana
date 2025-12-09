import java.util.*;



public class LinkedListApp {


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("Verde","Amarelo","Azul"));



        System.out.println("Append Element");
        list.add("Branco");
        System.out.println(list);

        System.out.println("Iterate LinkedList Elements");
        for (String s : list) System.out.println(s);

        System.out.println("Iterate from Position");
        int start = 1;
        for (int i = start; i < list.size(); i++) System.out.println(i + " -> " + list.get(i));

        System.out.println("Iterate in Reverse Order");
        Iterator<String> it = list.descendingIterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("Insert at Position");
        list.add(1, "Preto");
        System.out.println(list);

        System.out.println("Insert First and Last");
        list.addFirst("Rosa"); list.addLast("Laranja");
        System.out.println(list);

        System.out.println("Insert at Front");
        list.offerFirst("Cinza");
        System.out.println(list);

        System.out.println("Insert at End");
        list.offerLast("Marrom");
        System.out.println(list);

        System.out.println("Insert Multiple at Position");
        list.addAll(2, List.of("Ciano","Magenta"));
        System.out.println(list);

        System.out.println("First and Last Occurrence");
        list.add("Azul");
        System.out.println("first 'Azul'=" + list.indexOf("Azul") + ", last=" + list.lastIndexOf("Azul"));

        System.out.println("Print Elements with Positions");
        for (int i = 0; i < list.size(); i++) System.out.println(i + " -> " + list.get(i));

        System.out.println("Remove Element");
        list.remove("Preto");
        System.out.println(list);

        System.out.println("Remove First and Last");
        if (!list.isEmpty()) list.removeFirst();
        if (!list.isEmpty()) list.removeLast();
        System.out.println(list);

        System.out.println("Clear LinkedList");
        LinkedList<String> copyForLater = new LinkedList<>(list);
        list.clear();
        System.out.println(list);

        System.out.println("Swap Elements");
        list.addAll(List.of("A","B","C","D"));
        Collections.swap(list, 1, 3);
        System.out.println(list);

        System.out.println("Shuffle LinkedList");
        Collections.shuffle(list);
        System.out.println(list);

        System.out.println("Join LinkedLists");
        LinkedList<String> list2 = new LinkedList<>(List.of("X","Y"));
        LinkedList<String> joined = new LinkedList<>(list);
        joined.addAll(list2);
        System.out.println(joined);

        System.out.println("Copy LinkedList");
        LinkedList<String> copy = new LinkedList<>(joined);
        System.out.println(copy);

        System.out.println("Poll First Element");
        System.out.println("pollFirst -> " + copy.pollFirst());
        System.out.println(copy);

        System.out.println("Peek First Element");
        System.out.println(copy.peekFirst());

        System.out.println("Peek Last Element");
        System.out.println(copy.peekLast());

        System.out.println("Contains Element");
        System.out.println(copy.contains("A"));

        System.out.println("Convert to ArrayList");
        ArrayList<String> arr = new ArrayList<>(copy);
        System.out.println(arr);

        System.out.println("Compare LinkedLists");
        System.out.println(copy.equals(new LinkedList<>(arr)));

        System.out.println("Check if Empty");
        System.out.println(copy.isEmpty());

        System.out.println("Replace Element");
        if (!copy.isEmpty()) copy.set(0, "ZZZ");
        System.out.println(copy);

    }

    
}
