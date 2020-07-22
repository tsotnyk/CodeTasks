package com.j2core.sts.leetcode.com.tmp.tmp;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import java.util.List;

public class Solution {


    public void solution1(int[] array, int k){

        if(k > array.length) return;

        int[] tmpArray = new int[k];

        //tmpArray
        System.arraycopy(array, array.length-k-1, tmpArray, 0, k);

        System.arraycopy(array, 0, array, array.length-k-1, array.length-k);

        System.arraycopy(tmpArray, 0, array, 0, k);

        // space O(k);    time O(3n)
    }

    public int[] solution2(int[] array, int k){

        int[] newArray = new int[array.length];

        int counter = 0;
        int index = array.length-k;

        while (counter < array.length){

            if (index == array.length){
                index = 0;
            }
            newArray[counter++] = array[index++];
        }
        return newArray;
       // array = newArray;
        // time O(n) space O(n)
    }

    public int[] solution3(int[] array, int k){

        List<Integer> tmp = new ArrayList<>(k);

        for (int i = k-1; i < array.length; i++){
            tmp.add(array[i]);
        }

        System.arraycopy(array, 0, array, array.length-k-1, array.length-k);

        for (int i = 0; i < array.length-k; i++){
            array[i] = tmp.get(i);
        }

        return array;

        // time O(n)+O(n)  = O(2n)  space O(n)
    }

    @Test
    public void test(){

        int[] result = solution2(new int[]{1,2,3,4,5,6,7}, 3);

        Assert.assertEquals(result.length, 8);
    }

}
