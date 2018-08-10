package com.j2core.sts.leetcode.com.arrays.maximumAverageSubarrayI;

public class Solution {

    public double findMaxAverage(int[] nums, int k) {

        double result = 0;

        double tmpSum = 0;
        for (int i = 0; i < k; i++){

            tmpSum = tmpSum + nums[i];

        }

        result = tmpSum/k;

        for (int j = 1; j <= nums.length-k; j++){

            tmpSum = tmpSum - nums[j-1] + nums[j+k-1];
            double tmpResult = tmpSum/k;

            if (tmpResult > result){

                result = tmpResult;
            }
        }

        return result;
    }
}
