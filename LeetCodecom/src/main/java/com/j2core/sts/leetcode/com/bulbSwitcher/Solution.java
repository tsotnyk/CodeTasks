package com.j2core.sts.leetcode.com.bulbSwitcher;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int bulbSwitchSlow(int n) {

        boolean[] bulbs = new boolean[n];

        for (int i = 1; i < n; i++){

            for (int j = 0+i; j < n; j = j+i+1){
                bulbs[j] = !bulbs[j];
            }
        }

        int counter = 0;
        for (boolean value : bulbs){
            if (!value){
                counter++;
            }
        }

        return counter;
    }


    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }




    @Test
    public void test(){

        int result = bulbSwitch(3);

        Assert.assertEquals(result, 1);
    }
}
