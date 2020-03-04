package com.j2core.sts.leetcode.com.spiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int indexMStart = 0;
        int indexMEnd = n-1;
        int indexNStart = 0;
        int indexNEnd = n-1;
        int counter = 1;

        while (indexMStart <= indexMEnd && indexNStart <= indexNEnd) {

            for (int i = indexNStart; i < indexNEnd; i++) {
                result[indexMStart][i] = counter++;
            }
            for (int j = indexMStart; j < indexMEnd; j++) {
                result[j][indexNEnd] = counter++;
            }
            for (int k = indexNEnd; k > indexNStart; k--) {
                result[indexMEnd][k] = counter++;
            }
            for (int l = indexMEnd; l > indexMStart; l--) {
                result[l][indexNStart] = counter++;
            }

            if (indexMStart == indexMEnd && indexNStart == indexNEnd) {
                result[indexMStart][indexNStart] = counter++;
            }
            indexMStart++;
            indexMEnd--;
            indexNStart++;
            indexNEnd--;
        }

        return result;
    }
}
