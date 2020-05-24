package com.j2core.sts.leetcode.com.tripleByte;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution44 {

    public static int stock_runs(int[] prices){

        if (prices == null || prices.length < 1) return 0;
        if (prices.length == 1) return 1;

        int maxLength = 1;
        int index = 0;

        while (index+1 < prices.length){

            if (prices[index] == prices[index+1]){
                index++;
            }else {
                int counter = 1;
                if (prices[index] < prices[index+1]){
                    while (index+1 < prices.length && prices[index] < prices[index+1]){
                        counter++;
                        index++;
                    }
                }else {
                    while (index+1 < prices.length && prices[index] > prices[index+1]){
                        counter++;
                        index++;
                    }
                }
                maxLength = Math.max(maxLength, counter);
            }
        }
        return maxLength;
    }

    @Test
    public void test(){

        Assert.assertEquals(stock_runs(new int[]{1,2,3}), 3);
        Assert.assertEquals(stock_runs(new int[]{2,3,4,3,2,1}), 4);
        Assert.assertEquals(stock_runs(new int[]{3,2,2,1}), 2);


    }
}
