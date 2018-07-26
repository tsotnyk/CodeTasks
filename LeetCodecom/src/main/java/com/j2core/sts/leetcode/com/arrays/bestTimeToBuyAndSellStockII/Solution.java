package com.j2core.sts.leetcode.com.arrays.bestTimeToBuyAndSellStockII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxProfit(int[] prices) {

        int profit = 0;
        int index = 0;
        int buy;
        int sell;

        while (index < prices.length){

            buy = prices[index];
            sell = prices[index];

            while (index < prices.length && prices[index] < buy){
                buy = prices[index];
                index++;
            }

            sell = prices[index];
            ++index;

            while (index < prices.length && prices[index] > sell){
                sell = prices[index];
                index++;
            }

            profit = profit + (sell - buy);

        }

        return profit;
    }


    @Test
    public void test(){

        int result = maxProfit(new int[]{7,1,5,3,6,4});

        Assert.assertEquals(result, 7);

        int result1 = maxProfit(new int[]{1,2,3,4,5});

        Assert.assertEquals(result1, 4);

        int result2 = maxProfit(new int[]{7,6,5,4,3,1});

        Assert.assertEquals(result2, 0);

    }
}
