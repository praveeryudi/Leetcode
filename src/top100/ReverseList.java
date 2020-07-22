package top100;

public class ReverseList {
    private static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private static Node reverse(Node head) {
        if(null == head || null == head.next)
            return head;
        Node curr = head;
        Node prev = null, next = null;
        while(null != curr) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node start = new Node(5);
        start.next = new Node(7);
        start.next.next = new Node(8);
        start.next.next.next = new Node(1);
        Node revHead = reverse(start);
        while(null != revHead) {
            System.out.print(revHead.key + " ");
            revHead = revHead.next;
        }
    }
}
