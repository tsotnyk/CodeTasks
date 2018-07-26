package com.j2core.sts.leetcode.com.arrays.bestTimeToBuyAndSellStockwithTransactionFee;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxProfit(int[] prices, int fee) {

        int hold = - prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++){

            int tmpProfit = hold + prices[i] - fee;
            if (tmpProfit > profit){
                profit = tmpProfit;
            }

            int tmpHold = profit - prices[i];
            if (tmpHold > hold){
                hold = tmpHold;
            }

        }

        return profit;
    }

    @Test
    public void test(){

        int result = maxProfit(new int[]{1,3,2,8,4,9}, 2);

        Assert.assertEquals(result, 8);

        int result1 = maxProfit(new int[]{1,3,7,5,10,3}, 3);

        Assert.assertEquals(result1, 6);

        int result2 = maxProfit(new int[]{4,5,2,4,3,3,1,2,5,4}, 1);

        Assert.assertEquals(result2, 4);
    }
}
