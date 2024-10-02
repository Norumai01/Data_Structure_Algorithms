public class DoublyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;


    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        return node.data;
    }

    public int indexOf(T data) {
        Node<T> node = head;
        int index = 0;
        while (node != null) {
            if (node.data.equals(data)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
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
        else if (index == size - 1) {
            add(data);
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node<T> newNode = new Node<>(data);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    public void remove(int index) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        System.out.println("Size: " + list.size());
        System.out.println("Is Empty? " + list.isEmpty());
        System.out.println();

        // Adding elements to Doubly Linked List.
        list.add("Apple");
        list.add("Banana");
        list.add("Grape");
        list.add("Pineapple");
        list.add("Orange");
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("Is Empty? " + list.isEmpty());
        System.out.println();

        // Check if element exists.
        int indexPosition = list.indexOf("Potato");
        System.out.println("Does Potato exist? " + ((indexPosition != -1) ? "Yes" : "No"));
        indexPosition = list.indexOf("Grape");
        System.out.println("Does Apple exist? " + ((indexPosition != -1) ? "Yes" : "No"));
        System.out.println("3rd Index: " + list.get(3));
        System.out.println();

        // Adding element ot the front.
        list.addFront("Peach");
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println();

        // Adding element at particular index.
        list.add("Pear", 4);
        System.out.println(list);
        System.out.println();
    }
}
