package com.j2core.sts.leetcode.com.arrays.heightChecker;

import java.util.Arrays;

public class Solution {

    public int heightChecker(int[] heights) {

        int[] sortArray = heights.clone();
        Arrays.sort(sortArray);

        int counter = 0;

        for (int i = 0; i < sortArray.length; i++){

            if (heights[i] != sortArray[i]){
                counter++;
            }
        }
        return counter;
    }

}
