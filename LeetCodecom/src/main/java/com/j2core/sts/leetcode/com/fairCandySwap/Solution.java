package com.j2core.sts.leetcode.com.fairCandySwap;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {

        int[] result = new int[2];
        long sumA = sumAllElements(A);
        long sumB = sumAllElements(B);

        for(int i = 0; i < A.length; i++){
            int tmpNumA = A[i];
            long tmpSumA = sumA - tmpNumA;
            for (int j= 0; j < B.length; j++){
                int tmpNumB = B[j];
                if (tmpSumA + tmpNumB == sumB - tmpNumB + tmpNumA){
                    result[0] = A[i];
                    result[1] = B[j];
                    return result;
                }
            }
        }

        return result;
    }

    private long sumAllElements(int[] array){

        long sum = 0;
        for (int num : array){
            sum += num;
        }
        return sum;
    }

    @Test
    public void test(){

        int[] result = fairCandySwap(new int[]{1,1}, new int[]{2,2});

        Assert.assertEquals(new int[]{1, 2}, result);

    }
}
