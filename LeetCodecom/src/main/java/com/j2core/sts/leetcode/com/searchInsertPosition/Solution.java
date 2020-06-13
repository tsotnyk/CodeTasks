package com.j2core.sts.leetcode.com.searchInsertPosition;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int searchInsertOld(int[] nums, int target) {

        int i;

        for (i = 0; i < nums.length; i++){

            if ( target <= nums[i]){
                return i;
            }
        }

        return i;
    }

    public int searchInsert(int[] nums, int target) {

        if (nums.length < 1) return 0;
        if (nums[0] > target) return 0;
        if (nums[nums.length-1] < target) return nums.length;
        if (nums[nums.length-1] == target) return nums.length-1;

        int index = 1;

        while (index < nums.length){

            if (nums[index] == target) return index;
            if (nums[index] > target){
                if (nums[index-1] >= target){
                    return index-1;
                }else return index;
            }
            index += 2;
        }
        return index-1;
    }

    @Test
    public void test(){

//        int index = searchInsert(new int[0], 0);
//
//        System.out.print(index);

        Assert.assertEquals(searchInsert(new int[]{1,2,4,6,7}, 3), 2);

        Assert.assertEquals(searchInsert(new int[]{1,3,5}, 4), 2);
        Assert.assertEquals(searchInsert(new int[]{1,3}, 2), 1);
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 5), 2);
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 2), 1);
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 7), 4);
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 0), 0);

    }
}
