package com.j2core.sts.leetcode.com.numbersWithRepeatedDigits;

import org.testng.annotations.Test;

public class Solution {

    public int numDupDigitsAtMostNEx(int N) {

        int counter = 0;

        for (int i = 1; i < 10; i++){
            int number = (i*10)+i;
            while (number <= N){
                counter++;
                number = number*10+i;
            }
        }



        return counter;
    }

    @Test
    public void test(){

    }
}
