package com.j2core.sts.leetcode.com.validTriangleNumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public int triangleNumberOld(int[] nums) {

        Arrays.sort(nums);
        int counter = 0;
        for (int i = nums.length-1; i > 1; i--){
            for (int k = i-1; k > 0; k--){
                for (int l = k-1; l > -1; l--){
                    if (nums[l] + nums[k] > nums[i]){
                        counter++;
                    }else {
                        break;
                    }
                }
            }
        }

        return counter;
    }

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }

    @Test
    public void test(){

        Assert.assertEquals(3, triangleNumber(new int[]{2,2,3,4}));
        Assert.assertEquals(4, triangleNumber(new int[]{4,2,3,4}));

    }
}
