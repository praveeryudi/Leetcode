package _30daychallenge;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{4, -1, 0, 2, 3, -3};
        System.out.println("Max Subarray Sum = " + getMaxSum(arr));
        System.out.println("Max Subarray Sum = " + getMaxSum(arr, 0, arr.length - 1));
    }

    /* Kadane's Algorithm (O(N)) */
    private static int getMaxSum(int[] nums) {
        if(nums.length == 0)
            return Integer.MIN_VALUE;
        int max = nums[0];
        int currentSum = nums[0];
        for(int index = 1; index < nums.length; index++) {
            currentSum = Math.max(nums[index], currentSum + nums[index]);
            max = Math.max(max, currentSum);
        }
        return max;
    }

    /* Divide & Conquer Approach O(log N)*/
    private static int getMaxSum(int[] nums, int low, int high) {
        if(low == high)
            return nums[low];
        int mid = (low + high)/ 2;
        int leftSum = getMaxSum(nums, low, mid);
        int rightSum = getMaxSum(nums, mid + 1, high);
        int crossSum = getCrossSum(nums, low, mid, high);
        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    private static int getCrossSum(int[] nums, int low, int mid, int high) {
        int leftSum = 0;
        int sum = 0;
        for(int index = mid; index >= low; index--) {
            sum += nums[index];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = 0;
        sum = 0;
        for(int index = mid; index <= high; index++) {
            sum += nums[index];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
