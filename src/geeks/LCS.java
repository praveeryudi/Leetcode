package geeks;

import java.util.HashMap;
import java.util.Map;

public class LCS {

    private static int lcs(String s1, String s2) {

        int rows = s1.length() + 1;
        int cols = s2.length() + 1;

        int[][] dp = new int[rows][cols];
        for(int r = rows-2; r >= 0; r--) {
            for(int c = cols - 2; c >= 0; c--) {
                if(s1.charAt(r) == s2.charAt(c)) {
                    dp[r][c] = 1 + Math.max(dp[r+1][c], dp[r][c+1]);
                } else {
                    dp[r][c] = Math.max(dp[r+1][c], dp[r][c+1]);
                }
            }
        }
        return dp[0][0];
    }

    private static int lcsRecursive(String s1, int m, String s2, int n,
            Map<String, Integer> cache) {
        if (m == 0 || n == 0) {
            return 0;
        }
        String key = m + ":" + n;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int res;
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            res = 1 + lcsRecursive(s1, m - 1, s2, n - 1, cache);
        } else {
            int res1 = lcsRecursive(s1, m - 1, s2, n, cache);
            int res2 = lcsRecursive(s1, m, s2, n - 1, cache);
            res = Math.max(res1, res2);
        }
        cache.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        int res = lcs(s1, s2);
        System.out.println(res);
        int res2 = lcsRecursive(s1, s1.length(), s2, s2.length(), new HashMap<>());
        System.out.println(res2);
    }

}
