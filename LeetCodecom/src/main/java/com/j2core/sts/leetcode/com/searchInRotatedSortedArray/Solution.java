package com.j2core.sts.leetcode.com.searchInRotatedSortedArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int search1(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target < nums[0] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length < 1) return -1;
        if (nums[nums.length-1] == target) return nums.length-1;
        if (nums[0] == target) return 0;
        int index = 0;
        if (nums[0] < target){
            while (index < nums.length-1 && nums[index] < target){
                index++;
            }
        }else {
            index = nums.length-1;
            while (index > 0 && nums[index] > target){
                index--;
            }
        }
        return nums[index] == target ? index : -1;
    }

    @Test
    public void test(){

        Assert.assertEquals(search(new int[]{4,5,6,7,0,1,2}, 0), 4);
        Assert.assertEquals(search(new int[]{4,5,6,7,0,1,2}, 3), -1);
        Assert.assertEquals(search(new int[]{1}, 0), -1);
        Assert.assertEquals(search(new int[]{3,1}, 3), 0);



    }

}
