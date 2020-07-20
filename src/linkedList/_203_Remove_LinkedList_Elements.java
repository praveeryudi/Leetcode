package linkedList;

public class _203_Remove_LinkedList_Elements {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode remove(ListNode head, int val) {
        if(null == head) return null;

        while(null != head && head.val == val)
        {
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = head;

        if(null == head)
            return null;

        while(null != curr) {
            if(curr.val == val) {
                while(null != curr && curr.val == val)
                    curr = curr.next;

                prev.next = curr;
                prev = prev.next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(6);
        start.next.next.next = new ListNode(3);
        start.next.next.next.next = new ListNode(4);
        start.next.next.next.next.next = new ListNode(5);
        start.next.next.next.next.next.next = new ListNode(6);

        ListNode newHead = remove(start, 6);
        while(null != newHead) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

}
