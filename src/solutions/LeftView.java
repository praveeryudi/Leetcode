package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    private static class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(2);
        root.left = new TreeNode<>(35);
        root.right = new TreeNode<>(10);

        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(2);
        printLeftView(root);
    }

    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.

        StringBuilder res = new StringBuilder();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            res.append(q.peek().data).append(" ");
            while(size > 0) {
                TreeNode<Integer> temp = q.poll();
                if(null != temp.left) {
                    q.add(temp.left);
                }
                if(null != temp.right) {
                    q.add(temp.right);
                }
                size--;
            }
        }
        System.out.println(res);
    }
}
