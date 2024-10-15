package blind75.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static int getWays(int n, Map<Integer, Integer> cache) {
        if(n <= 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        int ways = getWays(n-2, cache) + getWays(n-1, cache);
        cache.put(n, ways);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println("# of ways = " + getWays(10, new HashMap<>()));
    }

}
