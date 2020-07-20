package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 */
public class Combination_Sum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(null == candidates || candidates.length == 0)
            return results;
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), results);
        return results;
    }

    private static void helper(int[] nums, int index, int remTarget, List<Integer> current, List<List<Integer>> results) {
        if(remTarget == 0) {
            results.add(new ArrayList<>(current));
        }
        for(int i = index; i < nums.length; i++) {
            if(nums[i] > remTarget)
                continue;
            current.add(nums[i]);
            helper(nums, i, remTarget - nums[i], current, results);
            current.remove(current.size() - 1);
        }
    }
}
