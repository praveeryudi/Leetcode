package top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            int current = nums[index];
            if(indexMap.containsKey(target - current)) {
                return new int[] {index, indexMap.get(target - current)};
            }
            else {
                indexMap.put(current, index);
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

}
