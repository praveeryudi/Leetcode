package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _5_Longest_Palindromic_Substring {

    public static void main(String[] args) {
        String input = "babad";
        int len = input.length();
        boolean[][] dp = new boolean[len][len];

        for(int r = 0; r < 2; r++) {
            for(int c = 0; c < len; c++) {
                dp[0][c] = true;
            }
        }

        int maxLength = 1;
        // Start from 3rd row
        for(int r = 2; r < len; r++) {
            for(int c = 0; c < len; c++) {
                if(c >= r-1) {
                    String sub = input.substring(c-r+1, c+1);
                    if(sub.charAt(0) == sub.charAt(sub.length()-1)) {
                        dp[r][c] = dp[r-2][c-1];
                        maxLength = Math.max(maxLength, r);
                    }
                }
            }
        }

        System.out.println("Max Length palindromic substring :: " + maxLength);
        // Method 2
        System.out.println("Max Length palindromic substring :: " + lps("babad"));
    }

    private static class Palindrome {
        int index;
        String str;
        Palindrome(int index, String str) {
            this.index = index;
            this.str = str;
        }
        @Override
        public String toString() {
            return index + ":" + str;
        }
    }

    private static int lps(String str) {
        if(null == str || str.isEmpty()) return 0;
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        List<Palindrome> palindromes = new ArrayList<>();

        for(int L = 1; L <= n; L++) {
            for(int start = 0; start + L - 1 < n; start++) {
                int end = start + L - 1;
                if(start == end) {
                    dp[start][end] = true;
                } else if(start + 1 == end) {
                    dp[start][end] = str.charAt(start) == str.charAt(end);
                } else {
                    if(str.charAt(start) == str.charAt(end) && dp[start+1][end-1]) {
                        dp[start][end] = true;
                    }
                }
                if(dp[start][end]) {
                    palindromes.add(new Palindrome(start, str.substring(start, end + 1)));
                    max = Math.max(max, end-start+1);
                }
            }
        }
        palindromes.sort((p1, p2) -> {
            if (p1.str.length() == p2.str.length()) {
                return p1.index - p2.index;
            } else {
                return p2.str.length() - p1.str.length();
            }
        });
        System.out.println(palindromes);
        return max;
    }

}
