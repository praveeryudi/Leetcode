package _30daychallenge;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] output = new int[nums.length];
        int n = 1;
        for(int index = 0; index < nums.length; index++) {
            output[index] = n;
            n = n * nums[index];
        }
        n = 1;
        for(int index = nums.length - 1; index >= 0; index--) {
            output[index] = n * output[index];
            n = n * nums[index];
        }

        System.out.println(Arrays.toString(output));
    }
}