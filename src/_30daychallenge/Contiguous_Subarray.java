package _30daychallenge;

import java.util.HashMap;
import java.util.Map;

public class Contiguous_Subarray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1,0,1,1,0};
        Map<Integer, Integer> counts_map = new HashMap<>();
        counts_map.put(0, -1);

        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int index = 0; index < arr.length; index++) {
            count = arr[index] == 0 ? count - 1 : count + 1;
            if(counts_map.containsKey(count)) {
                max = Math.max(max, index - counts_map.get(count));
            }
            else {
                counts_map.put(count, index);
            }
        }
        System.out.println("Maximum Length Subarray of 0s and 1s = " + max);
    }
}