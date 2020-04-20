package _30daychallenge;

public class BST_From_Preorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,5,1,7,10,12};
        BST_From_Preorder bst = new BST_From_Preorder();
        TreeNode root = bst.bstFromPreOrder(arr);
        bst.doInorder(root);
    }

    private TreeNode bstFromPreOrder(int[] preorder) {
        if(null == preorder || preorder.length == 0)
            return null;
        return constructTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int start, int end) {
        if(start > end)
            return null;

        TreeNode root = new TreeNode(preorder[start]);
        if(start == end) {
            return root;
        }
        int i;
        for(i = start; i <= end; i++) {
            if(preorder[i] > root.val) {
                break;
            }
        }
        root.left = constructTree(preorder, start + 1, i-1);
        root.right = constructTree(preorder, i, end);
        return root;
    }

    private void doInorder(TreeNode root) {
        if(null == root) return;
        doInorder(root.left);
        System.out.print(root.val + " ");
        doInorder(root.right);
    }
}