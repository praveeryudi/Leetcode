package tree;

import java.util.ArrayList;
import java.util.List;

public class _1469_Lonely_Nodes {

    private static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private static List<Integer> lonelyNodes = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(2);
        findLonelyNodes(root);
        System.out.println(lonelyNodes);
    }

    private static void findLonelyNodes(TreeNode root) {
        if(null == root)
            return;
        if(null != root.left && null == root.right)
            lonelyNodes.add(root.left.key);
        if(null != root.right && null == root.left)
            lonelyNodes.add(root.right.key);
        findLonelyNodes(root.left);
        findLonelyNodes(root.right);
    }

}
