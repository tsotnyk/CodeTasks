package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution8_3 {

    public int findMagicIndexBigON(int[] array){

        if (array == null || array.length < 1) return -1;

        for (int i = 0; i < array.length; i++){

            if (array[i] == i) return i;
        }

        return -1;
// time complexity is O(n) for all cases;
    }

    public int findMagicIndex(int[] array){

        if (array == null || array.length < 1) return -1;

        int index = array[0];

        while(index < array.length){
            if(array[index] == index) return index;
            index = array[index];
        }

        return -1;

// time complexity for wars case - O(n), best case - O(1), average case O(logn);
    }

    @Test
    public void test(){

        Assert.assertEquals(findMagicIndexBigON(new int[]{1,3,5,7,8,9,11}), -1);
        Assert.assertEquals(findMagicIndex(new int[]{1,3,5,7,8,9,11}), -1);
        Assert.assertEquals(findMagicIndexBigON(new int[]{}), -1);
        Assert.assertEquals(findMagicIndex(new int[]{}), -1);
        Assert.assertEquals(findMagicIndexBigON(null), -1);
        Assert.assertEquals(findMagicIndex(null), -1);
        Assert.assertEquals(findMagicIndexBigON(new int[]{0,3,5,7,8,9,11}), 0);
        Assert.assertEquals(findMagicIndex(new int[]{1,1,5,7,8,9,11}), 1);
        Assert.assertEquals(findMagicIndexBigON(new int[]{1,4,4,4,4,9,11}), 4);
        Assert.assertEquals(findMagicIndex(new int[]{1,4,4,4,4,9,11}), 4);
    }

}
