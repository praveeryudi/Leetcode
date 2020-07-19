package top100;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 */
public class SymmetricTree {
	
	private static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
			left = right = null;
		}
	}
	
	private static boolean isSymmetric(TreeNode t1, TreeNode t2) {
		if(null == t1 && null == t2) return true;
		if(null == t1 || null == t2) return false;
		if(t1.key != t2.key) return false;
		return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println("Is Tree Symmetric = " + isSymmetric(root.left, root.right));
	}

}
