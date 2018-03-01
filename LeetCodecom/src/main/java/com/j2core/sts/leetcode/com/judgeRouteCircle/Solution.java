package com.j2core.sts.leetcode.com.judgeRouteCircle;

/*
   The class  given a sequence of its moves, judge if robot makes a circle.
 */
public class Solution {

    /**
     * The method given a sequence of its moves, judge if robot makes a circle
     *
     * @param moves   sequence of moves
     * @return        can robot moves back to the original place or not
     */
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
