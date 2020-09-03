package com.j2core.sts.leetcode.com.crackingCodingInterview.charter16;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Solution16_21 {

    public int[] swapPair(int[] array1, int[] array2){

        HashSet<Integer> arrayOne = new HashSet<>();
        HashSet<Integer> arrayTwo = new HashSet<>();
        int sumOne = 0;
        int sumTwo = 0;
        int delta;

        for(int num : array1){
            sumOne += num;
            arrayOne.add(num);
        }

        for(int num : array2){
            sumTwo += num;
            arrayTwo.add(num);
        }

        delta = Math.abs(sumOne - sumTwo);

        for(int num : arrayOne){
            int pairNum = delta - num;
            if(arrayTwo.contains(pairNum)){
                return new int[]{num, pairNum};
            }
        }

        return null;
    }


    @Test
    public void test(){

        Assert.assertNotNull(swapPair(new int[]{4,1,2,1,1,2}, new int[]{3,6,3,3}));
        Assert.assertEquals(swapPair(new int[]{4,1,2,1,1,2}, new int[]{3,6,3,3})[0], 1);
        Assert.assertEquals(swapPair(new int[]{4,1,2,1,1,2}, new int[]{3,6,3,3})[1], 3);

    }
}
