package top100;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class LCA_BT {

    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private static Node getLCA(Node root, int a, int b) {
        if(null == root) return null;
        if(root.key == a || root.key == b) return root;
        Node left = getLCA(root.left, a, b);
        Node right = getLCA(root.right, a, b);
        if(null != left && null != right)
            return root;
        return null != left ? left : right;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node res = getLCA(root, 4, 3);
        System.out.println(res.key);
    }
}
