package com.j2core.sts.leetcode.com.largestRectangleInHistogram;

public class Solution {

    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++){

            int counter = 0;
            int tmp = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++){
                counter++;
                tmp = Integer.min(tmp, heights[j]);
                maxArea = Integer.max(maxArea, tmp*counter);
            }
        }

        return maxArea;
    }
}
