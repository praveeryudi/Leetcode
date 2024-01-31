package geeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopBottomView {

    private static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static class Pair {
        int hd;
        TreeNode node;
        Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right.left = new TreeNode(90);
        root.right.right = new TreeNode(100);

        System.out.println(topView(root));
        System.out.println(bottomView(root));
    }

    private static List<Integer> topView(TreeNode root) {
        // hd <-> node value map
        Map<Integer, Integer> view = new TreeMap<>();
        // for level order traversal
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Pair p = q.poll();
                if(!view.containsKey(p.hd)) {
                    view.put(p.hd, p.node.data);
                }
                if(null != p.node.left) {
                    q.add(new Pair(p.hd - 1, p.node.left));
                }
                if(null != p.node.right) {
                    q.add(new Pair(p.hd + 1, p.node.right));
                }
                size--;
            }
        }
        return new ArrayList<>(view.values());
    }

    private static List<Integer> bottomView(TreeNode root) {
        // hd <-> node value map
        Map<Integer, Integer> view = new TreeMap<>();
        // for level order traversal
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Pair p = q.poll();
                view.put(p.hd, p.node.data);
                if(null != p.node.left) {
                    q.add(new Pair(p.hd - 1, p.node.left));
                }
                if(null != p.node.right) {
                    q.add(new Pair(p.hd + 1, p.node.right));
                }
                size--;
            }
        }
        return new ArrayList<>(view.values());
    }

}
