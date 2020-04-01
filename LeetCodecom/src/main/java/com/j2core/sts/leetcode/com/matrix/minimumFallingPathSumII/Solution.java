package com.j2core.sts.leetcode.com.matrix.minimumFallingPathSumII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int minFallingPathSum(int[][] arr) {

        int length = arr.length;
        int index = 1;
        int[] sumArray = new int[length];

        System.arraycopy(arr[0], 0, sumArray, 0, length);

        while (index < length){

            int[] tmpArray = new int[length];
            Arrays.fill(tmpArray, Integer.MAX_VALUE);

            for (int i = 0; i < length; i++){
                for (int j = 0; j < length; j++){
                    if (i != j){
                        tmpArray[j] = Math.min(sumArray[i]+arr[index][j], tmpArray[j]);
                    }
                }
            }

            sumArray = tmpArray;
            index++;
        }

        int sum = sumArray[0];

        for (int num : sumArray){
            sum = sum > num ? num : sum;
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}), 13);
    }
}
