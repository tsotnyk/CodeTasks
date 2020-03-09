package com.j2core.sts.leetcode.com.matrix.search2DMatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length < 1 || matrix[0].length < 1) return false;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int i = 0;

        while (i < rowLength){
            if (matrix[i][0] > target){
                break;
            }else i++;
        }

        if (i-- == 0) return false;

        for (int j = columnLength-1; j > -1; j--){
            if (matrix[i][j] == target){
                return true;
            }
            if (matrix[i][j] < target){
                break;
            }
        }

        return false;
    }
}
