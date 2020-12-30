package com.j2core.sts.leetcode.com.arrays.setIntersectionSizeAtLeastTwo;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int intersectionSizeTwo(int[][] intervals) {

        int counter = 0;
        Arrays.sort(intervals, (t1, t2) ->{
            if (t1[0] == t2[0]){
                return t1[1] - t2[1];
            }
            return t2[0] - t1[0];
        });
        int startInterval = Integer.MAX_VALUE;
        int endInterval = Integer.MAX_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] == startInterval) continue;

            if (interval[1] < startInterval) {
                startInterval = interval[0];
                endInterval = interval[0] + 1;
                counter += 2;
            } else if (interval[1] >= startInterval && interval[1] < endInterval) {
                endInterval = startInterval;
                startInterval = interval[0];
                counter += 1;
            }
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(intersectionSizeTwo(new int[][]{{1,3},{1,4},{2,5},{3,5}}), 3);
        Assert.assertEquals(intersectionSizeTwo(new int[][]{{1,2},{2,3},{2,4},{4,5}}), 5);
        Assert.assertEquals(intersectionSizeTwo(new int[][]{{3,13},{2,8},{5,10}}), 2);

    }
}
