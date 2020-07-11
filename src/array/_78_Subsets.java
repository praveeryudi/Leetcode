package array;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    private static List<List<Integer>> results = new ArrayList<>();

    private static List<List<Integer>> subsets(int[] nums) {
        if(null == nums || nums.length == 0)
            return results;
        helper(nums, 0, new ArrayList<>());
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subsets(arr);
        System.out.println(results);
    }

    private static void helper(int[] nums, int index, List<Integer> current) {
        results.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            helper(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
