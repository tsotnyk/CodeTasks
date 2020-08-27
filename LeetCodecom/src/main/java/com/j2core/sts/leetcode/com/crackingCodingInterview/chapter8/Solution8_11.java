package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution8_11 {

    public int calculateNumbersOfWays(int sum, int[] coins){

        if (coins == null || coins.length < 1 || sum == 0) return 0;

        int[] matrix = new int[sum+1];
        matrix[0] = 1;

        for (int i = 1; i <= sum; i++){
            int sumWays = 0;
            for (int coin : coins) {
                if (coin > i) break;
                sumWays += matrix[i - coin];
            }
            matrix[i] = sumWays;
        }

        return matrix[sum];
    }

    @Test
    public void test(){

        Assert.assertEquals(calculateNumbersOfWays(12, new int[]{1,5,10,25}), 26);

    }
}
