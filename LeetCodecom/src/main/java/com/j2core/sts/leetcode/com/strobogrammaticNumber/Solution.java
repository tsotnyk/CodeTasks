package com.j2core.sts.leetcode.com.strobogrammaticNumber;

public class Solution {

    public boolean isStrobogrammatic(String num) {

        char[] array = new char[num.length()];
        int index = array.length-1;
        for (int i = 0; i < array.length; i++){
            switch (num.charAt(index--)){
                case '9':
                    array[i] = '6';
                    break;
                case '6':
                    array[i] = '9';
                    break;
                case '8':
                    array[i] = '8';
                    break;
                case '1':
                    array[i] = '1';
                    break;
                case '0':
                    array[i] = '0';
                    break;
                default: return false;
            }
        }

        for (int i = 0; i < num.length(); i++){
            if (num.charAt(i) != array[i]) return false;
        }

        return true;
    }
}
