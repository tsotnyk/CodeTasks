package com.j2core.sts.leetcode.com.ToeplitzMatrix;

public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix.length == 1) {
            return true;
        }else {
            int num, tmpNumIndex;
            int arrayIndex = 1;
            int[] array = matrix[0];
            for (int i = array.length-2; i > -1; i--){
                num = array[i];
                tmpNumIndex = i + 1;
                while (arrayIndex < matrix.length && tmpNumIndex < matrix[arrayIndex].length){

                    if (matrix[arrayIndex][tmpNumIndex] != num) return false;

                    arrayIndex++;
                    tmpNumIndex++;
                }
                arrayIndex = 1;
            }

            while (arrayIndex < matrix.length){

                num = matrix[arrayIndex][0];
                int tmpArrayIndex = arrayIndex+1;
                tmpNumIndex = 1;
                while (tmpArrayIndex < matrix.length && tmpNumIndex < matrix[tmpArrayIndex].length){

                    if (matrix[tmpArrayIndex][tmpNumIndex] != num){
                        return false;
                    }

                    tmpArrayIndex++;
                    tmpNumIndex++;
                }

                arrayIndex++;
            }
            return true;
        }
    }
}
