package blind75.dp;

import java.util.Arrays;

public class UniquePaths {

    private static int getPaths(int rows, int cols) {
        int[][] dp = new int[rows][cols];
        Arrays.fill(dp[0], 1);
        for(int[] row : dp) {
            Arrays.fill(row, 1);
        }

        for(int x = 1; x < rows; x++) {
            for(int y = 1; y < cols; y++) {
                dp[x][y] = dp[x-1][y] + dp[x][y-1];
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        System.out.println("Paths=" + getPaths(3, 2));
    }

}
