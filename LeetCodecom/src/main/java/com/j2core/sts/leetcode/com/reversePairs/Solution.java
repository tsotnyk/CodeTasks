package com.j2core.sts.leetcode.com.reversePairs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int reversePairsTLE2(int[] nums) {

        int counter = 0;
        for (int i = 0; i < nums.length-1; i++){
            long num = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if ((long)nums[j]*2 < num){
                    counter++;
                }
            }
        }

        return counter;
    }

    public int reversePairsTLE1(int[] nums) {

        Map<Long, Integer> numMap = new HashMap<>();

        for (long num : nums){
            long tmpNum = 2*num;
            numMap.put(tmpNum, numMap.getOrDefault(tmpNum, 0)+1);
        }

        int counter = 0;
        TreeMap<Long, Integer> treemap = new TreeMap<>(numMap);

        for (long num : nums){
            long tmpNum = 2*num;
            treemap.put(tmpNum, treemap.get(tmpNum)-1);
            for (Map.Entry<Long, Integer> entry : treemap.entrySet()){
                if (num > entry.getKey()){
                    counter += entry.getValue();
                }
                else {
                    break;
                }
            }

        }

        return counter;
    }

    public int reversePairs(int[] nums) {

    }

    @Test
    public void test(){

        Assert.assertEquals(reversePairs(new int[]{1,3,2,3,1}), 2);

        Assert.assertEquals(reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}), 0);
    }
}
