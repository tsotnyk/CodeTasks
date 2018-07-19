package com.j2core.sts.leetcode.com.sum.sumOfSquareNumbers;

/*
  The class decide whether there're two integers a and b such that a2 + b2 = c.
 */
public class Solution {

    /**
     * The method decide whether there're two integers a and b such that a2 + b2 = c
     *
     * @param c        expression result
     * @return         decide whether there're two integers a and b such that a2 + b2 = c or not
     */
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
