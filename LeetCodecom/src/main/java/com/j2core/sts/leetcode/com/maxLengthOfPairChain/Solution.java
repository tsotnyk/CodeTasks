package com.j2core.sts.leetcode.com.maxLengthOfPairChain;

import java.util.Arrays;

/*
   The class find the length longest chain which can be formed.
   (In every pair, the first number is always smaller than the second number, we define a pair (c, d) witch can follow another
   pair (a, b) if and only if b < c.)
 */
public class Solution {

    /**
     * The method find the length longest chain which can be formed
     *
     * @param pairs   pairs of numbers
     * @return        length longest chain which can be formed
     */
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
