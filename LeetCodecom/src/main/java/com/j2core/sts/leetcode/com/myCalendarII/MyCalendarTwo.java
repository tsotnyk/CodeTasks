package com.j2core.sts.leetcode.com.myCalendarII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

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

    @Test
    public void test(){

        MyCalendarTwo calendarTwo = new MyCalendarTwo();
        Assert.assertTrue(calendarTwo.book(26, 35));
        Assert.assertTrue(calendarTwo.book(26, 32));
        Assert.assertFalse(calendarTwo.book(25, 32));
        Assert.assertTrue(calendarTwo.book(18, 26));
        Assert.assertTrue(calendarTwo.book(40, 45));
        Assert.assertTrue(calendarTwo.book(19, 26));
        Assert.assertTrue(calendarTwo.book(48, 50));
        Assert.assertTrue(calendarTwo.book(1, 6));
        Assert.assertTrue(calendarTwo.book(46, 50));
        Assert.assertTrue(calendarTwo.book(11, 18));

//        MyCalendarTwo calendarTwo = new MyCalendarTwo();
//        Assert.assertTrue(calendarTwo.book(47, 50));
//        Assert.assertTrue(calendarTwo.book(1, 10));
//        Assert.assertTrue(calendarTwo.book(27, 36));
//        Assert.assertTrue(calendarTwo.book(40, 47));
//        Assert.assertTrue(calendarTwo.book(20, 27));
//        Assert.assertTrue(calendarTwo.book(15, 23));
//        Assert.assertTrue(calendarTwo.book(10, 18));
//        Assert.assertTrue(calendarTwo.book(27, 36));
//        Assert.assertFalse(calendarTwo.book(17, 25));
//        Assert.assertFalse(calendarTwo.book(8, 17));
//        Assert.assertFalse(calendarTwo.book(24, 33));
//        Assert.assertFalse(calendarTwo.book(23, 28));
//        Assert.assertFalse(calendarTwo.book(21, 27));
//        Assert.assertTrue(calendarTwo.book(47, 50));
//        Assert.assertFalse(calendarTwo.book(14, 21));
//        Assert.assertFalse(calendarTwo.book(26, 32));
//        Assert.assertFalse(calendarTwo.book(16, 21));
//        Assert.assertTrue(calendarTwo.book(2, 7));
//        Assert.assertFalse(calendarTwo.book(24, 33));
//        Assert.assertFalse(calendarTwo.book(6, 13));
//        Assert.assertFalse(calendarTwo.book(44, 50));
//        Assert.assertFalse(calendarTwo.book(33, 39));
//        Assert.assertFalse(calendarTwo.book(30, 36));
//        Assert.assertFalse(calendarTwo.book(6, 15));
//        Assert.assertFalse(calendarTwo.book(21, 27));
//        Assert.assertFalse(calendarTwo.book(49, 50));
//        Assert.assertTrue(calendarTwo.book(38, 45));
//        Assert.assertFalse(calendarTwo.book(4, 12));
//        Assert.assertFalse(calendarTwo.book(46, 50));
//        Assert.assertFalse(calendarTwo.book(13, 21));

//                MyCalendarTwo calendarTwo = new MyCalendarTwo();
//        Assert.assertTrue(calendarTwo.book(5, 12));
//        Assert.assertTrue(calendarTwo.book(42, 50));
//        Assert.assertTrue(calendarTwo.book(4, 9));
//        Assert.assertTrue(calendarTwo.book(33, 41));
//
//        Assert.assertFalse(calendarTwo.book(2, 7));
//
//        Assert.assertTrue(calendarTwo.book(16, 25));
//
//        Assert.assertFalse(calendarTwo.book(7, 16));
//        Assert.assertFalse(calendarTwo.book(6, 11));
//
//        Assert.assertTrue(calendarTwo.book(13, 18));
//        Assert.assertTrue(calendarTwo.book(38, 43));
//        Assert.assertTrue(calendarTwo.book(49, 50));
//
//        Assert.assertFalse(calendarTwo.book(6, 15));
//        Assert.assertFalse(calendarTwo.book(5, 13));
//        Assert.assertFalse(calendarTwo.book(35, 42));
//
//        Assert.assertTrue(calendarTwo.book(19, 24));
//
//        Assert.assertFalse(calendarTwo.book(46, 50));
//        Assert.assertFalse(calendarTwo.book(39, 44));
//
//        Assert.assertTrue(calendarTwo.book(28, 36));
//
//        Assert.assertFalse(calendarTwo.book(28, 37));
//        Assert.assertFalse(calendarTwo.book(20, 29));
//        Assert.assertFalse(calendarTwo.book(41, 49));
//        Assert.assertFalse(calendarTwo.book(11, 19));
//        Assert.assertFalse(calendarTwo.book(41, 46));
//        Assert.assertFalse(calendarTwo.book(28, 37));
//        Assert.assertFalse(calendarTwo.book(17, 23));
//        Assert.assertFalse(calendarTwo.book(22, 31));
//        Assert.assertFalse(calendarTwo.book(4,10));
//        Assert.assertFalse(calendarTwo.book(31, 40));
//        Assert.assertFalse(calendarTwo.book(4, 12));
//        Assert.assertFalse(calendarTwo.book(19, 26));

    }
}
