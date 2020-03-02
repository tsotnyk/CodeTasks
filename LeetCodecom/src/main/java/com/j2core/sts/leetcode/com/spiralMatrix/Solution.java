package com.j2core.sts.leetcode.com.spiralMatrix;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new LinkedList<>();
        if (matrix.length < 1) return result;

        int indexM = matrix.length-1;
        int indexN = matrix[0].length-1;
        int indexMStart = 0;
        int indexMEnd = indexM;
        int indexNStart = 0;
        int indexNEnd = indexN;

        while (indexMStart <= indexMEnd && indexNStart <= indexNEnd){

            readMatrix(matrix, result, indexMStart, indexMEnd, indexNStart, indexNEnd);

            indexMStart++;
            indexMEnd--;
            indexNStart++;
            indexNEnd--;
        }

        return result;
    }

    private void readMatrix(int[][] matrix, List<Integer> nums, int indexMStart, int indexMEnd, int indexNStart, int indexNEnd){

        if (indexMStart == indexMEnd && indexNStart == indexNEnd){
            nums.add(matrix[indexMStart][indexNStart]);
        } else
            if (indexMStart == indexMEnd){
            for (int i = indexNStart; i <= indexNEnd; i++){
                nums.add(matrix[indexMStart][i]);
            }
        } else
            if (indexNStart == indexNEnd){
            for (int i = indexMStart; i <= indexMEnd; i++){
                nums.add(matrix[i][indexNStart]);
            }
        }else {
                for (int i = indexNStart; i < indexNEnd; i++){
                    nums.add(matrix[indexMStart][i]);
                }
                for (int j = indexMStart; j < indexMEnd; j++){
                    nums.add(matrix[j][indexNEnd]);
                }
                for (int k = indexNEnd; k > indexNStart; k--){
                    nums.add(matrix[indexMEnd][k]);
                }
                for (int l = indexMEnd; l > indexMStart; l--){
                    nums.add(matrix[l][indexNStart]);
                }
            }
    }

    @Test
    public void test(){

        int[][] matrix = new int[][]{{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        Integer[] array = new Integer[]{1,2,3,4,5,5,5,5,5,4,3,2,1,1,1,1,2,3,4,4,4,3,2,2,3};
        List<Integer> list = Arrays.asList(array);
        Assert.assertEquals(spiralOrder(matrix), list);

        int[][] matrix2 = new int[][]{ {1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }};
        Integer[] array2 = new Integer[]{1,2,3,6,9,8,7,4,5};
        Assert.assertEquals(spiralOrder(matrix2), Arrays.asList(array2));

        int[][] matrix3 = new int[][]{{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};
        Integer[] array3 = new Integer[]{1,2,3,4,8,12,11,10,9,5,6,7};
        Assert.assertEquals(spiralOrder(matrix3), Arrays.asList(array3));

        int[][] matrix4 = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        Integer[] array4 = new Integer[]{2,3,4,7,10,13,16,15,14,11,8,5,6,9,12};
        Assert.assertEquals(spiralOrder(matrix4), Arrays.asList(array4));

        int[][] matrix5 = new int[][]{{7},{9},{6}};
        Integer[] array5 = new Integer[]{7,9,6};
        Assert.assertEquals(spiralOrder(matrix5), Arrays.asList(array5));

        int[][] matrix6 = new int[][]{{6,9,7}};
        Integer[] array6 = new Integer[]{6,9,7};
        Assert.assertEquals(spiralOrder(matrix6), Arrays.asList(array6));
    }
}
