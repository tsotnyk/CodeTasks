package com.j2core.sts.leetcode.com.matrix.rangeSumQuery2DMutable;

import java.util.HashMap;
import java.util.Map;

public class NumMatrix {

    Map<Integer, Integer> sumMap = new HashMap<>();
    int[][] matrix;

    public NumMatrix(int[][] matrix) {

        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++){
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++){
                sum += matrix[i][j];
            }
            sumMap.put(i, sum);
        }
    }

//    public NumMatrix(int[][] matrix){
//        this.matrix = matrix;
//    }
//
//    public void update(int row, int col, int val) {
//        matrix[row][col] = val;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//
//        int sum = 0;
//        for (int i = row1; i <= row2; i++){
//            for (int j = col1; j <= col2; j++){
//                sum += matrix[i][j];
//            }
//        }
//
//        return sum;
//    }

    public void update(int row, int col, int val) {

        int newSum  = sumMap.get(row);
        newSum = newSum - matrix[row][col] + val;
        matrix[row][col] = val;
        sumMap.put(row, newSum);

    }



    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum = 0;
        int countCol = col2-col1+1;
        for (int i = row1; i <= row2; i++){
            if (countCol > matrix[i].length) {
                sum += sumMap.get(i);
                for (int k = 0; k < col1; k++) {
                    sum -= matrix[i][k];
                }
                for (int l = col2 + 1; l < matrix[i].length; l++) {
                    sum -= matrix[i][l];
                }
            }else {
                for (int j = col1; j <= col2; j++){
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */