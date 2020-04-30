package _30daychallenge;

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence,
 * check if a given string is a valid sequence in such binary tree.
 */
public class String_Path_In_Tree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean isValidSequence(TreeNode root, int[] arr) {
        if(null == root || arr.length == 0)
            return false;
        return isValid(root, arr, 0);
    }

    private static boolean isValid(TreeNode root, int[] arr, int index) {
        if(root.val != arr[index])
            return false;
        if(index == arr.length - 1)
            return (null == root.left) && (null == root.right);

        return (null != root.left && isValid(root.left, arr, index + 1)) ||
                (null != root.right && isValid(root.right, arr, index + 1));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.left.right = new TreeNode(1);

        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);

        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);

        int[] arr = new int[]{0,1,0,1};
        boolean isValid = isValidSequence(root, arr);
        System.out.println("Path Exists = " + isValid);
    }
}
