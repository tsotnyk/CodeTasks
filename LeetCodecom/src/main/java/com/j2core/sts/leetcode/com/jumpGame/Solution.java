package com.j2core.sts.leetcode.com.jumpGame;

public class Solution {

    public boolean canJump(int[] nums) {

        if (nums.length < 2) return true;

        int counter = 1;

        for (int i = nums.length-2; i > 0; i--){
            if (nums[i] >= counter){
                counter = 1;
            }else {
                counter++;
            }
        }

        return nums[0] >= counter;
    }
}
