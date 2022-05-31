package com.j2core.sts.leetcode.com.kEmptySlots;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int kEmptySlots(int[] bulbs, int k) {

        int[] bulbStatus = new int[bulbs.length];

        for (int i = 0; i < bulbs.length; i++){
            int turnOnIndex = bulbs[i]-1;
            bulbStatus[turnOnIndex] = 1;
            int counter = 0;
            int index = turnOnIndex-1;
            while (index >= 0 && bulbStatus[index] == 0){
                counter++;
                index--;
            }
            if (counter == k && index >= 0) return i+1;
            index = turnOnIndex+1;
            counter = 0;
            while (index < bulbs.length && bulbStatus[index] == 0){
                counter++;
                index++;
            }
            if (counter == k && index < bulbs.length) return i+1;
        }

        return -1;
    }

    @Test
    public void test(){

        Assert.assertEquals(2, kEmptySlots(new int[]{1,3,2}, 1));
    }
}
