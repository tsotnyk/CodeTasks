package com.j2core.sts.hackerrank.com.bitManipulation.sumVSxor;

public class Solution {

    long sumXor(long n) {

        int counter = 1;
        long nextNum = n+1;
        for (int x = 1; x < n; x++){
            if (nextNum++ == (x^n)) {
                counter++;
            }
        }

        return counter;
    }
}
