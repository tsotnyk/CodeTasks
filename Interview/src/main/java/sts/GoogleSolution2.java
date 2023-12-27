package sts.airbnb;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GoogleSolution2 {

    int countOfIsland(int[][] arr){

        int counter = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (arr[i][j] == 1){
                    counter++;
                    helper(i, j, arr);
                }
            }
        }

        return counter;
    }

    private void helper(int i, int j, int[][] arr){

        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return;

        if (arr[i][j] == 1){
            arr[i][j] = 2;
            helper(i+1, j, arr);
            helper(i-1, j, arr);
            helper(i, j+1, arr);
            helper(i, j-1, arr);
        }
    }

    public boolean containSumOfTree(int[] arr){

        for (int i = 0; i < arr.length; i++){
            int sum = 0-arr[i];
            int left = 0;
            int right = arr.length-1;
            while (left <= right){
                if (arr[left++] + arr[right--] == sum) return true;
            }
        }

        return false;

//        for (int i = 0; i < arr.length; i++){
//            int sum = 0-arr[i];
//            int left = 0;
//            int right = arr.length-1;
//            while (left < right){
//                if (left == i){
//                    left++;
//                    continue;
//                }
//                if (right == i){
//                    right--;
//                    continue;
//                }
//                if (arr[left++] + arr[right--] == sum) return true;
//            }
//        }
//
//        return false;
    }

    @Test
    public void test1(){


        Assert.assertEquals(countOfIsland(new int[][]{{1,1,1},{0,0,0},{0,0,1}}), 2);
    }

    @Test
    public void test(){

        Assert.assertTrue(containSumOfTree(new int[]{0}));
        Assert.assertTrue(containSumOfTree(new int[]{-1, 2}));
        Assert.assertTrue(containSumOfTree(new int[]{1,2,3,5,-2,8,0,2,0,0}));
    }
}
