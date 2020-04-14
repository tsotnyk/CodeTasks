package com.j2core.sts.leetcode.com.arrays.сountingElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int countElements(int[] arr) {

        Arrays.sort(arr);
        int counter = 0;
        int num;

        for (int i = 0; i < arr.length; ){
            num = arr[i++];
            int amount = 1;
            while (i < arr.length && arr[i] == num){
                i++;
                amount++;
            }
            if (i < arr.length && num+1 == arr[i]) {
                while (i < arr.length && amount > 0 && num + 1 == arr[i]) {
                    counter++;
                    amount--;
                }
            }
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(countElements(new int[]{1,1,2,2}), 2);
        Assert.assertEquals(countElements(new int[]{1,1,2}), 2);
        Assert.assertEquals(countElements(new int[]{1,3,2,3,5,0}), 3);
        Assert.assertEquals(countElements(new int[]{1,2,3}), 2);
        Assert.assertEquals(countElements(new int[]{1,1,3,3,5,5,7,7}), 0);

    }
}
