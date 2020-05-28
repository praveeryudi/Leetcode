package array;

import java.util.Arrays;

public class _438_Anagrams_In_String {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        int windowLen = p.length();
        int len = s.length();
        char[] chars = p.toCharArray();
        int[] char_count = new int[26];
        for(char ch : chars) {
            char_count[ch - 'a']++;
        }

        //Arrays.sort(chars);
        int[] input_char_count;
        for(int index = 0; index < len - windowLen + 1; index++) {
            String input = s.substring(index, index + windowLen);
            input_char_count = new int[26];
            for(char ch : input.toCharArray()) {
                input_char_count[ch - 'a']++;
            }
            if(Arrays.equals(char_count, input_char_count)) {
                System.out.println("Anagram starting index = " + index);
            }
            /*if(isAnagram(input, chars)) {
                System.out.println("Anagram starting index = " + index);
            }*/
        }
    }

    private static boolean isAnagram(String input, char[] target) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return Arrays.equals(chars, target);
    }
}
