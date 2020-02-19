package com.j2core.sts.leetcode.com.employeeFreeTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Interval> employeeFreeTimeOld(List<List<Interval>> schedule) {

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

                for (int i = interval.start-min; i < interval.end-min; i++){
                    array[i] += 1;
                }
            }
        }

        int index = 0;
        List<Interval> result = new LinkedList<>();
        while (index < array.length){
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


    }

    private List<Interval> findFreePeriods(List<List<Interval>> empList, int min, int max){

        List<Interval> result = new LinkedList<>();

        for (List<Interval> intervalList : empList){
            for (Interval interval : intervalList){
                if (interval.start > min){
                    result.add(new Interval(min, interval.start));
                }
                if (interval.end < max){
                    result.add(new Interval(interval.end, max));
                }
            }
        }
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

        Assert.assertEquals(employeeFreeTime(data).size(), 1);
    }
}
