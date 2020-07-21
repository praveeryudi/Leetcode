package top100;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int N = 5;
        System.out.println("# of ways = " + climbStairs(N, new HashMap<>()));
    }

    private static int climbStairs(int n, Map<Integer, Integer> cache) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        int ways = climbStairs(n-2, cache) + climbStairs(n-1, cache);
        cache.put(n, ways);
        return ways;
    }

}
