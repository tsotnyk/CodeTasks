package com.j2core.sts.leetcode.com.trees.uniqueBinarySearchTrees;

public class Solution {

    public int numTrees(int n) {

        int[] memoizArray = new int[n + 1];
        memoizArray[0] = 1;
        memoizArray[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                memoizArray[i] += memoizArray[j - 1] * memoizArray[i - j];
            }
        }
        return memoizArray[n];
    }
}
