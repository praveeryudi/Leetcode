package top150;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolish {

    private static final List<String>
            OPERATORS = Arrays.asList("+", "-", "*", "/");

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int output = evalRPN(tokens);
        System.out.println(output);
    }

    private static int evalRPN(String[] tokens) {

        Stack<String> st = new Stack<>();
        for(String s : tokens) {
            if(isOperator(s)) {
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                int res;
                switch (s) {
                case "+":
                    res = a + b;
                    break;
                case "-":
                    res = a - b;
                    break;
                case "*":
                    res = a * b;
                    break;
                default:
                    res = a / b;
                    break;
                }
                st.push(String.valueOf(res));
            } else {
                st.push(s);
            }
            System.out.println(st);
        }
        return Integer.parseInt(st.pop());
    }

    private static boolean isOperator(String str) {
        return OPERATORS.contains(str);
    }

}
