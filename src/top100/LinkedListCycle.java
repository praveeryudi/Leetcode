package top100;

/**
 * Given a linked list, determine if it has a cycle in it.
 */
public class LinkedListCycle {

    private static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private static boolean hasCycle(Node head) {

        Node slow = head, fast = head;
        while(null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node start = new Node(3);
        start.next = new Node(2);
        start.next.next = new Node(0);
        start.next.next.next = new Node(-4);
        // Create the loop
        start.next.next.next.next = start.next;
        System.out.println("Has Cycle = " + hasCycle(start));
    }
}
