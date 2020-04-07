package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_Unique_Occurances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[] {1,2};
		System.out.println(uniqueOccurrences(input));

	}
	
	private static boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> count = new HashMap();
        for(int i : arr) {
            if(count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            }
            else {
                count.put(i, 1);
            }
        }
        
        Set<Integer> set = new HashSet();
        for(int i : count.values()) {
        	set.add(i);
        }
        return count.size() == set.size();
        
    }

}
