package com.j2core.sts.leetcode.com.minimumIncrementToMakeArrayUnique;

import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public int minIncrementForUniqueTimeLimitEx(int[] A) {

        if (A == null || A.length < 2) return 0;

        int counter = 0;
        HashSet<Integer> uniqNum = new HashSet<>();

        for (int num : A){

            int tmpCounter = 0;
            while (uniqNum.contains(num)){
                tmpCounter++;
                num++;
            }
            uniqNum.add(num);
            counter += tmpCounter;
        }

        return counter;
    }

    public int minIncrementForUnique(int[] A) {

        if (A == null || A.length < 2) return 0;

        Arrays.sort(A);
        int counter = 0;

        for (int i = 1; i < A.length; i++){
            if (A[i] <= A[i-1]){
                int delta = A[i-1] - A[i] + 1;
                A[i] += delta;
                counter += delta;
            }
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(minIncrementForUnique(null), 0);
        Assert.assertEquals(minIncrementForUnique(new int[]{}), 0);
        Assert.assertEquals(minIncrementForUnique(new int[]{1}), 0);
        Assert.assertEquals(minIncrementForUnique(new int[]{1,2,2}), 1);
        Assert.assertEquals(minIncrementForUnique(new int[]{3,2,1,2,1,7}), 6);

    }
}
