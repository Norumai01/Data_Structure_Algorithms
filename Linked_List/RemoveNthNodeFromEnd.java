public class RemoveNthNodeFromEnd {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int sizeList(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = sizeList(head);
        // If size of list is 0 or 1, return null anyway.
        if (size == 1) return null;

        // Shallow copy, mutable will also affect the current object.
        ListNode temp = head;
        int amountTravel = size - n;
        // Travelling through the whole list, removes the first element by return head.next/
        if (amountTravel == 0) {
            return head.next;
        }
        // Start from 0, then count up.
        for (int i = 0; i < amountTravel - 1; i++) {
            temp = temp.next;
        }
        // Connect to the next element.
        temp.next = temp.next.next;
        // Return the entire linked list object.
        return head;
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static String linkedListToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

        ListNode listOne = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(linkedListToString(listOne));

        listOne = removeNthFromEnd(listOne, 2);
        System.out.println(linkedListToString(listOne));
        System.out.println();

        ListNode listTwo = createLinkedList(new int[]{1});
        System.out.println(linkedListToString(listTwo));

        listTwo = removeNthFromEnd(listTwo, 1);
        System.out.println((listTwo == null) ? "null" : linkedListToString(listTwo));
        System.out.println();

        ListNode listThree = createLinkedList(new int[]{1, 2});
        System.out.println(linkedListToString(listThree));

        listThree = removeNthFromEnd(listThree, 1);
        System.out.println(linkedListToString(listThree));
        System.out.println();

        ListNode listFour = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(linkedListToString(listFour));

        listFour = removeNthFromEnd(listFour, 7);
        System.out.println(linkedListToString(listFour));
        System.out.println();
    }
}
