package com.j2core.sts.hackerrank.com.bitManipulation.maximizingXOR;

public class Solution {

    int maximizingXor(int l, int r) {

        int maxXor = 0;
        for(int i = l; i <= r; i++){
            for(int j = l; j <= r; j++){
                maxXor = Math.max(maxXor, i^j);
            }
        }
        return maxXor;
    }
}
