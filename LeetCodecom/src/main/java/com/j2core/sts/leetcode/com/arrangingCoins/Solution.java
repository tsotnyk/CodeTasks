package com.j2core.sts.leetcode.com.arrangingCoins;

public class Solution {

    public int arrangeCoins(int n) {
        if(n < 1) return 0;


        if (n == 1) return 1;

        int num = 0;

        while (n > num){

            num++;
            n -= num;

        }

        return num;
    }
}
