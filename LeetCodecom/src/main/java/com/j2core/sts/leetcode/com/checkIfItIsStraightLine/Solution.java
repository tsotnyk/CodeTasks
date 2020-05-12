package com.j2core.sts.leetcode.com.checkIfItIsStraightLine;

public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {

        if (coordinates.length == 2) return true;

        int deltaX = -1;
        int deltaY = -1;
        deltaX = Math.abs(coordinates[0][0]-coordinates[1][0]);
        deltaY = Math.abs(coordinates[0][1]-coordinates[1][1]);

        if (deltaX == 0){

            for (int i = 2; i < coordinates.length; i++){
                if (coordinates[i][0] != coordinates[0][0]) return false;
            }
            return true;
        }
        if (deltaY == 0){

            for (int i = 2; i < coordinates.length; i++){
                if (coordinates[i][1] != coordinates[0][1]) return false;
            }
            return true;
        }

        for (int i = 2; i < coordinates.length; i++){
            if (!((coordinates[i-2][1] - coordinates[i-1][1]) * (coordinates[i][0] - coordinates[i-1][0])
                    == (coordinates[i][1] - coordinates[i-1][1]) * (coordinates[i-2][0] - coordinates[i-1][0]))) return false;
        }

        return true;
    }
}
