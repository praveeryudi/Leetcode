package _30daychallenge;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleNode {

    private static class ListNode<T> {
        T key;
        ListNode<T> next;
        ListNode(T key) {
            this.key = key;
            next = null;
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }

    private static ListNode findMiddleNode(ListNode head) {
        if(null == head || null == head.next)
            return head;
        ListNode slow = head, fast = head;
        while(null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode<Integer> start = new ListNode<>(5);
        start.next = new ListNode<>(-4);
        start.next.next = new ListNode<>(18);
        start.next.next.next = new ListNode<>(12);
        start.next.next.next.next = new ListNode<>(6);
        start.next.next.next.next.next = new ListNode<>(11);
        System.out.println(findMiddleNode(start));
    }
}
