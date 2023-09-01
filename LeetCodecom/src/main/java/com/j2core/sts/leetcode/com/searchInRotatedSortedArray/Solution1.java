package com.j2core.sts.leetcode.com.searchInRotatedSortedArray;

public class Solution1 {

    public int search(int[] nums, int target) {

        int index = nums.length-1;
        if(nums[0] == target) return 0;
        if (nums[index] == target) return index;
        int prevElement;
        if (nums[index] > target){
            prevElement = nums[index--];
            for (int i = index; i > -1 && nums[i] < prevElement; i--){
                if (nums[i] == target) return i;
            }
            return -1;
        }
        prevElement = nums[0];
        for (int i = 1; i < index && nums[i] > prevElement; i++){
            if (nums[i] == target) return i;
        }
        return -1;

    }

}
