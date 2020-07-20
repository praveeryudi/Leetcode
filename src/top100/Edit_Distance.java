package top100;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class Edit_Distance {

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println("Minimum Edit Distance = " + minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {

        int rows = word1.length() + 1;
        int cols = word2.length() + 1;
        int[][] dp = new int[rows][cols];

        for(int r = 1; r < rows; r++)
            dp[r][0] = 1 + dp[r-1][0];

        for(int c = 1; c < cols; c++)
            dp[0][c] = 1 + dp[0][c-1];

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}
