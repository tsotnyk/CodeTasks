package com.j2core.sts.leetcode.com.MaxLengthOfPairChain;

import java.util.Arrays;

public class Solution {

    public int findLongestChain(int[][] pairs) {
        int counter = 1;
        if (pairs.length < 2) return 1;

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int tmpCounter = 1;
        int[] subArray1 = pairs[0];

        for (int j = 1; j < pairs.length; j++){

            int[] subArray2 = pairs[j];

            if (subArray1[1] < subArray2[0]){

                tmpCounter++;
                subArray1 = subArray2;
            }

        }

        if (counter < tmpCounter){

            counter = tmpCounter;
        }

        return counter;
    }
}
