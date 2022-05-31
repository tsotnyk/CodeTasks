package com.j2core.sts.leetcode.com.meetingRooms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {

    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length == 0) return true;
        LinkedList<int[]> list = new LinkedList<>(Arrays.asList(intervals));
        Collections.sort(list, (t1, t2) ->{
            if (t1[0] == t2[0]){
                return t1[1] - t2[1];
            }
            return t1[0] - t2[0];
        });
        int[] meeting = list.removeFirst();
        for (int[] nextMeeting : list){

            if (nextMeeting[0] < meeting[1]) return false;
            meeting = nextMeeting;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertFalse(canAttendMeetings(new int[][]{{0,30},{15,20},{5,10}}));
        Assert.assertTrue(canAttendMeetings(new int[][]{{7,10},{2,4}}));
    }
}
