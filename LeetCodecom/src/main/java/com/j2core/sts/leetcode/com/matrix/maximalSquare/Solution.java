package com.j2core.sts.leetcode.com.matrix.maximalSquare;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maximalSquare(char[][] matrix) {

        if (matrix.length < 1) return 0;
        int maxSteps = 0;
        int iLength = matrix.length;
        int jLength = matrix[0].length;
        for (int i = 0; i < iLength; i++){
            if (iLength-i <= maxSteps){
                break;
            }
            for (int j = 0; j < jLength; j++){
                if (matrix[i][j] == '1'){
                    int steps = 1;
                    while (checkSquareSubMatrix(matrix, i, iLength, j, jLength, steps)){
                        steps++;
                    }
                    maxSteps = Math.max(maxSteps, steps);
                }
                if (jLength-j <= maxSteps){
                    break;
                }
            }
        }
        return maxSteps*maxSteps;
    }

    private boolean checkSquareSubMatrix(char[][] matrix, int i, int iLength, int j, int jLength, int steps){

        if (i+steps >= iLength || j+steps >= jLength) return false;

        if (matrix[i+steps][j+steps] != '1') return false;

        int counter = 0;
        while (counter < steps){
            if (matrix[i+steps][j+counter] != '1') return false;
            counter++;
        }

        counter = 0;
        while (counter < steps){
            if (matrix[i+counter][j+steps] != '1') return false;
            counter++;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'},{'1', '0', '1', '1', '1'},{'1', '1', '1', '1', '1'},{'1', '0', '0', '1', '0'}}), 4);
    }
}
