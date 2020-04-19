package _30daychallenge;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int res = findIndex(nums, 0);
        System.out.println("Index = " + res);
    }

    private static int findIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end)/ 2;
            if(nums[mid] == target)
                return mid;

            else if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

            else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
