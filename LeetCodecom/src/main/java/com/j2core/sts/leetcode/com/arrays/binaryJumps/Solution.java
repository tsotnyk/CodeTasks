package com.j2core.sts.leetcode.com.arrays.binaryJumps;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public static int powerOfJump(int[] array){

        int maxJump = 1;
        int counter = 1;

        for(int i = array.length-2; i > -1; i--){
            if (array[i] != array[array.length-1]){
                counter++;
            }else {
                if (counter > maxJump){
                    maxJump = counter;
                }
                counter = 1;
            }
        }

        if (counter > maxJump) maxJump = counter;

        return maxJump;
    }

    @Test
    public void test(){

        Assert.assertEquals(powerOfJump(new int[]{1,1,1,1,1,1,1,1}), 1);
        Assert.assertEquals(powerOfJump(new int[]{1,0,0,0,0}), 2);
        Assert.assertEquals(powerOfJump(new int[]{1,1,1,1,0}), 5);
        Assert.assertEquals(powerOfJump(new int[]{1,0,1,0,1}), 2);


    }
}
