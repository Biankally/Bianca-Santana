import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>(Arrays.asList("Verde","Amarelo","Azul"));
        System.out.println("1) Append Element");
        ll.add("Branco"); System.out.println(ll);

        System.out.println("\n2) Iterate LinkedList Elements");
        for (String s: ll) System.out.println(s);

        System.out.println("\n3) Iterate from Position (from index 1)");
        ListIterator<String> it = ll.listIterator(1);
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\n4) Iterate in Reverse Order");
        Iterator<String> rev = ll.descendingIterator();
        while (rev.hasNext()) System.out.println(rev.next());

        System.out.println("\n5) Insert at Position (1)");
        ll.add(1, "Preto"); System.out.println(ll);

        System.out.println("\n6) Insert First and Last");
        ll.addFirst("Roxo"); ll.addLast("Laranja"); System.out.println(ll);

        System.out.println("\n7) Insert at Front");
        ll.offerFirst("Cinza"); System.out.println(ll);

        System.out.println("\n8) Insert at End");
        ll.offerLast("Rosa"); System.out.println(ll);

        System.out.println("\n9) Insert Multiple at Position (index 2)");
        ll.addAll(2, Arrays.asList("Marrom","Bege")); System.out.println(ll);

        System.out.println("\n10) First and Last Occurrence of 'Azul'");
        System.out.println("firstIndex=" + ll.indexOf("Azul") + ", lastIndex=" + ll.lastIndexOf("Azul"));

        System.out.println("\n11) Print Elements with Positions");
        for (int i=0;i<ll.size();i++) System.out.println(i+" -> "+ll.get(i));

        System.out.println("\n12) Remove Element 'Preto'");
        ll.remove("Preto"); System.out.println(ll);

        System.out.println("\n13) Remove First and Last");
        if (!ll.isEmpty()) ll.removeFirst();
        if (!ll.isEmpty()) ll.removeLast();
        System.out.println(ll);

        System.out.println("\n14) Clear LinkedList");
        LinkedList<String> copia = new LinkedList<>(ll);
        ll.clear(); System.out.println(ll);

        System.out.println("\n15) Swap Elements (na cópia 0<->1)");
        if (copia.size()>=2) Collections.swap(copia,0,1);
        System.out.println(copia);

        System.out.println("\n16) Shuffle LinkedList (cópia)");
        Collections.shuffle(copia); System.out.println(copia);

        System.out.println("\n17) Join LinkedLists");
        LinkedList<String> outra = new LinkedList<>(Arrays.asList("X","Y"));
        LinkedList<String> join = new LinkedList<>(copia); join.addAll(outra); System.out.println(join);

        System.out.println("\n18) Copy LinkedList");
        LinkedList<String> copy2 = new LinkedList<>(join); System.out.println(copy2);

        System.out.println("\n19) Poll First Element");
        System.out.println("pollFirst -> " + (copy2.isEmpty()? null : copy2.pollFirst()));
        System.out.println(copy2);

        System.out.println("\n20) Peek First Element");
        System.out.println("peekFirst -> " + copy2.peekFirst());

        System.out.println("\n21) Peek Last Element");
        System.out.println("peekLast -> " + copy2.peekLast());

        System.out.println("\n22) Contains Element 'Azul'");
        System.out.println(copy2.contains("Azul"));

        System.out.println("\n23) Convert to ArrayList");
        ArrayList<String> al = new ArrayList<>(copy2);
        System.out.println(al);

        System.out.println("\n24) Compare LinkedLists (join vs copy2)");
        System.out.println(join.equals(copy2));

        System.out.println("\n25) Check if Empty (ll)");
        System.out.println(ll.isEmpty());

        System.out.println("\n26) Replace Element (copy2 index 0 = 'ZZ')");
        if (!copy2.isEmpty()) copy2.set(0,"ZZ");
        System.out.println(copy2);
    }
}
