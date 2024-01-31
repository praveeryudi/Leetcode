package tree;

public class LongestUnivaluePath {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(4);

        getLongestUnivalPath(root);
        System.out.println("Longest path :: " + max);
    }

    private static int max = 0;

    private static int getLongestUnivalPath(TreeNode root) {
        if(null == root) return 0;
        int left = getLongestUnivalPath(root.left);
        if(null != root.left && root.val == root.left.val) {
            left++;
        }
        int right = getLongestUnivalPath(root.right);
        if(null != root.right && root.val == root.right.val) {
            right++;
        }
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

}