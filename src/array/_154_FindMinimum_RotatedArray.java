package array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * The array may contain duplicates.
 */

public class _154_FindMinimum_RotatedArray {

    public static void main(String[] args) {
        int[] nums = {1,3,5};

        int left = 0, right = nums.length - 1;
        // Case when all elements in array are same
        while(right > 0 && nums[left] == nums[right])
            right--;

        int lastValue = nums[right];

        while(left < right) {
            int mid = left + (right - left)/ 2;
            if(nums[mid] <= lastValue) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println("Min Element = " + nums[left]);
    }

}
