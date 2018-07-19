package com.j2core.sts.leetcode.com.thirdMaximumNumber;

public class Solution {

    public int thirdMax(int[] nums) {

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
}
