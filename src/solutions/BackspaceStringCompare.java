package solutions;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println(backspaceCompare(S, T));
    }


    private static boolean backspaceCompare(String S, String T) {
        if(null == S || S.isEmpty())
            return false;

        if(null == T || T.isEmpty())
            return false;

        Stack<Character> st = new Stack<>();
        for(char ch : S.toCharArray()) {
            if(ch == '#') {
                if(!st.isEmpty()) {
                    st.pop();
                }
            }
            else
                st.push(ch);
        }

        String str1 = "";
        while(!st.isEmpty()) {
            str1 = str1.concat(String.valueOf(st.pop()));
        }

        for(char ch : T.toCharArray()) {
            if(ch == '#') {
                if(!st.isEmpty()) {
                    st.pop();
                }
            }
            else
                st.push(ch);
        }

        String str2 = "";
        while(!st.isEmpty()) {
            str2 = str2.concat(String.valueOf(st.pop()));
        }
        return str1.equals(str2);
    }
}
