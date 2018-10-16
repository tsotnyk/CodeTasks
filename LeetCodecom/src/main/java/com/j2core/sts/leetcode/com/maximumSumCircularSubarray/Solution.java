package com.j2core.sts.leetcode.com.maximumSumCircularSubarray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxSubarraySumCircularSlow(int[] A) {

        int length = A.length;
        int max = Integer.MIN_VALUE;
        int index;

        for (int i = 0; i < A.length; i++) {

            index = i;
            int sum = 0;

            for (int j = 0; j < length; j++) {

                if (index == length) {
                    index = 0;
                }

                sum = sum + A[index++];

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }


    public int maxSubArraySumCircular(int[] A) {

        int localMax = -30001;
        int globalMax = -30001;
        int localMin = 30001;
        int globalMin = 30001;
        int sum = 0;


        for (int e : A) {

            sum += e;
            localMax = Math.max(localMax + e, e);
            localMin = Math.min(localMin + e, e);
            globalMax = Math.max(globalMax, localMax);
            globalMin = Math.min(globalMin, localMin);

        }

        return globalMax > 0 ? Math.max(globalMax, sum - globalMin) : globalMax;
    }

    @Test
    public void test(){

        int result = maxSubArraySumCircular(new int[]{1, -2, 3, -2});

        Assert.assertEquals(3, result);

    }

}
