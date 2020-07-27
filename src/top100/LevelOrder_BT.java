package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree,
 * return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class LevelOrder_BT {

    private static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);

        root.right.left = new Node(15);
        root.right.right = new Node(7);

        List<List<Integer>> levels = new ArrayList<>();
        levelOrder(0, root, levels);
        System.out.println(levels);
    }

    private static void levelOrder(int level, Node root, List<List<Integer>> levels) {
        if(level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.key);
        if(null != root.left)
            levelOrder(level + 1, root.left, levels);
        if(null != root.right)
            levelOrder(level + 1, root.right, levels);
    }

}
