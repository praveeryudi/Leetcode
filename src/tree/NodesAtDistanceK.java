package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NodesAtDistanceK {

    private static class BinaryTreeNode<T> {

        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null; right = null;
        }
    }

    private static void markParents(BinaryTreeNode<Integer> root, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> pMap) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        pMap.put(root, null);
        while(!q.isEmpty()) {
            BinaryTreeNode<Integer> curr = q.poll();
            if(null != curr.left) {
                q.offer(curr.left);
                pMap.put(curr.left, curr);
            }
            if(null != curr.right) {
                q.offer(curr.right);
                pMap.put(curr.right, curr);
            }
        }
    }

    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int K) {
        // Write your code here.
        List<BinaryTreeNode<Integer>> res = new ArrayList<>();
        if(null == root)
            return res;
        // Create parent pointers map
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> pMap = new HashMap<>();
        markParents(root, pMap);

        // Set of visited nodes
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
        visited.add(target);

        // Queue for BFS
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(target);

        int level = 0;
        while(!q.isEmpty()) {
            if(level == K) {
                break;
            }
            int size = q.size();
            while(size > 0) {
                BinaryTreeNode<Integer> curr = q.poll();
                if(null != curr.left && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(null != curr.right && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                if(pMap.containsKey(curr)) {
                    BinaryTreeNode<Integer> parent = pMap.get(curr);
                    if(null != parent && !visited.contains(parent)) {
                        q.offer(parent);
                        visited.add(parent);
                    }
                }
                size--;
            }
            level++;
        }

        while(!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;

    }

}
