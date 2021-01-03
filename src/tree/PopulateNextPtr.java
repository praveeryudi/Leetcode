package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPtr {

    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {}

        Node(int _val) {
            val = _val;
        }

        Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    private static Node connect(Node root) {

        if(null == root)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node temp = q.poll();
                if(size == 1) {
                    temp.next = null;
                }
                else {
                    temp.next = q.peek();
                }
                if(null != temp.left)
                    q.add(temp.left);
                if(null != temp.right)
                    q.add(temp.right);
                size--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);
    }

}
