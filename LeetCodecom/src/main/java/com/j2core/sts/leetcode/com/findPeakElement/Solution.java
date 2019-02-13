package com.j2core.sts.leetcode.com.findPeakElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int findPeakElement(int[] nums) {

        int length = nums.length;
        if (length > 2) {

            int first = 0;
            int last = length-1;

            while (first < length && last > -1){

                if (nums[first+1] < nums[first]){
                    return first;
                }
                first++;
                if (nums[last-1] < nums[last]){
                    return last;
                }
                last--;

            }
            return length-1;
        }else if (length > 1){
            return nums[0] > nums[1] ? 0 : 1;
        }else {
            return 0;
        }
    }

    @Test
    public void test(){

        int result = findPeakElement(new int[]{1,2,1});

        Assert.assertEquals(result, 1);

    }
}
