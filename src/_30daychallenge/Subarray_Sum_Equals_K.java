package _30daychallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous sub-arrays whose sum equals to k.
 */
public class Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int sum = -10;

        int res = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            currSum += i;
            if(currSum == sum)
                res++;
            if(map.containsKey(currSum - sum))
                res += map.get(currSum - sum);

            Integer count = map.get(currSum);
            if(null == count)
                map.put(currSum, 1);
            else
                map.put(currSum, 1 + count);
        }
        System.out.println("# of sub arrays = " + res);
    }
}