package linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class _147_InsertionSort {

    private static class ListNode {
        int key;
        ListNode next;
        ListNode(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private static ListNode insertionSort(ListNode head) {

        Queue<ListNode> q = new LinkedList<>();
        ListNode curr = head;
        while(null != curr) {
            q.add(curr);
            curr = curr.next;
        }

        ListNode newHead = null;
        while(!q.isEmpty()) {
            ListNode temp = q.poll();
            temp.next = null;

            // Case 1. If new head is null
            if(null == newHead) {
                newHead = temp;
                continue;
            }
            // Case 2. If the node in question is having less value than new head
            if(temp.key < newHead.key) {
                temp.next = newHead;
                newHead = temp;
                continue;
            }

            ListNode n = newHead;
            ListNode prev = null;
            while(null != n && n.key <= temp.key) {
                prev = n;
                n = n.next;
            }

            prev.next = temp;
            temp.next = n;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(4);
        start.next = new ListNode(2);
        start.next.next = new ListNode(1);
        start.next.next.next = new ListNode(3);
        ListNode k = insertionSort(start);
        while(null != k) {
            System.out.print(k.key + " ");
            k = k.next;
        }
    }
}
