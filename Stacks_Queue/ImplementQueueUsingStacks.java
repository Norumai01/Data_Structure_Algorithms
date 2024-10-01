import java.util.Stack;
import java.util.ArrayList;

public class ImplementQueueUsingStacks {

    // URL: https://leetcode.com/problems/implement-queue-using-stacks/

    static class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;  // Helper, assisting with reversing order.

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {   // O(1)
            // Push element into queue.
            stack1.push(x);
        }

        public int pop() {   // Worst case: O(n)
            // Push elements from stack1 to stack2, reverse the order.
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }

            // Pop the top element from stack2, which pop the front element in queue.
            int x = stack2.pop();

            // Push elements from stack2 back to stack1. Reorganize stack1 original order of state.
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }

            return x;
        }

        // Similar to pop(), but using peek() instead.
        public int peek() {   // Worst case: O(n)
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }

            int x = stack2.peek();

            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }

            return x;
        }

        public boolean isEmpty() {  // O(1)
            // Return true if stack1 is empty.
            return stack1.isEmpty();
        }

        public ArrayList<Integer> printQueueCollection() {
            ArrayList<Integer> queue = new ArrayList<>();
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            while (!stack2.isEmpty()) {
                int value = stack2.pop();
                // Push correct order into Array List.
                queue.add(value);
                // Restores correct order in stack1.
                stack1.push(value);
            }
            return queue;
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyQueue
        MyQueue queue = new MyQueue();

        // Test pushing elements to the queue
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.printQueueCollection() + "\n");

        // Peek the front element
        System.out.println("Peek: " + queue.peek());  // Output: Peek: 1
        // Pop the front element
        System.out.println("Pop: " + queue.pop());  // Output: Pop: 1
        System.out.println(queue.printQueueCollection() + "\n");

        // Peek again
        System.out.println("Peek: " + queue.peek());  // Output: Peek: 2
        // Pop the next element
        System.out.println("Pop: " + queue.pop());  // Output: Pop: 2
        System.out.println(queue.printQueueCollection() + "\n");

        queue.push(4);
        System.out.println(queue.printQueueCollection() + "\n");

        // Peek and pop the front element.
        System.out.println("Peek: " + queue.peek());  // Output: Peek: 3
        System.out.println("Pop: " + queue.pop());  // Output: Pop: 3
        System.out.println(queue.printQueueCollection() + "\n");

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());  // Output: false

        // Peek and pop the front element and last remaining element.
        System.out.println("Peek: " + queue.peek());  // Output: Peek: 4
        System.out.println("Pop: " + queue.pop());  // Output: Pop: 4
        System.out.println(queue.printQueueCollection() + "\n");

        // Check if the queue is empty now
        System.out.println("Is queue empty? " + queue.isEmpty());  // Output: true
    }
}
