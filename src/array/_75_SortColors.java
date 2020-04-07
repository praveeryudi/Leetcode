package array;

import java.util.Arrays;

public class _75_SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2,0,1,1,0,2,2,1};
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		int temp = -1;
		
		while(mid <= high) {
			switch(nums[mid]) {

			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
				
			case 1:
				mid++;
				break;
				
			case 2:
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
				break;
			}
		}
	}

}
