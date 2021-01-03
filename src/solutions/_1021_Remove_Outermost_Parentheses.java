package solutions;

public class _1021_Remove_Outermost_Parentheses {

    private static String removeOuterParentheses(String S) {

        StringBuilder sb = new StringBuilder();

        int pos = 0;
        int open = 0, closed = 0;
        for(int index = 0; index < S.length(); index++) {
            if(S.charAt(index) == '(')
                open++;
            else
                closed++;

            if(open == closed) {
                sb.append(S.substring(pos + 1, index));
                pos = open + closed;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "(()())(())";
        String output = removeOuterParentheses(input);
        System.out.println(output);
    }
}
