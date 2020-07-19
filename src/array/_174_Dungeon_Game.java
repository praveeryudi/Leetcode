package array;

import java.util.Arrays;

public class _174_Dungeon_Game {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {-2, -3,3},
                {-5,-10,1},
                {10,30,-5}
        };

        int health = getMinHealth(grid);
        System.out.println("Minimum Health = " + health);
    }

    private static int getMinHealth(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows+1][cols+1];
        for(int r = 0; r <= rows; r++) {
            Arrays.fill(dp[r], Integer.MAX_VALUE);
        }

        dp[rows][cols-1] = 1;
        dp[rows-1][cols] = 1;

        for(int i = rows-1; i >=0; i--) {
            for(int j = cols-1; j >=0; j--) {
                int minHp = Math.min(dp[i + 1][j], dp[i][j + 1]) - matrix[i][j];
                if(minHp <= 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = minHp;
                }
            }
        }
        return dp[0][0];
    }


}
