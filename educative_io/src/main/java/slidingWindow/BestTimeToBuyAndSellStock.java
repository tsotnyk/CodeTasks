package slidingWindow;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++){

            if (prices[i] < buy){
                buy = prices[i];
            }else {
                maxProfit = Math.max(maxProfit, prices[i]-buy);
            }
        }

        // Replace this placeholder return statement with your code

        return maxProfit;
    }
}
