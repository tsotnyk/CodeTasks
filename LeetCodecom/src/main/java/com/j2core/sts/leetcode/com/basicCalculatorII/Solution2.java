package com.j2core.sts.leetcode.com.basicCalculatorII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution2 {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        char action = '+';

        for (int i = 0; i < s.length(); i++){

            char symbol = s.charAt(i);

            if (Character.isDigit(symbol)){
                curNum = (curNum * 10) + (symbol - '0');
            }
            if (!Character.isDigit(symbol) && !Character.isWhitespace(symbol) || i == s.length()-1){
                switch (action){
                    case '+':
                        stack.push(curNum);
                        curNum = 0;
                        break;
                    case '-':
                        stack.push(-curNum);
                        curNum = 0;
                        break;
                    case '*':
                        stack.push(stack.pop()*curNum);
                        curNum = 0;
                        break;
                    case '/':
                        stack.push(stack.pop()/curNum);
                        curNum = 0;
                        break;
                }
                action = symbol;
            }
        }

        int sum = 0;

        while (!stack.empty()){
            sum += stack.pop();
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(calculate("3+5 / 2 "), 5);
    }
}
