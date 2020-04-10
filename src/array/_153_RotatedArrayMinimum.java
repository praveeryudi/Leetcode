package array;

public class _153_RotatedArrayMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {4,5,6,7,0,1,2};
		System.out.println(findMin(arr));
	}
	
	public static int findMin(int[] nums) {
        if(null == nums || nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];
        
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low)/ 2;
            
            if(mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            else if(nums[mid] >= nums[low] && nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return nums[low];
    }

}
