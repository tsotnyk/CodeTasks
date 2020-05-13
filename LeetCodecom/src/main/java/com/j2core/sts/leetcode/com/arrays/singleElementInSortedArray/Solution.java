package com.j2core.sts.leetcode.com.arrays.singleElementInSortedArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) return nums[0];
        int i = 0;
        int j = nums.length-1;

        while (i <= j){
            if (nums[i] != nums[i+1]){
                return nums[i];
            }else {
                while (nums[i] == nums[i+1]){
                    i++;
                }
                i++;
            }
            if (nums[j] != nums[j-1]){
                return nums[j];
            }else {
                while (nums[j] == nums[j-1]){
                    j--;
                }
                j--;
            }
        }

        return nums[0];
    }

    @Test
    public void test(){

        Assert.assertEquals(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}), 2);
        Assert.assertEquals(singleNonDuplicate(new int[]{1,2,2,3,3,4,4,8,8}), 1);
        Assert.assertEquals(singleNonDuplicate(new int[]{1,1,2,2,3,4,4,8,8}), 3);
        Assert.assertEquals(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,8}), 8);
        Assert.assertEquals(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,7,8,8}), 7);


    }
}
