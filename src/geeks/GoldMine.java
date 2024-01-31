package geeks;

public class GoldMine {

    public static void main(String[] args) {
        int[][] mine = {
                {0,0,0,0,0}
        };
        System.out.println("Max gold " + maxGold(1,5, mine));
    }

    static int maxGold(int n, int m, int M[][])
    {
        // code here

        if(n == 1) {
            int gold = 0;
            for(int c = 0; c < m; c++) {
                gold += M[0][c];
            }
            return gold;
        }

        int[][] dp = new int[n][m];
        for(int r = 0; r < n; r++) {
            dp[r][0] = M[r][0];
        }

        for(int c = 1; c < m; c++) {
            for(int r = 0; r < n; r++) {
                if(r == 0) {
                    dp[r][c] = M[r][c] + Math.max(dp[r][c-1], dp[r+1][c-1]);
                } else if(r == n-1) {
                    dp[r][c] = M[r][c] + Math.max(dp[r-1][c-1], dp[r][c-1]);
                } else {
                    dp[r][c] = M[r][c] + Math.max(dp[r][c-1], Math.max(dp[r-1][c-1], dp[r+1][c-1]));
                }
            }
        }

        int max = 0;
        for(int r = 0; r < n; r++) {
            max = Math.max(max, dp[r][m-1]);
        }
        return max;
    }


}
