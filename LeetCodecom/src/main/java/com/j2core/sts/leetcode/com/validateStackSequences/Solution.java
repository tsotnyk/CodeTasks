package com.j2core.sts.leetcode.com.validateStackSequences;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int indexInput = 0;
        int indexOutput = 0;

        while (indexInput < pushed.length){

            if (pushed[indexInput] == popped[indexOutput]){
                indexOutput++;
                indexInput++;
            }else {
                if (!stack.isEmpty()){
                    if (stack.peek() == popped[indexOutput]){
                        stack.pop();
                        indexOutput++;
                    }else {
                        stack.push(pushed[indexInput++]);
                    }
                }else {
                    stack.push(pushed[indexInput++]);
                }
            }
        }

        while (!stack.isEmpty()){
            if (stack.pop() != popped[indexOutput++]) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        Assert.assertFalse(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}
