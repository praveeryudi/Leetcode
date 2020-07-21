package top100;

import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
    public static void main(String[] args) {
        int[][] sq = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };
        int result = getMaxArea(sq);
        System.out.println("Maximal Area = " + result);
    }

    private static int getMaxArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        int max = dp[0][0];

        for(int c = 1; c < cols; c++)
            dp[0][c] = grid[0][c];

        for(int r = 1; r < rows; r++)
            dp[r][0] = grid[r][0];

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(grid[i][j] != 0) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
