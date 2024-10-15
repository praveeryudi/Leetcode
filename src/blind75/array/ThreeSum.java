package blind75.array;

import java.util.Arrays;

public class ThreeSum {

    private static int[] threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int start = 0; start < n - 2; start++) {
            int left = start + 1;
            int right = n - 1;
            while(left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                if(sum == target) {
                    return new int[] {nums[start], nums[left], nums[right]};
                }
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new int[] {-1,-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(threeSum(nums, 0)));
    }

}
