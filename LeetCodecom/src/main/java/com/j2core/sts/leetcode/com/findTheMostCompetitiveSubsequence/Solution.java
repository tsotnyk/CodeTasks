package com.j2core.sts.leetcode.com.findTheMostCompetitiveSubsequence;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int[] mostCompetitiveTLE(int[] nums, int k) {

        int[] resultArray = new int[k];
        int resultIndex = 0;
        int lastPosition = -1;
        int minValue;
        int minIndex;
        int start = nums.length-k;
        while (start < nums.length){
            minValue = nums[start];
            minIndex = start;
            int index = start-1;
            while (index > lastPosition){
                if (nums[index] <= minValue){
                    minValue = nums[index];
                    minIndex = index;
                }
                index--;
            }
            resultArray[resultIndex++] = minValue;
            lastPosition = minIndex;
            start++;
        }

        return resultArray;
    }

    public int[] mostCompetitive(int[] nums, int k) {

        LinkedList<Integer> list = new LinkedList<>();
        int additionalCount = nums.length - k;
        for (int num : nums) {
            while (!list.isEmpty() && list.getLast() > num && additionalCount > 0) {
                list.removeLast();
                additionalCount--;
            }
            list.addLast(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.removeFirst();
        }
        return result;
    }

    @Test
    public void test(){
        Assert.assertEquals(mostCompetitive(new int[]{3,5,2,6}, 2), new int[]{2,6});
        Assert.assertEquals(mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4), new int[]{2,3,3,4});

    }
}
