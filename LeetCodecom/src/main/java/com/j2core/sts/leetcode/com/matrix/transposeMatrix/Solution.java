package com.j2core.sts.leetcode.com.matrix.transposeMatrix;

public class Solution {

    public int[][] transpose(int[][] A) {

        int[][] result = new int[A[0].length][A.length];

        for (int j = 0; j < A[0].length; j++){

            for (int i = 0; i < A.length; i++){

                result[j][i] = A[i][j];

            }

        }

        return result;

    }
}
