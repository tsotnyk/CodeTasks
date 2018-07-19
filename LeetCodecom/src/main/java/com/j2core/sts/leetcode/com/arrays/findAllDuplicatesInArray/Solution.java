package com.j2core.sts.leetcode.com.arrays.findAllDuplicatesInArray;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<Integer> findDuplicates(int[] nums) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums){

            if (numMap.containsKey(num)){
                int tmp = numMap.get(num) + 1;
                numMap.put(num, tmp);
            }else {
                numMap.put(num, 1);
            }
        }

        List<Integer> result = new LinkedList<>();

        Set<Map.Entry<Integer, Integer>> numSet = numMap.entrySet();

        for (Map.Entry<Integer, Integer> entry : numSet){

            if (entry.getValue() == 2){
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        return result;
    }

    @Test
    public void test(){

        List<Integer> result = findDuplicates(new int[]{4,3,2,7,8,2,3,1});

        Assert.assertEquals(result.size(), 2);

    }
}
