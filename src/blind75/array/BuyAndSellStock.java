package blind75.array;

public class BuyAndSellStock {

    private static int getProfit(int[] prices) {
        int profit = 0;
        int cp = prices[0];
        for(int idx = 1; idx < prices.length; idx++) {
            int price = prices[idx];
            if(price < cp) {
                cp = price;
            } else {
                profit = Math.max(profit, price - cp);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("Profit " + getProfit(new int[] {7,1,5,3,6,4}));
    }

}
