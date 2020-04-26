package _30daychallenge;

public class Longest_Common_Subsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("LCS = " + lcs(text1, text2));
    }

    private static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else {
                    int temp1 = dp[i-1][j];
                    int temp2 = dp[i][j-1];
                    dp[i][j] = Math.max(temp1, temp2);
                }
            }
        }
        return dp[m][n];
    }

}
