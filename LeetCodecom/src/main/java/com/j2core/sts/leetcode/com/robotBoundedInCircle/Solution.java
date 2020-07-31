package com.j2core.sts.leetcode.com.robotBoundedInCircle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isRobotBounded(String instructions) {

        int countTerns = 0;

        for (char symbol : instructions.toCharArray()){

            if (symbol == 'L'){
                countTerns++;
            }else if(symbol == 'R'){
                countTerns--;
            }
        }

        return countTerns != 0;
    }

    @Test
    public void test(){

        Assert.assertTrue(isRobotBounded("GGLLGG"));
        Assert.assertTrue(isRobotBounded("GL"));
        Assert.assertFalse(isRobotBounded("GG"));

    }
}
