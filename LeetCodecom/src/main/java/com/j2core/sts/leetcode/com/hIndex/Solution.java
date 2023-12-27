package com.j2core.sts.leetcode.com.hIndex;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int hIndex(int[] citations) {

        int[] counter = new int[citations.length+1];

        for (int i = 0; i < citations.length; i++){
            if (citations[i] > citations.length){
                counter[citations.length] += 1;
            }else {
                counter[citations[i]] += 1;
            }
        }

        int calc = 0;
        for (int i = citations.length; i >= 0; i--){
            calc += counter[i];
            if (calc >= i) return i;
        }

        return 0;
    }

    @Test
    public void test(){

        Assert.assertEquals(hIndex(new int[]{3,0,6,1,5}), 3);
        Assert.assertEquals(hIndex(new int[]{1,3,1}), 1);
        Assert.assertEquals(hIndex(new int[]{100}), 1);
    }
}

