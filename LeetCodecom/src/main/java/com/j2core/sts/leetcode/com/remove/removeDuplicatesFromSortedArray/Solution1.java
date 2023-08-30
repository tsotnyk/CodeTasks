package com.j2core.sts.leetcode.com.remove.removeDuplicatesFromSortedArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int removeDuplicates(int[] nums) {

        int i1 = 1;
        int i2 = 1;

        while (i1 < nums.length){
            if (nums[i1] == nums[i2-1]){
                i1++;
                continue;
            }
            nums[i2++] = nums[i1++];
        }

        return i2;
    }

    @Test
    public void test(){

        Assert.assertEquals(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}), 5);
    }
}
