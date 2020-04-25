package _30daychallenge;

public class Jump_Game {

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println("Can Jump :: " + canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        if(null == nums || nums.length == 0)
            return false;

        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
        for(int i = len-2; i >= 0; i--) {
            int canTake = nums[i];
            int required = len - i - 1;
            if(canTake >= required)
                dp[i] = true;
            else {
                while(canTake > 0) {
                    if(dp[i + canTake]) {
                        dp[i] = true;
                        break;
                    }
                    canTake--;
                }
            }
        }
        return dp[0];
    }
}