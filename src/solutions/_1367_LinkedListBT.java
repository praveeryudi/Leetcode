package solutions;

public class _1367_LinkedListBT {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static boolean isSubPath(ListNode head, TreeNode root) {
        if(null == head) return true;
        if(null == root) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean dfs(ListNode head, TreeNode root) {
        if(null == head) return true;
        if(null == root) return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);
        System.out.println(isSubPath(head, root));
    }

}
