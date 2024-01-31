package solutions;

import java.util.Arrays;
import java.util.Stack;

public class _316_RemoveDuplicateLetters {

    private static String removeDuplicateLetters(String s) {
        int [] counts = new int[26];
        boolean [] visited = new boolean [26];
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char c: chars){
            counts[c - 'a']++;
        }

        System.out.println(Arrays.toString(counts));

        int index;
        for (char c : chars) {
            index = c - 'a';
            if (visited[index])
                continue;
            counts[index]--;
            while (!st.isEmpty() && c < st.peek()
                    && counts[st.peek() - 'a'] != 0) {
                char top = st.pop();
                visited[top - 'a'] = false;
            }
            st.push(c);
            visited[index] = true;

            System.out.println("Visited: " + Arrays.toString(visited));
            System.out.println("Counts: " + Arrays.toString(counts));
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = removeDuplicateLetters("cbacdcbc");
        System.out.println(res);
    }

}
