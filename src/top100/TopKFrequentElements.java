package top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,1,1,2,2,3};
		int[] result = topKFrequent(arr, 2);
		System.out.println(Arrays.toString(result));
	}
	
	private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int key : nums) {
        	if(counts.containsKey(key)) {
        		counts.put(key, 1 + counts.get(key));
        	}
        	else {
        		counts.put(key, 1);
        	}
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
        	return entry1.getValue() - entry2.getValue();
        });
        
        // Iterate the counts map
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        	pq.add(entry);
        	if(pq.size() > k)
        		pq.remove();
        }
        
        int[] output = new int[k];
        for(int index = k-1; index >= 0; index--) {
        	output[index] = pq.poll().getKey();
        }
        return output;
    }

}
