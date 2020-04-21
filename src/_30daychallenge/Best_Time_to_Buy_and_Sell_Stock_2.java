package _30daychallenge;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class Best_Time_to_Buy_and_Sell_Stock_2 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = 0;
        for(int index = 1; index < prices.length; index++) {
            int diff = prices[index] - prices[index-1];
            if(diff > 0)
                maxProfit += diff;
        }
        System.out.println("Max Profit = " + maxProfit);
    }
}