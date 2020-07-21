package top100;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] houses = {2,7,9,3,1};
        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(dp[0], dp[1]);

        for(int index = 2; index < houses.length; index++) {
            dp[index] = Math.max(houses[index] + dp[index - 2], dp[index - 1]);
        }

        int maxAmount = dp[dp.length - 1];
        System.out.println("Maximum Amount Robbed = " + maxAmount);
    }

}
