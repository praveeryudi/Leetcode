package array;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static int fibonacciNumber(int n){
        // Write your code here.
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % mod;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = fibonacciNumber(95);
        System.out.println(res);
    }

}
