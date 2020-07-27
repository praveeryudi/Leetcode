package top100;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] nums = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int rows = nums.length;
        int cols = nums[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = nums[0][0];
        for(int r = 1; r < rows; r++) {
            dp[r][0] = nums[r][0] + dp[r-1][0];
        }
        for(int c = 1; c < cols; c++) {
            dp[0][c] = nums[0][c] + dp[0][c-1];
        }
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                dp[i][j] = nums[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        int min = dp[rows-1][cols-1];
        System.out.println("Min weight path sum = " + min);
    }

}
