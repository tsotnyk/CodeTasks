package com.j2core.sts.leetcode.com.arrays.subarrayProductLessThanK;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        long sum = 1;
        int first = 0;
        int last = 0;
        int counter = 0;
        while(last < nums.length){

            sum *= nums[last];

            while(first <= last && sum >= k){
                sum /= nums[first];
                first++;
            }
            counter += (last - first + 1);
            last++;
        }
        return counter;
    }


    @Test
    public void test(){

        int result = numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);

        Assert.assertTrue(result==8);

        int result1 = numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19);

        Assert.assertTrue(result1==18);

    }

}
