package array;

import java.util.Arrays;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 */
public class _120_Triangle {

    public static void main(String[] args) {
        int[][] triangle = {
            {2},
            {3,4},
            {6,5,7},
            {4,1,8,3}
        };

        int sum = getMinSum(triangle);
        System.out.println("Minimum Sum = " + sum);
    }

    private static int getMinSum(int[][] triangle) {
        if(null == triangle || triangle.length == 0)
            return 0;
        int rows = triangle.length;
        int[] dp = new int[rows + 1];
        for(int i = rows - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[j] = triangle[i][j] + Math.min(dp[j], dp[j+1]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

}
