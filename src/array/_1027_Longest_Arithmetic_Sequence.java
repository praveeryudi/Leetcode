package array;

import java.util.HashMap;
import java.util.Map;

public class _1027_Longest_Arithmetic_Sequence {

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,9,12};
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int gap = nums[j] - nums[i];
                int count = 2;
                if(map.containsKey(i + ":" + gap)) {
                    count = 1 + map.get(i + ":" + gap);
                }
                map.put(j + ":" + gap, count);
                max = Math.max(max, count);
            }
        }
        System.out.println("Length of longest sequence = " + max);
    }
}
