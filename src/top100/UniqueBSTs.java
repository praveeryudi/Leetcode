package top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */
public class UniqueBSTs {

    public static void main(String[] args) {
        int N = 3;
        int result = getBSTCount(N, new HashMap<>());
        System.out.println("# of unique BST = " + result);
    }

    private static int getBSTCount(int n, Map<Integer, Integer> cache) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        int count = 0;
        for(int i = 1; i <= n; i++) {
            count += getBSTCount(n-i, cache) * getBSTCount(i-1, cache);
        }
        cache.put(n, count);
        return count;
    }
}
