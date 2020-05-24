package com.j2core.sts.leetcode.com.intervalListIntersections;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> list = new LinkedList<>();

        int lengthA = A.length;
        int lengthB = B.length;
        int indexA = 0;
        int indexB = 0;

        while (indexA < lengthA && indexB < lengthB){

            int[] intervalA = A[indexA];
            int[] intervalB = B[indexB];

            if (intervalA[1] < intervalB[0]){
                indexA++;
            }else if (intervalB[1] < intervalA[0]){
                indexB++;
            }else {
                int[] newInterval = new int[]{Math.max(intervalA[0], intervalB[0]), Math.min(intervalA[1], intervalB[1])};
                list.add(newInterval);
                if (intervalA[1] > intervalB[1]){
                    indexB++;
                }else {
                    indexA++;
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
