package blind75.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    private static int[] getProduct(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int num = 1;

        // First pass
        for (int idx = 0; idx < n; idx++) {
            output[idx] = num;
            num = num * nums[idx];
        }

        // Reset num
        num = 1;

        // Second pass
        for (int idx = n - 1; idx >= 0; idx--) {
            output[idx] = output[idx] * num;
            num = num * nums[idx];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(getProduct(nums)));
    }

}
