package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleOASolution1 {

    public void reverseString(char[] s) {

        int i = 0;
        int j = s.length-1;

        while (i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public int numSubmat(int[][] mat) {

        if (mat.length == 0) {
            return 0;
        }
        int numOfMatrices = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1 && c > 0) {
                    mat[r][c] += mat[r][c - 1];
                }
                int width = mat[r][c];
                for (int i = r; i >= 0 && mat[i][c] != 0; i--) {
                    width = Math.min(width, mat[i][c]);
                    numOfMatrices += width;
                }
            }
        }
        return numOfMatrices;

    }

    @Test
    public void test(){

        Assert.assertEquals(24, numSubmat(new int[][]{{0,1,1,0},{0,1,1,1},{1,1,1,0}}));
        Assert.assertEquals(13, numSubmat(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }
}
