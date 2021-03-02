package com.j2core.sts.leetcode.com.tmp.mockInterview.googleOA;


import org.junit.Assert;
import org.junit.Test;

public class Solution2 {

    int countWaysToSplit(String s) {
        int counter = 0;
        for(int b = 1; b < s.length()-1; b++){
            for(int c = b+1; c < s.length(); c++){
                if (isDiffString(0, b, c, s)) counter++;
            }
        }
        return counter;
    }

    private boolean isDiffString(int a, int b, int c, String s){

        int length = s.length();
        int aLength = b;
        int cLength = length-c;
        int bLength = length-cLength-aLength;

        String b2c = s.substring(b, c)+s.substring(c);
        String a2b = s.substring(a, b)+s.substring(b, c);
        String c2a = s.substring(c)+s.substring(a, b);

        if (aLength+bLength == bLength+cLength){
            if (a2b.equals(b2c)) return false;
        }
        if (aLength+bLength == cLength+aLength){
            if (a2b.equals(c2a)) return false;
        }
        if (bLength+cLength == cLength+aLength){
            return !b2c.equals(c2a);
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(24, countWaysToSplit("xxxxxxxxxx"));
        Assert.assertEquals(5, countWaysToSplit("xzxzx"));

    }

}
