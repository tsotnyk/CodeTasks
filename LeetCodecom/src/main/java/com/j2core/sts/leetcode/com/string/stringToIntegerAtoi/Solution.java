package com.j2core.sts.leetcode.com.string.stringToIntegerAtoi;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int myAtoi1(String str) {

        if (str.length() < 1) return 0;

        String num = parsNum(str);
        int result;

        try {

            result = Integer.parseInt(num);

        }catch (NumberFormatException ex){

            if (num.charAt(0) == '-'){
                result = -2147483648;
            }else {
                result = 2147483647;
            }
        }

        return result;

    }


    private String parsNum(String str){

        str = trimWhiteSpace(str);

        int delta = 0;
        int startIndex = -1;
        int endIndex = -1;

        for (int i= 0; i < str.length(); i++){

            if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')){
                delta = 1;
            }else if (Character.isDigit(str.charAt(i))){

                if (startIndex == -1){
                    startIndex = i;
                }
                endIndex = i;
            }else break;
        }

        if (startIndex > -1){
            return str.substring(startIndex-delta, endIndex+1);
        }else return "0";
    }


    private String trimWhiteSpace(String srt){

        int index = -1;
        for (int i = 0; i < srt.length(); i++){

            if (srt.charAt(i) != ' '){
                index = i;
                break;
            }
        }

        return index == -1 ? srt : srt.substring(index);
    }

    public int myAtoi(String str) {

        str = str.trim();

        if (str.length() < 1) return 0;
        boolean negativeNum = false;

        char firstSymbol = str.charAt(0);
        if (!Character.isDigit(firstSymbol) && firstSymbol != '-' && firstSymbol != '+') return 0;
        int index = 0;
        if (firstSymbol == '-') {
            negativeNum = true;
            index++;
        }else if (firstSymbol == '+'){
            index++;
        }
        int lastDelta = negativeNum ? 8 : 7;
        int oneStepBackNum = Integer.MAX_VALUE/10;
        int sum = 0;
        while (index < str.length()){

            char symbol = str.charAt(index);
            if (Character.isDigit(symbol)){
                int num = (int) symbol - (int)'0';
                if (sum > oneStepBackNum){
                    return negativeNum ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }else if (sum == oneStepBackNum){
                    if (num >= lastDelta){
                        return negativeNum ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    } else {
                        sum *= 10;
                        sum += num;
                    }
                }else {
                    sum *= 10;
                    sum += num;
                }
            }else {
                break;
            }
            index++;
        }

        return negativeNum ? sum*-1 : sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(myAtoi("-2147483647"), -2147483647);


        Assert.assertEquals(myAtoi("2147483646"), 2147483646);

        Integer result = myAtoi("42");

        Assert.assertEquals(new Integer(42), result);

        Integer result1 = myAtoi("  -42");

        Assert.assertEquals(new Integer(-42), result1);

        Integer result2 = myAtoi("4193  with words");

        Assert.assertEquals(new Integer(4193), result2);

        Integer result3 = myAtoi("word and 987");

        Assert.assertEquals(new Integer(0), result3);

        Integer result4 = myAtoi("-91283472332");

        Assert.assertEquals(new Integer(-2147483648), result4);

        Integer result5 = myAtoi("+");

        Assert.assertEquals(new Integer(0), result5);

        Integer result6 = myAtoi("4-2");

        Assert.assertEquals(new Integer(4), result6);

        Integer result7 = myAtoi("   +0 123");

        Assert.assertEquals(new Integer(0), result7);

    }


}
