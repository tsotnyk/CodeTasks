package com.j2core.sts.leetcode.com.string.reverseOnlyLetters;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String reverseOnlyLetters(String S) {

        char[] array = S.toCharArray();
        int index = S.length()-1;

        for (int i = 0; i < array.length; i++){

            if (Character.isLetter(array[i])){

                while (!Character.isLetter(S.charAt(index))){
                    index--;
                }

                array[i] = S.charAt(index--);
            }

        }

        return new String(array);
    }

    @Test
    public void test(){

        Assert.assertEquals("dc-ba", reverseOnlyLetters("ab-cd"));

    }

}
