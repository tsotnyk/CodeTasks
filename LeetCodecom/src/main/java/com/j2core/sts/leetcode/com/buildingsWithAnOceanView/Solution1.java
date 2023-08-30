package com.j2core.sts.leetcode.com.buildingsWithAnOceanView;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution1 {

    public int[] findBuildings(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length-1);

        for (int i = heights.length-2; i >= 0; i--){
            if (heights[i] > heights[stack.peek()]){
                stack.push(i);
            }
        }

        int[] res = new int[stack.size()];

        for (int i = 0; i< res.length; i++){
            res[i] = stack.pop();
        }

        return res;
    }
}
