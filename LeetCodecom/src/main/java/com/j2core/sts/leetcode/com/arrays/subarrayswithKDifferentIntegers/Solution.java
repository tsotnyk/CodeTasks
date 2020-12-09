package com.j2core.sts.leetcode.com.arrays.subarrayswithKDifferentIntegers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Solution {

    public int subarraysWithKDistinctTimeLimitEx(int[] A, int K) {

        int counter = 0;

        for (int i = 0; i <= A.length-K; i++){
            counter += countSubArray(A, i, K);
        }

        return counter;
    }

    private int countSubArray(int[] array, int index, int k) {

        int counter = 0;
        HashSet<Integer> set = new HashSet<>();
        while (index < array.length && set.size() <= k){
            set.add(array[index]);
            if (set.size() == k){
                counter++;
            }
            index++;
        }

        return counter;
    }

    public int subarraysWithKDistinct(int[] A, int K) {

        return 0;
    }

    @Test
    public void test(){

        Assert.assertEquals(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2), 7);
        Assert.assertEquals(subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3), 3);

    }
}
