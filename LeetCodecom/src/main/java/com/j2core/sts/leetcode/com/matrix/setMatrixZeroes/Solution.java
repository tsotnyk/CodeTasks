package com.j2core.sts.leetcode.com.matrix.setMatrixZeroes;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public void setZeroes1(int[][] matrix) {

        LinkedList<int[]> zerosList = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    zerosList.add(new int[]{i, j});
                }
            }
        }

        if (!zerosList.isEmpty()){
            for (int[] zeroIndexes : zerosList){
                for (int i = 0; i < matrix[0].length; i++){
                    matrix[zeroIndexes[0]][i] = 0;
                }
                for (int j = 0; j < matrix.length; j++){
                    matrix[j][zeroIndexes[1]] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {

        int[] iArray = new int[matrix.length];
        int[] jArray = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    iArray[i] += 1;
                    jArray[j] += 1;
                }
            }
        }

        for (int i = 0; i < iArray.length; i++){
            if (iArray[i] > 0){
                changeRowSymbol(matrix, i);
            }
        }

        for (int j = 0; j < jArray.length; j++){
            if (jArray[j] > 0){
                changeColumnSymbol(matrix, j);
            }
        }
    }

    private void changeRowSymbol(int[][] matrix, int i){
        for (int j = 0; j < matrix[0].length; j++){
            matrix[i][j] = 0;
        }
    }

    private void changeColumnSymbol(int[][] matrix, int j){
        for (int i = 0; i < matrix.length; i++){
            matrix[i][j] = 0;
        }
    }
}
