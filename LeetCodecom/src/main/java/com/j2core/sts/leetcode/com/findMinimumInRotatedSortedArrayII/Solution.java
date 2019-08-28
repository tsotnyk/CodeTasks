package com.j2core.sts.leetcode.com.findMinimumInRotatedSortedArrayII;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int findMin(int[] nums) {

        int lastIndex = nums.length-1;
        if (lastIndex == 0 || nums[0] < nums[lastIndex]) return nums[0];

        int minEl = nums[lastIndex];
        int indexFirst = 0;
        int indexLast = lastIndex-1;

        while (indexFirst <= indexLast){
            if (nums[indexFirst] < minEl){
                return nums[indexFirst];
            }
            if (nums[indexLast] < minEl){
                minEl = nums[indexLast];
            }
            indexFirst++;
            indexLast--;
        }
        return minEl;
    }

    @Test
    public void test(){

        int result = findMin(new int[]{3,1,3,3});
        Assert.assertEquals(result, 1);
    }
}
