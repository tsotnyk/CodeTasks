package com.j2core.sts.leetcode.com.string.zigZagConversion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1){
            return s;
        }

        StringBuilder[] array = createStringBuilderArray(numRows);

        int index = 0;
        int delta = 1;

        for (int i = 0; i < s.length(); i++){

            array[index].append(s.charAt(i));

            index = index + delta;

            if (index == numRows-1){
                delta = -1;
            }else if (index == 0){
                delta = 1;
            }
        }

        return createString(array);

    }

    private StringBuilder[] createStringBuilderArray(int numRow){

        StringBuilder[] array = new StringBuilder[numRow];

        for (int i = 0; i < numRow; i++){

            array[i] = new StringBuilder();
        }

        return array;
    }

    private String createString(StringBuilder[] builders){

        StringBuilder result = builders[0];

        for (int i = 1; i < builders.length; i++){

            result.append(builders[i]);
        }

        return result.toString();
    }


    @Test
    public void test(){

        String string = convert("PAYPALISHIRING", 3);

        Assert.assertEquals(string, "PAHNAPLSIIGYIR");


        String string1 = convert("PAYPALISHIRING", 4);

        Assert.assertEquals(string1, "PINALSIGYAHRPI");

    }

}
