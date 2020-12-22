package com.j2core.sts.leetcode.com.maximumProfitOfOperatingCentennialWheel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int maxProfit = 0;
        int maxProfitRotation = -1;
        int rotation = 0;
        int profit = 0;
        int guys = customers[0];
        int index = 0;

        while (index < customers.length || guys > 0){
            int curBoard = Math.min(guys, 4);
            guys -= curBoard;
            profit += curBoard*boardingCost - runningCost;
            rotation++;
            if (profit > maxProfit){
                maxProfit = profit;
                maxProfitRotation = rotation;
            }
            index++;
            if (index < customers.length){
                guys += customers[index];
            }
        }

        return maxProfitRotation;
    }

    @Test
    public void test(){

        Assert.assertEquals(minOperationsMaxProfit(new int[]{8,3}, 5,6), 3);
        Assert.assertEquals(minOperationsMaxProfit(new int[]{10,9,6}, 6,4), 7);
        Assert.assertEquals(minOperationsMaxProfit(new int[]{3,4,0,5,1}, 1,92), -1);
        Assert.assertEquals(minOperationsMaxProfit(new int[]{10,10,6,4,7}, 3,8), 9);

    }
}
