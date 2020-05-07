package tree;

public class Cousins_In_BT {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.val = key;
        }
    }

    private static boolean isCousins(TreeNode root, int x, int y) {
        int d1 = depthOfNode(root, x, 0);
        int d2 = depthOfNode(root, y, 0);
        if(d1 != d2)
            return false;
        TreeNode p1 = getParent(root, x);
        TreeNode p2 = getParent(root, y);
        return !(p1.val == p2.val);
    }

    private static TreeNode getParent(TreeNode root, int x) {
        if(null == root) return null;
        if(root.val == x)
            return null;
        if(null != root.left && root.left.val == x)
            return root;
        if(null != root.right && root.right.val == x)
            return root;
        TreeNode left = getParent(root.left, x);
        TreeNode right = getParent(root.right, x);
        return null != left ? left : right;
    }

    private static int depthOfNode(TreeNode root, int data, int depth) {
        if(null == root) return 0;
        if(root.val == data)
            return depth;
        int left = depthOfNode(root.left, data, depth + 1);
        if(left != 0)
            return left;
        return depthOfNode(root.right, data, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println("" + isCousins(root, 5, 4));
    }
}
