package com.j2core.sts.leetcode.com.maximumElementAfterDecreasingAndRearranging;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);

        int maxValue = 1;

        for (int i = 1; i < arr.length; i++){
            if (Math.abs(maxValue - arr[i]) > 1){
                maxValue++;
            }else {
                maxValue = arr[i];
            }
        }

        return maxValue;
    }

    @Test
    public void test(){

        Assert.assertEquals(maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}), 2);
        Assert.assertEquals(maximumElementAfterDecrementingAndRearranging(new int[]{1, 100, 1000}), 3);
        Assert.assertEquals(maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}), 5);
    }

}
