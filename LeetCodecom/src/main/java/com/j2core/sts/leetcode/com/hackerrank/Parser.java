package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Parser {

    public boolean isBalanced(String string){

        if (string == null || string.length() < 1) return true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++){
            char tmp = string.charAt(i);
            if (tmp == '(' || tmp == '{'){
                stack.push(tmp);
            }else if (!stack.isEmpty()){
                if (tmp == '}'){
                    if (stack.peek() == '{'){
                        stack.pop();
                    }else return false;
                }else {
                    if (stack.peek() == '('){
                        stack.pop();
                    }else return false;
                }
            }else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test(){

        Assert.assertTrue(isBalanced("{}()"));
        Assert.assertTrue(isBalanced("({()})"));
        Assert.assertFalse(isBalanced("{}("));

    }
}
