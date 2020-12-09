package com.j2core.sts.leetcode.com.minimumNumberOfArrowsToBurstBalloons;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int findMinArrowShots(int[][] points) {

        if (points == null) return 0;
        if (points.length < 2) return points.length;

        Arrays.sort(points, (t1, t2) ->{

            if (t1[0] == t2[0]){
                return t1[1]-t2[1];
            }else {
                return Integer.compare(t1[0], t2[0]);
            }
        });

        int[] point = points[0];
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 1; i < points.length; i++){
            int[] nextPoint = points[i];
            if (nextPoint[0] > point[1]){
                result.add(point);
                point = nextPoint;
            }else {
                point = new int[]{nextPoint[0], Math.min(nextPoint[1], point[1])};
            }
        }
        result.add(point);

        return result.size();
    }

    @Test
    public void test(){

        Assert.assertEquals(findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}), 2);

        Assert.assertEquals(findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}), 2);
        Assert.assertEquals(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}), 2);
        Assert.assertEquals(findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}), 4);
        Assert.assertEquals(findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}), 2);
        Assert.assertEquals(findMinArrowShots(new int[][]{{1,2}}), 1);
        Assert.assertEquals(findMinArrowShots(new int[][]{{2,3},{2,3}}), 1);
    }
}
