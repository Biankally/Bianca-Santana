import java.util.ArrayDeque;

class ArrayDequeDemo {
    public static void main(String[] args) {
        // cria um ArrayDeque
        ArrayDeque<String> adq = new ArrayDeque<>();

        // usa o ArrayDeque como uma pilha
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        // remove e imprime os elementos da pilha
        System.out.print("Popping the stack: ");
        while (adq.peek() != null) {
            System.out.print(adq.pop() + " ");
        }
        System.out.println();
    }
}
