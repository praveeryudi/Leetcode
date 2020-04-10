package _30daychallenge;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    private MinStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    private void push(int x) {
        st1.push(x);
        if(st2.isEmpty()) {
            st2.push(x);
            return;
        }
        if( x <= st2.peek())
            st2.push(x);
    }

    private void pop() {
        int element = st1.pop();
        if(element == st2.peek())
            st2.pop();
    }

    private int top() {
        return st1.peek();
    }

    private int min() {
        return st2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-3);
        minStack.push(1);
        System.out.println("Stack Minimum = " + minStack.min());
        minStack.pop();
        minStack.push(-5);
        System.out.println("Top Element = " + minStack.top());
        System.out.println("Stack Minimum = " + minStack.min());
    }
}
