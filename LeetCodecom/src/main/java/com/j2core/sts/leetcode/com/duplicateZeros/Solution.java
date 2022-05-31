package com.j2core.sts.leetcode.com.duplicateZeros;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public void duplicateZeros(int[] arr) {

        int i = 0;
        int j = arr.length-1;
        int k = arr.length-1;

        while (i < j){
            if (arr[i] == 0){
                j--;
            }
            i++;
        }

        while (j > -1){
            if (arr[j] == 0){
                arr[k--] = arr[j];
            }
            arr[k--] = arr[j--];
        }
    }

    @Test
    public void test(){

        int[] array = new int[]{0,0,0,0,0,0,0};

        duplicateZeros(array);

        Assert.assertArrayEquals(array, new int[]{0,0,0,0,0,0,0});
    }
}
