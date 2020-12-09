package com.j2core.sts.leetcode.com.rotateArray;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public void rotateOld(int[] nums, int k) {

        if(nums.length > k) {

            int lastIndex = nums.length - k;

            int[] tmp = new int[k];

            for (int i = 0; i < k; i++) {

                tmp[i] = nums[lastIndex + i];

            }

            System.arraycopy(nums, 0, nums, k, nums.length - k);

            for (int i = 0; i < k; i++) {

                nums[i] = tmp[i];

            }
        }else if (nums.length != k){

            int step = 0;
            while (step < k){

                int tmp = nums[nums.length-1];

                for (int i = nums.length-1; i > 0; i--){

                    nums[i] = nums[i-1];

                }
                nums[0] = tmp;
                step++;

            }
        }

    }

    public void rotateCopyNum(int[] nums, int k) {

        k = k%nums.length;

        if (k > 0){

            int[] tmpArray = Arrays.copyOfRange(nums, nums.length-k, nums.length);

            System.arraycopy(nums, 0, nums, k, nums.length-k);
            System.arraycopy(tmpArray, 0, nums, 0, k);
        }
    }

    @Test
    public void test(){

        int[] array1 = new int[]{1,2,3,4,5,6,7};
        rotateCopyNum(array1, 3);
        Assert.assertEquals(array1, new int[]{5,6,7,1,2,3,4});

        int[] array2 = new int[]{-1,-100,3,99};
        rotateCopyNum(array2, 2);
        Assert.assertEquals(array2, new int[]{3,99,-1,-100});
    }
}
