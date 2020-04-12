package tree;

import java.util.LinkedList;
import java.util.Queue;

public class _1373_MaximumSum_BST {

    private static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer val) {
            this.val = val;
            left = right = null;
        }
    }

    static int maxSumBST(TreeNode root) {
        if(null == root) return 0;
        int max = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode curr = root;
        q.add(curr);
        while(!q.isEmpty()) {
            curr = q.poll();
            if(isBST(curr, Long.MIN_VALUE, Long.MAX_VALUE)) {
                int sum = getSubtreeSum(curr);
                max = Math.max(max, sum);
            }
            if(null != curr.left)
                q.add(curr.left);
            if(null != curr.right)
                q.add(curr.right);
        }
        return max;
    }

    private static int getSubtreeSum(TreeNode node) {
        if(null == node)
            return 0;
        return node.val + getSubtreeSum(node.left) + getSubtreeSum(node.right);
    }

    private static boolean isBST(TreeNode root, Long min, Long max) {
        if(null == root)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return isBST(root.left, min, Long.valueOf(root.val)) && isBST(root.right, Long.valueOf(root.val), max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-4);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-5);

        int res = maxSumBST(root);
        System.out.println("Maximum Sum = " + res);
    }
}
