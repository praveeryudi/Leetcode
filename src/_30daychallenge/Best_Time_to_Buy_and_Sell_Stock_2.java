package _30daychallenge;

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