package com.j2core.sts.leetcode.com.numberOfFullRoundsYouHavePlayed;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int numberOfRounds(String startTime, String finishTime) {

        int startHour = Integer.parseInt(startTime.substring(0, 2));
        int startMin = Integer.parseInt(startTime.substring(3));
        int endHour = Integer.parseInt(finishTime.substring(0, 2));
        int endMin = Integer.parseInt(finishTime.substring(3));

        if ((startHour > endHour) || (startHour == endHour && startMin >= endMin)){
            return countOfGames(startHour, startMin, 24, 0) + countOfGames(0, 0, endHour, endMin);
        }else {
            return countOfGames(startHour, startMin, endHour, endMin);
        }
    }

    private int countOfGames(int startHour, int startMin, int endHour, int endMin){

        if (startHour == endHour){

            int end = (endMin/15);
            int start = 4-((60-startMin)/15);
            return end <= start ? 0 : end-start;
        }

        int counter = ((60-startMin)/15)+(endMin/15);

        return (endHour-startHour-1)*4 + counter;

    }

    @Test
    public void test(){

        Assert.assertEquals(0, numberOfRounds("00:47", "00:57"));
        Assert.assertEquals(1, numberOfRounds("12:01", "12:44"));
        Assert.assertEquals(40, numberOfRounds("20:00", "06:00"));
        Assert.assertEquals(95, numberOfRounds("00:00", "23:59"));
    }

}
