package tree;

import java.util.LinkedList;
import java.util.Queue;

public class _662_Max_Width_BT {

    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.key = key;
            left = right = null;
        }
        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    private static class Pair<TreeNode, Integer> {
        TreeNode treeNode;
        Integer index;
        Pair(TreeNode treeNode, Integer index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }

    private static int widthOfBinaryTree(TreeNode root) {
        if(null == root) return 0;

        int maxWidth = Integer.MIN_VALUE;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()) {

            int size = q.size();
            Pair<TreeNode, Integer> first = q.peek();
            Pair<TreeNode, Integer> curr = null;
            while(size > 0) {
                curr = q.poll();
                int currIndex = curr.index;
                if(null != curr.treeNode.left) {
                    q.offer(new Pair<>(curr.treeNode.left, 2 * currIndex));
                }
                if(null != curr.treeNode.right) {
                    q.offer(new Pair<>(curr.treeNode.right, 2 * currIndex + 1));
                }
                size--;
            }
            int currWidth = curr.index - first.index + 1;
            maxWidth = Math.max(maxWidth, currWidth);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        int maximumWidth = widthOfBinaryTree(root);
        System.out.println("Max Width = " + maximumWidth);
    }

}
