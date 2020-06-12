package solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {

    public static void main(String[] args) {
        String s1 = "axc";
        String s2 = "ahbgdc";
        isSubsequence(s1, s2);
    }

    private static boolean isSubsequence(String s, String t) {
        int lcsLength = lcs(s, s.length(), t, t.length(), new HashMap<>());
        System.out.println("LCS Length = " + lcsLength);
        return lcsLength == s.length();
    }

    private static int lcs(String str1, int m, String str2, int n, Map<String, Integer> cache) {
        if(m == 0 || n == 0)
            return 0;

        String key = m + ":" + n;
        if(cache.containsKey(key))
            return cache.get(key);

        int res;
        if(str1.charAt(m-1) == str2.charAt(n-1))
            res = 1 + lcs(str1, m-1, str2, n-1, cache);
        else {
            int r1 = lcs(str1, m-1, str2, n, cache);
            int r2 = lcs(str1, m, str2, n-1, cache);
            res = Math.max(r1, r2);
        }
        cache.put(key, res);
        return res;
    }
}
