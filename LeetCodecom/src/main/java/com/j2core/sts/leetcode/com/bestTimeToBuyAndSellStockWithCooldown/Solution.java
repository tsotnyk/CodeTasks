package com.j2core.sts.leetcode.com.bestTimeToBuyAndSellStockWithCooldown;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxProfit(int[] prices) {

        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);

    }

    @Test
    public void test(){

        Assert.assertEquals(maxProfit(new int[]{1,2,3,0,2}), 3);
    }
}
