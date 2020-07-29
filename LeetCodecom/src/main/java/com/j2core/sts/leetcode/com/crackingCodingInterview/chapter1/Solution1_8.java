package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution1_8 {

    public void zeroMatrix(int[][] matrix){

        if (matrix != null && matrix.length > 0 && matrix[0].length > 0){

            List<int[]> zeroPoints = new LinkedList<>();
            int iLength = matrix.length;
            int jLength = matrix[0].length;
            for (int i = 0; i < iLength; i++){
                for (int j = 0; j < jLength; j++){
                    if (matrix[i][j] == 0){
                        zeroPoints.add(new int[]{i, j});
                    }
                }
            }

            for (int[] point : zeroPoints){
                for (int j = 0; j < jLength; j++){
                    matrix[point[0]][j] = 0;
                }
                for (int i = 0; i < iLength; i++){
                    matrix[i][point[1]] = 0;
                }
            }
        }
    }

    @Test
    public void test(){

        int[][] matrix1 = null;
        zeroMatrix(matrix1);
        Assert.assertNull(matrix1);

        int[][] matrix2 = new int[][]{{}};
        zeroMatrix(matrix2);
        Assert.assertEquals(matrix2, new int[][]{{}});

        int[][] matrix3 = new int[][]{{1}};
        zeroMatrix(matrix3);
        Assert.assertEquals(matrix3, new int[][]{{1}});

        int[][] matrix4 = new int[][]{{1,1,0,1}};
        zeroMatrix(matrix4);
        Assert.assertEquals(matrix4, new int[][]{{0,0,0,0}});

        int[][] matrix5 = new int[][]{{1,1,1,1}};
        zeroMatrix(matrix5);
        Assert.assertEquals(matrix5, new int[][]{{1,1,1,1}});

        int[][] matrix6 = new int[][]{{1},{0},{0},{1}};
        zeroMatrix(matrix6);
        Assert.assertEquals(matrix6, new int[][]{{0},{0},{0},{0}});

        int[][] matrix7 = new int[][]{{1},{1},{1},{1}};
        zeroMatrix(matrix7);
        Assert.assertEquals(matrix7, new int[][]{{1},{1},{1},{1}});

        int[][] matrix8 = new int[][]{{1,1,1,1,1},{1,0,1,1,0},{0,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        zeroMatrix(matrix8);
        Assert.assertEquals(matrix8, new int[][]{{0,0,1,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,1,1,0},{0,0,1,1,0}});
    }
}
