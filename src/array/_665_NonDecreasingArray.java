package array;

public class _665_NonDecreasingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2,3,3,2,4};
		System.out.println(checkPossibility(arr));
	}

	public static boolean checkPossibility(int[] nums) {
		if (null == nums || nums.length == 0)
			return true;

		int errorPos = getErrorPosition(nums);
		if (errorPos == -1)
			return true;

		int errorVal = nums[errorPos];
		nums[errorPos] = nums[errorPos + 1];
		if (getErrorPosition(nums) == -1)
			return true;
		
		nums[errorPos] = errorVal;
		nums[errorPos + 1] = errorVal;
		if (getErrorPosition(nums) == -1)
			return true;
		return false;
	}

	private static int getErrorPosition(int[] nums) {
		for (int index = 0; index < nums.length - 1; index++) {
			if (nums[index] > nums[index + 1])
				return index;
		}
		return -1;
	}

}
