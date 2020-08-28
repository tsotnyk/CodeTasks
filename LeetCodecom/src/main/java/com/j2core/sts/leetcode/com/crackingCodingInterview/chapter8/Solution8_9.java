package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution8_9 {

    public boolean isValidBrackets(String expression){

        if (expression == null) return true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '('){
                stack.push('(');
            }else{
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test(){

        Assert.assertTrue(isValidBrackets("()(())"));
        Assert.assertFalse(isValidBrackets("((("));
        Assert.assertFalse(isValidBrackets(")("));
        Assert.assertTrue(isValidBrackets(""));
        Assert.assertTrue(isValidBrackets(null));

    }
}
