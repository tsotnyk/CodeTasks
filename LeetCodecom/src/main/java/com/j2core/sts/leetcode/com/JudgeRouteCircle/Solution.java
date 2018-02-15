package com.j2core.sts.leetcode.com.JudgeRouteCircle;

public class Solution {

    public boolean judgeCircle(String moves) {
        int counterUpDown = 0;
        int counterRight = 0;
        int counterLeft = 0;
        for (int i = 0; i < moves.length(); i++){
            char tmp = moves.charAt(i);
            switch (tmp){
                case 'U':
                    counterUpDown++;
                    break;
                case 'D':
                    counterUpDown--;
                    break;
                case 'L':
                    counterLeft++;
                    break;
                case 'R':
                    counterRight++;
                    break;
            }
        }
        if (counterUpDown != 0) {
            return false;
        }else {
            counterLeft = counterLeft%4;
            counterRight = counterRight%4;
            return counterLeft == counterRight;
        }
    }
}
