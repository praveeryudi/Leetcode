package linkedList;

public class _19_RemoveNthNode {
	
	private static class Node<T extends Comparable<T>> {
		T key;
		Node<T> next;

		public Node(T key) {
			this.key = key;
			this.next = null;
		}
	}


	public static void main(String[] args) {

		int n = 3;
		Node start = new Node(12);
		start.next = new Node(2);
		start.next.next = new Node(32);
		start.next.next.next = new Node(22);
		
		Node target = removeNthNode(start, n);
		while(null != target) {
			System.out.print(target.key + " ");
			target = target.next;
		}
	}
	
	private static Node removeNthNode(Node head, int n) {
		Node fastPtr = head, slowPtr = head;
		int i = 0;
		while(i < n && null != fastPtr)
		{
			i++;
			fastPtr = fastPtr.next;
		}
		
		if(null == fastPtr) {
			head = head.next;
			return head;
		}
		
		System.out.println("Fast Ptr = " + fastPtr.key);
		
		while(null != fastPtr.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		Node temp = slowPtr.next;
		slowPtr.next = temp.next;
		temp.next = null;
		return head;
	}

}
