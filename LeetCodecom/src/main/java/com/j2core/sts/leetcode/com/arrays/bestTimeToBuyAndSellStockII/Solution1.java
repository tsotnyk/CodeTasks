package com.j2core.sts.leetcode.com.arrays.bestTimeToBuyAndSellStockII;

public class Solution1 {

    public int maxProfit(int[] prices) {

        int buy = prices[0];
        int sell = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++){
            if (prices[i] < sell){
                profit += sell-buy;
                buy = prices[i];
                sell = buy;
            }else {
                sell = prices[i];
            }
        }


        return profit + (sell-buy);
    }
}
