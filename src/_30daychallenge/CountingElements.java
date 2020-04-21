package _30daychallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 */
public class CountingElements {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2,3,5,0};
        System.out.println(countElements(nums));
    }

    private static int countElements(int[] arr) {
        if(null == arr || arr.length == 0)
            return 0;

        int len = arr.length;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : arr) {
            if(count.containsKey(i))
                count.put(i, count.get(i) + 1);
            else
                count.put(i, 1);
        }

        for (int current : arr) {
            if (count.containsKey(current + 1))
                count.put(current + 1, count.get(current + 1) - 1);
        }

        return len - count.values().stream().mapToInt(Integer::intValue).sum();
    }
}
