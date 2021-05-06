package _30daychallenge;

public class ShortestUnsortedArray {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int len = minLengthUnsortedArray(nums);
        System.out.println("Min Length Unsorted Array: " + len);
    }

    private static int minLengthUnsortedArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n-1; i++) {
            if(nums[i] > nums[i+1]) {
                min = Math.min(min, nums[i+1]);
            }
        }

        for(int i = n-1; i > 0; i--) {
            if(nums[i] < nums[i-1]) {
                max = Math.max(max, nums[i-1]);
            }
        }

        System.out.println("Min:" + min + " Max: " + max);

        int left = 0, right = 0;
        for(int index = 0; index < n; index++) {
            if(nums[index] > min) {
                left = index;
                break;
            }
        }

        for(int index = n-1; index > 0; index--) {
            if(nums[index] < max) {
                right = index;
                break;
            }
        }
        return right - left > 0 ? right - left + 1 : 0;
    }
}
