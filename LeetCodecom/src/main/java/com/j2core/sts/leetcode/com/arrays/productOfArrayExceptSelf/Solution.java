package com.j2core.sts.leetcode.com.arrays.productOfArrayExceptSelf;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int sum = 1;
        int index = nums.length-1;
        while (index > -1){
            result[index] = sum;
            sum *= nums[index--];
        }

        index++;
        sum = 1;

        while (index < nums.length){
            result[index] *= sum;
            sum *= nums[index++];
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(productExceptSelf(new int[]{1,2,3,4}), new int[]{24,12,8,6});
    }
}
