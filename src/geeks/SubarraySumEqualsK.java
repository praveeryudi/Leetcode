package geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,3,4,8,10,12};
        System.out.println(countSubarray(nums, 22));
        List<int[]> result = getIndices(nums, 22);
        for(int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int countSubarray(int[] nums, int k) {
        int count = 0;
        int cSum = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(cSum, 1);
        for(int i : nums) {
            cSum += i;
            if(seen.containsKey(cSum - k)) {
                count += seen.get(cSum - k);
            }
            seen.put(cSum, seen.getOrDefault(cSum, 0) + 1);
        }
        return count;
    }

    private static List<int[]> getIndices(int[] nums, int k) {
        int cSum = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        int start = -1, end = -1;
        seen.put(cSum, start);
        for(int index = 0; index < nums.length; index++) {
            cSum += nums[index];
            if(cSum == k) {
                end = index;
                res.add(new int[] {start, end});
            }
            if(seen.containsKey(cSum - k)) {
                start = seen.get(cSum - k) + 1;
                end = index;
                res.add(new int[] {start, end});
            } else {
                seen.put(cSum, index);
            }
        }
        return res;
    }

}
