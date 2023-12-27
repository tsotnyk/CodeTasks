package com.j2core.sts.leetcode.com.decodeWays;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution1 {

    public int numDecodings(String s) {

        AtomicInteger counter = new AtomicInteger(0);

        validateParse(s, 0, 1, counter);
        validateParse(s, 0, 2, counter);

        return counter.get();
    }

    private void validateParse(String s, int iS, int delta, AtomicInteger counter){

        if (s.length() == iS) counter.incrementAndGet();
        if (s.length() < iS+delta || (s.charAt(iS) == '0')) return;

        int num = Integer.parseInt(s.substring(iS, iS+delta));

        if (num > 26) return;

        if (delta+iS == s.length()){
            counter.incrementAndGet();
            return;
        }
        validateParse(s, iS+delta, 1, counter);
        validateParse(s, iS+delta, 2, counter);

    }
    @Test
    public void test(){

        Assert.assertEquals(numDecodings("12"), 2);
        Assert.assertEquals(numDecodings("226"), 3);
        Assert.assertEquals(numDecodings("06"), 0);
        Assert.assertEquals(numDecodings("12"), 2);

    }
}
