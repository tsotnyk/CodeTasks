package com.j2core.sts.leetcode.com.arrays.bestTimeToBuyAndSellStockwithTransactionFee;

public class Solution1 {

    public int maxProfit(int[] prices, int fee) {

        int buy = prices[0];
        int sell = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++){
            if (sell < prices[i]){
                sell = prices[i];
            }else if (buy > prices[i]){
                int curProfit = sell - buy - fee;
                if (curProfit > 0) profit += curProfit;
                buy = prices[i];
                sell = buy;
            }else {

            }
        }
        int lastProf = sell-buy-fee;
        if ( lastProf > 0){
            profit += lastProf;
        }

        return profit;

    }
}
