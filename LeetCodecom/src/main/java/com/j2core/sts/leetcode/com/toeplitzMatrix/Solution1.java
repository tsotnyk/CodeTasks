package com.j2core.sts.leetcode.com.toeplitzMatrix;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public boolean isToeplitzMatrix(int[][] matrix) {

        int iLength = matrix.length;
        int jLength = matrix[0].length;

        for (int j = 0; j < jLength; j++){
            if (!toeplitzDiagonal(0, j, matrix, iLength, jLength)){
                return false;
            }
        }

        for (int i = 1; i < iLength; i++){
            if (!toeplitzDiagonal(i, 0, matrix, iLength, jLength)){
                return false;
            }
        }

        return true;
    }

    private boolean toeplitzDiagonal(int i, int j, int[][] m, int iL, int jL){

        int base = m[i++][j++];
        while (i < iL && j < jL){
            if (m[i++][j++] != base) return false;
        }

        return true;
    }

    @Test
    public void test(){

        int[][] m1 = new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };

        Assert.assertTrue(isToeplitzMatrix(m1));
    }
}
