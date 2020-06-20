package com.j2core.sts.leetcode.com.matrix.search2DMatrixII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) break;
            }
        }

        return false;
    }

    @Test
    public void test(){

        Assert.assertFalse(searchMatrix(new int[][]{{1,4,7,11,15}, {2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));

//        Assert.assertFalse(searchMatrix(new int[][]{{}}, 0));
//        Assert.assertTrue(searchMatrix(new int[][]{{-5}}, -5));
//
//        Assert.assertFalse(searchMatrix(new int[][]{{1,1}}, 0));
    }
}
