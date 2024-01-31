package geeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversal {

    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        System.out.println(verticalOrder(root));

    }

    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root)
    {
        // add your code here
        Map<Integer, List<Integer>> map = new TreeMap<>();
        dfs(root, 0, map);
        System.out.println(map);
        ArrayList <Integer> res = new ArrayList<>();
        for(List<Integer> l : map.values()) {
            res.addAll(l);
        }
        return res;
    }

    private static void dfs(Node root, int level, Map<Integer, List<Integer>> map) {
        if(null == root) return;
        if(map.containsKey(level)) {
            List<Integer> current = map.get(level);
            current.add(root.data);
            map.put(level, current);
        } else {
            List<Integer> l = new ArrayList<>();
            l.add(root.data);
            map.put(level, l);
        }
        dfs(root.left, level-1, map);
        dfs(root.right, level + 1, map);
    }

}
