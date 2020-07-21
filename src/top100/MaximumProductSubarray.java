package top100;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] arr = {-2,0,-1};
        System.out.println("Max Product = " + getMaxProduct(arr));
    }

    private static int getMaxProduct(int[] nums) {
        int maxProduct = nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if(curr > 0) {
                max[i] = Math.max(curr, curr * max[i-1]);
                min[i] = Math.min(curr, curr * min[i-1]);
            }
            else {
                max[i] = Math.max(curr, curr * min[i-1]);
                min[i] = Math.min(curr, curr * max[i-1]);
            }
            maxProduct = Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }
}
