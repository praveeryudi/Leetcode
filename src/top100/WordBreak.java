package top100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));
        String wordToBreak = "leetcode";
        boolean[] dp = new boolean[1 + wordToBreak.length()];
        dp[0] = true;

        for(int low = 0; low < wordToBreak.length(); low++) {
            if(!dp[low])
                continue;
            for(int high = low + 1; high <= wordToBreak.length(); high++) {
                String s = wordToBreak.substring(low, high);
                if(dict.contains(s))
                    dp[high] = true;
            }
        }
        System.out.println("Can be broken = " + dp[wordToBreak.length()]);
    }

}
