package geeks;

import java.util.HashMap;
import java.util.Map;

public class LIS {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        int result = lis(arr);
        System.out.println(result);
    }

    private static int lis(int[] nums) {
        return lis(nums, -1, 0, new HashMap<>());
    }

    private static int lis(int[] nums, int prev, int index, Map<String, Integer> cache) {
        if(index == nums.length) {
            return 0;
        }
        String key = prev + ":" + index;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        int take = 0;
        int skip = 0;
        // include
        if(prev == -1 || (nums[index] > nums[prev])) {
            take = 1 + lis(nums, index, index + 1, cache);
        }
        // exclude
        else {
            skip = lis(nums, prev, index + 1, cache);
        }
        int res = Math.max(take, skip);
        cache.put(key, res);
        return res;
    }

}
