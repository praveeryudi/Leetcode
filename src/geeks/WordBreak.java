package geeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    public static int wordBreak(String A, List<String> B )
    {
        //code here
        Set<String> dict = new HashSet<>(B);
        boolean result = wordBreak(A, "", new HashMap<>(), dict);
        return result ? 1 : 0;
    }

    private static boolean wordBreak(String input, String ans, Map<String, Boolean> cache, Set<String> dict) {
        if(input.isEmpty()) {
            System.out.println(ans);
            return true;
        }

        if(cache.containsKey(input))
            return cache.get(input);

        boolean res;
        for(int idx = 0; idx < input.length(); idx++) {
            String left = input.substring(0, idx + 1);
            if(dict.contains(left)) {
                String right = input.substring(idx + 1);
                res = wordBreak(right, ans + left + " ", cache, dict);
                cache.put(input, res);
                if(res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("pep", "coding", "pepcoding", "loves", "mango", "ice", "cream", "icecream");
        int result = wordBreak("pepcodinglovesmangoicecream", dict);
        System.out.println(result);
    }

}
