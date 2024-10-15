package blind75.array;

import java.util.Arrays;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[] {left, right};
            }
            if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

}
