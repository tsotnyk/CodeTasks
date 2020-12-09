package com.j2core.sts.leetcode.com.arrays.makeTwoArraysEqualByReversingSubArrays;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {

        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : target){
            if (numMap.containsKey(num)){
                numMap.put(num, numMap.get(num)+1);
            }else {
                numMap.put(num, 1);
            }
        }

        for (int num : arr){
            if (numMap.getOrDefault(num, 0) == 0){
                return false;
            }else {
                numMap.put(num, numMap.get(num)-1);
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(canBeEqual(new int[]{1,2,3,4}, new int[]{2,4,1,3}));
        Assert.assertTrue(canBeEqual(new int[]{1,2,3,4}, new int[]{1,4,3,2}));
        Assert.assertTrue(canBeEqual(new int[]{7}, new int[]{7}));
        Assert.assertTrue(canBeEqual(new int[]{1,12}, new int[]{12,1}));
        Assert.assertTrue(canBeEqual(new int[]{1,12}, new int[]{1,12}));
        Assert.assertTrue(canBeEqual(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1}));
        Assert.assertFalse(canBeEqual(new int[]{3,7,9}, new int[]{3,7,11}));
        Assert.assertFalse(canBeEqual(new int[]{1,2,3,4}, new int[]{1,4,3,3}));
    }
}
