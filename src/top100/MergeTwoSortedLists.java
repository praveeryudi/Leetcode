package top100;

/**
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

    private static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private static Node merge(Node first, Node second) {
        if(null == first) return second;
        if(null == second) return first;
        Node res;
        if(first.key <= second.key) {
            res = first;
            res.next = merge(first.next, second);
        }
        else {
            res = second;
            res.next = merge(first, second.next);
        }
        return res;
    }

    private static void printMergedList(Node newHead) {
        while(null != newHead) {
            System.out.print(newHead.key + " ");
            newHead = newHead.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(3);
        head1.next = new Node(5);
        head1.next.next = new Node(7);

        Node head2 = new Node(30);
        head2.next = new Node(50);
        head2.next.next = new Node(70);

        Node resultNode = merge(head1, head2);
        printMergedList(resultNode);
    }
}
