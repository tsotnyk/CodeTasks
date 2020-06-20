package com.j2core.sts.leetcode.com.matrix.diagonalTraverse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public  int[] findDiagonalOrder(int[][] matrix) {

        int iLength = matrix.length;
        if (iLength < 1) return new int[]{};
        if (iLength == 1) return matrix[0];
        int jLength = matrix[0].length;
        int[] result = new int[iLength*jLength];
        int index = 0;
        boolean doun = false;
        int counter = 1;
        int jIndex = (iLength-1)*-1;

        while(counter < iLength+jLength){

            index = addLine(matrix, iLength, jLength, jIndex, result, index, doun);
            doun = !doun;
            jIndex++;
            counter++;
        }

        return result;
    }

    private int addLine(int[][] matrix, int iLength, int jLength, int jHead, int[] result, int index, boolean doun){

        if(doun){
            jHead +=iLength-1;
            for(int i = 0; i < iLength; i++){
                if(jHead > -1 && jHead < jLength){
                    result[index++] = matrix[i][jHead];
                }
                jHead--;
            }
        }else{
            for(int i = iLength-1; i > -1; i--){
                if(jHead > -1 && jHead < jLength){
                    result[index++] = matrix[i][jHead];
                }
                jHead++;
            }
        }

        return index;
    }

    @Test
    public void test(){

        int[] result = findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(result.length);
    }
}
