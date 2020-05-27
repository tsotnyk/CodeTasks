package com.j2core.sts.leetcode.com.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] mergeOld(int[][] intervals) {

        if(intervals.length <= 1) return intervals;

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] newI = intervals[i];
            for(int j = 0; j < list.size(); j++){
                int[] oldI = list.get(j);
                if(overlap(oldI, newI)){
                    int l = Math.min(oldI[0], newI[0]);
                    int r = Math.max(oldI[1], newI[1]);
                    newI = new int[]{l, r};
                    list.remove(j--);
                }
            }
            list.add(newI);
        }

        return list.toArray(new int[list.size()][]);
    }

    private boolean overlap(int[] i1, int[] i2){
        return (i1[0] <= i2[1] && i2[0] <= i1[1]);
    }

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);

        int[] pair = intervals[0];
        ArrayList<int[]> result = new ArrayList<>(intervals.length);

        for (int i = 1; i < intervals.length; i++){

            int[] tmp = intervals[i];
            if (pair[1] < tmp[0]){
                result.add(pair);
                pair = tmp;
            }else if (pair[1] >= tmp[0]){
                pair[0] = Math.min(pair[0], tmp[0]);
                pair[1] = Math.max(pair[1], tmp[1]);
            }
        }

        result.add(pair);

        return result.toArray(new int[][]{new int[result.size()]});
    }
}
