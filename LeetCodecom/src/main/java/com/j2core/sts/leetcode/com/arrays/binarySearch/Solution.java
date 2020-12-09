package com.j2core.sts.leetcode.com.arrays.binarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length-1, target);

    }

    private int binarySearch(int[] nums, int start, int end, int target){

        if (target < nums[start]) return -1;
        if (target > nums[end]) return -1;
        if (target == nums[start]) return start;
        if (target == nums[end]) return end;

        int median = start + ((end-start)/2);
        if (nums[median] == target) return median;
        if (nums[median] < target){
            return binarySearch(nums, median+1, end, target);
        }else {
            return binarySearch(nums, start, median-1, target);
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(search(new int[]{-1,0,3,5,9,12}, 9), 4);
        Assert.assertEquals(search(new int[]{-1,0,3,5,9,12}, 2), -1);

    }
}
