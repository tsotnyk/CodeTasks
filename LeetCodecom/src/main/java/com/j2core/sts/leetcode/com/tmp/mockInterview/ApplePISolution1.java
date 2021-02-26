package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ApplePISolution1 {

    public boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char symbol : s.toCharArray()){
            map.put(symbol, map.getOrDefault(symbol, 0)+1);
        }

        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue()%2 != 0){
                if (flag) return false;
                flag = true;
            }
        }

        return true;
    }

    public int findLHS(int[] nums) {

        int maxLength = 0;
        Arrays.sort(nums);
        int index = 0;
        int firstIndex = 0;
        int secondIndex = firstIndex;
        while (index < nums.length){
            if (nums[index] == nums[secondIndex]){
                index++;
            }else {
                if (secondIndex == firstIndex){
                    secondIndex = index;
                }else {
                    maxLength = Math.max(maxLength, index-firstIndex);
                    firstIndex = secondIndex;
                    secondIndex = index++;
                }
                if (nums[firstIndex] != nums[secondIndex]-1){
                    firstIndex = secondIndex;
                }
            }
        }

        if (firstIndex == secondIndex) return maxLength;

        return Math.max(maxLength, index-firstIndex);
    }

    @Test
    public void testFindLHS(){

        Assert.assertEquals(findLHS(new int[]{1,4,1,3,1,-14,1,-13}), 2);


        Assert.assertEquals(findLHS(new int[]{1,3,5,7,9,11,13,15,17}), 0);

        Assert.assertEquals(findLHS(new int[]{1,2,2,1}), 4);

        Assert.assertEquals(findLHS(new int[]{1,3,2,2,5,2,3,7}), 5);
        Assert.assertEquals(findLHS(new int[]{1,2,3,4}), 2);

        Assert.assertEquals(findLHS(new int[]{1,1,1,1}), 0);


    }

}
