package tree;

public class SubtreeSum {

    private static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer val) {
            this.val = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        setSubtreeSum(root);
        preorder(root);
    }

    private static int setSubtreeSum(TreeNode root) {
        if(null == root) return 0;
        if(null == root.left && null == root.right) return root.val;
        int leftSum = setSubtreeSum(root.left);
        int rightSum = setSubtreeSum(root.right);
        root.val += leftSum + rightSum;
        return root.val;
    }

    private static void preorder(TreeNode root) {
        if(null == root) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

}
