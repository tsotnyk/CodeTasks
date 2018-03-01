package com.j2core.sts.leetcode.com.searchInsertPosition;

import org.testng.annotations.Test;

public class Solution {

    public int searchInsert(int[] nums, int target) {

        int i;

        for (i = 0; i < nums.length; i++){

            if ( target <= nums[i]){
                return i;
            }
        }

        return i;
    }


    @Test
    public void test(){

        Solution solution = new Solution();

        int index = solution.searchInsert(new int[0], 0);

        System.out.print(index);
    }
}
