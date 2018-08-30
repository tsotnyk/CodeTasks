package com.j2core.sts.leetcode.com.string.stringToIntegerAtoi;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int myAtoi(String str) {

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

    @Test
    public void test(){

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
