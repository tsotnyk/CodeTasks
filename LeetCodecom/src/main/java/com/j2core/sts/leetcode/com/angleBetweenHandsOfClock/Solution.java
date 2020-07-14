package com.j2core.sts.leetcode.com.angleBetweenHandsOfClock;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public double angleClock(int hour, int minutes) {

        double hourDegree = 360/12;
        double mHourDegree = hourDegree/60;
        double mDegree = 360/60;
        double hLine = ((hour%12) * hourDegree) + (minutes * mHourDegree);
        double mLine = minutes * mDegree;

        double leftStep = Math.abs(hLine - mLine);
        if (hLine < mLine){
            return Math.min(leftStep, (360-mLine)+hLine);
        }else {
            return Math.min(leftStep, (360-hLine)+mLine);
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(angleClock(12, 30), 165.0);
        Assert.assertEquals(angleClock(3, 30), 75.0);
        Assert.assertEquals(angleClock(3, 15), 7.5);
        Assert.assertEquals(angleClock(4,50), 155.0);
        Assert.assertEquals(angleClock(12, 0), 0.0);
        Assert.assertEquals(angleClock(1, 57), 76.5);

    }
}
