package tree;

import java.util.ArrayList;
import java.util.List;

public class _129_Root_To_Leaf_Sum {

    private static class Tree<T> {
        T value;
        Tree<T> left;
        Tree<T> right;

        Tree(T x) {
            value = x;
        }
    }

    private static List<List<Integer>> paths = new ArrayList<>();

    public static void main(String[] args) {
        Tree<Integer> root = new Tree<>(1);
        root.left = new Tree<>(0);
        root.right = new Tree<>(4);
        root.left.left = new Tree<>(3);
        root.left.right = new Tree<>(1);

        long sum = digitTreeSum(root);
        System.out.println("Sum of digits = " + sum);
    }

    private static long digitTreeSum(Tree<Integer> t) {
        getRootToLeafPath(t, new ArrayList<>());
        System.out.println(paths);
        long output = 0L;
        for (List<Integer> path : paths) {
            String num = "";
            for (Integer x : path) {
                num += String.valueOf(x);
            }
            output += Long.valueOf(num);
        }
        return output;
    }

    private static void getRootToLeafPath(Tree<Integer> root, List<Integer> current) {
        if (null == root)
            return;

        current.add(root.value);
        if (null == root.left && null == root.right) {
            paths.add(new ArrayList<>(current));
        }
        getRootToLeafPath(root.left, current);
        getRootToLeafPath(root.right, current);
        current.remove(current.size() - 1);
    }
}
