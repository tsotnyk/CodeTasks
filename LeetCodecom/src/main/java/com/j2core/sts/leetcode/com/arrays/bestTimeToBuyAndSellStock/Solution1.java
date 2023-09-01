package com.j2core.sts.leetcode.com.arrays.bestTimeToBuyAndSellStock;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
                continue;
            }

            int newProfit = prices[i] - min;
            profit = Math.max(profit, newProfit);
        }

        return profit;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxProfit(new int[]{7,6,5,4,1}), 0);
        Assert.assertEquals(maxProfit(new int[]{7,1,5,3,6,4}), 5);

    }
}
