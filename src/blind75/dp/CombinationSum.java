package blind75.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private static void backtrack(int[] nums, int index, int k, List<Integer> current, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(nums[i] > k) break;
            current.add(nums[i]);
            backtrack(nums, i, k - nums[i], current, res);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 5, 3};
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, 7, new ArrayList<>(), res);
        System.out.println(res);
    }

}
