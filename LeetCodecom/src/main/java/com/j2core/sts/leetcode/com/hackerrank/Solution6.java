package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution6 {

    public static String decryptPassword(String s) {
        // Write your code here
//
//        char[] string = s.toCharArray();
//        int index = 0;
//        int lastIndex = s.length()-1;
//
//        while (index < s.length() && Character.isDigit(s.charAt(index))){
//            lastIndex = s.lastIndexOf('0', lastIndex);
//            string[lastIndex++] = string[index++];
//        }
//
//        while (index < s.length()){
//            if (s.charAt(index) == '*'){
//                char tmp = string[index-2];
//                string[index-2] = string[index-1];
//                string[index-1] = tmp;
//            }
//            index++;
//        }

        StringBuilder builder = new StringBuilder();
        int index = -1;
        for (int i = s.length()-1; i > index;){
            if (s.charAt(i) == '*'){
                builder.append(s.charAt(i-2)).append(s.charAt(i-1));
                i -= 3;
            }else if (s.charAt(i) == '0'){
                builder.append(s.charAt(++index));
                i--;
            }else {
                builder.append(s.charAt(i));
                i--;
            }
        }

        return builder.reverse().toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(decryptPassword("pTo*Ta*O"), "poTaTO");

        Assert.assertEquals(decryptPassword("51Pa*0Lp*0e"), "aP1pL5e");
    }
}
