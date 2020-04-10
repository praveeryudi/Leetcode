package _30daychallenge;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(findAnagrams(input));
    }

    private static List<List<String>> findAnagrams(String[] arr) {
        Map<String, List<String>> words = new HashMap<>();
        for(String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if(words.containsKey(key)) {
                words.get(key).add(str);
            }
            else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                words.put(key, anagrams);
            }
        }
        return new ArrayList<>(words.values());
    }
}
