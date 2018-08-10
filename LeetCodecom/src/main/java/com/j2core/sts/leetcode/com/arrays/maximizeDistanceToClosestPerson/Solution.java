package com.j2core.sts.leetcode.com.arrays.maximizeDistanceToClosestPerson;

public class Solution {

    public int maxDistToClosest(int[] seats) {

        int maxDistance = 0;

        int length = -1;
        for(int i = 0; i < seats.length; i++) {

            int tmpDistance = -1;
            if(seats[i] == 1) {
                if(length == -1) {
                    tmpDistance = i - length -1;
                }
                else {
                    tmpDistance = (i - length)/2;
                }
                length = i;
            }
            else {
                if(i == seats.length-1) {
                    tmpDistance = i - length;
                }
            }

            if (maxDistance < tmpDistance){

                maxDistance = tmpDistance;
            }
        }
        return maxDistance;
    }
}
