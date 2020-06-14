package linkedList;

public class _445_Add_Two_Numbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.val == 0 && l2.val == 0)
            return new ListNode(0);

        StringBuilder num1 = new StringBuilder();
        while (null != l1) {
            num1.append(l1.val);
            l1 = l1.next;
        }

        StringBuilder num2 = new StringBuilder();
        while (null != l2) {
            num2.append(l2.val);
            l2 = l2.next;
        }

        long sum = Long.valueOf(num1.toString()) + Long.valueOf(num2.toString());
        System.out.println("Sum = " + sum);
        ListNode head = null;

        while (sum > 0) {
            long digit =  sum % 10;
            ListNode newNode = new ListNode((int)digit);
            newNode.next = head;
            head = newNode;
            sum = sum / 10;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode start1 = new ListNode(3);
        start1.next = new ListNode(9);
        start1.next.next = new ListNode(9);
        start1.next.next.next = new ListNode(9);
        start1.next.next.next.next = new ListNode(9);
        start1.next.next.next.next.next = new ListNode(9);
        start1.next.next.next.next.next.next = new ListNode(9);
        start1.next.next.next.next.next.next.next = new ListNode(9);
        start1.next.next.next.next.next.next.next.next = new ListNode(9);
        start1.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode start2 = new ListNode(7);
        ListNode newHead = addTwoNumbers(start1, start2);
        while(null != newHead) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }
    }
}
