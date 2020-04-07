package tree;

public class _105_Construct_Tree_Inorder_Preorder {
	
	private static class Node {
		int key;
		Node left;
		Node right;
		
		Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}
	
	private static int preIndex = 0;
	
	/**
	 * Builds the binary tree recursively.
	 * @param preorder
	 * @param inorder
	 * @param start
	 * @param end
	 * @return Node
	 */
	private static Node buildTree(int[] preorder, int[] inorder, int start, int end) {
		if(start > end)
			return null;
		Node root = new Node(preorder[preIndex++]);
		if(start == end)
			return root;
		int index = search(inorder, root.key, start, end);
		root.left = buildTree(preorder, inorder, start, index - 1);
		root.right = buildTree(preorder, inorder, index + 1, end);
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
		
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7};
		
		Node root = buildTree(preorder, inorder, 0, inorder.length-1);
		doInorder(root);

	}

}
