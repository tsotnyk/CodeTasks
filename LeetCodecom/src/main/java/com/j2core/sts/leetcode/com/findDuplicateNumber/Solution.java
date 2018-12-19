package com.j2core.sts.leetcode.com.findDuplicateNumber;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Solution {


    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length-1; i++){
            int num = nums[i];
            for (int j = i+1; j< nums.length; j++){

                if (num == nums[j]){
                    return num;
                }
            }
        }
        return 0;
    }

    @Test
    public void test(){

        int result = findDuplicate(new int[]{1,3,4,2,2});

        Assert.assertTrue(result == 2);
    }

}
