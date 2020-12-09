package com.j2core.sts.leetcode.com.carPooling;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public boolean carPooling(int[][] trips, int capacity) {

        Map<Integer, Integer> timeStamp = new TreeMap<>();
        for (int[] trip : trips) {
            int start_passenger = timeStamp.getOrDefault(trip[1], 0) + trip[0];
            timeStamp.put(trip[1], start_passenger);

            int end_passenger = timeStamp.getOrDefault(trip[2], 0) - trip[0];
            timeStamp.put(trip[2], end_passenger);
        }
        int ued_capacity = 0;
        for (int passenger_change : timeStamp.values()) {
            ued_capacity += passenger_change;
            if (ued_capacity > capacity) {
                return false;
            }
        }
        return true;



//        int[] start = new int[1001];
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for(int[] tidx: trips)
//        {
//            start[tidx[1]] += tidx[0];
//            start[tidx[2]] -=tidx[0];
//            min = Math.min(min,tidx[1]);
//            max = Math.max(max,tidx[2]);
//        }
//        int total = 0;
//        for(int i = min ; i<= max;i++)
//        {
//
//            total+=start[i];
//            if(total>capacity)
//                return false;
//
//        }
//
//        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));

    }
}

