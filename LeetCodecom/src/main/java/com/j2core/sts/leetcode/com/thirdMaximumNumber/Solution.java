package com.j2core.sts.leetcode.com.thirdMaximumNumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public int thirdMaxOld(int[] nums) {

        if (nums.length < 3){

         if (nums[0] > nums[1]){
             return nums[0];
         }  else return nums[1];

        }else if (nums.length == 3){

            int result = nums[0];

            for (int i = 1; i < nums.length; i++){
                if (nums[i] < result){
                    result = nums[i];
                }
            }

            return result;

        }else {

            int index = 0;
            int[] resultArray = new int[3];

            return 0;
        }
    }

    public int thirdMax(int[] nums) {

        Arrays.sort(nums);
        int index = nums.length-1;
        if (nums.length < 3) return nums[index];
        int num = nums[index--];
        int counter = 3;

        while (counter > 1 && index > -1){

            if (num != nums[index]){
                counter--;
                num = nums[index];
            }

            index--;
        }

        return ( counter == 1) ? num : nums[nums.length-1];
    }

    @Test
    public void test(){

        Assert.assertEquals(1, thirdMax(new int[]{3,2,1}));
        Assert.assertEquals(2, thirdMax(new int[]{2,1}));
        Assert.assertEquals(1, thirdMax(new int[]{3,2,1,2}));
    }
}
