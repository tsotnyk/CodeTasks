package com.j2core.sts.leetcode.com.arrays.findAllNumbersDisappearedInArray;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findDisappearedNumbers1(int[] nums) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {

            numMap.put(num, null);
        }
        List<Integer> result = new LinkedList<>();

        for (int i = 1; i <= nums.length; i++){

            if (!numMap.containsKey(i)){

                result.add(i);
            }
        }

        return result;

    }


    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++){

            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int j = 0; j < nums.length; j++){

            if (nums[j] > 0){
                result.add(j+1);
            }

        }

        return result;
    }


    @Test
    public void test(){

        List<Integer> result = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});

        Assert.assertEquals(2, result.size());

    }
}
