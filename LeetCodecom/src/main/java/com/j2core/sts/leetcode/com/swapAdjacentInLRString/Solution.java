package com.j2core.sts.leetcode.com.swapAdjacentInLRString;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean canTransformOld(String start, String end) {

        if (start.length() != end.length()) return false;
        int charR = 0;
        int charL = 0;

        for (int i = 0; i < start.length(); i++){
            char tmpStart = start.charAt(i);
            if (tmpStart == 'R'){
                charR++;
            }else if (tmpStart == 'L'){
                charL--;
            }
            char tmpEnd = end.charAt(i);
            if (tmpEnd == 'R'){
                charR--;
            }else if (tmpEnd == 'L'){
                charL++;
            }

            if (charL > 0 && charR > 0 || charL < 0 || charR < 0) return false;
        }

        return charL == 0 && charR == 0;
    }

    public boolean canTransform(String start, String end) {

        int index = start.length()-1;
        char[] startArray = start.toCharArray();

        while (index > -1){

            if (end.charAt(index) == startArray[index]){
                index--;
            }else if (index == 0){
                return false;
            }else{
                if ((startArray[index] == 'R' && startArray[index-1] == 'X') || (startArray[index] == 'X' && startArray[index-1] == 'R') ||
                        (startArray[index] == 'L' && startArray[index-1] == 'X') || (startArray[index] == 'X' && startArray[index-1] == 'L')){
                    char tmp = startArray[index];
                    startArray[index] = startArray[index-1];
                    startArray[index-1] = tmp;
                    if (end.charAt(index) != startArray[index]) return false;
                    index--;
                }else return false;
            }
        }

        return true;
    }

    public boolean canTransform1(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;

        int i = 0, j = 0;
        int len = start.length();

        while (i < len && j < len) {
            while (i < len && start.charAt(i) == 'X') i++;
            while (j < len && end.charAt(j) == 'X') j++;
            if (i < len && start.charAt(i) == 'L' && i < j) return false;
            if (i < len && start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }

        return true;
    }

    @Test
    public void test(){

//        Assert.assertTrue(canTransform("RXXLRXRXL", "XRLXXRRLX"));
//        Assert.assertTrue(canTransform("XRRXRX", "RXLRRX"));
        Assert.assertFalse(canTransform("XRXXXLXXXR","XXRLXXXRXX"));


    }
}
