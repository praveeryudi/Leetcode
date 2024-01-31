package geeks;

public class PalindromeLinkedList {

    private static class Node
    {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }

    //Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head)
    {
        //Your code here

        Node mid = getMid(head);
        System.out.println(mid.data);

        Node newHead = reverse(mid);
        System.out.println(newHead.data);

        //newHead.next = mid;

        Node curr = head;
        while(null != newHead) {
            if(curr.data != newHead.data) {
                return false;
            }
            curr = curr.next;
            newHead = newHead.next;
        }
        return true;
    }

    private static Node getMid(Node head) {
        Node slow = head, fast = head;
        while(null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node reverse(Node head) {
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

}
