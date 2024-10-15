package tree;

public class NodeLevel {

    private static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);

        root.right.right = new BinaryTreeNode<>(6);
        System.out.println(nodeLevel(root, 20));
    }

    public static long nodeLevel(BinaryTreeNode<Integer> root, int node)
    {
        /*
		  Your class should be named Solution.
	 	  Read input as specified in the question.
	 	  Print output as specified in the question.
		*/
        return dfs(root, node, 1L);
    }

    private static long dfs(BinaryTreeNode<Integer> root, int M, long level) {
        if(null == root) {
            return 0;
        }
        if(root.data == M) {
            return 1;
        }
        long left = 1 + dfs(root.left, M, level + 1);
        long right = 1 + dfs(root.right, M, level + 1);
        return Math.max(left, right);
    }

}
