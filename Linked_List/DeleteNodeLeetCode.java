public class DeleteNodeLeetCode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void deleteNode(ListNode node) {
        // We are stuck on the node that needs to be deleted.
        // Therefore, we will replace the current val with next.
        node.val = node.next.val;

        // Connect the current node to next next node.
        // Removing the og duplicated node.
        node.next = node.next.next;
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
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
        ListNode head = createLinkedList(new int[]{4, 5, 1, 9});

        System.out.println(linkedListToString(head));

        // Remove this node.
        ListNode nodeToDelete = head.next;

        deleteNode(nodeToDelete);

        System.out.println(linkedListToString(head));
    }
}
