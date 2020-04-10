package linkedList;

public class _23_MergeKSortedLists {

	private static class Node<T extends Comparable> {
		T key;
		Node<T> next;

		public Node(T key) {
			this.key = key;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		// Create 1st List
		Node firstHead = new Node(12);
		firstHead.next = new Node(15);
		
		// Create 2nd list
		Node secondHead = new Node(4);
		secondHead.next = new Node(6);
		
		Node[] nodes = new Node[] {firstHead, secondHead};
		Node sortedHead = mergeKSortedLists(nodes, 0, nodes.length - 1);
		System.out.println("Sorted Key = " + sortedHead.key);
	}

	private static Node mergeKSortedLists(Node[] nodes, int start, int end) {

		if (start == end)
			return nodes[start];
		
		else if (start < end) {
			int mid = start + (end - start) / 2;
			Node leftNode = mergeKSortedLists(nodes, start, mid);
			Node rightNode = mergeKSortedLists(nodes, mid + 1, end);
			return merge2SortedLists(leftNode, rightNode);
			
		} else {
			return null;
		}
	}

	private static Node merge2SortedLists(Node<? extends Comparable> n1, Node<? extends Comparable> n2) {
		if (null == n1)
			return n2;
		
		if (null == n2)
			return n1;
		
		Node res;
		if (n1.key.compareTo(n2.key) <= 0) {
			res = n1;
			res.next = merge2SortedLists(n1.next, n2);
		} else {
			res = n2;
			res.next = merge2SortedLists(n1, n2.next);
		}
		return res;
	}

}
