package top100;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterBinaryTree {

    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private static int getDiameter(Node root) {
        if(null == root) return 0;
        int rootDiameter = getDepth(root.left) + getDepth(root.right);
        int leftDiameter = getDiameter(root.left);
        int rightDiameter = getDiameter(root.right);
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int getDepth(Node root) {
        if(null == root) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int dia = getDiameter(root);
        System.out.println("Diameter = " + dia);
    }

}
