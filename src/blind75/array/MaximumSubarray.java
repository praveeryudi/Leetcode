package blind75.array;

public class MaximumSubarray {

    private static int getMaxSubarray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            currSum = Math.max(nums[idx], currSum + nums[idx]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(
                getMaxSubarray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

}
