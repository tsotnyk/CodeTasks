package com.j2core.sts.leetcode.com.candy;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Solution {

    public int candy(int[] ratings) {

        if (ratings == null || ratings.length < 1) return 0;
        if (ratings.length == 1) return 1;

        int[] array = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++){
            if (i == 0){
                array[i] = 1;
            } else {
                if (ratings[i] > ratings[i-1]){
                    array[i] = array[i-1]+1;
                }else {
                    array[i] = 1;
                }
            }
        }
        int prev = 1;
        for (int j = ratings.length-1; j > -1; j--){
            if (j == ratings.length-1){
                array[j] = Math.max(prev, array[j]);
            }else {
                if (ratings[j] > ratings[j+1]){
                    array[j] = Math.max(array[j], ++prev);
                }else {
                    prev = 1;
                }
            }
        }

        int counter = 0;

        for (int num : array){
            counter += num;
        }
        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(candy(new int[]{1,0,2}), 5);
        Assert.assertEquals(candy(new int[]{1,2,2}), 4);
        Assert.assertEquals(candy(new int[]{1,3,2,2,1}), 7);


    }
}
