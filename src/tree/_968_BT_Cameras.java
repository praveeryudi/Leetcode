package tree;

public class _968_BT_Cameras {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    private static class Pair {
        boolean hasCamera;
        boolean isMonitored;
        Pair(boolean hasCamera, boolean isMonitored) {
            this.hasCamera = hasCamera;
            this.isMonitored = isMonitored;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        Pair p = helper(root);
        // If root node is NOT monitored
        if(!p.isMonitored) {
            count++;
        }
        System.out.println("# of cameras: " + count);
    }

    private static int count = 0;

    private static Pair helper(TreeNode root) {
        if(null == root) {
            return new Pair(false, true);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        boolean hasCamera = false;
        boolean isMonitored = false;

        // If either left child or right child has camera
        if(left.hasCamera || right.hasCamera) {
            isMonitored = true;
        }
        // If neither child is monitored or only one child is monitored
        if(!left.isMonitored || !right.isMonitored) {
            hasCamera = true;
            isMonitored = true;
            count ++;
        }
        return new Pair(hasCamera, isMonitored);
    }

}
