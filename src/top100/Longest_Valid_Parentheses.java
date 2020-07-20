package top100;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 */
public class Longest_Valid_Parentheses {
    public static void main(String[] args) {
        String input = "()()()";
        int result = longestValidParentheses(input);
        System.out.println("Length of longest = " + result);
    }

    private static int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;

        int len = s.length();
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);

        for(int index = 0; index < len; index++) {
            char ch = s.charAt(index);
            if(ch == '(') {
                characterStack.push(ch);
                indexStack.push(index);
            }
            else {
                if(!characterStack.isEmpty() && characterStack.peek() == '(') {
                    characterStack.pop();
                    indexStack.pop();
                    max = Math.max(max, index - indexStack.peek());
                }
                else {
                    indexStack.push(index);
                }
            }
        }
        return max;
    }
}
