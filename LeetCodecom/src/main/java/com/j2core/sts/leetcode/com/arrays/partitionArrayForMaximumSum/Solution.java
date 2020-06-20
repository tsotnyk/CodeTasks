package com.j2core.sts.leetcode.com.arrays.partitionArrayForMaximumSum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxSumAfterPartitioning1(int[] A, int K) {
        int[] dp = new int[A.length + 1];

        for (int i = 1; i <= A.length; ++i) {
            dp[i] = dp[i - 1] + A[i - 1];
            int lmax = A[i - 1];
            for (int j = i - 1; j - 1 >= 0 && i - j < K; --j) {
                lmax = Math.max(lmax, A[j - 1]);
                dp[i] = Math.max(dp[i], dp[j - 1] + lmax * (i - j + 1));

            }
        }

        return dp[A.length];
    }

    public int maxSumAfterPartitioning(int[] A, int K) {

        int sum = findMaxValue(A, 0, K-1, K, Integer.MIN_VALUE);
        int tmpMax = sum;

        for (int i = 1; i < A.length; i++){

            tmpMax = findMaxValue(A, i, i+K-1, K, tmpMax);
            sum += tmpMax;
        }

        return sum;
    }

    private int findMaxValue(int[] array, int indexStart, int indexEnd, int length, int maxVale){

        if (indexStart == 0){
            int max = Integer.MIN_VALUE;
            for (int i = indexStart; i < indexEnd; i++){
                max = Math.max(max, array[i]);
            }
            return max;
        }

        if (indexEnd >= array.length){
            indexEnd = indexEnd - array.length;
        }
        if (array[indexStart-1] < maxVale && array[indexEnd] < maxVale) return maxVale;

        if (array[indexEnd] > maxVale) return maxVale;

        int max = Integer.MIN_VALUE;
        while (length > 0){

            max = Math.max(max, array[indexStart]);
            if (indexStart == array.length){
                indexStart = -1;
            }
            indexStart++;
            length--;
        }
        return max;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxSumAfterPartitioning1(new int[]{1,15,7,9,2,5,10}, 3), 84);
    }
}
