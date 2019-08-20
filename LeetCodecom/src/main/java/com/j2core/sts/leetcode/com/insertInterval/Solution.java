package com.j2core.sts.leetcode.com.insertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        boolean flag = true;

        for (int i= 0 ; i< intervals.length; i++ ){
            int[] interval = intervals[i];
            if (newInterval[1] < interval[0]){
                result.add(newInterval);
                flag = false;
                copyInterval(result, i, intervals);
                break;
            }
            if (interval[0] < newInterval[0]){
                if (interval[1] < newInterval[0]){
                    result.add(interval);
                }else if(interval[1] > newInterval[1]){
                    copyInterval(result, i, intervals);
                    flag = false;
                    break;
                }else {
                    newInterval[0] = interval[0];
                }
            }else if(interval[1] > newInterval[1]){
                newInterval[1] = interval[1];
            }
        }

        if (flag){
            result.add(newInterval);
        }
        return createArray(result);
    }

    private int[][] createArray(List<int[]> list){

        int[][] result = new int[list.size()][];

        for (int i = 0; i < list.size(); i++){

            result[i] = list.get(i);
        }
        return result;
    }

    private void copyInterval(List<int[]> list, int index, int[][] intervals){

        for (int i = index; i < intervals.length; i++){
            list.add(intervals[i]);
        }
    }
}
