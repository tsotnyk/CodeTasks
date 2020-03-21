package com.j2core.sts.leetcode.com.reverseBits;

public class Solution {

    public int reverseBits(int n) {

        int result = 0;
        for (int i=0; i<32; i++) {
            result = result << 1;
            if ((n&0x1)==1) {
                result |= 0x1;
            }
            n = n >> 1;
        }
        return result;
    }
}
