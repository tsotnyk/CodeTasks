package com.j2core.sts.leetcode.com.squaresOfSortedArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] sortedSquares(int[] A) {

        int length = A.length;
        int[] result = new int[length];

        int indexR = 0;

        if (A[length-1] < 0){
            indexR = length-1;
        }else {
            for (int i = 0; i < length; i++){
                if (A[i] > -1){
                    indexR = i;
                    break;
                }
            }
        }

        int indexL = indexR-1;

        for (int j = 0; j < length; j++){
            int sum;
            if (indexL > -1 && indexR < length){
                int tmpL = Math.abs(A[indexL]);
                int tmpR = Math.abs(A[indexR]);
                if (tmpL < tmpR){
                    sum = A[indexL] * A[indexL];
                    indexL--;
                }else {
                    sum = A[indexR] * A[indexR];
                    indexR++;
                }
            }else if (indexL < 0){ // if numbers only r
                sum = A[indexR] * A[indexR];
                indexR++;
            }else {// if numbers only left
                sum = A[indexL] * A[indexL];
                indexL--;
            }
            result[j] = sum;
        }

        return result;
    }

    @Test
    public void test(){

        int[] result = sortedSquares(new int[]{-4,-1,0,3,10});

        Assert.assertEquals(result, new int[]{0,1,9,16,100});
    }
}
