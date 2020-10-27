package com.j2core.sts.leetcode.com.longestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int longestSubarray(int[] nums, int limit) {

        int maxLength = 1;

        for (int i = 0; i < nums.length-1; i++){
            int length = 1;
            int minValue = nums[i];
            int maxVal = nums[i];
            int delta = 0;
            for (int j = i+1; j < nums.length; j++){
                boolean flag = false;
                if (minValue > nums[j]){
                    minValue = nums[j];
                    flag = true;
                }
                if (maxVal < nums[j]){
                    maxVal = nums[j];
                    flag = true;
                }
                if (flag){
                    delta = maxVal-minValue;
                }
                if (delta <= limit) {
                    length = j - i + 1;
                }else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, length);
            if (maxLength >= nums.length-i) break;
        }

        return maxLength;
    }

    @Test
    public void test(){

//        Assert.assertEquals(longestSubarray(new int[]{8,2,4,7}, 4), 2);
        Assert.assertEquals(longestSubarray(new int[]{10,1,2,4,7,2}, 5), 4);
        Assert.assertEquals(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0), 3);

    }
}
