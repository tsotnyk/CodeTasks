package com.j2core.sts.hackerrank.com.practice.twoDArrayDS;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int hourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length-3; i++){
            for (int j = 0; j <= arr[0].length-3; j++){
                int sum = 0;
                for (int k = i; k < i+3; k++){
                    if ((k-i)%2 == 0){
                        for (int l = j; l < j+3; l++){
                            sum += arr[k][l];
                        }
                    }else {
                        sum += arr[k][j+1];
                    }
                }

                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    @Test
    public void test(){

        Assert.assertEquals(hourglassSum(new int[][]{{0,-4,-6,0,-7,-6},{-1,-2,-6,-8,-3,-1},{-8,-4,-2,-8,-8,-6},{-3,-1,-2,-5,-7,-4},{-3,-5,-3,-6,-6,-6},{-3,-6,0,-8,-6,-7}}), -19);

        Assert.assertEquals(hourglassSum(new int[][]{{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}}), 19);
    }

}
