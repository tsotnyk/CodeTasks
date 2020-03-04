package com.j2core.sts.leetcode.com.sum.sumOfSubarrayMinimums;

import java.util.Stack;

public class Solution {

    public int sumSubarrayMins(int[] A) {

        int[] numArray = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        long sum = 0;
        long lastSum = 0;
        long tmpSum;

        for(int num : A){
            int counter = 0;
            int stackSize = stack.size();
            while(!stack.empty() && stack.peek() >= num){
                int tmpCounter = numArray[stack.size()-1];
                int oldNum = stack.pop();
                lastSum += (num - oldNum) * tmpCounter;
                counter += tmpCounter;
                stackSize--;
            }

            tmpSum = lastSum + num;
            sum += tmpSum;
            lastSum = tmpSum;

            numArray[stackSize] = counter + 1;
            stack.push(num);
        }

        return (int)(sum % (Math.pow(10, 9) + 7));
    }
}
