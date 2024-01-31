package solutions;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 */
public class _394_DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String output = decodeString(s);
        System.out.println(output);
    }

    private static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int index = 0;

        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                while(Character.isDigit(s.charAt(index))) {
                    count = (count * 10) + Character.getNumericValue(s.charAt(index));
                    index += 1;
                }
                counts.push(count);
            } else if(s.charAt(index) == '[') {
                result.push(res);
                res = "";
                index += 1;

            } else if(s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(result.pop());
                int x = counts.pop();
                for(int c = 0; c < x; c++) {
                    sb.append(res);
                }
                res = sb.toString();
                index += 1;
            } else {
                res += s.charAt(index);
                index += 1;
            }
        }
        return res;
    }
}
