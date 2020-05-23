package com.j2core.sts.leetcode.com.matrix.countSquareSubmatricesWithAllOnes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int countSquares(int[][] matrix) {

        if (matrix.length < 1) return 0;

        int counter = 0;

        int iLength = matrix.length;
        int jLength = matrix[0].length;

        for (int i = 0; i < iLength; i++){

            for (int j = 0; j < jLength; j++){

                if (matrix[i][j] == 1){
                    int steps = 1;
                    counter++;
                    while (checkSquareSubMatrix(matrix, i, iLength, j, jLength, steps)){
                        counter++;
                        steps++;
                    }
                }
            }
        }
        return counter;
    }

    private boolean checkSquareSubMatrix(int[][] matrix, int i, int iLength, int j, int jLength, int steps){

        if (i+steps >= iLength || j+steps >= jLength) return false;

        if (matrix[i+steps][j+steps] != 1) return false;

        int counter = 0;
        while (counter < steps){
            if (matrix[i+steps][j+counter] != 1) return false;
            counter++;
        }

        counter = 0;
        while (counter < steps){
            if (matrix[i+counter][j+steps] != 1) return false;
            counter++;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}), 15);
        Assert.assertEquals(countSquares(new int[][]{{1,0,1},{1,1,0},{1,1,0}}), 7);

    }
}
