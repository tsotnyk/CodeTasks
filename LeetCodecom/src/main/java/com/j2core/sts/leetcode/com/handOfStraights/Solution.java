package com.j2core.sts.leetcode.com.handOfStraights;

import java.util.Arrays;

public class Solution {

    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) return true;
        if (hand.length % W != 0) return false;

        Arrays.sort(hand);
        int amountSubArray = hand.length/W;
        boolean[] visited = new boolean[hand.length];
        int index = 0;
        int value = hand[index]++;
        visited[index++] = true;

        while (amountSubArray-- > 0){
            int nextStart = index;
            int step = W;
            while (index < hand.length && step > 0){
//                if (visited[])
            }


        }

        return true;
    }
}
