package com.j2core.sts.leetcode.com.backspaceStringCompare;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public boolean backspaceCompare(String S, String T) {

        S = trimSting(S);
        T = trimSting(T);

        return S.equals(T);
    }

    private String trimSting(String str){

        StringBuilder builder = new StringBuilder();
        int index = str.length()-1;
        int counter = 0;
        while (index > -1){

            char tmp = str.charAt(index--);
            if (tmp == '#'){
                counter++;
            }else {
                if (counter > 0){
                    counter--;
                }else {
                    builder.append(tmp);
                }
            }
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assert.assertTrue(backspaceCompare("ab##c", "c"));
        Assert.assertTrue(backspaceCompare("ab##", ""));
        Assert.assertFalse(backspaceCompare("adb##c", "c"));

    }
}
