package blind75.dp;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2,5,3,7,101,18};
        int i, j;
        int maxLength = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(i = 0; i < nums.length; i++) {
            for(j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println("Max LIS = " + maxLength);
    }

}
