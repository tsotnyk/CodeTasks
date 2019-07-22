package com.j2core.sts.leetcode.com.shiftingLetters;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public String shiftingLetters(String S, int[] shifts) {

        char[] array = S.toCharArray();
        int index = 1;

        while (index <= array.length){

            for (int i = 0; i < index; i++){

                array[i] = shifting(array[i], shifts[index-1]);
            }
            index++;
        }

        return new String(array);
    }

    private char shifting(char ch, int num){

        num = num%26;

        int numCh = ch;
        numCh += num;

        if (numCh > 122){

            int tmp = numCh - 122;
            numCh = 96+tmp;
        }

        return (char) numCh;
    }

    @Test
    public void test(){

String tmp = shiftingLetters("z", new int[]{52});

        Assert.assertEquals( "z", tmp);

    }

    public String shiftingLetters2(String S, int[] shifts) {

        char[] array = S.toCharArray();
        int index = 0;
        int sum = 0;

        for (int tmp : shifts){
            sum += tmp%26;
        }

        while (index < array.length){

            array[index] = shifting(array[index], sum);
            sum -= shifts[index]%26;
            index++;
        }

        return new String(array);
    }
}
