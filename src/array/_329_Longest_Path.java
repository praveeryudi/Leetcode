package array;

public class _329_Longest_Path {

    public static void main(String[] args) {
        int[][] nums = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };

        int[][] dp = new int[nums.length][nums[0].length];

        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++) {
            for(int j = 0; j < nums[0].length; j++) {
                if(dp[i][j] == 0) {
                    dfs(nums, i, j, dp, Integer.MIN_VALUE);
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        System.out.println("Maximum length of increasing path = " + maxLength);
    }

    private static int dfs(int[][] grid, int i, int j, int[][] dp, int prev) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] <= prev)
            return 0;

        if(dp[i][j] != 0)
            return dp[i][j];

        int left = dfs(grid, i, j-1, dp, grid[i][j]);
        int up = dfs(grid, i-1, j, dp, grid[i][j]);
        int right = dfs(grid, i, j+1, dp, grid[i][j]);
        int down = dfs(grid, i+1, j, dp, grid[i][j]);

        dp[i][j] = 1 + getMax(left, up, right, down);
        return dp[i][j];
    }

    private static int getMax(int a, int b, int c, int d) {
        int min1 = Math.max(a,b);
        int min2 = Math.max(c, d);
        return Math.max(min1, min2);
    }
}
