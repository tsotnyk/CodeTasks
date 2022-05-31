package com.j2core.sts.leetcode.com.tmp.mockInterview.googlePI;

import org.junit.Assert;
import org.junit.Test;

public class Solution3 {

    public int minDominoRotations(int[] tops, int[] bottoms) {

        int countRotation = Math.min(rotationBottom(tops, bottoms, bottoms[0]), rotationTop(tops, bottoms, tops[0]));
        int tmpCount = Math.min(rotationTop(tops, bottoms, bottoms[0]), rotationBottom(tops, bottoms, tops[0]));
        if (tmpCount < Integer.MAX_VALUE) {
            countRotation = Math.min(countRotation, tmpCount + 1);
        }
        return countRotation < Integer.MAX_VALUE ? countRotation : -1;
    }

    private int rotationTop(int[] tops, int[] bottoms, int top){
        int counter = 0;
        for (int i = 1; i < tops.length; i++){

            if (tops[i] != top && bottoms[i] != top ) return Integer.MAX_VALUE;

            if (tops[i] != top && bottoms[i] == top) {
                counter++;
            }
        }
        return counter;
    }

    private int rotationBottom(int[] tops, int[] bottoms, int bottom){

        int counter = 0;
        for (int i = 1; i < tops.length; i++){

            if (tops[i] != bottom && bottoms[i] != bottom ) return Integer.MAX_VALUE;

            if (tops[i] == bottom && bottoms[i] != bottom) {
                counter++;
            }
        }
        return counter;

    }

    @Test
    public void test1(){

        Assert.assertEquals(2, minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        Assert.assertEquals(-1, minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }

    public void duplicateZeros(int[] arr) {

        int countZero = 0;

        for (int i = 0; i < arr.length; i++){
            if (i+countZero == arr.length) break;
            if (i == countZero+1) return;
            if (arr[i] == 0) countZero++;
        }

        for (int j = arr.length-1; j > -1; j--){
            arr[j] = arr[j-countZero];
            if (arr[j-countZero] == 0){
                j--;
                arr[j] = 0;
                countZero--;
            }
        }
    }

    @Test
    public void test(){

        int[] arrayResult = new int[]{8,4,5,0,0,0,0,0};
        int[] arr = new int[]{8,4,5,0,0,0,0,7};
        duplicateZeros(arr);
        Assert.assertArrayEquals(arr, arrayResult);

//        int[] arrayResult = new int[]{0,0,0,0,0,0,0};
//        int[] arr = new int[]{0,0,0,0,0,0,0};
//        duplicateZeros(arr);
//        Assert.assertArrayEquals(arr, arrayResult);

//        int[] arrayResult = new int[]{1,0,0,2,3,0,0,4};
//        int[] arr = new int[]{1,0,2,3,0,4,5,0};
//        duplicateZeros(arr);
//        Assert.assertArrayEquals(arr, arrayResult);
    }
}
