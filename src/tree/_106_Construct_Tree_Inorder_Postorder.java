package tree;

public class _106_Construct_Tree_Inorder_Postorder {
	
	private static class Node {
		int key;
		Node left;
		Node right;
		
		Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}
	
	private static int postIndex = 0;
	
	/**
	 * Builds the binary tree recursively.
	 * @param postorder
	 * @param inorder
	 * @param start
	 * @param end
	 * @return Node
	 */
	private static Node buildTree(int[] postorder, int[] inorder, int start, int end) {
		if(start > end)
			return null;
		Node root = new Node(postorder[postIndex++]);
		if(start == end)
			return root;
		
		int index = search(inorder, root.key, start, end);
		root.right = buildTree(postorder, inorder, index + 1, end);
		root.left = buildTree(postorder, inorder, start, index - 1);
		return root;
	}
	
	/**
	 * Search the index of the root element in inorder array. 
	 * @param inorder
	 * @param target
	 * @param start
	 * @param end
	 * @return integer
	 */
	private static int search(int[] inorder, int target, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(inorder[i] == target)
				return i;
		}
		return -1;
	}

	/**
	 * Method to verify the returned tree is correct.
	 * @param root
	 */
	private static void doInorder(Node root) {
		if(null == root)
			return;
		doInorder(root.left);
		System.out.print(root.key + " ");
		doInorder(root.right);
	}

	public static void main(String[] args) {
		
		int[] postorder = new int[] {9,15,7,20,3};
		int[] inorder = new int[] {9,3,15,20,7};
		
		Node root = buildTree(postorder, inorder, 0, inorder.length-1);
		doInorder(root);

	}

}
