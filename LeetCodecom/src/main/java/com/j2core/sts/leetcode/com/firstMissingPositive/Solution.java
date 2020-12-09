package com.j2core.sts.leetcode.com.firstMissingPositive;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int firstMissingPositiveOld(int[] nums) {

        int length = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < length; i++){

            if(!numMap.containsKey(nums[i])){
                numMap.put(nums[i], null);
            }

        }

        for (int j = 1; j <= length; j++){

            if (!numMap.containsKey(j)){
                return j;
            }
        }

        return length+1;
    }

    @Test
    public void test1(){

        Assert.assertEquals(firstMissingPositiveOld(new int[]{1,2,0}), 3);
        Assert.assertEquals(firstMissingPositiveOld(new int[]{3,4,-1,1}), 2);
        Assert.assertEquals(firstMissingPositiveOld(new int[]{7,8,9,11,12}), 1);

    }

    public int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);
        int smallerMissingNum = 1;

        for (int num : nums){

            if (num > 0){
                if (num > smallerMissingNum){
                    return smallerMissingNum;
                }
                if (num == smallerMissingNum){
                    smallerMissingNum++;
                }
            }
        }
        return smallerMissingNum;
    }

    @Test
    public void test2(){

        Assert.assertEquals(firstMissingPositive(new int[]{1,2,0}), 3);
        Assert.assertEquals(firstMissingPositive(new int[]{3,4,-1,1}), 2);
        Assert.assertEquals(firstMissingPositive(new int[]{7,8,9,11,12}), 1);
        Assert.assertEquals(firstMissingPositive(new int[]{1,1}), 2);

    }
}
