package array;

import java.util.Arrays;

public class _1_TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {2,7,11,15};
		int target = 18;
		System.out.println(Arrays.toString(twoSum(arr, target)));

	}

	private static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		Arrays.sort(nums);
		int start = 0, end = nums.length - 1;
		while(start <= end) {
			if(nums[start] + nums[end] == target) {
				res[0] = start;
				res[1] = end;
				break;
			}
			else if(nums[start] + nums[end] < target) 
				start++;
			else
				end--;
		}
		return res;
	}

}
