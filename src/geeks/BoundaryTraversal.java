package geeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundaryTraversal {

    private static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    private static boolean isLeaf(Node node) {
        return null == node.left && null == node.right;
    }

    private static void leftBoundary(Node root, List<Integer> list) {
        if(null == root) return;
        if(null != root.left) {
            list.add(root.data);
            leftBoundary(root.left, list);
        } else if(null != root.right) {
            list.add(root.data);
            leftBoundary(root.right, list);
        } else {
            list.add(root.data);
        }
    }

    private static void rightBoundary(Node root, List<Integer> list) {
        if(null == root) return;
        if(null != root.right) {
            rightBoundary(root.right, list);
            list.add(root.data);
        } else if(null != root.left) {
            rightBoundary(root.left, list);
            list.add(root.data);
        } else {
            list.add(root.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(15);

        root.left.right = new Node(17);
        root.right.left = new Node(20);

        List<Integer> result = new ArrayList<>();
        result.add(root.data);
        leftBoundary(root.left, result);
        rightBoundary(root.right, result);
        System.out.println(result);
    }

}
