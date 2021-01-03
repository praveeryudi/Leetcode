package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {

    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int[] nums, int index, int remTarget, List<Integer> current, List<List<Integer>> results) {
        if(remTarget == 0) {
            if(current.size() == 3 && !results.contains(current))
                results.add(new ArrayList<>(current));
        }

        for(int i = index; i < nums.length; i++) {
            if(nums[i] > remTarget)
                continue;
            current.add(nums[i]);
            helper(nums, i + 1, remTarget - nums[i], current, results);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {-7,-5,5,-6,-2,1,7,3,-4,-2,-2,-4,-8,-1,8,8,-2,-7,3,2,-7,8,-3,-10,5,2,8,7,7};
        System.out.println(threeSum(input));
    }
}
