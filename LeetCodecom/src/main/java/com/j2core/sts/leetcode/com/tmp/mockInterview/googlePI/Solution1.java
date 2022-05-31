package com.j2core.sts.leetcode.com.tmp.mockInterview.googlePI;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution1 {

    public boolean validMountainArray(int[] arr) {

        if (arr.length < 3) return false;
        int mount = 1;

        while (mount < arr.length){

            if (arr[mount-1] < arr[mount]){
                mount++;
                continue;
            }
            if (arr[mount-1] == arr[mount]){
                return false;
            }
            break;
        }

        if (mount == arr.length || mount == 1) return false;

        while (mount < arr.length){
            if (arr[mount] < arr[mount-1]){
                mount++;
                continue;
            }
            if (arr[mount] >= arr[mount-1]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void testValidMountainArray(){

        Assert.assertFalse(validMountainArray(new int[]{0,1,2,1,2}));
        Assert.assertFalse(validMountainArray(new int[]{2,0,2}));
        Assert.assertTrue(validMountainArray(new int[]{0,2,3,4,5,2,1,0}));
        Assert.assertTrue(validMountainArray(new int[]{0,3,2,1}));
        Assert.assertFalse(validMountainArray(new int[]{3,5,5}));
        Assert.assertFalse(validMountainArray(new int[]{0,2}));
    }

    public int minAreaRect(int[][] points) {

        return 0;
    }

    class MyCalendarTwo {

        List<int[]> oneTime;
        List<int[]> twoTimes;

        public MyCalendarTwo() {

            oneTime = new ArrayList<>();
            twoTimes = new ArrayList<>();
        }

        public boolean book(int start, int end) {

            if (!twoTimes.isEmpty()){
                for (int[] time : twoTimes){
                    if (end <= time[0]){
                        break;
                    }
                    if (start < time[1]){
                        return false;
                    }
                }        }

            return addNewBooking(start, end);
        }

        private boolean addNewBooking(int start, int end){

            if (oneTime.isEmpty()){
                oneTime.add(new int[]{start, end});
                return true;
            }

            for (int i = 0; i < oneTime.size(); i++){
                int[] time = oneTime.get(i);
                if (end <= time[0]){
                    oneTime.add(i, new int[]{start, end});
                    return true;
                }
                if (start < time[1]){
                    int doubleStart = Math.max(start, time[0]);
                    int doubleEnd = Math.min(end, time[1]);
                    twoTimes.add(new int[]{doubleStart, doubleEnd});
                    twoTimes.sort((t1, t2) -> t1[0] - t2[0]);
                    oneTime.remove(i);
                    if (time[0] < doubleStart || start < doubleStart){
                        int newStart = Math.min(time[0], start);
                        oneTime.add(i, new int[]{newStart, doubleStart});
                    }
                    if (doubleEnd < time[1] || doubleEnd < end){
                        int newEnd = Math.max(time[1], end);
                        addNewBooking(doubleEnd, newEnd);
                    }
                    return true;
                }
            }

            return oneTime.add(new int[]{start, end});
        }
    }
}
