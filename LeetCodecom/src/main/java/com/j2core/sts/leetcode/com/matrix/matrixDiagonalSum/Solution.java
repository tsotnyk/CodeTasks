package com.j2core.sts.leetcode.com.matrix.matrixDiagonalSum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int diagonalSum(int[][] mat) {

        int sum = 0;
        int prim = 0;
        int secondary = mat.length-1;

        for (int i = 0; i < mat.length; i++){
            if (prim+i == secondary-i){
                sum += mat[i][prim+i];
            }else {
                sum += mat[i][prim+i];
                sum += mat[i][secondary-i];
            }
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(diagonalSum(new int[][]{{7,3,1,9},{3,4,6,9},{6,9,6,6},{9,5,8,5}}), 55);
    }
}
