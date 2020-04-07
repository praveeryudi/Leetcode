package array;

public class _33_SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {4,5,6,7,0,1,2};
		int target = 6;
		
		System.out.println("Found Index = " + searchIndex(arr, target));

	}
	
	private static int searchIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			int mid = (left + right)/ 2;
			
			if(nums[mid] == target)
				return mid;
			
			// If left sub array is sorted
			if(nums[left] < nums[mid]) {
				
				if(target >= nums[left] && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
			// Right sub array is sorted
			else {
				if(target > nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}

}
