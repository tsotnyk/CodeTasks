package com.j2core.sts.leetcode.com.courseScheduleIII;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int scheduleCourse(int[][] courses) {

        int n = courses.length;
        long[] studyTime = new long[n];
        n = 0;
        for (int[] course : courses) {
            studyTime[n++] = course[0] | (long)course[1] << 32;
        }
        Arrays.sort(studyTime);
        int curLastDay = 0;
        Queue<Integer> duration = new PriorityQueue<>();
        int curLen, curDeadline;

        for (long course : studyTime) {
            curLen = (int)course;
            curDeadline = (int)(course >> 32);
            curLastDay += curLen;
            duration.offer(-curLen);
            if (curDeadline < curLastDay) {
                curLastDay += duration.poll();
            }
        }

        return duration.size();
    }
}
