package com.j2core.sts.leetcode.com.arrays.coinChange2;

public class Solution {

    public int change(int amount, int[] coins) {
        int[] array = new int[amount + 1];
        array[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                array[i] += array[i - coin];
            }
        }
        return array[amount];
    }
}
