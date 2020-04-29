package _30daychallenge;

public class Max_Path_Sum_BT {

    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private static int findMaxPathSum(Node root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        getMaxSum(root, max);
        return max[0];
    }

    private static int getMaxSum(Node root, int[] max) {
        if(null == root) return 0;
        int left = getMaxSum(root.left, max);
        int right = getMaxSum(root.right, max);
        if(left < 0) left = 0;
        if(right < 0) right = 0;
        int single_max = Math.max(root.key, root.key + Math.max(left, right));
        max[0] = Math.max(max[0], Math.max(single_max, root.key + left + right));
        return single_max;
    }

    public static void main(String[] args) {
        Node root = new Node(-5);
        root.left = new Node(-3);
        root.right = new Node(-4);
        System.out.println("Max Path Sum = " + findMaxPathSum(root));
    }
}
