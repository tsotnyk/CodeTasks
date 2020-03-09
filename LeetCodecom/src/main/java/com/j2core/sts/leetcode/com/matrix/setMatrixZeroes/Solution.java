package com.j2core.sts.leetcode.com.matrix.setMatrixZeroes;

import java.util.LinkedList;

public class Solution {

    public void setZeroes(int[][] matrix) {

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
}
