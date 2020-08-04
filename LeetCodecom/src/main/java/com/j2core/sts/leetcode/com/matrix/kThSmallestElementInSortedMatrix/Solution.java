package com.j2core.sts.leetcode.com.matrix.kThSmallestElementInSortedMatrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Solution {

    public int kthSmallestTimeLimitEx(int[][] matrix, int k) {

        ArrayList<Integer> matrixRow = new ArrayList<>(matrix.length* matrix.length);

        for (int i = 0; i < matrix.length; i++){
            ArrayList<Integer> allValue = new ArrayList<>(matrix.length* matrix.length);
            if (i == 0){
                for (int num : matrix[i]){
                    allValue.add(num);
                }
            }else {
                int indexArray = 0;
                while (indexArray < matrix.length && !matrixRow.isEmpty()){
                    if (matrix[i][indexArray] <= matrixRow.get(0)){
                        allValue.add(matrix[i][indexArray++]);
                    }else {
                        allValue.add(matrixRow.remove(0));
                    }
                }
                if (!matrixRow.isEmpty()){
                    allValue.addAll(matrixRow);
                }else {
                    while (indexArray < matrix.length){
                        allValue.add(matrix[i][indexArray++]);
                    }
                }
            }
            matrixRow = allValue;
        }

        return matrixRow.get(k-1);
    }

    public int kthSmallest(int[][] matrix, int k) {

        if (k == 1) return matrix[0][0];
        int counter = 1;
        int length = matrix.length;

        for (int l = 1; l < length+length-1; l++){
            int jIndex = l;
            for (int i = 0; i < length; i++){
                if (jIndex > -1 && jIndex < length){
                    counter++;
                    if (counter == k) return matrix[i][jIndex];
                }
                jIndex--;
            }
        }

        return matrix[length-1][length-1];
    }

    @Test
    public void test(){

        Assert.assertEquals(kthSmallest(new int[][]{{1,2},{1,3}}, 2), 1);

        Assert.assertEquals(kthSmallest(new int[][]{{1,2},{1,3}}, 1), 1);
        Assert.assertEquals(kthSmallest(new int[][]{{1,2},{1,3}}, 4), 3);

        Assert.assertEquals(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8), 13);
    }
}
