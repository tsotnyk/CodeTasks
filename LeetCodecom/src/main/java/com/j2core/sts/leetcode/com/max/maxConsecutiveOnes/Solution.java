package com.j2core.sts.leetcode.com.max.maxConsecutiveOnes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int counter = 0;
        int tmpCounter = 0;

        for (int i = 0; i < nums.length; i++){

            if (nums[i] == 1){

                tmpCounter++;
            }else {

                if (counter < tmpCounter){
                    counter = tmpCounter;
                }
                tmpCounter = 0;
            }
        }

        if (counter < tmpCounter){
            counter = tmpCounter;
        }

        return counter;
    }


    @Test
    public void test(){

        int result = findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});


        Assert.assertEquals(result, 3);

    }

}
