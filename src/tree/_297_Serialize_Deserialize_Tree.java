package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _297_Serialize_Deserialize_Tree {
	
	private static class Node {
		Integer key;
		Node left;
		Node right;
		
		public Node(Integer key) {
			this.key = key;
		}
	}
	
	private static String serialize(Node root) {
		if(null == root)
			return "#";
		String leftStr = serialize(root.left);
		String rightStr = serialize(root.right);
		return root.key + "," + leftStr + "," + rightStr;
	}
	
	private static Node deserialize(String input) {
		Queue<String> q = new LinkedList<String>();
		q.addAll(Arrays.asList(input.split(",")));
		return deserializeHelper(q);
	}
	
	private static Node deserializeHelper(Queue<String> q) {
		String str = q.poll();
		if(str.equals("#"))
			return null;
		
		Node root = new Node(Integer.parseInt(str));
		root.left = deserializeHelper(q);
		root.right = deserializeHelper(q);
		return root;
	}
	
	private static void printPreorder(Node root) {
		if(null == root)
			return;
		System.out.print(root.key + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(15);
		root.left = new Node(12);
		root.right = new Node(18);
		
		String serializedTree = serialize(root);
		System.out.println(serializedTree);
		
		Node r = deserialize(serializedTree);
		printPreorder(r);
		
	}

}
