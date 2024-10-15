package tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {

    private static class BinaryTreeNode <T> {
        public T data;
        public BinaryTreeNode <T> left;
        public BinaryTreeNode <T> right;

        BinaryTreeNode (T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        System.out.println(rootToLeafSum(root));
    }

    public static int rootToLeafSum(BinaryTreeNode<Integer> root) {
        List<String> res = new ArrayList<>();
        dfs(root, new StringBuilder(), res);
        System.out.println(res);
        int sum = 0;
        for(String element : res) {
            sum += Long.parseLong(element) % 1000000007;
        }
        long i = 5307388143L;
        return sum;
    }

    private static void dfs(BinaryTreeNode<Integer> root, StringBuilder sb,
            List<String> res) {
        if (null == root) return;
        sb.append(root.data);
        if (null == root.left && null == root.right) {
            res.add(sb.toString());
        }
        dfs(root.left, sb, res);
        dfs(root.right, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }

}
