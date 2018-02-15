package com.j2core.sts.leetcode.com.LargestNumberAtLeastTwiceOfOthers;

public class Solution {

    public int dominantIndex(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }else {
            int index = 0;
            int maxValue = nums[index];
            for (int i = 1; i < nums.length; i++){
                if (maxValue < nums[i]){
                    maxValue = nums[i];
                    index = i;
                }
            }

            for (int j = 0; j < nums.length;  j++){

                if (nums[j] != maxValue){
                    if (nums[j]*2 > maxValue) {
                        return -1;
                    }
                }
            }
            return index;
        }
    }
}
