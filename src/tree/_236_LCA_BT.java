package tree;

public class _236_LCA_BT {
	
	private static class Node<T> {
		
		T key;
		Node left;
		Node right;
		
		public Node(T key) {
			this.key = key;
			left = right =null;
		}
	}
	
	private static <T> Node getLCA(Node root, T data1, T data2) {
		if(null == root)
			return null;
		if(root.key == data1 || root.key == data2)
			return root;
		Node leftLCA = getLCA(root.left, data1, data2);
		Node rightLCA = getLCA(root.right, data1, data2);
		
		if(null != leftLCA && null != rightLCA)
			return root;
		
		return null != leftLCA ? leftLCA : rightLCA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> root = new Node(34);
		root.left = new Node(12);
		root.right = new Node(45);
		
		root.left.left = new Node(10);
		root.left.right = new Node(15);
		
		root.right.left = new Node(36);
		root.right.right = new Node(47);
		
		Node lca = getLCA(root, 36, 15);
		System.out.println("LCA = " + lca.key);

	}

}
