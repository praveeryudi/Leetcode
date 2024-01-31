package geeks;

public class InterleavingStrings {

    // aabc
    // axyb
    // aaaxybcb

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solve(s1, s2, s3, 0, 0, new int[101][101]));
    }

    private static boolean solve(String s1, String s2, String s3, int i, int j, int[][] cache) {
        if(i == s1.length() && j == s2.length() && (i + j) == s3.length()) {
            return true;
        }
        if((i + j) >= s3.length()) {
            return false;
        }
        if(cache[i][j] != 0) {
            return cache[i][j] == 1;
        }
        boolean res = false;
        if(i < s1.length() && s3.charAt(i + j) == s1.charAt(i)) {
            res = solve(s1, s2, s3, i + 1, j, cache);
        } else if(j < s2.length() && s3.charAt(i + j) == s2.charAt(j)) {
            res = solve(s1, s2, s3, i, j + 1, cache);
        }
        cache[i][j] = res ? 1 : -1;
        return res;
    }

}
