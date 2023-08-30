package com.j2core.sts.leetcode.com.addDigits;

public class Solution1 {

    public int addDigits(int num) {

        int newNum = sumNumbers(num);

        while (newNum >= 10){
            newNum = sumNumbers(newNum);
        }

        return newNum;
    }

    private int sumNumbers(int num){

        if (num < 10) return num;
        int newNum = 0;

        while (num > 0){
            newNum += num%10;
            num = num/10;
        }

        return newNum;
    }
}
