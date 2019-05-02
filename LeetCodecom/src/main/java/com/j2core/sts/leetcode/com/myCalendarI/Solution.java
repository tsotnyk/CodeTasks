package com.j2core.sts.leetcode.com.myCalendarI;

import java.util.*;

public class Solution {

    Set<List<Integer>> calendar = new TreeSet<List<Integer>>(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> s1, List<Integer> s2) {
            return s1.get(1).compareTo(s2.get(1));
        }
    });

    public Solution() {

    }

    public boolean book(int start, int end) {

        if (calendar.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(start, end));
            calendar.add(list);
            return true;
        }

        List< Integer> entryNext = null;

        for (List<Integer> item : calendar){
            if (item.get(1) > start){
                entryNext = item;
                break;
            }
        }

        if (entryNext == null || end <= entryNext.get(0)) {
            calendar.add(new ArrayList<>(Arrays.asList(start, end)));
            return true;
        }

        return false;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

