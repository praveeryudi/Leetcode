package top100;

public class RemoveNthNode {
	
	private static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }
	
	private static Node removeNthNode(Node head, int n) {
		
		Node slow = head;
		Node fast = head;
		int k = 0;
		while(null != fast && k < n) {
			fast = fast.next;
			k++;
		}
		if(null == fast) {
			return head.next;
		}
			
		while(null != fast.next) {
			fast = fast.next;
			slow = slow.next;
		}
		
		Node nodeToBeDeleted = slow.next;
		slow.next = nodeToBeDeleted.next;
		nodeToBeDeleted.next = null;
		nodeToBeDeleted = null;
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next = new Node(3);
		start.next.next.next = new Node(4);
		start.next.next.next.next = new Node(5);
		
		int n = 2;
		Node newNode = removeNthNode(start, n);
		// Verify
		while(null != newNode) {
			System.out.print(newNode.key + " ");
			newNode = newNode.next;
		}
		
	}

}
