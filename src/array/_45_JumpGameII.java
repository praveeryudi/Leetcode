package array;

import java.util.Arrays;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 */
public class _45_JumpGameII {

    public static void main(String[] args) {
        int[] arr = {1,0,3,2,1};
        int jumps = minJumps(arr);
        System.out.println(Integer.MAX_VALUE);
        int ans = (jumps == Integer.MAX_VALUE - 1) ? -1 : jumps;
        System.out.println("Min Jumps: " + ans);
    }

    private static int jump(int[] nums) {

        int n = nums.length;
        if(n == 1) return 0;

        int res = 0;
        int left = 0, right = 0;
        while(right < n - 1) {
            int farthest = 0;
            for(int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            res++;
        }
        return res;
    }

    private static int minJumps(int[] array){
        int n = array.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(array, 0, n-1, dp);
    }

    private static int solve(int[] nums, int index, int end, int[] dp) {
        if(index == end) return 0;
        if(nums[index] == 0) return Integer.MAX_VALUE - 1;
        if(dp[index] != -1)
            return dp[index];
        int minJumps = Integer.MAX_VALUE - 1;
        for(int jump = 1; jump <= nums[index]; jump++) {
            // if within bounds
            if(index + jump <= end) {
                minJumps = Math.min(minJumps, 1 + solve(nums, index + jump, end, dp));
            }
        }
        dp[index] = minJumps;
        return minJumps;
    }

}
