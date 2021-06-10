package array;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that
 * each element appears only once and returns the new length.
 *
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[index] = nums[i+1];
                index++;
            }
        }
        return index;
    }

}
