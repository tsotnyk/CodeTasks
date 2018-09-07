package com.j2core.sts.leetcode.com.containsDuplicate;

import java.util.Arrays;

public class Solution {

    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ){

            int num = nums[i];
            int counter = 1;

            while (++i < nums.length && nums[i] == num){
                counter++;
            }

            if (counter > 1) return true;
        }
        return false;
    }

}
