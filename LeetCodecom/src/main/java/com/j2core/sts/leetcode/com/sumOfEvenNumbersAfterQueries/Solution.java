package com.j2core.sts.leetcode.com.sumOfEvenNumbersAfterQueries;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int queriesLength = queries.length;
        int[] result = new int[queriesLength];

        int sum = 0;

        for (int i = 0; i < A.length; i++){

            if (A[i]%2 == 0){
                sum += A[i];
            }
        }

        for (int j = 0; j < queriesLength; j++){

            int[] query = queries[j];
            int index = query[1];
            boolean flag;
            int newValue = query[0];
            flag = newValue%2 == 0;
            if (A[index]%2 == 0){
                if (flag){
                    sum += newValue;
                }else {
                    sum -= A[index];
                }
            }else {
                if (!flag){
                    sum += A[index] + newValue;
                }
            }
            A[index] += newValue;
            result[j] = sum;
        }

        return result;
    }

    @Test
    public void test(){

        int[] result = sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{{1,0},{-3,1},{-4,0},{2,3}});

        Assert.assertEquals(result, new int[]{8,6,2,4});
    }
}
