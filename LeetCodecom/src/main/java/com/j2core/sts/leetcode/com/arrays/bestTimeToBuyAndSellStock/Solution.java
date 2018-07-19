package com.j2core.sts.leetcode.com.arrays.bestTimeToBuyAndSellStock;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {


    public int maxProfit(int[] prices) {

        if (prices.length < 2) return 0;

        int profit = 0;
        int big;
        int small = prices[0];

        for (int i = 1; i < prices.length; ){

            if (prices[i] < small){

                small = prices[i];

                for (int j = i+1; j < prices.length; j++){

                    if (prices[j] < small){
                        small = prices[j];
                        i = j+1;
                        break;
                    }else if (prices[j] > small){

                        int tmp = prices[j] - small;
                        if (tmp > profit){

                            profit = tmp;
                        }
                    }
                }

            }else {

                big = prices[i];
                if (big - small > profit){
                    profit = big - small;
                }
                i++;
            }
        }
        return profit;

    }


    @Test
    public void test(){

        int result = maxProfit(new int[]{7,1,5,3,6,4});

        Assert.assertEquals(result, 5);

        int result1 = maxProfit(new int[]{7,6,4,3,1});

        Assert.assertEquals(result1, 0);

        int result2 = maxProfit(new int[]{7,6,4,3,1,2});

        Assert.assertEquals(result2, 1);

        int result3 = maxProfit(new int[]{});

        Assert.assertEquals(result3, 0);

        int result4 = maxProfit(new int[]{2,4,1});

        Assert.assertEquals(result4, 2);

    }
}
