package array;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 */
public class _45_JumpGameII {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int jumps = jump(arr);
        System.out.println("Min Jumps: " + jumps);
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

}
