package com.j2core.sts.leetcode.com.threeConsecutiveOdds;

public class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {

        int counter = 0;
        for (int num : arr){
            if (num %2 == 0){
                counter = 0;
            }else {
                counter++;
            }
            if (counter == 3) return true;
        }
        return false;
    }
}
