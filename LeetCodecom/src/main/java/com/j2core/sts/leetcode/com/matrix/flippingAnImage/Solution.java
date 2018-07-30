package com.j2core.sts.leetcode.com.matrix.flippingAnImage;

import org.testng.annotations.Test;

public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++){

            int firstIndex = 0;
            int lastIndex = A[i].length-1;
            while (firstIndex < lastIndex){

                int first = Math.abs(A[i][firstIndex]-1);
                A[i][firstIndex] = Math.abs(A[i][lastIndex]-1);
                A[i][lastIndex] = first;
                firstIndex++;
                lastIndex--;
            }
            if (firstIndex == lastIndex){

                A[i][firstIndex] = Math.abs(A[i][firstIndex]-1);
            }
        }

        return A;
    }


    @Test
    public void test(){

        int[][] result = flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});

        System.out.print(result.length);

    }
}
