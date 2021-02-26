package com.j2core.sts.leetcode.com.maximumProductOfThreeNumbers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int sum = 1;
        int indexS = 0;
        int indexE = nums.length;
        if (nums[0] >= 0){
            indexS = nums.length-3;
        }else if (nums[nums.length-1] < 0){
            indexE = 3;
        }else {
            if (nums[0]*nums[1] > nums[nums.length-1]*nums[nums.length-2]){
                indexS = indexS+2;
                sum = nums[0]*nums[1];
            }else{
                indexE = indexE-2;
                sum = nums[nums.length-1]*nums[nums.length-2];
            }

            sum *= Math.max(nums[indexS], nums[indexE - 1]);
            return sum;
        }

        for (int i = indexS; i < indexE; i++){
            sum *= nums[i];
        }

        return sum;
    }

    int avoidObstacles(int[] inputArray) {
        Arrays.sort(inputArray);

        int length = 1;
        int counter = 1;

        for(int i = 1; i < inputArray.length; i++){
            if(inputArray[i] == inputArray[i-1]+1){
                counter++;
            }else{
                length = Math.max(length, counter);
                counter = 1;
            }
        }

        length = Math.max(length, counter);

        boolean[] canJump = new boolean[inputArray[inputArray.length-1]+1];
        for(int index : inputArray){
            canJump[index] = true;
        }

        for(int i = length+1; i < 1001; i++){
            boolean flag = true;
            int index = 0;
            while(index < canJump.length){
                if(canJump[index]) {
                    flag = false;
                    break;
                }
                index += i;
            }
            if(flag) return i;
        }

        return 1001;
    }

    @Test
    public void test(){

        Assert.assertEquals(avoidObstacles(new int[]{5,3,6,7,9}), 4);
        Assert.assertEquals(avoidObstacles(new int[]{2,3}), 4);
        Assert.assertEquals(avoidObstacles(new int[]{1, 4, 10, 6, 2}), 7);
        Assert.assertEquals(avoidObstacles(new int[]{1000, 999}), 6);

    }


    int[][] boxBlur(int[][] image) {

        int[][] matrix = new int[image.length-2][image[0].length-2];

        int startX = 0;
        int endX = 3;
        int startY = 0;
        int endY = 3;

        while(endY <= image.length){

            if(startX == 0 && startY == 0){
                int sum = 0;
                for(int i = startY; i < endY; i++){
                    for(int j = startX; j < endX; j++){
                        sum += image[i][j];
                    }
                }
                matrix[startY][startX] = sum;
            }else if(startX == 0){
                int sum = matrix[startY-1][startX];
                for(int i = startX; i < endX; i++){
                    sum -= image[startY-1][i];
                    sum += image[endY-1][i];
                }
                matrix[startY][startX] = sum;
            }else{
                int sum = matrix[startY][startX-1];
                for(int i = startY; i < endY; i++){
                    sum -= image[i][startX-1];
                    sum += image[i][endX-1];
                }
                matrix[startY][startX] = sum;
            }
            startX++;
            endX++;
            if(endX > image[0].length){
                startY++;
                endY++;
                startX = 0;
                endX = 3;
            }
        }


         for(int i = 0; i < matrix.length; i++){
             for(int j = 0; j < matrix[0].length; j++){
                 matrix[i][j] = matrix[i][j]/9;
             }
         }

        return matrix;
    }

@Test
    public void test1(){

        Assert.assertEquals(boxBlur(new int[][]{{7,4,0,1},{5,6,2,2},{6,10,7,8},{1,4,2,0}}), new int[][]{{5,4},{4,4}});
}

    int[][] minesweeper(boolean[][] matrix) {

        int[][] result = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int counter = 0;
                if(i-1 > -1){
                    if(j-1 > -1 && matrix[i-1][j-1]) counter++;
                    if(matrix[i-1][j]) counter++;
                    if(j+1 < matrix[0].length && matrix[i-1][j+1]) counter++;
                }
                if(j-1 > -1 && matrix[i][j-1]) counter++;
                if(j+1 < matrix[0].length && matrix[i][j+1]) counter++;
                if(i+1 < matrix.length){
                    if(j-1 > -1 && matrix[i+1][j-1]) counter++;
                    if(matrix[i+1][j]) counter++;
                    if(j+1 < matrix[0].length && matrix[i+1][j+1]) counter++;
                }
                result[i][j] = counter;
            }
        }

        return result;
    }

    @Test
    public void test2(){

        char tmp = 'a';
        tmp++;

        System.out.println(tmp);

        Assert.assertEquals(minesweeper(new boolean[][]{{true,false,false},{false,true,false},{false,false,false}}), new int[][]{{1,2,1},{2,1,1},{1,1,1}});
    }

    int depositProfit(int deposit, int rate, int threshold) {

        int counter = 0;

        while(deposit < threshold){
            float profit = ((float) deposit/100)*(float) rate;
            deposit += profit;
            counter++;
        }

        return counter;
    }

    @Test
    public void test4(){

        Assert.assertEquals(depositProfit(100, 20, 1000), 3);
    }
}
