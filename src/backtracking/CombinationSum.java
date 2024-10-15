package backtracking;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int[] ARR = {1,2,3};
        combSum(ARR, 5);
    }

    public static List<List<Integer>> combSum(int[] ARR, int B) {
        // Write your code here.
        List<List<Integer>> res = new ArrayList<>();
        if(ARR.length == 0) {
            return res;
        }
        //Arrays.sort(ARR);
        backtrack(ARR, 0, B, new ArrayList<>(), res);
        System.out.println(res);
        return res;
    }

    private static void backtrack(int[] nums, int index, int remainingSum, List<Integer> current,
            List<List<Integer>> res) {
        if(remainingSum == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            if(nums[i] > remainingSum)
                continue;
            current.add(nums[i]);
            backtrack(nums, i, remainingSum - nums[i], current, res);
            current.remove(current.size() - 1);
        }
    }
}
