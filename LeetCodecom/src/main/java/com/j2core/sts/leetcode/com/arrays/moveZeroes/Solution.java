package com.j2core.sts.leetcode.com.arrays.moveZeroes;

import org.testng.annotations.Test;

public class Solution {

    public void moveZeroesOld(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++){

            if (nums[i] == 0){

                for (int j = i+1; j< length; j++){

                    if (nums[j] != 0){

                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;

                    }
                }
            }
        }
    }

    public void moveZeroes(int[] nums) {

        if(nums == null || nums.length < 2) return;

        int left = 0;
        int right = 1;

        while(right < nums.length){
            if(nums[left] != 0){
                left++;
                right++;
            }else if (nums[right] == 0){
                right++;
            }else {
                nums[left++] = nums[right];
                nums[right++] = 0;
            }
        }
    }

    @Test
    public void test(){

        int[] array = new int[]{0,1,0,3,12};
        moveZeroes(array);

        System.out.println(array);
    }
}
