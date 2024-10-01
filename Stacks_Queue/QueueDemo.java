import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        // Queue = First-In First-Out (FIFO) data structure

        // Queue is an interface, not a class. So we use Linked List.
        // Priority Queue is also an implementation of queue, but works differently.
        // Space: O(n)
        Queue<String> queue = new LinkedList<String>();

        // Add element -> enqueue, offer(). Time: O(1)
        queue.offer("Sam");
        queue.add("Bob");
        queue.add("Jack");
        queue.offer("David");
        queue.offer("Lena");
        System.out.println(queue);
        System.out.println();

        // Removing element -> dequeue, poll(). Time: O(1)
        queue.poll();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        System.out.println();

        // Checking the front element -> top, peek(). Time: O(1)
        System.out.println("Front Element: " + queue.peek());
        System.out.println("Front Element: " + queue.element());
        System.out.println();

        // Useful methods from collection class.
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Queue's size: " + queue.size());
        System.out.println(queue.contains("David"));

        /*
        Real-world Applications of Queue:
        - Real-world systems (e.g. waiting lines -- first come, first served)
        - CPU Task Handling
        - Data Transferring -> Network communication
        */
    }
}
