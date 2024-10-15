package blind75.dp;

import java.util.HashMap;
import java.util.Map;

public class LCS {

    private static int lcs(String str1, int m, String str2, int n, Map<String, Integer> cache) {
        if(m == 0 || n == 0)
            return 0;
        String key = m + ":" + n;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        int res;
        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            res = 1 + lcs(str1, m-1, str2, n-1, cache);
        } else {
            int res1 = lcs(str1, m-1, str2, n, cache);
            int res2 = lcs(str1, m, str2, n-1, cache);
            res = Math.max(res1, res2);
        }
        cache.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println("LCS=" + lcs(str1, str1.length(), str2, str2.length(), new HashMap<>()));
    }

}
