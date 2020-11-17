package com.j2core.sts.leetcode.com.matrix.matrixBlockSum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[][] matrixBlockSumBF(int[][] mat, int K) {

        int[][] outputMatrix = new int[mat.length][mat[0].length];
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int sum = 0;
                for (int k = i-K; k <= i+K; k++){
                    if (k > -1 && k < m) {
                        for (int l = j - K; l <= j + K; l++) {
                            if (l > -1 && l < n){
                                sum += mat[k][l];
                            }
                        }
                    }
                }
                outputMatrix[i][j] = sum;
            }
        }

        return outputMatrix;

    }

    public int[][] matrixBlockSum(int[][] mat, int K) {


    }

    @Test
    public void test(){

        Assert.assertEquals(matrixBlockSumBF(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1), new int[][]{{12,21,16},{27,45,33},{24,39,28}});
        Assert.assertEquals(matrixBlockSumBF(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 2), new int[][]{{45,45,45},{45,45,45},{45,45,45}});

    }
}
