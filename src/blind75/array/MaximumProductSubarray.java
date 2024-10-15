package blind75.array;

public class MaximumProductSubarray {

    private static int getMaxProduct(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];

        for(int idx = 1; idx < n; idx++) {
            int num = nums[idx];
            if(num > 0) {
                min[idx] = Math.min(num, num * min[idx-1]);
                max[idx] = Math.max(num, num * max[idx-1]);
            } else {
                min[idx] = Math.max(num, num * min[idx-1]);
                max[idx] = Math.min(num, num * max[idx-1]);
            }
            res = Math.max(res, max[idx]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getMaxProduct(new int[] {-2,0,-1} ));
    }

}
