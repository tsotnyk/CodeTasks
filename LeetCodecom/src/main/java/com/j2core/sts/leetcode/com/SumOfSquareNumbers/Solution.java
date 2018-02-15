package com.j2core.sts.leetcode.com.SumOfSquareNumbers;

public class Solution {

    public boolean judgeSquareSum(int c) {
        int tmpA = (int) Math.sqrt(c);

        int delta;
        int lengthA = String.valueOf(tmpA).length();
        if (lengthA < 2){
            delta = lengthA;
        }else if (lengthA < 4){
            delta = (int) (tmpA*0.5);
        }else {
            delta = (int) (tmpA*0.2);
        }
        int a = tmpA - delta;
        for (; a <= tmpA; a++){

            int a2 = a*a;
            int b2 = c-a2;
            int tmpB = (int) Math.sqrt(b2);

            if (a2 + (tmpB*tmpB) == c){
                return true;
            }

        }

        return false;
    }
}
