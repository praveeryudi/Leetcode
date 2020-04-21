package _30daychallenge;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {

    private static class TreeNode<T> {
        T key;
        TreeNode left;
        TreeNode right;
        TreeNode(T key) {
            this.key = key;
        }
    }

    private static int getDiameter(TreeNode root) {
        if(null == root) return 0;
        int rootDia = getDepth(root.left) + getDepth(root.right);
        int leftDia = getDiameter(root.left);
        int rightDia = getDiameter(root.right);
        return Math.max(rootDia, Math.max(leftDia, rightDia));
    }

    private static int getDepth(TreeNode node) {
        if(null == node) return 0;
        int leftD = getDepth(node.left);
        int rightD = getDepth(node.right);
        return 1 + Math.max(leftD, rightD);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(6);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(13);

        root.left.left = new TreeNode<>(14);
        root.left.right = new TreeNode<>(11);

        int dia = getDiameter(root);
        System.out.println("Diameter = " + dia);
    }
}
