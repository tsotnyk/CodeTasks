package com.j2core.sts.leetcode.com.matrix.friendCircles;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int findCircleNum(int[][] M) {

        changeFriendMatrix(M);

        return calculateFriendCircle(M);
    }


    private void changeFriendMatrix(int[][] matrix){

        int matLength = matrix.length;

        for (int k = matLength-1; k > -1; k--){

            boolean flag = false;

            for (int i = matLength-1; i > k; i--){

                if (matrix[k][i] == -1){
                    flag = true;
                    break;
                }
            }

            if (flag) matrix[k][k] = -1;

            for (int j = k-1; j > -1; j--){

                if (matrix[k][j] == 1){

                    if (flag){

                        flag = false;
                        for (int l = k+1; l < matLength; l++){

                            if (matrix[k][l] == -1){

                                matrix[l][l] = -1;
                            }
                        }
                    }
                    matrix[k][j] = -1;
                    matrix[j][k] = -1;
                }
            }
        }
    }


    private int calculateFriendCircle(int[][] matrix){

        int result = 0;

        for (int[] aMatrix : matrix) {

            for (int anAMatrix : aMatrix) {

                if (anAMatrix == 1) {

                    result++;
                }
            }
        }

        return result == 0 ? 1 : result;

    }


    @Test
    public void test(){

        int[][] data = new int[][]{{1,1,0},{1,1,0},{0,0,1}};

        int result = findCircleNum(data);

        Assert.assertEquals(2, result);

        int[][] data1 = new int[][]{{1,1,0},{1,1,1},{0,1,1}};

        int result1 = findCircleNum(data1);

        Assert.assertEquals(1, result1);


        int[][] data2 = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        int result2 = findCircleNum(data1);

        Assert.assertEquals(1, result2);

    }
}
