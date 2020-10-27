package com.j2core.sts.leetcode.com.arrays.findTwoNonOverlappingSubArraysEachWithTargetSum;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int minSumOfLengths(int[] arr, int target) {

        if (arr.length < 2) return -1;

        int[] matrix = new int[arr.length+1];
        List<Integer> lengthList = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            matrix[i+1] = sum;
        }
        int indexS = 0;
        int indexE = indexS+1;
        while (indexS < arr.length){
            while (indexE <= arr.length){
                sum = matrix[indexE]-matrix[indexS];
                if (sum == target){
                    lengthList.add(indexE-indexS);
                    indexS = indexE-1;
                    indexE = indexS;
                    break;
                }else if (sum > target) break;
                indexE++;
            }
            indexS++;
        }

        if (lengthList.size() < 2) return -1;
        Collections.sort(lengthList);

        return lengthList.get(0)+lengthList.get(1);
    }

    @Test
    public void test(){

        Assert.assertEquals(minSumOfLengths(new int[]{1,2,2,3,2,6,7,2,1,4,8}, 5), 4);
        Assert.assertEquals(minSumOfLengths(new int[]{1,6,1}, 7), -1);
        Assert.assertEquals(minSumOfLengths(new int[]{3,2,2,4,3}, 3), 2);
        Assert.assertEquals(minSumOfLengths(new int[]{7,3,4,7}, 7), 2);
        Assert.assertEquals(minSumOfLengths(new int[]{4,3,2,6,2,3,4}, 6), -1);
        Assert.assertEquals(minSumOfLengths(new int[]{5,5,4,4,5}, 3), -1);
        Assert.assertEquals(minSumOfLengths(new int[]{3,1,1,1,5,1,2,1}, 3), 3);

    }
}
