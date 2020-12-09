package com.j2core.sts.leetcode.com.robotBoundedInCircle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int direction = 0;
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L': direction = (direction + 1) % 4; break;
                case 'R': direction = (direction + 3) % 4; break;
                case 'G':
                    switch (direction) {
                        case 0: y++; break;
                        case 1: x--; break;
                        case 2: y--; break;
                        case 3: x++; break;
                    }
            }
        }
        return direction != 0 || (x == 0 && y == 0);
    }

    @Test
    public void test(){

        Assert.assertTrue(isRobotBounded("GGLLGG"));
        Assert.assertTrue(isRobotBounded("GL"));
        Assert.assertFalse(isRobotBounded("GG"));

    }
}
