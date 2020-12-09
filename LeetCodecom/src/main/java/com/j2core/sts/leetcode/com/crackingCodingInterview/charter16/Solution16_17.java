package com.j2core.sts.leetcode.com.crackingCodingInterview.charter16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution16_17 {

    public int maxSubArraySum(int[] array){

        int maxSum = array[0];
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                array[j] = array[j]+array[i];
                if(array[j] > maxSum){
                    maxSum = array[j];
                }
            }
        }

        return maxSum;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxSubArraySum(new int[]{2,-8,3,-2,4,-10}), 5);
    }
}
