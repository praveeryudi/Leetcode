package stack;

import java.util.Stack;

public class ReverseStack {

    private static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }

        Integer ele = st.pop();
        reverseStack(st);
        insert_at_bottom(ele, st);
    }

    static void insert_at_bottom(Integer x, Stack<Integer> st)
    {

        if (st.isEmpty())
            st.push(x);

        else {

            // All items are held in Function
            // Call Stack until we reach end
            // of the stack. When the stack becomes
            // empty, the st.size() becomes 0, the
            // above if part is executed and
            // the item is inserted at the bottom
            Integer a = st.pop();
            insert_at_bottom(x, st);

            // push all the items held
            // in Function Call Stack
            // once the item is inserted
            // at the bottom
            st.push(a);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        reverseStack(st);
        System.out.println(st);
    }

}
