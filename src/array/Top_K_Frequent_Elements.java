package array;

import java.util.*;

public class Top_K_Frequent_Elements {

    private static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                map.put(key, 1 + map.get(key));
            } else {
                map.put(key, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> counts = new ArrayList<>(map.entrySet());
        counts.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());
        List<Map.Entry<Integer, Integer>> topKList = counts.subList(0, k);
        int[] result;
        result = topKList.stream().mapToInt(Map.Entry::getKey).toArray();
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
