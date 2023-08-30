package com.j2core.sts.leetcode.com.basicCalculatorII;

import java.util.Stack;

public class Solution1 {

    public int calculate(String s) {

        Stack<Integer> numbers = new Stack<>();

        int index = 1;
        int iS = 0;

        while (index < s.length()){
            while (Character.isDigit(s.charAt(index))) index++;
            int num = Integer.parseInt(s.substring(iS, index));

        }

        int sum = Integer.parseInt(s.substring(iS));

        switch (s.charAt(iS-1)) {
            case '+':
                sum += numbers.pop();
                break;
            case '-':
                sum -= numbers.pop();
                break;
            case '*':
                sum *= numbers.pop();
                break;
            case '/':
                sum = numbers.pop()/sum;
                break;
        }

        while (!numbers.empty()){
            sum += numbers.pop();
        }

        return sum;
    }
}
