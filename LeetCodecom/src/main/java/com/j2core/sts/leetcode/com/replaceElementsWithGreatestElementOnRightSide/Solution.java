package com.j2core.sts.leetcode.com.replaceElementsWithGreatestElementOnRightSide;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int[] replaceElementsOld(int[] arr) {

        int length = arr.length;
        int maxNum = arr[length-1];
        int[] result = new int[length];
        result[length-1] = -1;

        for (int i = length-2; i > -1; i--){

            result[i] = maxNum;
            if (arr[i] > maxNum){
                maxNum = arr[i];
            }
        }

        return result;
    }

    public int[] replaceElements(int[] arr) {

        if (arr.length == 1) return new int[]{-1};
        int[] result = new int[arr.length];
        int index = arr.length-1;
        result[index--] = -1;
        result[index] = arr[index-- + 1];
        while (index > -1){
            result[index] = Math.max(arr[index+1], result[index+1]);
            index--;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(new int[]{18,6,6,6,1,-1}, replaceElements(new int[]{17,18,5,4,6,1}));
    }
}
