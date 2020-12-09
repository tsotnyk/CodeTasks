package com.j2core.sts.leetcode.com.arrays.removeCoveredIntervals;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (t1, t2) -> {
            if (t1[0] != t2[0]){
                return t1[0] - t2[0];
            }else {
                return t2[1] - t1[1];
            }
        });

        int counter = 1;
        int index = 0;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > intervals[index][0]){
                if ( intervals[index][1] < intervals[i][1]){
                    counter++;
                    index = i;
                }
            }
        }
        return counter;
    }

    @Test
    public void test(){


        Assert.assertEquals(removeCoveredIntervals(new int[][]{{0,10},{5,12}}),2);
        Assert.assertEquals(removeCoveredIntervals(new int[][]{{3,10},{4,10},{5,11}}),2);

        Assert.assertEquals(removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}),2);
        Assert.assertEquals(removeCoveredIntervals(new int[][]{{1,4},{2,3}}),1);
        Assert.assertEquals(removeCoveredIntervals(new int[][]{{1,2},{1,4},{3,4}}), 1);
        Assert.assertEquals(removeCoveredIntervals(new int[][]{{66672,75156},{59890,65654},{92950,95965},{9103,31953},{54869,69855},{33272,92693},{52631,65356},{43332,89722},{4218,57729},{20993,92876}}), 3);

    }

}
