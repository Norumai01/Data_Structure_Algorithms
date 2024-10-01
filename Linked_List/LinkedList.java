// Implementation of Linked List
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;


        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void add(T data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFront(data);
        }
        else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void addFront(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void removeFront() {
        if (size < 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        head = head.next;
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = head.next;
        }
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void removeLast() {
        if (size < 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        if (size == 1) {
            head = null;
        }
        else {
            Node<T> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Check if error checking is correct.
        //list.remove();

        // Is initial list empty?
        System.out.println("Is list empty? " + list.isEmpty());
        System.out.println("List size: " + list.size());
        System.out.println();

        // Add element.
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        System.out.println();

        // Is list now empty?
        System.out.println("Is list empty? " + list.isEmpty());
        System.out.println("List size: " + list.size());
        System.out.println();

        // Remove front element.
        list.removeFront();
        System.out.println(list);
        System.out.println();

        // Remove element at 5th index.
        list.remove(5);
        System.out.println(list);
        System.out.println();

        // Add element to the front
        list.addFront(1);
        System.out.println(list);
        System.out.println();

        // Remove last element
        list.removeLast();
        System.out.println(list);
        System.out.println();

        // Add element in particular position
        list.add(10, 3);
        System.out.println(list);
        System.out.println();
    }
}
