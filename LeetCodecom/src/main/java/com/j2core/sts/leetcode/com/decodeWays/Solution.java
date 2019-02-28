package com.j2core.sts.leetcode.com.decodeWays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int numDecodings(String s) {

        int length = s.length();

        if (length < 1){
            return 0;
        }
        if (length == 1){
            return 1;
        }

        int counter = 1;

        for(int i = 0; i < length-1; i++){

            counter++;
            if (Integer.parseInt(s.substring(i, i+2)) < 27){
                counter++;
            }

        }

        return counter;
    }


    @Test
    public void test(){

        int result = numDecodings("122");
        Assert.assertEquals(result, 3);

    }
}
