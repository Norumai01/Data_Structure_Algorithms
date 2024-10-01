import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // Stack is a Last In, First Out (LIFO) data structure

        // Call in stack. Space: O(n)
        Stack<String> stack = new Stack<>();

        // Insert in element at top. Time: O(1)
        stack.push("C++");
        stack.push("Java");
        stack.push("Python");
        stack.push("PHP");
        stack.push("Go");
        System.out.println(stack);
        System.out.println();

        // Check the size of stack. Time: O(1)
        System.out.println("Stack's size: " + stack.size());
        System.out.println();

        // Remove the top element. Time: O(1)
        String removeElement = stack.pop();
        System.out.println("Removed: " + removeElement);
        System.out.println(stack);
        removeElement = stack.pop();
        System.out.println("Removed: " + removeElement);
        System.out.println(stack);
        System.out.println();

        // Peek or Top, viewing the top element. Time: O(1)
        System.out.println("Top Element: " + stack.peek());
        System.out.println();

        // isEmpty(), check if stacks is empty. Time: O(1)
        Stack<String> stack2 = new Stack<>();
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack empty? " + stack2.isEmpty());

        /*
        Applications of Stacks:
        - Redo-Undo features in IDEs, Editors, etc.
        - Forward/Backward web browsers
        - Backtracking algorithms
        - Recursion
        - Calling functions (call stack)
        */
    }
}