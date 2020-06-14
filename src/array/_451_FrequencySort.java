package array;

import java.util.*;

public class _451_FrequencySort {

    public static void main(String[] args) {
        String input = "Aabb";
        frequencySort(input);
    }

    private static void frequencySort(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char ch : str.toCharArray()) {
            if(counts.containsKey(ch)) {
                counts.put(ch, 1 + counts.get(ch));
            }
            else {
                counts.put(ch, 1);
            }
        }

        List<Map.Entry<Character, Integer>> l = new ArrayList<>(counts.entrySet());
        l.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : l) {
            int i = entry.getValue();
            while(i > 0) {
                sb.append(entry.getKey());
                i--;
            }
        }

        System.out.println(sb.toString());
    }
}
