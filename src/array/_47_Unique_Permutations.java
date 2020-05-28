package array;

import java.util.Arrays;

public class _47_Unique_Permutations {

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2};
        permute(arr, 0, arr.length - 1);
    }

    private static void permute(int[] nums, int start, int end) {
        if(start == end)
            System.out.println(Arrays.toString(nums));
        for(int i = start; i <= end; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
