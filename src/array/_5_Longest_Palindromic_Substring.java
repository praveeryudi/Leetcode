package array;

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
    }

}
