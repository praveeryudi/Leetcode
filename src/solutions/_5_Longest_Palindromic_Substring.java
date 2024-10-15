package solutions;

public class _5_Longest_Palindromic_Substring {

    private static int maxLength = Integer.MIN_VALUE;
    private static String res = "";

    public static void main(String[] args) {

        String input = "abcd";

        int len = input.length();
        for(int start = 0; start < len - 1; start++) {
            if(len % 2 != 0) {
                expandFromCenter(input, start, start); // for odd length string
            }
            else {
                expandFromCenter(input, start, start+1); // for even length string
            }
        }
        System.out.println("Max Length Palindrome = " + maxLength);
        System.out.println("Palindrome String = " + res);
    }

    private static void expandFromCenter(String str, int begin, int end) {
        while(begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        begin ++;
        end --;
        if(maxLength < end - begin + 1) {
            maxLength = end - begin + 1;
            res = str.substring(begin, begin + maxLength);
        }
    }
}
