package solutions;

public class _953_VerifyingAlienDictionary {

    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        isAlienSorted(words, order);
    }

    private static boolean isAlienSorted(String[] words, String order) {

        int n = words.length;
        for(int index = 1; index < n; index++) {

            String first_word = words[index-1];
            String second_word = words[index];

            int i = 0, j = 0;
            while(i < first_word.length() && j < second_word.length()) {

                char ch1 = first_word.charAt(i);
                char ch2 = second_word.charAt(j);
                if(ch1 == ch2) {
                    i++;
                    j++;
                    continue;
                }
                if(order.indexOf(ch1) > order.indexOf(ch2))
                    return false;
                else
                    break;
            }

            if(i < first_word.length() && j == second_word.length())
                return false;
        }
        return true;
    }
}
