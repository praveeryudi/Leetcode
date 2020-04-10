package linkedList;

public class _234_Palindrome_Linked_List {
	
	private static class Node{
		int key;
		Node next;
		
		public Node(int key) {
			this.key = key;
		}
	}
	
	private static boolean isLinkedListPalindrome(Node head) {
		
		Node slow = head, fast = head;
		while(null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		slow = reverse(slow);
		fast = head;
		while(null != slow) {
			if(slow.key != fast.key)
				return false;
			slow =slow.next;
			fast = fast.next;
		}
		return true;
	}
	
	/**
	 * Generic code to reverse a SLL.
	 * @param head
	 * @return Node
	 */
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

	public static void main(String[] args) {

		Node start = new Node(3);
		start.next = new Node(2);
		start.next.next = new Node(1);
		start.next.next.next = new Node(1);
		start.next.next.next.next = new Node(2);
		start.next.next.next.next.next = new Node(3);
		
		System.out.println("Is Linked List Palindrome = " + isLinkedListPalindrome(start));
	}

}
