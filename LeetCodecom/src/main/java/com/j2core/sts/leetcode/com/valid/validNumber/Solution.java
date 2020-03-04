package com.j2core.sts.leetcode.com.valid.validNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    static Set<Character> characterSet = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', 'e', '-', '+'));

    public boolean isNumberOld(String s) {

        s = s.trim();

        int length = s.length();
        if (length == 0) return false;
        int eIndex = -1;
        int pointIndex = -1;

        for (int i = 0; i < length; i++){
            char symbol = s.charAt(i);
            if (!characterSet.contains(symbol)){
                return false;
            }
            switch (symbol){
                case '+':
                    if (i != 0){
                        return false;
                    }
                    break;
                case '-':
                    if (eIndex+1 != i || i == length-1 || s.charAt(i+1) > '9' || s.charAt(i+1) < '0'){
                        return false;
                    }
                    break;
                case '.':
                    if (eIndex != -1 || length == 1 || pointIndex != -1 || (i+1 < length && s.charAt(i+1) == 'e')){
                        return false;
                    }
                    pointIndex = i;
                    break;
                case 'e':
                    if (i == 0 || i == length-1 || eIndex != -1 || pointIndex+1 == i){
                        return false;
                    }
                    if (s.charAt(i+1) == '+'){
                        return false;
                    }
                    eIndex = i;
                    break;
                default:
                    break;
            }
        }

        return true;
    }

    public boolean isNumber(String s) {

        String str = s.trim();
        if (str.length() < 1) return false;
        int eIndex = str.indexOf('e');

        if (eIndex < 0){
            return isNumberWithoutE(str);
        }else if (eIndex == 0 || eIndex == str.length()-1){
            return false;
        }else {
            if (isNumberAfterE(str.substring(eIndex+1))){
                return isNumberWithoutE(str.substring(0, eIndex));
            }else return false;
        }
    }

    private boolean isNumberWithoutE(String string){

        boolean point = false;
        int index = 0;
        int length = string.length();
        if (string.charAt(0) == '-' || string.charAt(0) == '+'){
            index++;
            if (length == 1){
                return false;
            }
        }
        for (int i = index; i < length; i++){
            char character = string.charAt(i);
            if (character == '.'){
                if (length-index == 1 || point){
                    return false;
                }
                point = true;
            }else if (character == '-' || character == '+'){
                return false;
            }else if (character < '0' || character > '9'){
                return false;
            }
        }
        return true;
    }

    private boolean isNumberAfterE(String string){

        for (int i = 0; i < string.length(); i++){

            if (string.charAt(i) == '-' || string.charAt(i) == '+'){
                if (i > 0 || string.length() == 1) return false;
            }else if (string.charAt(i) < '0' || string.charAt(i) > '9'){
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){

        String[] arrayTrue = new String[]{"0", " 0.1", "2e10", " -90e3", " 6e-1", " 53.5e93", "46.e3", "3.", ".3", " 005047e+6"};
        String[] arrayFalse = new String[]{"-e58 ", " +0e-", " ", ".", "..", ".e2", " -.", "95a54e53", "-+3", " --6", "99e2.5", "e3", " 1e", "1 a", "abc"};

        for (String string : arrayTrue){
            Assert.assertTrue(isNumber(string));
        }

        for (String string : arrayFalse){
            Assert.assertFalse(isNumber(string));
        }
    }
}
