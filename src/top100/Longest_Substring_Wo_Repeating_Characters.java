package top100;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Longest_Substring_Wo_Repeating_Characters {

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Longest substring = " + lengthOfLongestSubstring(input));
    }

    private static int lengthOfLongestSubstring(String str) {
        int max = 0;
        int start = 0;
        Set<Character> seen = new HashSet<>();
        while(start < str.length()) {
            int end = start;
            while(end < str.length() && !seen.contains(str.charAt(end)))
            {
                seen.add(str.charAt(end));
                end++;
            }
            max = Math.max(max, seen.size());
            seen.clear();
            start++;
        }
        return max;
    }
}
