package linkedList;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    private static class Node {
        int value;
        Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Deque<Node> dq;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
        this.dq = new LinkedList<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            System.out.println("Key" + key + " not found");
            return -1;
        } else {
            Node existingNode = map.get(key);
            map.remove(key);
            dq.remove(existingNode);
            map.put(key, existingNode);
            dq.addFirst(existingNode);
            return existingNode.value;
        }
    }

    public void put(int key, int value) {

        if(map.isEmpty()) {
            Node newNode = new Node(value);
            dq.add(newNode);
            map.put(key, newNode);
        } else if(map.containsKey(key)) {
            Node existingNode = map.get(key);
            map.remove(key);
            dq.remove(existingNode);
            dq.addFirst(existingNode);
            existingNode.value = value;
            map.put(key, existingNode);
        } else if(map.size() == capacity) {
            Node last = dq.removeLast();
            for(Map.Entry<Integer, Node> entry : map.entrySet()) {
                if(entry.getValue() == last) {
                    map.remove(entry.getKey());
                    break;
                }
            }
            Node newNode = new Node(value);
            dq.addFirst(newNode);
            map.put(key, newNode);
        } else {
            Node newNode = new Node(value);
            map.put(key, newNode);
            dq.addFirst(newNode);
        }
    }

    @Override
    public String toString() {
        return dq.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        System.out.println(cache);
        cache.put(2,2);
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.put(3,3);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
        cache.put(4,4);
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.get(3);
        System.out.println(cache);
        cache.get(4);
        System.out.println(cache);
    }
}
