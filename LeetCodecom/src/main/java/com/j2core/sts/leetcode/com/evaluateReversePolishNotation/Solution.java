package com.j2core.sts.leetcode.com.evaluateReversePolishNotation;

import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String str : tokens){
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                switch (str){
                    case "+":
                        stack.push(first+second);
                        break;
                    case "-":
                        stack.push(first-second);
                        break;
                    case "*":
                        stack.push(first*second);
                        break;
                    default:
                        stack.push( first/second);
                }
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
