package com.j2core.sts.leetcode.com.intervalListIntersections;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {

        List<Interval> list = new LinkedList<>();

        int lengthA = A.length;
        int lengthB = B.length;
        int indexA = 0;
        int indexB = 0;

        while (indexA < lengthA && indexB < lengthB){

            Interval intervalA = A[indexA];
            Interval intervalB = B[indexB];

            if (intervalA.end < intervalB.start){
                indexA++;
            }else if (intervalB.end < intervalA.start){
                indexB++;
            }else {
                Interval newInterval = new Interval();
                newInterval.start = Math.max(intervalA.start, intervalB.start);
                newInterval.end = Math.min(intervalA.end, intervalB.end);
                list.add(newInterval);
                if (intervalA.end > intervalB.end){
                    indexB++;
                }else {
                    indexA++;
                }
            }
        }

        Interval[] result = new Interval[list.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
