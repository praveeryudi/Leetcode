package solutions;

public class _65_ValidNumber {

    private static boolean isNumber(String s) {

        s = s.trim();
        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                numSeen = true;
            }
            else if(ch == 'e' || ch == 'E') {
                if(eSeen || !numSeen)
                    return false;
                eSeen = true;
                numSeen = false;
            }
            else if(ch == '.') {
                if(dotSeen || eSeen)
                    return false;
                dotSeen = true;
            }
            else if(ch == '-' || ch == '+') {
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            }
            else
                return false;
        }
        return numSeen;
    }

    public static void main(String[] args) {
        String s = "005047e+6";
        System.out.println(isNumber(s));
    }

}
