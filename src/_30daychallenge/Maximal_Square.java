package _30daychallenge;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class Maximal_Square {

    private static int maximalSquare(char[][] matrix) {

        if(null == matrix || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0] == '0' ? 0 : 1;
        int max = dp[0][0];

        // Fill 1st column
        for(int r = 1; r < rows; r++) {
            dp[r][0] = Character.getNumericValue(matrix[r][0]);
            max = Math.max(max, dp[r][0]);
        }

        // Fill 1st row
        for(int c = 1; c < cols; c++) {
            dp[0][c] = Character.getNumericValue(matrix[0][c]);
            max = Math.max(max, dp[0][c]);
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','0', '1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println("Maximal Square Area = " + maximalSquare(grid));
    }
}
