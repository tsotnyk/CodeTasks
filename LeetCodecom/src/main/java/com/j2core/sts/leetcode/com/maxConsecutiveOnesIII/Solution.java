package com.j2core.sts.leetcode.com.maxConsecutiveOnesIII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int longestOnes(int[] A, int K) {

        int zero = 0;
        int maxLength = K;
        int startIndex = 0;
        int index = 0;

        while (index < A.length){

            while (index < A.length && zero <= K){
                if (A[index] == 0){
                    if (zero < K) {
                        zero++;
                    }else break;
                }
                index++;
            }
            maxLength = Math.max(maxLength, index-startIndex);
            if (A[startIndex++] == 0){
                zero = zero > 0 ? zero-1 : 0;
            }
            if (index < startIndex) index = startIndex;
        }

        return maxLength;
    }

    @Test
    public void test(){

        Assert.assertEquals(longestOnes(new int[]{0,0,1,1,1,0,0}, 0), 3);

        Assert.assertEquals(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3), 10);
    }

}
