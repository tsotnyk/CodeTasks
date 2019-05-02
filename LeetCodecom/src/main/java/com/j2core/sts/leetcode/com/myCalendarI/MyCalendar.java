package com.j2core.sts.leetcode.com.myCalendarI;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MyCalendar {

    private Map calendar = new TreeMap<Integer, Integer>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {

        if (calendar.isEmpty()){
            calendar.put(end, start);
            return true;
        }

        Map.Entry<Integer, Integer> entry = null;
        Map.Entry<Integer, Integer> entryNext = null;

        Set<Map.Entry<Integer, Integer>> entries = calendar.entrySet();

        for (Map.Entry<Integer, Integer> item : entries){
            if (item.getKey() <= start){
                entry = item;
            }else {
                entryNext = item;
                break;
            }
        }

        if (entryNext == null || end <= entryNext.getValue()) {
            calendar.put(end, start);
            return true;
        }

        return false;
    }
}
