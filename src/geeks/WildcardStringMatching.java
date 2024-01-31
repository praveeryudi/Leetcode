package geeks;

public class WildcardStringMatching {

    private static boolean match(String wild, String pattern)
    {
        // code here

        // DP: cols = no of chars in pattern + 1
        // rows = no of chars in wild + 1

        int rows = wild.length() + 1;
        int cols = pattern.length() + 1;

        boolean[][] dp = new boolean[rows][cols];
        dp[rows-1][cols-1] = true;

        for(int r = 0; r <= rows-2; r++) {
            if(wild.charAt(r) == '*') {
                dp[r][cols-1] = dp[r+1][cols-1];
                break;
            }
        }

        for(int r = rows-2; r >= 0; r--) {
            for(int c = cols-2; c >= 0; c--) {

                char wildChar = wild.charAt(r);
                char patternChar = pattern.charAt(c);

                // Case 1. If different character
                if(Character.isLetter(wildChar) && wildChar != patternChar) {
                    dp[r][c] = false;
                }
                // Case 2. If same character
                else if(Character.isLetter(wildChar) && wildChar == patternChar) {
                    dp[r][c] = dp[r+1][c+1];
                }
                // Case 3. If '?' for wild character
                else if(wildChar == '?') {
                    dp[r][c] = dp[r+1][c+1];
                }
                // Case 4. If '*' for wild character
                else {
                    dp[r][c] = dp[r+1][c] || dp[r][c+1];
                }
            }
        }

        // Print
        for(int r = rows-1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                System.out.print(dp[r][c] + " ");
            }
            System.out.println("");
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        boolean res = match("uvm*lxusn?reiaxaqhkxiksrqcuurvyfykidpfh", "uvmewlfxusnhreiaxaqhkxiksrqcuurvyfykidzpfh");
        System.out.println(res);
    }
}
