package com.j2core.sts.leetcode.com.sortColors;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public void sortColors(int[] nums) {

        if (nums.length <= 1) return;
        if (nums.length == 2){
            if (nums[0] > nums[1]){
                int tmp = nums[1];
                nums[1] = nums[0];
                nums[0] = tmp;
            }
            return;
        }

        int i0 = 0;
        int i2 = nums.length-1;
        int i = 0;
        while (i <= i2){

            int tmp;
            switch (nums[i]){
                case 0:
                    tmp = nums[i0];
                    nums[i0] = nums[i];
                    nums[i] = tmp;
                    i0++;
                    i++;
                    break;
                case 2:
                    tmp = nums[i2];
                    nums[i2--] = nums[i];
                    nums[i] = tmp;
                    break;
                default:
                    i++;

            }
        }
    }

    @Test
    public void test(){

        int[] arr1 = new int[]{2,0,2,1,1,0};
        int[] arr1R = new int[]{0,0,1,1,2,2};
        sortColors(arr1);

        int[] arr2 = new int[]{2,0,1};
        int[] arr2R = new int[]{0,1,2};
        sortColors(arr2);

        Assert.assertEquals(arr1, arr1R);
        Assert.assertEquals(arr2, arr2R);

    }
}
