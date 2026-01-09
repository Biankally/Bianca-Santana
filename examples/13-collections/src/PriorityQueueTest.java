import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        // cria uma fila de prioridade de números decimais
        PriorityQueue<Double> queue = new PriorityQueue<>();

        // adiciona elementos à fila
        queue.offer(3.2);
        queue.offer(9.8);
        queue.offer(5.4);

        System.out.print("Polling from queue: ");

        while (!queue.isEmpty()) {
            System.out.printf("%.1f ", queue.poll());
        }
    }
}
