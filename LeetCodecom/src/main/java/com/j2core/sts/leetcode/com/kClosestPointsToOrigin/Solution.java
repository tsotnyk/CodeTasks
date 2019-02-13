package com.j2core.sts.leetcode.com.kClosestPointsToOrigin;

import java.util.*;

public class Solution {

    public int[][] kClosest(int[][] points, int K) {

        int pointsLength = points.length;
        if (pointsLength == K) {
            return points;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                int sum1 = (first[0]*first[0]) + (first[1]*first[1]);
                int sum2 = (second[0]*second[0]) + (second[1]*second[1]);
                if (sum1 > sum2){
                    return 1;
                }
                else if (sum1 == sum2){
                    return 0;
                }
                else return - 1;
            }
        });

        int[][] result = new int[K][];

        System.arraycopy(points, 0, result, 0, K);
        return result;
    }

}
