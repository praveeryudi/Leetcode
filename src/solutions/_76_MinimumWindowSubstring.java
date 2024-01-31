package solutions;

import java.util.Arrays;

public class _76_MinimumWindowSubstring {

    private static final Integer SIZE = 26;

    public static String minWindow(String s, String t) {

        // sanity check
        if(s.length() < t.length())
            return "";
        int dmct = t.length();

        int[] counts = new int[SIZE];
        for(char ch : t.toCharArray()) {
            counts[ch - 'A']++;
        }

        System.out.println(Arrays.toString(counts));

        int start = 0, startIdx = -1;
        int mct = 0;
        int[] hashCounts = new int[SIZE];
        int min = Integer.MAX_VALUE;

        for(int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            hashCounts[ch - 'A']++;

            if(hashCounts[ch - 'A'] <= counts[ch - 'A']) {
                mct++;
            }

            if(mct == dmct) {
                System.out.println(Arrays.toString(hashCounts));
                while(hashCounts[s.charAt(start) - 'A'] > counts[s.charAt(start)- 'A'] || counts[s.charAt(start) - 'A'] == 0) {
                    if(hashCounts[s.charAt(start) - 'A'] > counts[s.charAt(start) - 'A']) {
                        hashCounts[s.charAt(start) - 'A']--;
                    }
                    start++;
                }

                int len = j-start+1;
                if(min > len) {
                    min = len;
                    startIdx = start;
                }
            }
        }

        return s.substring(startIdx, startIdx + min);

    }

    public static void main(String[] args) {
        String input = "ADOBECODEBANC";
        String ans = minWindow(input, "ABC");
        System.out.println(ans);
    }

}
