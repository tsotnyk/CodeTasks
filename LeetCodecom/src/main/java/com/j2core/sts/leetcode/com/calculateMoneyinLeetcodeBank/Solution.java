package com.j2core.sts.leetcode.com.calculateMoneyinLeetcodeBank;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int totalMoney(int n) {

        int weeks = n/7;
        int days = n%7;

        int cost = 1;
        int sum = 0;
        for (int i = 0; i < weeks; i++){
            int costWeek = cost;
            for (int j = 0; j < 7; j++){
                sum += costWeek++;
            }
            cost++;
        }

        for (int k = 0; k < days; k++){
            sum += cost++;
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(totalMoney(4), 10);
        Assert.assertEquals(totalMoney(10), 37);
        Assert.assertEquals(totalMoney(20), 96);

    }
}
