package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_Group_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(input);
	}
	
	private static void groupAnagrams(String[] input) {
		Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		
		for(String str : input) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String word = Arrays.toString(ch);
			if(anagramMap.containsKey(word)) {
				anagramMap.get(word).add(str);
			}
			else {
				List<String> val = new ArrayList<String>();
				val.add(str);
				anagramMap.put(word, val);
			}
		}
		
		// Iterate over the map values
		
		for(List<String> list : anagramMap.values()) {
			System.out.println(list);
		}
		
	}

}
