package com.j2core.sts.leetcode.com.graphs.couplesHoldingHands;

public class Solution {

    public int minSwapsCouples(int[] row) {

        int counter = 0;

        for (int i = 0; i < row.length-3; ){

            int findNum = row[i]%2 == 0 ? row[i]+1 : row[i]-1;
            if (row[i+1] != findNum){
                int index = i+2;
                while (row[index] != findNum){
                    index++;
                }
                int tmp = row[index];
                row[index] = row[i+1];
                row[i+1] = tmp;
                counter++;
            }
            i += 2;
        }

        return counter;
    }
}
