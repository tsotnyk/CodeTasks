package com.j2core.sts.leetcode.com.containerWithMostWater;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxAreaOld(int[] height) {

        int sum = 0;

        for (int i = 0; i < height.length-1; i++){

            int j = height.length-1;

            while (i < j){

                int tmpSum = Math.min(height[i], height[j]) * (j-i);

                if (sum < tmpSum){
                    sum = tmpSum;
                }
                j--;
            }
        }

        return sum;
    }

    public int maxArea(int[] height) {

        int first = 0;
        int last = height.length-1;
        int counter = last * Math.min(height[first], height[last]);

        while (first < last){

            if (height[first] < height[last]){
                first++;
            }else {
                last--;
            }

            counter = Math.max(counter, (last-first)*Math.min(height[first], height[last]));
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49);

    }


    public int tmp(int[] array){

        if (array == null || array.length < 1) return 0;

        int max = 1;
        int index = 0;
        int num = array[index++];
        int counter = 1;

        while (index < array.length){

            while (index < array.length && num == array[index]){
                counter++;
                index++;
            }

            max = Math.max(max, counter);
            counter = 1;
            if (index < array.length){
                num = array[index++];
            }
        }

        return max;
    }

    @Test
    public void test1(){

        Assert.assertEquals(tmp(new int[]{1,1,1}), 3);
        Assert.assertEquals(tmp(new int[]{1,1,2,2,2}), 3);

        Assert.assertEquals(tmp(new int[]{1,1,1, 2,2, 5,5,5}), 3);
        Assert.assertEquals(tmp(new int[]{1,1, 2,2,1, 1, 3,3,3,5,6}), 3);


    }
}
