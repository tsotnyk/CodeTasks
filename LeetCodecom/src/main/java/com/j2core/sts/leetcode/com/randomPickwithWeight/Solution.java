package com.j2core.sts.leetcode.com.randomPickwithWeight;

import java.util.Random;

public class Solution {

    private int[] prefixSums;
    private Random random;
    private int length;

    public Solution(int[] w) {

        this.length = w.length;
        this.random = new Random();
        this.prefixSums = w;
        for (int i = 1; i < w.length; i++){
            prefixSums[i] += prefixSums[i-1];
        }
    }

    public int pickIndex() {

        int target = this.random.nextInt(prefixSums[this.length-1]);
        for (int i = 0; i < prefixSums.length; i++){

            if (target < prefixSums[i]) {
                return i;
            }
        }

        return prefixSums.length-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
