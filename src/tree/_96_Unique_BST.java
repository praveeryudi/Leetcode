package tree;

import java.util.HashMap;
import java.util.Map;

public class _96_Unique_BST {

    public static void main(String[] args) {
        int res = getUniqueBSTs(5, new HashMap<>());
        System.out.println("# of unique bst = " + res);
    }

    private static int getUniqueBSTs(int n, Map<Integer, Integer> cache) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;

        if(cache.containsKey(n))
            return cache.get(n);

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            int left = getUniqueBSTs(i, cache);
            int right = getUniqueBSTs(n - i, cache);
            sum += left * right;
        }
        cache.put(n, sum);
        return sum;
    }

}
