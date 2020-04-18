package _30daychallenge;

public class MinPathSum {

    private static int minPathSum(int[][] grid) {

        if(null == grid || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        // Fill the 1st column
        for(int r = 1; r < rows; r++) {
            dp[r][0] = dp[r-1][0] + grid[r][0];
        }

        // Fill the 1st row
        for(int c = 1; c < cols; c++) {
            dp[0][c] = dp[0][c-1] + grid[0][c];
        }

        // Fill the remaining cells
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        int result = minPathSum(grid);
        System.out.println("Minimum Path Sum = " + result);
    }
}
