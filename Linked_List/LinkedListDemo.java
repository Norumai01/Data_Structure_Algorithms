import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        /*
        ArrayList: Dynamically allocates data within the structure linearly.
        add() --> O(1), worst case O(n) as it may need shift memory.
        get() --> O(1)
        remove() --> O(n), iterate through array to find the element.
        indexOf() --> O(n)
        contains() --> O(n)

        Pros: Dynamically allocate memory and faster to grab data. Good for smaller dataset.
        Cons: Bad for larger dataset, performance may hinder when inserting/deleting.
        */
        ArrayList<Integer> arrayList =  new ArrayList<>();

        /*
        Linked List: Collection of nodes where each node contains data and reference to another node with a next in a sequence. The tail or end of the list is null.
        Pros: Also Dynamic. Easy to insert/delete nodes without performance hindrance.
        Cons: Harder to search than an ArrayList. Needs to iterate through. Non-cache friendly.
		Good for: stacks, memory is tight.
		Bad for: frequent searches, reverse iteration, cache performance
        Reference: https://www.geeksforgeeks.org/time-and-space-complexity-of-linked-list/
        */

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        System.out.println(linkedList);

        // Add at particular index.
        linkedList.add(4, "g");
        System.out.println(linkedList);

        // Add First
        linkedList.addFirst("z");
        System.out.println(linkedList);

        // Add Last
        linkedList.addLast("y");
        System.out.println(linkedList);

        // Remove first and last elements.
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

        // Remove at certain index.
        linkedList.remove(4);
        System.out.println(linkedList);
        System.out.println();


        // Linked List can be used to implement a stack.
        LinkedList<String> linkedList3 = new LinkedList<String>();

        linkedList3.push("Minecraft");
        linkedList3.push("Fortnite");
        linkedList3.push("Apex Legend");
        linkedList3.push("Doom");
        System.out.println(linkedList3);
        // Top
        System.out.println(linkedList3.peek()); // Doom
        // Remove
        linkedList3.pop();
        System.out.println(linkedList3);
        System.out.println();


        // Linked List can also be used to implement queue.
        LinkedList<String> linkedList2 = new LinkedList<String>();

        linkedList2.offer("Minecraft");
        linkedList2.offer("Fortnite");
        linkedList2.offer("Apex Legend");
        System.out.println(linkedList2);
        // Front
        System.out.println(linkedList2.peek()); // Minecraft
        // Remove
        linkedList2.poll();
        System.out.println(linkedList2);

        /*
        Use cases:
        - Implement stack/queue
        - GPS Navigation
        - Music Playlist
        */
    }
}