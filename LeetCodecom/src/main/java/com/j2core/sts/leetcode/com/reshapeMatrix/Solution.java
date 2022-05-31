package com.j2core.sts.leetcode.com.reshapeMatrix;

import org.junit.Test;

public class Solution {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int size = mat.length*mat[0].length;
        if (r*c != size) return mat;

        int[][] result = new int[r][c];

        int indexI = 0;
        int indexJ = 0;

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                result[indexI][indexJ++] = mat[i][j];
                if (indexJ == c){
                    indexJ = 0;
                    indexI++;
                }
            }
        }

        return result;
    }

    @Test
    public void test(){

        System.out.println(matrixReshape(new int[][]{{1,2},{3,4}}, 1,4));
    }
}
