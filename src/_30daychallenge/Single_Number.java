package _30daychallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 */
public class Single_Number {

    private static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        Set<Integer> set = new HashSet<>();
        for(int index = 0; index < nums.length; index++) {
            if(set.contains(nums[index]))
                set.remove(nums[index]);
            else
                set.add(nums[index]);
        }
        for(int i : set)
            return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        int res = singleNumber(nums);
        System.out.println("Single Number = " + res);
    }
}
