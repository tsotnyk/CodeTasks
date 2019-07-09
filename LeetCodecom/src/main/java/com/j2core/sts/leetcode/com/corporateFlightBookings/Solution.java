package com.j2core.sts.leetcode.com.corporateFlightBookings;

import java.util.Arrays;

public class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] result = new int[n];

        Arrays.stream(bookings).forEach(booking -> {
            addBookings(result, booking[0], booking[1], booking[2]);
        });

        return result;
    }

    private void addBookings(int[] array, int startIndex, int endIndex, int amount){

        for (int i = startIndex-1; i < endIndex; i++){
            array[i] += amount;
        }
    }

}
