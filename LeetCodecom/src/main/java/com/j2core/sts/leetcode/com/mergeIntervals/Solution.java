package com.j2core.sts.leetcode.com.mergeIntervals;

import java.util.LinkedList;
import java.util.List;

public class Solution {


    public List<Interval> merge(List<Interval> intervals){

        if (intervals.size() > 1) {

            List<Interval> result = new LinkedList<>();

            Interval first = smallerInterval(intervals);

            while (!intervals.isEmpty()) {

                Interval second = smallerInterval(intervals);

                if (first.end < second.start){

                    result.add(first);
                    first = second;
                }else {
                    first = new Interval(Math.min(first.start, second.start), Math.max(first.end, second.end));
                }
            }

            result.add(first);
            return result;

        }else return intervals;
    }


    private Interval smallerInterval(List<Interval> intervals){

        int index = 0;
        Interval tmp = null;

        for (int i = 0; i < intervals.size(); i++){

            if (tmp == null){
                tmp = intervals.get(i);
            }else {
                if (intervals.get(i).start < tmp.start){
                    index = i;
                    tmp = intervals.get(i);
                }
            }
        }
        return intervals.remove(index);
    }
}
