package _30daychallenge;

import java.util.Stack;

public class Valid_Parenthesis_String {

    private static boolean checkValidString(String s) {
        if(null == s || s.isEmpty())
            return true;
        if(s.startsWith(")"))
            return false;

        /*
          Stack of Integers - to store indices of characters
         */
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        char[] chars = s.toCharArray();
        for(int index = 0; index < chars.length; index++) {
            char ch = chars[index];
            if(ch == '(') // simply push open bracket
                left.push(index);
            else if(ch == '*') // simply push star
                star.push(index);
            else {
                if(left.isEmpty() && star.isEmpty())
                    return false;
                else if(!left.isEmpty()) // pop from left first
                    left.pop();
                else
                    star.pop(); // pop from star to compensate for ')' bracket
            }
        }

        while(!left.isEmpty() && !star.isEmpty()) {
            if (left.peek() > star.peek()) // if all stars are coming behind the '(' bracket.
                return false;
            left.pop();
            star.pop();
        }

        return left.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()(()))(()()()))))((((()*()*(())())(()))((*()(*((*(*()))()(())*()()))*)*()))()()(())()(()))())))";
        System.out.println("Is String Valid = " + checkValidString(s));
    }
}
