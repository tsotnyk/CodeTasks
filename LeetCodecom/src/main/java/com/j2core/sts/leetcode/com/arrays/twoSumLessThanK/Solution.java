package com.j2core.sts.leetcode.com.arrays.twoSumLessThanK;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int twoSumLessThanK(int[] A, int K) {

        int maxSum = -1;

        for (int i = 0; i < A.length-1; i++){
            for (int j = i+1; j < A.length; j++){
                if (A[i] + A[j] < K){
                    maxSum = Math.max(A[i]+A[j], maxSum);
                }
            }
        }

        return maxSum;
    }

    public int twoSumLessThanKNo(int[] A, int K) {
        Arrays.sort(A);
        int start = 0, end = A.length - 1;
        int max = -1;
        while(start < end){
            if(A[start] + A[end] < K){
                max = Math.max(max, A[start] + A[end]);
                start ++;
            }
            else
                end --;
        }
        return max;
    }

    @Test
    public void test(){

        Assert.assertEquals(twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 60), 58);
        Assert.assertEquals(twoSumLessThanK(new int[]{10,20,30}, 15), -1);

    }
}
