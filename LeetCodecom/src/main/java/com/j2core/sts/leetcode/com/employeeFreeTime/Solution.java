package com.j2core.sts.leetcode.com.employeeFreeTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        int min = -1;
        int max = -1;
        for (List<Interval> intervalList : schedule){
            int length = intervalList.size();
            Interval first = intervalList.get(0);
            Interval last = intervalList.get(length-1);

            if (min == -1 || min > first.start){
                min = first.start;
            }
            if (max == -1 || max < last.end){
                max = last.end;
            }
        }
        int[] array = new int[max-min];

        for (List<Interval> intervalList : schedule){
            for (Interval interval : intervalList){
                if (interval.start < min) min = interval.start;
                if (interval.end > max) max = interval.end;
                for (int i = interval.start-min; i < interval.end-min; i++){
                    array[i] += 1;
                }
            }
        }

        int index = 0;
        List<Interval> result = new LinkedList<>();
        while (index < max-min){
            if (array[index] == 0){
                int start = index;
                while (array[index] == 0){
                    index++;
                }
                if (0 < index - start){
                    result.add(new Interval(start+min, index+min));
                }
            }else {
                index++;
            }
        }

        return result;
    }

    public List<Interval> employeeFreeTimeNew(List<List<Interval>> schedule) {

        List<Interval> workTime = schedule.remove(0);

        while (!schedule.isEmpty()){
            workTime = mergeTwoWorkList(workTime, schedule.remove(0));
        }

        List<Interval> result = new LinkedList<>();

        if (workTime.size() < 2) return result;

        int startFreeTime = workTime.remove(0).end;
        for (Interval interval : workTime){
            result.add(new Interval(startFreeTime, interval.start));
            startFreeTime = interval.end;
        }
        return result;
    }

    private List<Interval> mergeTwoWorkList(List<Interval> list1, List<Interval> list2){

        List<Interval> result = new LinkedList<>();
        List<Interval> first; List<Interval> second;

        if (list1.get(0).start > list2.get(0).start){
            first = list2;
            second = list1;
        }else {
            first = list1;
            second = list2;
        }

        Interval interval = first.remove(0);
        Interval tmp;
        while (!second.isEmpty() && !first.isEmpty()){
            if (second.get(0).start < first.get(0).start) {
                tmp = second.remove(0);
            }else {
                tmp = first.remove(0);
            }
            if (interval.end < tmp.start){
                result.add(interval);
                interval = tmp;
            }else {
                interval.end = Integer.max(tmp.end, interval.end);
            }
        }
        first = first.isEmpty() ? second : first;

        while (!first.isEmpty()){
            tmp = first.remove(0);
            if (interval.end < tmp.start){
                result.add(interval);
                interval = tmp;
            }else {
                interval.end = Integer.max(tmp.end, interval.end);
            }
        }
        result.add(interval);
        return result;
    }



    public List<Interval> employeeFreeTimeTMP(List<List<Interval>> schedule) {
        int OPEN = 0, CLOSE = 1;

        List<int[]> events = new ArrayList();
        for (List<Interval> employee: schedule)
            for (Interval iv: employee) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }

        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        List<Interval> ans = new ArrayList();

        int prev = -1, bal = 0;
        for (int[] event: events) {
            // event[0] = time, event[1] = command
            if (bal == 0 && prev >= 0)
                ans.add(new Interval(prev, event[0]));
            bal += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return ans;
    }

    @Test
    public void test(){

        List<Interval> emp1 = new LinkedList<>();
        emp1.add(new Interval(1,2));
        emp1.add(new Interval(5,6));
        List<Interval> emp2 = new LinkedList<>();
        emp2.add(new Interval(1,3));
        List<Interval> emp3 = new LinkedList<>();
        emp3.add(new Interval(4,10));
        List<List<Interval>> data = new LinkedList<>();
        data.add(emp1);
        data.add(emp2);
        data.add(emp3);

        Assert.assertEquals(employeeFreeTimeNew(data).size(), 1);

        List<Interval> emp11 = new LinkedList<>();
        emp11.add(new Interval(1,3));
        emp11.add(new Interval(6,7));
        List<Interval> emp22 = new LinkedList<>();
        emp22.add(new Interval(2,4));
        List<Interval> emp33 = new LinkedList<>();
        emp33.add(new Interval(2,5));
        emp33.add(new Interval(9,12));
        List<List<Interval>> data2 = new LinkedList<>();
        data2.add(emp11);
        data2.add(emp22);
        data2.add(emp33);

        Assert.assertEquals(employeeFreeTimeNew(data2).size(), 2);

        List<Interval> emp111 = new LinkedList<>();
        emp111.add(new Interval(43,76));
        emp111.add(new Interval(86,91));
        List<Interval> emp333 = new LinkedList<>();
        emp333.add(new Interval(17,20));
        emp333.add(new Interval(29,30));
        List<List<Interval>> data3 = new LinkedList<>();
        data3.add(emp111);
        data3.add(emp333);

        Assert.assertEquals(employeeFreeTimeNew(data3).size(), 3);
    }
}
