package tree;

import java.util.ArrayList;
import java.util.List;

public class _1302_Deepest_Leaves_Sum {
	
	private static class TreeNode {
		Integer key;
		TreeNode left;
		TreeNode right;
		
		TreeNode(Integer key) {
			this.key = key;
		}
	}

	private static List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    private static int deepestLeavesSum(TreeNode root) {
        if(null == root)
            return 0;
        helper(root, 0);
        List<Integer> lastLevel = result.get(result.size() - 1);
        return lastLevel.stream().mapToInt(x -> x).sum();
    }
    
    private static void helper(TreeNode root, int level) {
        if(result.size() == level) {
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(root.key);
        
        if(null != root.left)
            helper(root.left, level + 1);
        if(null != root.right)
            helper(root.right, level + 1);
    }
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(34);
		root.left = new TreeNode(12);
		root.right = new TreeNode(45);
		
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(15);
		
		root.right.left = new TreeNode(36);
		root.right.right = new TreeNode(47);
		
		int deepestSum = deepestLeavesSum(root);
		System.out.println("Deepest Sum = " + deepestSum);
	}

}
