package com.j2core.sts.leetcode.com.longPressedName;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isLongPressedName(String name, String typed) {

        if (name == null || typed == null || name.length() > typed.length()) return false;

        if (name.length() == typed.length()) return name.equalsIgnoreCase(typed);

        int index = 0;
        for (int i = 0; i < name.length(); ){
            if (index == typed.length()) {
                return false;
            }
            char character = name.charAt(i++);
            int counter = 1;

            while (i < name.length() && name.charAt(i) == character){
                counter++;
                i++;
            }

            if (typed.charAt(index++) == character){
                counter--;
                while (index < typed.length() && typed.charAt(index) == character){
                    counter--;
                    index++;
                }
                if (counter > 0){
                    return false;
                }
            }else {
                return false;
            }
        }

        return index >= typed.length();
    }


    @Test
    public void test(){

        boolean result = isLongPressedName("alex", "aaleex");
        Assert.assertTrue(result);
        boolean result1 = isLongPressedName("saeed", "ssaaedd");
        Assert.assertFalse(result1);
        boolean result2 = isLongPressedName("leelee", "lleeelee");
        Assert.assertTrue(result2);
        boolean result3 = isLongPressedName("laiden", "laiden");
        Assert.assertTrue(result3);
        boolean result4 = isLongPressedName("pyplrz", "ppyypllr");
        Assert.assertFalse(result4);
    }
}
