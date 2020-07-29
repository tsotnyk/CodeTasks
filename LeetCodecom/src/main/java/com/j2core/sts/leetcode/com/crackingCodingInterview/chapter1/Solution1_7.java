package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_7 {

    public void rotateMatrix(int[][] matrix){

        if (matrix != null && matrix.length > 1){

            int start = 0;
            int end = matrix.length-1;

            while (start < end){

                for (int i = 0; i < end-start; i++){
                    int tmp = matrix[start][start+i];
                    matrix[start][start+i] = matrix[start+i][end];
                    matrix[start+i][end] = matrix[end][end-i];
                    matrix[end][end-i] = matrix[end-i][start];
                    matrix[end-i][start] = tmp;
                }

                start++;
                end--;
            }
        }
    }

    @Test
    public void test(){

        int[][] matrix1 = null;
        rotateMatrix(matrix1);
        Assert.assertNull(matrix1);

        int[][] matrix2 = new int[][]{};
        rotateMatrix(matrix2);
        Assert.assertEquals(matrix2, new int[][]{});

        int[][] matrix3 = new int[][]{{1}};
        rotateMatrix(matrix3);
        Assert.assertEquals(matrix3, new int[][]{{1}});

        int[][] matrix4 = new int[][]{{1,2}, {3,4}};
        rotateMatrix(matrix4);
        Assert.assertEquals(matrix4, new int[][]{{2,4},{1,3}});

        int[][] matrix5 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(matrix5);
        Assert.assertEquals(matrix5, new int[][]{{3,6,9},{2,5,8},{1,4,7}});

        int[][] matrix6 = new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
        rotateMatrix(matrix6);
        Assert.assertEquals(matrix6, new int[][]{{6,12,18,24,30,36},{5,11,17,23,29,35},{4,10,16,22,28,34},{3,9,15,21,27,33},{2,8,14,20,26,32},{1,7,13,19,25,31}});
    }
}
