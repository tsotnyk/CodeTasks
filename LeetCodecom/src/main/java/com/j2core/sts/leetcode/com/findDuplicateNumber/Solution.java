package com.j2core.sts.leetcode.com.findDuplicateNumber;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public int findDuplicateOld(int[] nums) {

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

    public int findDuplicateSet(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            if (set.contains(num)) return num;
            set.add(num);
        }

        return 0;
    }

    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]) return nums[i];
        }

        return 0;
    }

    public int findDuplicateNew(int[] nums){

        Arrays.sort(nums);
        int num = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == num) {
                break;
            }
            num = nums[i];
        }

        return num;
    }


    @Test
    public void test(){

        int result = findDuplicateNew(new int[]{1,3,4,2,2});

        Assert.assertTrue(result == 2);
    }

}
