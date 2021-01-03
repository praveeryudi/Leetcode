package array;

public class _299_BullsAndCows {

    private static String getHint(String secret, String guess) {

        int bulls = 0, cows = 0;

        StringBuilder sb = new StringBuilder(secret);
        boolean[] visited = new boolean[guess.length()];

        for(int index = 0; index < guess.length(); index++) {
            if(sb.charAt(index) == guess.charAt(index)) {
                bulls++;
                sb.setCharAt(index, '\0');
                visited[index] = true;
            }
        }

        for(int index = 0; index < guess.length(); index++) {

            if(visited[index])
                continue;

            char target = guess.charAt(index);

            if(sb.charAt(index) == target) {
                bulls++;
                sb.setCharAt(index, '\0');
                continue;
            }
            int findIndex = sb.indexOf(String.valueOf(target));
            if(findIndex >= 0) {
                cows++;
                sb.setCharAt(findIndex, '\0');
            }
        }

        System.out.println("Bulls = " + bulls + " Cows = " + cows);
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        getHint("11", "10");
    }
}
