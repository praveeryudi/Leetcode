package top100;

/**
 * Invert a binary tree.
 */
public class InvertBT {
    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        Node n = invert(root);
    }

    private static Node invert(Node root) {
        helper(root);
        return root;
    }

    private static void helper(Node root) {
        if (null == root)
            return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }
}
