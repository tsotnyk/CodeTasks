package com.j2core.sts.leetcode.com.insertInterval;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insertOld(int[][] intervals, int[] newInterval) {

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

    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> array = new ArrayList<>();
        array.add(newInterval);

        for (int[] interval : intervals){
            addNewInterval(array, interval);
        }

        return createArray(array);

    }

    private void addNewInterval(ArrayList<int[]> list, int[] newInterval){

        for (int i = 0; i < list.size(); i++){

            int[] tmp = list.get(i);

            if (newInterval[1] < tmp[0]){
                list.add(i, newInterval);
                return;
            }else if (tmp[0] <= newInterval[0] && tmp[1] >= newInterval[1]){
                return;
            }else if (newInterval[0] <= tmp[1]){
                tmp[0] = Math.min(newInterval[0], tmp[0]);
                tmp[1] = Math.max(newInterval[1], tmp[1]);
                return;
            }
        }

        list.add(newInterval);
    }

    @Test
    public void test(){

        int[][] result = insert(new int[][]{{1,3}, {6,9}}, new int[]{2,5});
        Assert.assertEquals(result.length, 2);
        int[][] result1 = insert(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}}, new int[]{4,8});
        Assert.assertEquals(result1.length, 3);
    }
}
