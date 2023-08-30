package com.j2core.sts.leetcode.com.matrix.search2DMatrix;

public class Solution1 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int mL = matrix.length;
        int nL = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[mL-1][nL-1]) return false;

        int i = mL-1;
        boolean findRow = false;
        while (i > 0 || !findRow){
            if (matrix[i][0] == target) return true;
            if (matrix[i][0] > target){
                i--;
                continue;
            }
            findRow = true;
        }

        for (int j = 1; j < nL; j++){
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) break;
        }

        return false;
    }
}
