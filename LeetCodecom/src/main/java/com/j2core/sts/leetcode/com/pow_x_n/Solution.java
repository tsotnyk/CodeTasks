package com.j2core.sts.leetcode.com.pow_x_n;


public class Solution {

    public double myPow(double x, int n) {
        if(x == 1) {
            return x;
        }
        if(x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            x = 1/x;
            n *= -1;
        }
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }

        double output = helper(x, n/2);

        if(n % 2 == 0) {
            return output * output;
        }else {
            return output * output * x;
        }
    }
}
