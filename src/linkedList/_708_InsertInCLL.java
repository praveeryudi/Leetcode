package linkedList;

/**
 * Given a node from a cyclic linked list which has been sorted,
 * write a function to insert a value into the list such that it remains a cyclic sorted list.
 * The given node can be any single node in the list. Return the inserted new node.
 */
public class _708_InsertInCLL {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = head;

        insert(head.next, 3);
    }

    private static ListNode insert(ListNode node, int x) {
        // Base case I: List is empty
        if(null == node) {
            ListNode newNode = new ListNode(x);
            newNode.next = newNode;
            return newNode;
        }

        // Base case II: List has only one node
        if(node.next == node) {
            ListNode newNode = new ListNode(x);
            node.next = newNode;
            newNode.next = node;
            return node;
        }

        // Find the minimum and maximum Node
        // Next of maximum always points to minimum
        ListNode minNode = node, maxNode = node;
        ListNode prev = node;
        ListNode curr = node.next;
        while(null != curr) {
            if(prev.val >= curr.val) {
                minNode = curr;
                maxNode = prev;
                break;
            }
            if(curr.val < minNode.val) {
                minNode = curr;
            }
            if(curr.val >= maxNode.val) { // max node must be the last one if equal
                maxNode = curr;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Min Node: " + minNode.val);
        System.out.println("Max Node: " + maxNode.val);

        // Case III.A. Insert value is more than max OR less than min
        if(x >= maxNode.val || x <= minNode.val) {
            ListNode newNode = new ListNode(x);
            maxNode.next = newNode;
            newNode.next = minNode;
            return newNode;
        }

        curr = minNode;
        while(curr.next != minNode && curr.next.val < x) {
            curr = curr.next;
        }
        ListNode newNode = new ListNode(x);
        newNode.next = curr.next;
        curr.next = newNode;
        return node;
    }

}
