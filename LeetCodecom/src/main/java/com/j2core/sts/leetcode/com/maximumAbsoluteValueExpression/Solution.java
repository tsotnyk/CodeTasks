package com.j2core.sts.leetcode.com.maximumAbsoluteValueExpression;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int result = 0;
        int[] indexes = new int[4];
        int sum1 = findMaxSum(arr1, indexes, 1);
        int sum2 = findMaxSum(arr2, indexes, 2);
        int delta1 = Math.abs(indexes[0] - indexes[1]);
        int delta2 = Math.abs(indexes[2]- indexes[3]);

        if (sum1+delta1 > sum2+delta2){

            return sum1 + delta1 + Math.abs(arr2[indexes[0]] - arr2[indexes[1]]);
        }else {

            int tmp = Math.abs(arr1[indexes[2]] - arr1[indexes[3]]);
            return sum2 + delta2 + tmp;
        }
    }

    private int findMaxSum(int[] array, int[] indexes, int numArr){

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < array.length; i++){
            int tmp = array[i];
            if (tmp < min){
                min = tmp;
                minIndex = i;
            }
            if (tmp > max){
                max = tmp;
                maxIndex = i;
            }
        }

        if (numArr == 1){
            indexes[0] = minIndex;
            indexes[1] = maxIndex;
        }else {
            indexes[2] = minIndex;
            indexes[3] = maxIndex;
        }
        return Math.abs(max - min);
    }

    @Test
    public void test(){

        int result = maxAbsValExpr(new int[]{1,2,3,4}, new int[]{-1,4,5,6});
//        int result = maxAbsValExpr(new int[]{1,-2,-5,0,10}, new int[]{0,-2,-1,-7,-4});

        Assert.assertEquals(result, 13);
    }
}
