package geeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftRightView {

    private static class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(2);

        root.right.left = new TreeNode<>(3);
        root.right.right = new TreeNode<>(1);

        root.right.left.left = new TreeNode<>(6);
        root.right.left.right = new TreeNode<>(7);

        System.out.println(getLeftView(root));
        System.out.println(getRightView(root));
    }

    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().data);
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
        return res;
    }

    public static ArrayList<Integer> getRightView(TreeNode<Integer> root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                if(size == 1) {
                    res.add(q.peek().data);
                }
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
        return res;
    }

}
