package com.j2core.sts.leetcode.com.arrays.uncrossedLines;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Solution {

    public int maxUncrossedLines(int[] A, int[] B) {

        if (B.length < 1) return 0;

        int[][] matrix = new int[A.length+1][B.length+1];

        for (int i = 1; i <= A.length; i++){
            for (int j = 1; j <= B.length; j++){
                if (A[i-1] == B[j-1]){
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        return matrix[A.length][B.length];
    }

    @Test
    public void test(){

        Assert.assertEquals(maxUncrossedLines(new int[]{3,2}, new int[]{2,2,2,3}), 1);

        Assert.assertEquals(maxUncrossedLines(new int[]{3,3,1,3}, new int[]{1,3,2,3,3,1}), 3);

        Assert.assertEquals(maxUncrossedLines(new int[]{1,2,2}, new int[]{3}), 0);

        Assert.assertEquals(maxUncrossedLines(new int[]{2,1}, new int[]{1,2,1,3,3,2}), 2);

        Assert.assertEquals(maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}), 2);
        Assert.assertEquals(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}), 3);
        Assert.assertEquals(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}), 2);
        Assert.assertEquals(maxUncrossedLines(new int[]{3,3}, new int[]{1,3,1,2,1}), 1);
//        Assert.assertEquals(maxUncrossedLines(new int[]{1,1,2,1}, new int[]{3,3,1}), 1);



    }

}
