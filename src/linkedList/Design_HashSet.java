package linkedList;

public class Design_HashSet {

    private static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private Node[] buckets;

    /** Initialize your data structure here. */
    Design_HashSet() {
        this.buckets = new Node[16];
    }

    private void add(int key) {
        Node newNode = new Node(key);
        int index = hash(key);
        if(null == buckets[index]) {
            buckets[index] = newNode;
            return;
        }

        Node start = buckets[index];
        Node prev = null;
        while(null != start) {
            prev = start;
            if(start.key == key)
                return;
            start = start.next;
        }
        prev.next = newNode;
    }

    private void remove(int key) {
        int index = hash(key);
        if(null == buckets[index])
            return;
        Node head = buckets[index];
        if(head.key == key) {
            Node next = head.next;
            head.next = null;
            buckets[index] = next;
            return;
        }

        Node curr = head;
        Node prev = null;
        while(null != curr.next) {
            prev = curr;
            if(curr.next.key == key) {
                break;
            }
            curr = curr.next;
        }
        prev.next = curr.next;
        curr.next = null;
    }

    /** Returns true if this set contains the specified element */
    private boolean contains(int key) {
        int index = hash(key);
        if(null == buckets[index])
            return false;
        Node head = buckets[index];
        while(null != head) {
            if(head.key == key)
                return true;
            head = head.next;
        }
        return false;
    }

    private int hash(int data) {
        return data % 16;
    }

    public static void main(String[] args) {
        Design_HashSet hs = new Design_HashSet();
        hs.add(1);
        hs.add(2);
        hs.contains(1);
        hs.contains(3);
        hs.add(2);
        hs.contains(2);
        hs.remove(2);
        hs.contains(2);
    }

}
