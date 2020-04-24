package _30daychallenge;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 */
public class LRUCache {

    private class Node {
        Integer data;
        Node(Integer data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Map<Integer, Node> map;
    private Deque<Node> cache;
    private Integer capacity;

    private LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        cache = new LinkedList<>();
        this.capacity = capacity;
    }

    private int get(int key) {
        if(map.containsKey(key)) {
            Node value = map.get(key);
            cache.remove(value);
            map.remove(key); // need to remove to retain the insertion order.
            map.put(key, value);
            cache.addFirst(value);
            return value.data;
        }
        else {
            return -1;
        }
    }

    private void put(int key, int value) {

        if(cache.size() == capacity && !map.containsKey(key)) {
            Node lastValue = cache.removeLast();
            Iterator<Map.Entry<Integer, Node>> itr = map.entrySet().iterator();
            while(itr.hasNext()) {
                Map.Entry<Integer, Node> entry = itr.next();
                if(entry.getValue().data.equals(lastValue.data)) {
                    map.remove(entry.getKey());
                    break;
                }
            }
            Node newNode = new Node(value);
            cache.addFirst(newNode);
            map.put(key, newNode);
        }

        else if(map.containsKey(key)) {
            Node val = map.get(key);
            cache.remove(val);
            map.remove(key);
            Node newNode = new Node(value);
            map.put(key, newNode);
            cache.addFirst(newNode);
        }
        else {
            Node newNode = new Node(value);
            map.put(key, newNode);
            cache.addFirst(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2,1);
        obj.put(1,1);
        System.out.println(obj.get(2));
        obj.put(4,1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
    }
}