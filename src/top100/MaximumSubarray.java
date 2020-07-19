package top100;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int max = arr[0];
        int curr_sum = arr[0];

        for(int i = 1; i < arr.length; i++) {
            curr_sum = Math.max(arr[i], curr_sum + arr[i]);
            max = Math.max(max, curr_sum);
        }
        System.out.println("Max Subarray Sum = " + max);
    }
}
