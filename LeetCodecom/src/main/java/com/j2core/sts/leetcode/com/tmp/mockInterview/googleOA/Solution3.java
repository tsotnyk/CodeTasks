package com.j2core.sts.leetcode.com.tmp.mockInterview.googleOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution3 {

    public int heightChecker(int[] heights) {

        int[] sort = new int[heights.length];
        System.arraycopy(heights, 0, sort, 0, heights.length);
        Arrays.sort(sort);
        int counter = 0;
        for (int i = 0; i < heights.length; i++){
            if (heights[i] != sort[i]) counter++;
        }
        return counter;
    }

    public boolean isLongPressedName(String name, String typed) {

        if (typed.length() < name.length()) return false;
        int iName = 1;
        int iTyped = 1;
        int countName = 1;
        int countTyped = 1;
        char symbolName = name.charAt(0);
        char symbolTyped = typed.charAt(0);
        if (symbolName != symbolTyped) return false;

        while (iName <= name.length()){
            while (iName < name.length() && name.charAt(iName) == symbolName){
                countName++;
                iName++;
            }
            while (iTyped < typed.length() && typed.charAt(iTyped) == symbolTyped){
                countTyped++;
                iTyped++;
            }
            if (countName > countTyped) return false;
            if (iName < name.length() && iTyped < typed.length()){
                symbolName = name.charAt(iName++);
                countName = 1;
                symbolTyped = typed.charAt(iTyped++);
                countTyped = 1;
                if (symbolName != symbolTyped) return false;
            }else {
                break;
            }
        }

        return iName == name.length() && iTyped == typed.length();
    }

    @Test
    public void test(){

        Assert.assertTrue(isLongPressedName("vtkgn", "vttkgnn"));


        Assert.assertTrue(isLongPressedName("alex","aaleex"));
        Assert.assertTrue(isLongPressedName("laiden","laiden"));

        Assert.assertTrue(isLongPressedName("leelee","lleeelee"));
        Assert.assertFalse(isLongPressedName("saeed","ssaaedd"));
        Assert.assertFalse(isLongPressedName("xnhtq","xhhttqq"));
        Assert.assertFalse(isLongPressedName("a","b"));
        Assert.assertFalse(isLongPressedName("pyplrz", "ppyypllr"));




    }
}
