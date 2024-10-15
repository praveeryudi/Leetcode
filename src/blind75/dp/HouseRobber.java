package blind75.dp;

public class HouseRobber {

    private static int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int idx = 2; idx < n; idx++) {
            dp[idx] = Math.max(dp[idx-2] + nums[idx], dp[idx-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println("Money looted=" + rob(nums));
    }

}
