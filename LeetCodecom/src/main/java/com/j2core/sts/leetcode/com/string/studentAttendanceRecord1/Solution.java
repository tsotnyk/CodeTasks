package com.j2core.sts.leetcode.com.string.studentAttendanceRecord1;

public class Solution {

    public boolean checkRecord(String s) {

        int amountA = 0;

        int index = s.indexOf("A");

        while (index != -1){

            amountA++;
            index = s.indexOf("A", index+1);
        }

        if(amountA > 1) return false;

        int amountL = 0;

        index = s.indexOf("L");
        int oldIndex = index;

        while (index != -1){

            if (index > oldIndex + 1){
                amountL = 0;
            }
            amountL++;

            if (amountL > 2) return false;
            oldIndex = index;
            index = s.indexOf("L", index + 1);
        }

        return true;
    }
}
